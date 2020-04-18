package el.controllere.universale.serv;

import java.util.List;
import java.util.Optional;

import el.controllere.universale.domain.Entity2;
import el.controllere.universale.domain.UEntity;
import el.controllere.universale.dto.UDto;
import el.controllere.universale.exception.CustomException;
import el.controllere.universale.repo.Repository2;

public class Service2 extends AbstractService implements UService {

	private Repository2 repository;

	public Service2(Repository2 repo) {
		repository = repo;
	}

	@Override
	public Optional<UEntity> save(UDto dto) throws CustomException {

		Entity2 e2 = (Entity2) convertDto2Entity(dto, Entity2.class);

		if (e2 != null) {

			Entity2 result = repository.save(e2);

			return Optional.ofNullable(result);

		} else {

			return Optional.empty();
		}

	}

	@Override
	public List<? extends UEntity> getAll() {

		List<Entity2> ls = (List<Entity2>) repository.findAll();

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
