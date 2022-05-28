package pl.altkom.springcloud.lab07.oauth2.employeeservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.altkom.springcloud.lab07.oauth2.employeeservice.controller.model.CreateEmployeeRequest;
import pl.altkom.springcloud.lab07.oauth2.employeeservice.controller.model.Employee;
import pl.altkom.springcloud.lab07.oauth2.employeeservice.controller.model.UpdateEmployeeRequest;
import pl.altkom.springcloud.lab07.oauth2.employeeservice.service.EmployeeService;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/project/{projectId}")
    public List<Employee> getProjectEmployees(@PathVariable("projectId") final Long projectId) {
        log.info("Getting project {} employees", projectId);
        return employeeService.getProjectEmployees(projectId);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        log.info("Getting employee {}", id);
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody final CreateEmployeeRequest request) {
        return employeeService.addEmployee(request);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") final Long employeeId, @Valid @RequestBody final UpdateEmployeeRequest request) {
        return employeeService.modifyEmployee(employeeId, request);
    }
}
