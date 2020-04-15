package el.controllere.universale.serv;

import java.util.List;
import java.util.Optional;

import el.controllere.universale.domain.Entity2;
import el.controllere.universale.domain.RootEntity;
import el.controllere.universale.dto.RootDto;
import el.controllere.universale.exception.CustomException;
import el.controllere.universale.repo.Repository2;

public class Service2 extends AbstractService implements RootService {

	private Repository2 repository;

	public Service2(Repository2 repo) {

		repository = repo;

	}

	public Service2() {

	}

	@Override
	public Optional<RootEntity> save(RootDto dto) throws CustomException {

		Entity2 e2 = (Entity2) convertDto2Entity(dto, Entity2.class);

		if (e2 != null) {

			Entity2 result = repository.save(e2);

			return Optional.ofNullable(result);

		} else {

			return Optional.empty();
		}

	}

	@Override
	public List<? extends RootEntity> getAll() {

		List<Entity2> ls = (List<Entity2>) repository.findAll();

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
