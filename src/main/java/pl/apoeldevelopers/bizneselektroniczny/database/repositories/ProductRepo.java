package pl.apoeldevelopers.bizneselektroniczny.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.apoeldevelopers.bizneselektroniczny.entities.prestashop.Product;

/**
 * Created by Jakub Michałowski on 14.01.2018.
 * All rights reserved.
 */
@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
}
