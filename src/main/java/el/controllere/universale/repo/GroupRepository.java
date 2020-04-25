package el.controllere.universale.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import el.controllere.universale.domain.Groups;

@Repository
public interface GroupRepository extends CrudRepository<Groups, Long> {
	List<Groups> findByQ(Long q);
}
