package pl.biznes.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biznes.entities.prestashop.CategoryLang;

@Repository
public interface CategoryLangRepo extends CrudRepository<CategoryLang, Long> {
}
