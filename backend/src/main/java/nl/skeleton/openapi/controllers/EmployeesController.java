package nl.skeleton.openapi.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import nl.skeleton.openapi.models.Employee;
import nl.skeleton.openapi.models.ResponseMessage;

@OpenAPIDefinition(info = @Info(description = "Employee API"))
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/skeleton/v1")
public class EmployeesController {

    private final Employee johnDoe = createEmployee(1L, "John Doe", "IT", "Software Engineer", 50000.00);
    private final Employee janeSmith = createEmployee(2L, "Jane Smith", "FINANCE", "Accountant", 60000.00);
    private final Employee aliceJohnson = createEmployee(3L, "Alice Johnson", "IT", "System Administrator", 55750.00);
    private final Map<Long, Employee> employees = new HashMap<>();

    public EmployeesController() {
        employees.put(johnDoe.getId(), johnDoe);
        employees.put(janeSmith.getId(), janeSmith);
        employees.put(aliceJohnson.getId(), aliceJohnson);
    }

    @Operation(summary = "Get all employees")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all employees")
    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employees.values(), HttpStatus.OK);
    }

    @Operation(summary = "Get an employee by ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved employee")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    @GetMapping(value = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEmployee(@PathVariable Long employeeId) {
        if(!this.employees.containsKey(employeeId)) {
            return new ResponseEntity<>(new ResponseMessage("Employee not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.employees.get(employeeId), HttpStatus.OK);
    }

    @Operation(summary = "Update an employee by ID")
    @ApiResponse(responseCode = "200", description = "Employee updated successfully")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    @PutMapping(value = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> updateEmployeeById(@PathVariable Long employeeId, @Valid @RequestBody Employee employee) {
        if(!this.employees.containsKey(employeeId)) {
            return new ResponseEntity<>(new ResponseMessage("Employee not found"), HttpStatus.NOT_FOUND);
        }

        this.employees.put(employeeId, employee);

        return new ResponseEntity<>(new ResponseMessage("Employee updated successfully"), HttpStatus.OK);
    }

    @Operation(summary = "Create a new employee")
    @ApiResponse(responseCode = "201", description = "Employee created successfully")
    @ApiResponse(responseCode = "400", description = "Employee already exists")
    @PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee) {
        if (employee.getId() == null) {
            employee.setId(getHighestKey() + 1);
        }
        if(this.employees.containsKey(employee.getId())) {
            return new ResponseEntity<>(new ResponseMessage("Employee already exists"), HttpStatus.BAD_REQUEST);
        }

        this.employees.put(employee.getId(), employee);

        return new ResponseEntity<>(new ResponseMessage("Employee created successfully"), HttpStatus.CREATED);
    }

    @Operation(summary = "Delete an employee by ID")
    @ApiResponse(responseCode = "200", description = "Employee removed successfully")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    @DeleteMapping(value = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> deleteEmployeeById(@PathVariable Long employeeId) {
        if(!this.employees.containsKey(employeeId)) {
            return new ResponseEntity<>(new ResponseMessage("Employee not found"), HttpStatus.NOT_FOUND);
        }

        this.employees.remove(employeeId);

        return new ResponseEntity<>(new ResponseMessage("Employee removed successfully"), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    private Employee createEmployee(Long id, String name, String department, String position, Double salary) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setSalary(salary);

        return employee;
    }

    private Long getHighestKey() {
        Long highestKey = 1L;
        for (Long key : employees.keySet()) {
            if (key > highestKey) {
                highestKey = key;
            }
        }
        return highestKey;
    }
}
