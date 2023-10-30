package in.flipkart.ProductService;

import java.util.List;

import in.flipkart.productEntity.Product;

public interface ProductServiceInterface {

	public String upsertProduct(Product product);

	public List<Product> getProduct();

	public String deleteProduct(Integer bookId);
	
	public String updateProduct(Product product,int productId);

}
