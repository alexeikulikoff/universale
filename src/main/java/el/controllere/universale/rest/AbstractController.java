package el.controllere.universale.rest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;

import el.controllere.universale.Clazz;
import el.controllere.universale.exception.CustomException;
import el.controllere.universale.repo.Repository1;
import el.controllere.universale.repo.Repository2;
import el.controllere.universale.repo.Repository3;
import el.controllere.universale.resolvers.ContentResolver;
import el.controllere.universale.resolvers.ContentResolver1;
import el.controllere.universale.resolvers.ContentResolver2;
import el.controllere.universale.resolvers.ContentResolver3;
import el.controllere.universale.serv.Service1;
import el.controllere.universale.serv.Service2;
import el.controllere.universale.serv.Service3;
import el.controllere.universale.serv.UService;

abstract class AbstractController {

	private Map<String, Clazz> classMap = new HashMap<>();

	public AbstractController(Repository1 repo1, Repository2 repo2, Repository3 repo3) {

		classMap.put("Entity1", Clazz.of(Service1.class, Repository1.class, repo1, ContentResolver1.class));
		classMap.put("Entity2", Clazz.of(Service2.class, Repository2.class, repo2, ContentResolver2.class));
		classMap.put("Entity3", Clazz.of(Service3.class, Repository3.class, repo3, ContentResolver3.class));

	}

	public void addClass(String entityName, Clazz clazz) throws CustomException {

		if (classMap.containsKey(entityName)) {
			throw new CustomException("Errro! ClassMap has already contains key " + entityName);
		} else {
			classMap.put(entityName, clazz);
		}
	}
	protected Class<? extends ContentResolver> gerContentResolverClass(String name) {
		return classMap.get(name).getResolver();
	}

	protected UService getService(String entityName) throws CustomException {

		Clazz clazz = classMap.get(entityName);
		CrudRepository<?, ?> repository = clazz.getRepository();
		Class<? extends UService> serviceClass = clazz.getServiceClass();
		Constructor<?> constructor;
		UService service;
		try {
			constructor = serviceClass.getConstructor(clazz.getRepositoryClass());
			try {
				service = (UService) constructor.newInstance(repository);
				return service;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				throw new CustomException(e.getMessage());
			}
		} catch (NoSuchMethodException | SecurityException e) {
			throw new CustomException(e.getMessage());
		}
	}

}
