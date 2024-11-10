package icesi.cmr.controllers;

import icesi.cmr.dto.ProductRequestDTO;
import icesi.cmr.dto.products.ProductDTO;
import icesi.cmr.exceptions.InvalidProductType;
import icesi.cmr.exceptions.ProductTypeRequiredException;
import icesi.cmr.services.impl.ProductServiceImpl;
import icesi.cmr.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productServiceImpl;

    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {

        try {
            ProductDTO productDTO = productServiceImpl.parseProductDTO(productRequestDTO.getProductData());

            productServiceImpl.createProduct(productDTO, productRequestDTO.getStock());

            return ResponseEntity.ok().body("Product created successfully");

        }catch (InvalidProductType | ProductTypeRequiredException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }catch (HttpClientErrorException.Unauthorized e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }




}
