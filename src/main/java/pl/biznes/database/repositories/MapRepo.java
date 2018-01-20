package pl.biznes.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biznes.entities.UserIdMap;

import java.util.List;

@Repository
public interface MapRepo extends CrudRepository<UserIdMap, Long> {
    List<UserIdMap> findFirstBySid(String sid);
}
