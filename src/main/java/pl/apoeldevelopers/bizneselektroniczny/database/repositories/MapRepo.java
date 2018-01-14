package pl.apoeldevelopers.bizneselektroniczny.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.apoeldevelopers.bizneselektroniczny.entities.UserIdMap;

/**
 * Created by Jakub Michałowski on 14.01.2018.
 * All rights reserved.
 */
@Repository
public interface MapRepo extends CrudRepository<UserIdMap, Long> {
}