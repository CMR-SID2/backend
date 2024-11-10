package icesi.cmr.services.interfaces;

import icesi.cmr.dto.CategoryDTO;

public interface CategoryService {

    void saveCategory(CategoryDTO categoryDTO);

    void deleteCategory(String name);

    void updateCategory(CategoryDTO categoryDTO);

    void getCategory(String name);



}
