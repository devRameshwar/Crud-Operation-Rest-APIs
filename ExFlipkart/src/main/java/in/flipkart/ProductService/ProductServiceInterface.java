package in.flipkart.ProductService;

import java.util.List;

import in.flipkart.ProductDto.ProductDto;
import in.flipkart.productEntity.Product;

public interface ProductServiceInterface {

	public String upsertProduct(ProductDto productDto);

	public List<Product> getProduct();

	public String deleteProduct(Integer bookId);
	
	public String updateProduct(Product product,int productId);

}
