import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FIELD_URL } from '../contants/urls';
import { Field } from '../models/field';
import { ResponseWrapper } from '../models/response-wrapper';

@Injectable({
    providedIn: 'root'
})
export class FieldService {

    constructor(
        private http: HttpClient) { }

    getHttpHeaders() {
        return {
            headers: new HttpHeaders({
            'Content-Type': 'application/json'
            })
        };
    }

    /**
     * Get all fields
     */
    getAllFields(): Observable<ResponseWrapper> {
        return this.http.get<ResponseWrapper>(FIELD_URL, this.getHttpHeaders());
    }

    /**
     * Create new field
     */
    createField(field: Field): Observable<ResponseWrapper> {
        return this.http.post<ResponseWrapper>(FIELD_URL, field, this.getHttpHeaders());
    }
}
