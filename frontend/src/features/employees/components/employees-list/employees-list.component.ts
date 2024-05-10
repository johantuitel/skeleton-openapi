import { CommonModule } from '@angular/common';
import { ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Employee } from '../../api/employee';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { Router } from '@angular/router';
import { EmployeeService } from '../../services/employees-service';

@UntilDestroy()
@Component({
    selector: 'app-employees-list',
    templateUrl: './employees-list.component.html',
    styleUrl: './employees-list.component.css',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EmployeesListComponent implements OnInit {
    employees: Array<Employee> = [];
    constructor(private readonly changeDetectorReference: ChangeDetectorRef,
        private readonly router: Router,
        private readonly employeeService: EmployeeService) {}

    ngOnInit(): void {
        this.fetchAllEmployees();
    }

    fetchAllEmployees(): void {
        this.employeeService.fetchAllEmployees().pipe(untilDestroyed(this)).subscribe(employees => {
            if (employees) {
                employees.forEach(employee => this.employees.push(employee));
                this.changeDetectorReference.detectChanges();
            }
        });
    }

    new(): void {
        this.router.navigate(['/details']);
    }

    edit(employee: Employee): void {
        this.router.navigate(
            ['/details'],
            { queryParams: { employeeId: employee.id?.toString() } }
          );
    }
    
    remove(id: number | undefined): void {
        if (id) {
            this.employeeService.deleteEmployee(id.toString()).pipe(untilDestroyed(this)).subscribe(response => {
                console.log(response);
                this.employees = [];
                this.fetchAllEmployees();
            });
        }
    }
}
