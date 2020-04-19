package el.controllere.universale.serv;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

import el.controllere.universale.domain.Entity3;
import el.controllere.universale.domain.UEntity;
import el.controllere.universale.dto.Dto3;
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
		Random rand = new Random();
		Function<UDto, UEntity> fn = (u) -> {
			Dto3 dto3 = (Dto3) u;
			Entity3 en = new Entity3();
			en.setFirstName(dto3.getFirstName());
			en.setLastName(dto3.getLastName());
			en.setSalary(Long.valueOf(rand.nextInt(9999)));
			en.setBirthday(dto3.getBirthday());
			return en;

		};
		Entity3 e3 = (Entity3) toEntity(dto, fn);
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
