import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "./employee";

@Injectable({
    providedIn: "root"
})
export class EmployeeService {

    private readonly PATH = 'http://localhost:8080/skeleton/v1/employees';

    constructor(private readonly httpClient: HttpClient) {}

    getEmployees(): Observable<Array<Employee>> {
       return this.httpClient.get<Array<Employee>>(this.PATH);
    }

    updateEmployee(id: number, employee: Employee): void {
        this.httpClient.put(this.PATH + '/' + id, employee, {responseType: 'text'}).subscribe(result => console.log(result));
    }
}