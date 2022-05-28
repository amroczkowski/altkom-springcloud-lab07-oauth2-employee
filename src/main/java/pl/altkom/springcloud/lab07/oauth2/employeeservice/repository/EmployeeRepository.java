package pl.altkom.springcloud.lab07.oauth2.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.springcloud.lab07.oauth2.employeeservice.repository.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByProjectId(final Long projectId);
}
