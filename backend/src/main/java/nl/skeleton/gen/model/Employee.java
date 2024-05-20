package nl.skeleton.gen.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Employee
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-20T23:14:33.651827600+02:00[Europe/Amsterdam]", comments = "Generator version: 7.5.0")
public class Employee {

  private Long id;

  private String name;

  /**
   * Department of the employee
   */
  public enum DepartmentEnum {
    IT("IT"),
    
    FINANCE("FINANCE");

    private String value;

    DepartmentEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DepartmentEnum fromValue(String value) {
      for (DepartmentEnum b : DepartmentEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private DepartmentEnum department;

  private String position;

  private Double salary;

  public Employee() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Employee(Long id, String name, DepartmentEnum department, String position, Double salary) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.position = position;
    this.salary = salary;
  }

  public Employee id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the employee
   * @return id
  */
  @NotNull 
  @Schema(name = "id", description = "Unique identifier for the employee", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Employee name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the employee
   * @return name
  */
  @NotNull @Pattern(regexp = "^[a-zA-Z0-9\\s\\-]+$") 
  @Schema(name = "name", description = "Name of the employee", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Employee department(DepartmentEnum department) {
    this.department = department;
    return this;
  }

  /**
   * Department of the employee
   * @return department
  */
  @NotNull 
  @Schema(name = "department", description = "Department of the employee", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("department")
  public DepartmentEnum getDepartment() {
    return department;
  }

  public void setDepartment(DepartmentEnum department) {
    this.department = department;
  }

  public Employee position(String position) {
    this.position = position;
    return this;
  }

  /**
   * Position of the employee
   * @return position
  */
  @NotNull 
  @Schema(name = "position", description = "Position of the employee", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("position")
  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Employee salary(Double salary) {
    this.salary = salary;
    return this;
  }

  /**
   * Salary of the employee
   * minimum: 0
   * @return salary
  */
  @NotNull @DecimalMin("0") 
  @Schema(name = "salary", description = "Salary of the employee", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("salary")
  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.id, employee.id) &&
        Objects.equals(this.name, employee.name) &&
        Objects.equals(this.department, employee.department) &&
        Objects.equals(this.position, employee.position) &&
        Objects.equals(this.salary, employee.salary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, department, position, salary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    salary: ").append(toIndentedString(salary)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

