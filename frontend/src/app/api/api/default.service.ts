/**
 * Title: Employee Management API
 * Description: CRUD operations for managing employees
 *
 * The version of the OpenAPI document: 1.0.0
 */
import { Inject, Injectable, Optional } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,
         HttpResponse, HttpEvent, HttpParameterCodec, HttpContext 
        }       from '@angular/common/http';
import { CustomHttpParameterCodec } from '../encoder';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';
import { ErrorMessage } from '../model/error-message';

import { BASE_PATH, COLLECTION_FORMATS } from '../variables';
import { Configuration } from '../configuration';

@Injectable({
  providedIn: 'root'
})
export class DefaultService {

    private readonly PATH = 'http://localhost:8080/skeleton/v1/employees';

    constructor(private readonly httpClient: HttpClient) {}

    // fetchAllEmployees(): Observable<Array<Employee>> {
    //    return this.httpClient.get<Array<Employee>>(this.PATH);
    // }

    // fetchEmployee(id: string): Observable<Employee> {
    //     return this.httpClient.get<Employee>(this.PATH + '/' + id);
    // }

    // updateEmployee(employee: Employee): Observable<IResponseMessage> {
    //     return this.httpClient.put<IResponseMessage>(this.PATH + '/' + employee.id, employee);
    // }

    // createEmployee(employee: Employee): Observable<IResponseMessage> {
    //     return this.httpClient.post<IResponseMessage>(this.PATH, employee);
    // }

    // deleteEmployee(id: string): Observable<IResponseMessage> {
    //     return this.httpClient.delete<IResponseMessage>(this.PATH + '/' + id);
    // }


    /**
     * Create a new employee
     */
    createEmployee(employee: Employee): Observable<any> {
        return this.httpClient.post<any>(this.PATH);
    }
    
    /**
     * Delete an employee by ID
     */
    deleteEmployee(employeeId: number): Observable<any> {
        return this.httpClient.delete<any>(this.PATH);
    }
    
    /**
     * Get an employee by ID
     */
    getEmployeeById(employeeId: number): Observable<Employee> {
        return this.httpClient.get<Employee>(this.PATH);
    }
    
    /**
     * Get all employees
     */
    getEmployees(): Observable<Array<Employee>> {
        return this.httpClient.get<Array<Employee>>(this.PATH);
    }
    
    /**
     * Update an employee by ID
     */
    updateEmployee(employeeId: number, employee: Employee): Observable<any> {
        return this.httpClient.put<any>(this.PATH);
    }
    

}
