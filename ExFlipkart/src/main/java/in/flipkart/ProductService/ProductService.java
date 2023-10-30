package in.flipkart.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.flipkart.productEntity.Product;
import in.flipkart.productRepository.ProductRepository;

@Service
public class ProductService implements ProductServiceInterface {

	@Autowired
	private ProductRepository repository;

	@Override
	public String upsertProduct(Product product) {
		Integer productId = product.getProductId();
		repository.save(product);
		if (productId == null) {
			return "Record Inserted in DataBase.......!";
		} else {
			return "Record Updated....!";
		}
	}

	@Override
	public List<Product> getProduct() {
		return repository.findAll();
	}

	@Override
	public String deleteProduct(Integer bookId) {
		repository.deleteById(bookId);
		return "Product Delete..........!";
	}

	@Override
	public String updateProduct(Product product, int productId) {
	
		Product product2 = this.repository.findById(productId).get();
		
		product2.setProductName(product.getProductName());
		product2.setQty(product.getQty());
		product2.setPrice(product2.getPrice());
		
		Product save = this.repository.save(product2);
		
		if (save!=null) {
			return "Update Successfully";
		} else {
			return "Something went wrong";
		}
		
	}

}
