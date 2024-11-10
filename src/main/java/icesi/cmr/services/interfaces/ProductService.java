package icesi.cmr.services.interfaces;

import icesi.cmr.dto.products.ProductDTO;
import icesi.cmr.exceptions.ProductTypeRequiredException;

import java.util.Map;

public interface ProductService {



    void createProduct(ProductDTO productDTO, Integer stock);

    ProductDTO parseProductDTO(Map<String, Object> productData ) throws ProductTypeRequiredException;


}
