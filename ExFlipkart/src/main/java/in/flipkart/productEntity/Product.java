package in.flipkart.productEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Service;

@Entity
@Data
@Table(name = "FlipkartProduct")
@Service
public class Product {
	@Id
	//this is for auto generate id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer productId;
	@Column
	private String productName;
	@Column
	private Integer qty;
	@Column
	private double price;

}
