import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HelloService } from '../features/hello/hello-service';
import { HttpClientModule } from '@angular/common/http';
import { EmployeeService } from '../features/employees/employees-service';
import { Employee } from '../features/employees/employee';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule, CommonModule, FormsModule],
  providers: [
    HelloService,
    EmployeeService,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'skeleton-openapi-frontend';

  message = '';
  employees: Array<Employee> = [];
  employee: Employee = {
    id: 0,
    name: '',
    department: '',
    position: '',
    salary: 0
  }; // Initialize employee object

  constructor(private readonly helloService: HelloService,
    private readonly employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.helloService.getHello().subscribe(world => {
      this.message = world.message;
    });
    this.employeeService.getEmployees().subscribe(employees => this.employees = employees);
  }

  updateEmployee(): void {
    this.employeeService.updateEmployee(this.employee.id, this.employee);
    this.employeeService.getEmployees().subscribe(employees => this.employees = employees);
  }
}
