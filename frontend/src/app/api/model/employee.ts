/**
 * Title: Employee Management API
 * Description: CRUD operations for managing employees
 *
 * The version of the OpenAPI document: 1.0.0
 */
export interface Employee { 
    /**
     * Unique identifier for the employee
     */
    id: number;
    /**
     * Name of the employee
     */
    name: string;
    /**
     * Department of the employee
     */
    department: Employee.DepartmentEnum;
    /**
     * Position of the employee
     */
    position: string;
    /**
     * Salary of the employee
     */
    salary: number;
}
export namespace Employee {
    export type DepartmentEnum = 'IT' | 'FINANCE';
    export const DepartmentEnum = {
        It: 'IT' as DepartmentEnum,
        Finance: 'FINANCE' as DepartmentEnum
    };
}


