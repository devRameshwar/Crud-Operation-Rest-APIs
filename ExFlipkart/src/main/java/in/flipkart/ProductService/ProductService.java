package in.flipkart.ProductService;

import in.flipkart.ProductDto.ProductDto;
import in.flipkart.productEntity.Product;
import in.flipkart.productRepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private Product product;

    @Override
    public String upsertProduct(ProductDto productDto) {
        //	Integer productId = product.getProductId();
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setQty(productDto.getQty());
        Product productId = repository.save(product);
		return "Product Added...";
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

        if (save != null) {
            return "Update Successfully";
        } else {
            return "Something went wrong";
        }

    }

}
