package icesi.cmr.dto.products;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
public class ProductDTO {

    private String productType; // "laptop", "printer", "phone", etc.

    private String name;
    private String brand;
    private String model;
    private String description;
    private Double price;
    private Boolean available;
    private Integer warrantyPeriod;
    private Long releaseDate;
    private Map<String, Object> specifications;
    private Map<String, Object> images;
    private Map<String, Object> categories;
}
