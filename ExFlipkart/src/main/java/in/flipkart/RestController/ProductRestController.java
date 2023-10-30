package in.flipkart.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.flipkart.ProductService.ProductService;
import in.flipkart.productEntity.Product;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService service;

	@PostMapping("/product")
	public ResponseEntity<String> addBook(@RequestBody Product product) {
		System.err.println(product.getProductName());
		String msg = service.upsertProduct(product);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/product")
	public ResponseEntity<List<Product>> getProduct() {
		List<Product> list = service.getProduct();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

	@PutMapping("/product/{productId}")
	public ResponseEntity<String> updateProduct(@RequestBody Product product, @PathVariable int productId) {
		String msg = service.updateProduct(product, productId);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@DeleteMapping("product/{bookId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer bookId) {
		String deleteProduct = service.deleteProduct(bookId);
		return new ResponseEntity<String>(deleteProduct, HttpStatus.OK);
	}
}
