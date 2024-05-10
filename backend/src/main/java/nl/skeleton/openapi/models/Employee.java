package nl.skeleton.openapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Schema(description = "Employee entity")
public class Employee {

    @Schema(description = "Unique identifier for the employee")
    @NotNull(message = "ID is required")
    @Positive(message = "ID must be greater than 0")
    private Long id;

    @Schema(description = "Name of the employee")
    @NotNull(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z0-9\\s\\-]+$", message = "Name must be alphanumeric")
    private String name;

    @Schema(description = "Department of the employee")
    @NotNull(message = "Department is required")
    @Pattern(regexp = "^(IT|FINANCE)$", message = "Department can only be IT or FINANCE")
    private String department;

    @Schema(description = "Position of the employee")
    @NotNull(message = "Position is required")
    private String position;

    @Schema(description = "Salary of the employee")
    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be greater than 0")
    private Double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

