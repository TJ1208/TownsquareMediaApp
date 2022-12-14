import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Education } from 'src/app/models/Education';

@Injectable({
  providedIn: 'root'
})
export class EducationService {

  constructor(private http: HttpClient) { }

  getAllEducations(): Observable<Education[]> {
    return this.http.get<Education[]>(`https://townsquare-backend.azurewebsites.net/api/education`);
  }

  getAllUserEducations(userId: number): Observable<Education[]> {
    return this.http.get<Education[]>(`https://townsquare-backend.azurewebsites.net/api/education/${userId}`);
  }

  getEducationById(educationId: number): Observable<Education> {
    return this.http.get<Education>(`https://townsquare-backend.azurewebsites.net/api/education/id/${educationId}`);
  }

  addEducation(education: Education): Observable<any> {
    return this.http.post<any>(`https://townsquare-backend.azurewebsites.net/api/education/add`, education);
  }

  updateEducation(education: Education): Observable<any> {
    return this.http.put<any>(`https://townsquare-backend.azurewebsites.net/api/education/update`, education);
  }

  deleteEducation(educationId: number): Observable<String> {
    return this.http.delete<String>(`https://townsquare-backend.azurewebsites.net/api/Education/delete/${educationId}`);
  }
  
}
