package pl.biznes.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biznes.entities.UserRating;

import java.util.List;

@Repository
public interface RatingRepo extends CrudRepository<UserRating, Long>{
    List<UserRating> findFirstByProductIdAndUserId(Long productId, Long userId);
}
