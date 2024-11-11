package icesi.cmr.services.interfaces;

import icesi.cmr.dto.DepartmentDTO;
import icesi.cmr.model.relational.companies.Department;

import java.util.List;

public interface DepartmentService {


    Department getDepartment(Integer id);

    void saveDepartment(DepartmentDTO department);

    void deleteDepartment(Integer id);

    List<Department> getDepartments();


}
