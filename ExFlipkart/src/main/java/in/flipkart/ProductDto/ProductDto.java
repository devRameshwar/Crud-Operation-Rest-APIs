package in.flipkart.ProductDto;

import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class ProductDto {
    private String productName;
    private Integer qty;
    private double price;
}
