package employeeManagement.employeeManagement.dao;

import employeeManagement.employeeManagement.entity.EmployeePersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="employeeInfo", path="employee-info")
public interface EmployeePersonalInfoRepository extends JpaRepository<EmployeePersonalInfo, Integer> {
}
