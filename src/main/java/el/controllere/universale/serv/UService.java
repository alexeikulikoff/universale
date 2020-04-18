package el.controllere.universale.serv;

import java.util.List;
import java.util.Optional;

import el.controllere.universale.domain.UEntity;
import el.controllere.universale.dto.UDto;
import el.controllere.universale.exception.CustomException;

public interface UService {

	Optional<UEntity> save(UDto dto) throws CustomException;

	UEntity updateEntity(UDto dto);

	void deleteEntity(Long id);

	List<? extends UEntity> getAll();

}
