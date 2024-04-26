import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HelloService } from '../features/hello/hello-service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule],
  providers: [
    HelloService
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'skeleton-openapi-frontend';

  message = '';
  constructor(private readonly helloService: HelloService) {}

  ngOnInit(): void {
    this.helloService.getHello().subscribe(world => {
      this.message = world.message
    });
  }
}
