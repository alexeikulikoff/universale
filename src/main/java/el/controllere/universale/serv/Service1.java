package el.controllere.universale.serv;

import java.util.List;
import java.util.Optional;

import el.controllere.universale.domain.Entity1;
import el.controllere.universale.domain.UEntity;
import el.controllere.universale.dto.UDto;
import el.controllere.universale.exception.CustomException;
import el.controllere.universale.repo.Repository1;

public class Service1 extends AbstractService implements UService {

	private Repository1 repository;

	public Service1(Repository1 repo) {
		repository = repo;
	}

	@Override
	public Optional<UEntity> save(UDto dto) throws CustomException {

		Entity1 e1 = (Entity1) convertDto2Entity(dto, Entity1.class);

		if (e1 != null) {

			Entity1 result = repository.save(e1);

			return Optional.ofNullable(result);

		} else {

			return Optional.empty();
		}

	}

	@Override
	public List<? extends UEntity> getAll() {

		List<Entity1> ls = (List<Entity1>) repository.findAll();

		return ls;
	}

	@Override
	public UEntity updateEntity(UDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntity(Long id) {

		repository.deleteById(id);

	}
}
