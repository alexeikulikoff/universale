package el.controllere.universale.serv;

import java.util.List;
import java.util.Optional;

import el.controllere.universale.domain.RootEntity;
import el.controllere.universale.dto.RootDto;
import el.controllere.universale.exception.CustomException;

public interface RootService {

	Optional<RootEntity> save(RootDto dto) throws CustomException;

	RootEntity updateEntity(RootDto dto);

	void deleteEntity(Long id);

	List<? extends RootEntity> getAll();

}
