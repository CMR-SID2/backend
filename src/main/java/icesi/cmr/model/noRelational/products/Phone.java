package icesi.cmr.model.noRelational.products;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Document(collection = "products")
public class Phone extends Product {

    private String screenSize;
    private String batteryLife;
    private String cameraResolution;
    private String operatingSystem;

}
