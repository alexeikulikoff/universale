package el.controllere.universale;

import org.springframework.data.repository.CrudRepository;

import el.controllere.universale.domain.RootEntity;
import el.controllere.universale.serv.RootService;

public class Clazz {

	private String entityName;

	private Class<? extends RootService> serviceClass;

	private Class<? extends CrudRepository<? extends RootEntity, ?>> repositoryClass;

	private CrudRepository<? extends RootEntity, ?> repository;

	public Clazz(String entityName, Class<? extends RootService> serviceClass,
			Class<? extends CrudRepository<? extends RootEntity, ?>> repositoryClass,
			CrudRepository<? extends RootEntity, ?> repository) {
		super();
		this.entityName = entityName;
		this.serviceClass = serviceClass;
		this.repositoryClass = repositoryClass;
		this.repository = repository;
	}

	public String getEntityName() {

		return entityName;
	}

	public void setEntityName(String entityName) {

		this.entityName = entityName;
	}

	public Class<? extends RootService> getServiceClass() {

		return serviceClass;
	}

	public void setServiceClass(Class<? extends RootService> serviceClass) {

		this.serviceClass = serviceClass;
	}

	public Class<? extends CrudRepository<? extends RootEntity, ?>> getRepositoryClass() {

		return repositoryClass;
	}

	public void setRepositoryClass(Class<? extends CrudRepository<? extends RootEntity, ?>> repositoryClass) {

		this.repositoryClass = repositoryClass;
	}

	public CrudRepository<? extends RootEntity, ?> getRepository() {

		return repository;
	}

	public void setRepository(CrudRepository<? extends RootEntity, ?> repository) {

		this.repository = repository;
	}

}
