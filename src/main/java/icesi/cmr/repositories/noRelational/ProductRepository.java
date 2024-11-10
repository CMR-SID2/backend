package icesi.cmr.repositories.noRelational;

import icesi.cmr.model.noRelational.products.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Integer> {



}
