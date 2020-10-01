import { ResponseWrapper } from './models/response-wrapper';
import { FieldService } from './services/field.service';
import { Component, OnInit } from '@angular/core';
import { Field } from './models/field';
import { FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Talhões';

  fields: Array<Field>;
  fieldsToSee: Array<Field>;

  displayedColumns: Array<string> = ['id', 'code', 'latitude', 'longitude'];
  dataSource;
  lat: number;
  lng: number;

  codeControl = new FormControl('', [
    Validators.required
  ]);

  latitudeControl = new FormControl('', [
    Validators.required
  ]);

  longitudeControl = new FormControl('', [
    Validators.required
  ]);

  fieldsToSeeControl = new FormControl();

  constructor(
    private fieldService: FieldService,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.fetchTable();
  }

  createField() {
    const field: Field = {
      code: this.codeControl.value,
      latitude: this.latitudeControl.value,
      longitude: this.longitudeControl.value
    };
    this.fieldService.createField(field).subscribe((response: ResponseWrapper) => {
      this.fetchTable();
      this.codeControl.reset();
      this.latitudeControl.reset();
      this.longitudeControl.reset();
      this.snackBar.open('Talhão novo criado com sucesso', '', {duration: 3000});
    });
  }

  fetchTable() {
    this.fieldService.getAllFields().subscribe((response: ResponseWrapper) => {
      this.fields = response.data;
      this.dataSource = this.fields;
    });
  }

  showFieldsInMap() {
    const fieldsIds = this.fieldsToSeeControl.value;
    this.fieldsToSee = this.fields.filter(field => fieldsIds.includes(field.id));
    if (this.fieldsToSee && this.fieldsToSee.length !== 0) {
      this.lat = this.fieldsToSee[0].latitude;
      this.lng = this.fieldsToSee[0].longitude;
    } else {
      this.lat = undefined;
      this.lng = undefined;
    }
  }
}
