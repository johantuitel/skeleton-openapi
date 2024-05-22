package nl.skeleton.gen.api;

import nl.skeleton.gen.model.Employee;
import nl.skeleton.gen.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link EmployeesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-22T14:38:04.639431600+02:00[Europe/Amsterdam]", comments = "Generator version: 7.5.0")
public interface EmployeesApiDelegate {

    /**
     * POST /employees : Create a new employee
     *
     * @param employee  (required)
     * @return Employee created successfully (status code 201)
     *         or Bad request (status code 400)
     * @see EmployeesApi#createEmployee
     */
    ResponseEntity<Void> createEmployee(Employee employee);

    /**
     * DELETE /employees/{employeeId} : Delete an employee by ID
     *
     * @param employeeId  (required)
     * @return Employee removed successfully (status code 200)
     *         or Employee not found (status code 404)
     * @see EmployeesApi#deleteEmployee
     */
    ResponseEntity<Void> deleteEmployee(Long employeeId);

    /**
     * GET /employees/{employeeId} : Get an employee by ID
     *
     * @param employeeId  (required)
     * @return Successfully retrieved employee (status code 200)
     *         or Employee not found (status code 404)
     * @see EmployeesApi#getEmployeeById
     */
    ResponseEntity<Employee> getEmployeeById(Long employeeId);

    /**
     * GET /employees : Get all employees
     *
     * @return Successfully retrieved all employees (status code 200)
     * @see EmployeesApi#getEmployees
     */
    ResponseEntity<List<Employee>> getEmployees();

    /**
     * PUT /employees/{employeeId} : Update an employee by ID
     *
     * @param employeeId  (required)
     * @param employee  (required)
     * @return Employee updated successfully (status code 200)
     *         or Employee not found (status code 404)
     * @see EmployeesApi#updateEmployee
     */
    ResponseEntity<Void> updateEmployee(Long employeeId,
        Employee employee);

}
