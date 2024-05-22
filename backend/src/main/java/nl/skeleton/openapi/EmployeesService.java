package nl.skeleton.openapi;

import nl.skeleton.gen.api.EmployeesApiDelegate;
import nl.skeleton.gen.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeesService implements EmployeesApiDelegate {

    private final Employee johnDoe = createEmployee(1L, "John Doe", Employee.DepartmentEnum.IT, "Software Engineer", 50000.00);
    private final Employee janeSmith = createEmployee(2L, "Jane Smith", Employee.DepartmentEnum.FINANCE, "Accountant", 60000.00);
    private final Employee aliceJohnson = createEmployee(3L, "Alice Johnson", Employee.DepartmentEnum.IT, "System Administrator", 55750.00);
    private final Map<Long, Employee> employees = new HashMap<>();

    public EmployeesService() {
        employees.put(johnDoe.getId(), johnDoe);
        employees.put(janeSmith.getId(), janeSmith);
        employees.put(aliceJohnson.getId(), aliceJohnson);
    }

    @Override
    public ResponseEntity<Void> createEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(getHighestKey() + 1);
        }
        if(this.employees.containsKey(employee.getId())) {
            return ResponseEntity.badRequest().build();
        }

        this.employees.put(employee.getId(), employee);

        return ResponseEntity.created(null).build();
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Long employeeId) {
        if(!this.employees.containsKey(employeeId)) {
            return ResponseEntity.notFound().build();
        }

        this.employees.remove(employeeId);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(Long employeeId) {
        if(!this.employees.containsKey(employeeId)) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(this.employees.get(employeeId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(employees.values().stream().toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateEmployee(Long employeeId, Employee employee) {
        if(!this.employees.containsKey(employeeId)) {
            return ResponseEntity.notFound().build();
        }

        this.employees.put(employeeId, employee);

        return ResponseEntity.ok().build();
    }

    private Employee createEmployee(Long id, String name, Employee.DepartmentEnum department, String position, Double salary) {
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
