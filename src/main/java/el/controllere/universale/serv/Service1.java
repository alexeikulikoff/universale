package el.controllere.universale.serv;

import java.util.List;
import java.util.Optional;

import el.controllere.universale.domain.Entity1;
import el.controllere.universale.domain.RootEntity;
import el.controllere.universale.dto.RootDto;
import el.controllere.universale.exception.CustomException;
import el.controllere.universale.repo.Repository1;

public class Service1 extends AbstractService implements RootService {

	private Repository1 repository;

	public Service1(Repository1 repo) {

		repository = repo;

	}

	@Override
	public Optional<RootEntity> save(RootDto dto) throws CustomException {

		Entity1 e1 = (Entity1) convertDto2Entity(dto, Entity1.class);

		if (e1 != null) {

			Entity1 result = repository.save(e1);

			return Optional.ofNullable(result);

		} else {

			return Optional.empty();
		}

	}

	@Override
	public List<? extends RootEntity> getAll() {

		List<Entity1> ls = (List<Entity1>) repository.findAll();

		return ls;
	}

	@Override
	public RootEntity updateEntity(RootDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntity(Long id) {
		// TODO Auto-generated method stub

	}
}
