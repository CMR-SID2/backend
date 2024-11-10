package icesi.cmr.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import icesi.cmr.dto.products.LaptopDTO;
import icesi.cmr.dto.products.PhoneDTO;
import icesi.cmr.dto.products.PrinterDTO;
import icesi.cmr.dto.products.ProductDTO;
import icesi.cmr.exceptions.InvalidProductType;
import icesi.cmr.exceptions.ProductTypeRequiredException;
import icesi.cmr.mappers.ProductMapper;
import icesi.cmr.model.noRelational.products.Product;
import icesi.cmr.model.relational.equipments.Equipment;
import icesi.cmr.repositories.equipments.EquipmentRepository;
import icesi.cmr.repositories.noRelational.ProductRepository;
import icesi.cmr.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private EquipmentRepository equipmentRepository;

    public void createProduct(ProductDTO productDTO, Integer stock) {

        Equipment equipment = Equipment.builder().stock(stock).build();

        Product product = productMapper.toEntity(productDTO);

        Product productResponse = productRepository.save(product);

        //Set the product id of mongo to the equipment in order to maximize the relation between the two databases
        //and use the index optimization format.

        String inventaryCode = productResponse.getId();
        System.out.println("Inventary code: " + inventaryCode);
        equipment.setInventaryCode(inventaryCode);
        equipmentRepository.save(equipment);

    }

    public ProductDTO parseProductDTO(Map<String, Object> productData) throws ProductTypeRequiredException {

        String productType = (String) productData.get("productType");

        if (productType == null) {

            throw new ProductTypeRequiredException("Product type is required");

        }

        Class<? extends ProductDTO> dtoClass = getProductDTOClass(productType);

        var productDTO = objectMapper.convertValue(productData, dtoClass);

        System.out.println("ProductDTO  on productServiceImpl by convertValue: " + productDTO + "\n");

        return objectMapper.convertValue(productData, dtoClass);
    }

    private Class<? extends ProductDTO> getProductDTOClass(String productType) throws InvalidProductType {
        return switch (productType.toLowerCase()) {
            case "laptop" -> LaptopDTO.class;
            case "printer" -> PrinterDTO.class;
            case "phone" -> PhoneDTO.class;
            // Add cases for other product types
            default -> throw new InvalidProductType("Invalid product type.");
        };
    }


}
