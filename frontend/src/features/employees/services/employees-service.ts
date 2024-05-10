import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { EMPTY, Observable, of } from "rxjs";
import { Employee } from "../api/employee";
import { IResponseMessage } from "../api/response-message";

type Immutable<T> = {
    readonly [K in keyof T]: Immutable<T[K]>;
};

@Injectable({
    providedIn: "root"
})
export class EmployeeService {

    private readonly PATH = 'http://localhost:8080/skeleton/v1/employees';

    constructor(private readonly httpClient: HttpClient) {}

    fetchAllEmployees(): Observable<Immutable<Array<Employee>>> {
       return this.httpClient.get<Immutable<Array<Employee>>>(this.PATH);
    }

    fetchEmployee(id: Immutable<string>): Observable<Immutable<Employee>> {
        return this.httpClient.get<Immutable<Employee>>(this.PATH + '/' + id);
    }

    updateEmployee(employee: Employee): Observable<IResponseMessage> {
        return this.httpClient.put<IResponseMessage>(this.PATH + '/' + employee.id, employee);
    }

    createEmployee(employee: Employee): Observable<IResponseMessage> {
        return this.httpClient.post<IResponseMessage>(this.PATH, employee);
    }

    deleteEmployee(id: Immutable<string>): Observable<IResponseMessage> {
        return this.httpClient.delete<IResponseMessage>(this.PATH + '/' + id);
    }
}