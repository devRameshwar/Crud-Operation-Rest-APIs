package in.flipkart.productRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.flipkart.productEntity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
