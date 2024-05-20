package nl.skeleton.openapi;

import nl.skeleton.gen.api.EmployeesApiDelegate;
import nl.skeleton.gen.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeesService implements EmployeesApiDelegate {

    private final nl.skeleton.openapi.models.Employee johnDoe = createEmployee(1L, "John Doe", "IT", "Software Engineer", 50000.00);
    private final nl.skeleton.openapi.models.Employee janeSmith = createEmployee(2L, "Jane Smith", "FINANCE", "Accountant", 60000.00);
    private final nl.skeleton.openapi.models.Employee aliceJohnson = createEmployee(3L, "Alice Johnson", "IT", "System Administrator", 55750.00);
    private final Map<Long, nl.skeleton.openapi.models.Employee> employees = new HashMap<>();

    public EmployeesService() {
        employees.put(johnDoe.getId(), johnDoe);
        employees.put(janeSmith.getId(), janeSmith);
        employees.put(aliceJohnson.getId(), aliceJohnson);
    }
    @Override
    public ResponseEntity<Void> employeesEmployeeIdDelete(Long employeeId) {
        return EmployeesApiDelegate.super.employeesEmployeeIdDelete(employeeId);
    }

    @Override
    public ResponseEntity<Employee> employeesEmployeeIdGet(Long employeeId) {
        return EmployeesApiDelegate.super.employeesEmployeeIdGet(employeeId);
    }

    @Override
    public ResponseEntity<Void> employeesEmployeeIdPut(Long employeeId, Employee employee) {
        return EmployeesApiDelegate.super.employeesEmployeeIdPut(employeeId, employee);
    }

    @Override
    public ResponseEntity<List<Employee>> employeesGet() {
        return EmployeesApiDelegate.super.employeesGet();
    }

    @Override
    public ResponseEntity<Void> employeesPost(Employee employee) {
        return EmployeesApiDelegate.super.employeesPost(employee);
    }

    private nl.skeleton.openapi.models.Employee createEmployee(Long id, String name, String department, String position, Double salary) {
        nl.skeleton.openapi.models.Employee employee = new nl.skeleton.openapi.models.Employee();
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
