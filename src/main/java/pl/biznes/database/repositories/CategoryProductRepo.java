package pl.biznes.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biznes.entities.prestashop.CategoryProduct;

import java.util.List;

@Repository
public interface CategoryProductRepo extends CrudRepository<CategoryProduct, Long>{
    List<CategoryProduct> findCategoryProductByProductId(Long id);
}
