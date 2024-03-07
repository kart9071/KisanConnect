import { Component, OnInit } from '@angular/core'
declare const angular: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-app';
  openDropdown(event:MouseEvent):void{
    event?.preventDefault();
    const dropdown=(event.target as HTMLElement).nextElementSibling; // Get the next sibling element (the dropdown menu)
    if (dropdown) {
      dropdown.classList.toggle('show'); // Toggle the 'show' class to display the dropdown menu
    }
  }
}

