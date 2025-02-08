import { Component, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpCustomService } from './services/http-custom.service';


@Component({
selector: 'app-root',
  imports: [RouterOutlet, FormsModule, CommonModule, ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',

})


export class AppComponent implements OnInit  {
  title = 'frontend';

  form : FormGroup;
  isAuthentificated = false;

  constructor(private formBulder: FormBuilder, private http:HttpCustomService){
    this.form = formBulder.group(
      {
        login: [''],
        password: ['']
      }
    )
  }
  ngOnInit(): void {

  }

  onSumbt(){
    this.http.createUser({username:'Clone', password:'asdasd'}).subscribe(resp => alert(resp));


  }

  getFromServer(){
    //@ts-ignore
    this.http.pullUser().subscribe(resp => alert(resp.username));
  }

}
