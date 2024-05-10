import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../../services/employees-service';

@UntilDestroy()
@Component({
    selector: 'app-employee-details',
    templateUrl: './employee-details.component.html',
    styleUrl: './employee-details.component.css',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EmployeeDetailsComponent implements OnInit {
    employeeForm: FormGroup | undefined;
  
    constructor(private readonly formBuilder: FormBuilder,
                private readonly activatedRoute: ActivatedRoute,
                private readonly router: Router,
                private readonly employeeService: EmployeeService) { }
  
    ngOnInit(): void {
      this.employeeForm = this.formBuilder.group({
        id: [undefined],
        name: ['', Validators.required],
        department: ['', Validators.required],
        position: ['', Validators.required],
        salary: ['', [Validators.required, Validators.min(0)]]
      });

       this.activatedRoute.queryParams.subscribe(params => {
          const employeeId = params['employeeId'];
          if (employeeId) {
            this.employeeService.fetchEmployee(employeeId).pipe(untilDestroyed(this)).subscribe(employee => {
              this.employeeForm?.setValue({
                  id: employee.id,
                  name: employee.name,
                  department: employee.department,
                  position: employee.position,
                  salary: employee.salary
              });
            })
          }
        });

        // this.employeeForm.get('id')?.disable();

    }

    cancel(): void {
      this.router.navigateByUrl('/list');
    }

    onSubmit(): void {
        if (this.employeeForm) {
          if (this.employeeForm?.value.id) {
            this.employeeService.updateEmployee(this.employeeForm.value).pipe(untilDestroyed(this)).subscribe(response => {
              this.router.navigateByUrl('/list');
            });
          } else {
            this.employeeService.createEmployee(this.employeeForm.value).pipe(untilDestroyed(this)).subscribe(response => {
              console.log(response);
              this.router.navigateByUrl('/list');
            });
          }
        }
    }
}
