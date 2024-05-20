package nl.skeleton.gen.api;

import nl.skeleton.gen.model.Employee;
import nl.skeleton.gen.model.ErrorMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

    import jakarta.validation.constraints.*;
    import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-20T23:13:11.531162100+02:00[Europe/Amsterdam]", comments = "Generator version: 7.5.0")
    @Controller
@RequestMapping("${openapi.employeeManagement.base-path:/skeleton/v1}")
public class EmployeesApiController implements EmployeesApi {

    private final EmployeesApiDelegate service;

    @Autowired
    public EmployeesApiController(EmployeesApiDelegate service) {
        this.service = service;
    }

        @Override
        public ResponseEntity<Void> createEmployee(Employee employee) {
            return service.createEmployee(employee);
        }
        @Override
        public ResponseEntity<Void> deleteEmployee(Long employeeId) {
            return service.deleteEmployee(employeeId);
        }
        @Override
        public ResponseEntity<Employee> getEmployeeById(Long employeeId) {
            return service.getEmployeeById(employeeId);
        }
        @Override
        public ResponseEntity<List<Employee>> getEmployees() {
            return service.getEmployees();
        }
        @Override
        public ResponseEntity<Void> updateEmployee(Long employeeId,
        Employee employee) {
            return service.updateEmployee(employeeId,employee);
        }
}