package employeeManagement.employeeManagement.dao;

import employeeManagement.employeeManagement.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel="employeeDetails", path="employee-details")
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {
}
