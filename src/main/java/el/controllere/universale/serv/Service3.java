package el.controllere.universale.serv;

import java.util.List;
import java.util.Optional;

import el.controllere.universale.domain.Entity3;
import el.controllere.universale.domain.UEntity;
import el.controllere.universale.dto.UDto;
import el.controllere.universale.exception.CustomException;
import el.controllere.universale.repo.Repository3;

public class Service3 extends AbstractService implements UService {

	private Repository3 repository;

	public Service3(Repository3 repo) {
		repository = repo;
	}

	@Override
	public Optional<UEntity> save(UDto dto) throws CustomException {

		Entity3 e3 = (Entity3) convertDto2Entity(dto, Entity3.class);

		if (e3 != null) {

			Entity3 result = repository.save(e3);

			return Optional.ofNullable(result);

		} else {

			return Optional.empty();
		}

	}

	@Override
	public List<? extends UEntity> getAll() {

		List<Entity3> ls = (List<Entity3>) repository.findAll();

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
