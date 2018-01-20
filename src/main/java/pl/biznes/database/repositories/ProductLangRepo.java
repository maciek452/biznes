package pl.biznes.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biznes.entities.prestashop.ProductLang;

@Repository
public interface ProductLangRepo extends CrudRepository<ProductLang, Long> {
}
