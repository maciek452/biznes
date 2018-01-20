package pl.biznes.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biznes.entities.prestashop.Image;

@Repository
public interface ImageRepo extends CrudRepository<Image, Long>{
}
