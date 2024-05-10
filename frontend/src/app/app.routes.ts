import { Routes } from '@angular/router';
import { EmployeesComponentsModule } from '../features/employees/components/employees-components.module';

export const routes: Routes = [{
    path: '',
    loadChildren: () => import('../features/employees/components/employees-components.module').then(m => EmployeesComponentsModule)
}];
