package br.com.leivas.repository;

import br.com.leivas.model.Product;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
