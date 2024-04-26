import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { World } from "./world";

@Injectable({
    providedIn: "root"
})
export class HelloService {

    private readonly PATH = 'http://localhost:8080/hello/world';

    constructor(private readonly httpClient: HttpClient) {}

    getHello(): Observable<World> {
       return this.httpClient.get<World>(this.PATH);
    }
}