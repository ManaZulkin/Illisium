import { AuthentificationService, Person } from './services/authentification.service';
import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from "./components/header/header.component";
import { RouterOutlet } from '@angular/router';


@Component({
selector: 'app-root',
  imports: [HeaderComponent, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})


export class AppComponent implements OnInit {
  title = 'frontend';

  constructor(private apiServ: AuthentificationService,){}

  //@ts-ignore
  pers: Person;
  ngOnInit(): void {


    this.apiServ.getPerson().subscribe(
      (resp) =>{
        this.pers = resp;
        alert(this.pers.username);
      },
      (error)=>{
        console.error('FUck NO!', error);
      }
    )
  }

}
