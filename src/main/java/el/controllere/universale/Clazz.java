package el.controllere.universale;

import org.springframework.data.repository.CrudRepository;

import el.controllere.universale.domain.UEntity;
import el.controllere.universale.resolvers.ContentResolver;
import el.controllere.universale.serv.UService;

public class Clazz {



	private Class<? extends UService> serviceClass;
	private Class<? extends CrudRepository<? extends UEntity, ?>> repositoryClass;
	private CrudRepository<? extends UEntity, ?> repository;
	private Class<? extends ContentResolver> resolver;

	public static Clazz of( Class<? extends UService> serviceClass,
			Class<? extends CrudRepository<? extends UEntity, ?>> repositoryClass,
			CrudRepository<? extends UEntity, ?> repository, Class<? extends ContentResolver> resolver) {
		return new Clazz(serviceClass, repositoryClass, repository, resolver);
	}

	private Clazz(
			Class<? extends UService> serviceClass,
			Class<? extends CrudRepository<? extends UEntity, ?>> repositoryClass,
			CrudRepository<? extends UEntity, ?> repository, Class<? extends ContentResolver> resolver) {
		super();
	
		this.serviceClass = serviceClass;
		this.repositoryClass = repositoryClass;
		this.repository = repository;
		this.resolver = resolver;
	}


	public Class<? extends UService> getServiceClass() {

		return serviceClass;
	}

	public void setServiceClass(Class<? extends UService> serviceClass) {

		this.serviceClass = serviceClass;
	}

	public Class<? extends CrudRepository<? extends UEntity, ?>> getRepositoryClass() {

		return repositoryClass;
	}

	public void setRepositoryClass(Class<? extends CrudRepository<? extends UEntity, ?>> repositoryClass) {

		this.repositoryClass = repositoryClass;
	}

	public CrudRepository<? extends UEntity, ?> getRepository() {

		return repository;
	}

	public void setRepository(CrudRepository<? extends UEntity, ?> repository) {

		this.repository = repository;
	}

	public Class<? extends ContentResolver> getResolver() {
		return resolver;
	}

	public void setResolver(Class<? extends ContentResolver> resolver) {
		this.resolver = resolver;
	}


}
