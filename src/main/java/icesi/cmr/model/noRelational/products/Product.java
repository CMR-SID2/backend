package icesi.cmr.model.noRelational.products;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    @Indexed(unique = true)
    private String id;
    private String name;
    private String brand;
    private String model;
    private String description;
    private Double price;
    private Boolean available;
    private Integer warrantyPeriod; // in months
    private Long releaseDate;
    private Map<String, Object> specifications;
    private Map<String, Object> images;
    private String category;
}
