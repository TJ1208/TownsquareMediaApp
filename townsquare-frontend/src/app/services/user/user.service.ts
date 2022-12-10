import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  requestHeader = new HttpHeaders(
    { "No-Auth": "True" }
  )

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`https://townsquare-frontend.azurewebsites.net/api/user`);
  }

  getUserByUsername(username: string): Observable<User[]> {
    return this.http.get<User[]>(`https://townsquare-frontend.azurewebsites.net/api/user/name/${username}`);
  }

  getUserById(userId: number): Observable<User> {
    return this.http.get<User>(`https://townsquare-frontend.azurewebsites.net/api/user/${userId}`);
  }

  addUser(user: User): Observable<any> {
    return this.http.post<any>(`https://townsquare-frontend.azurewebsites.net/api/user/register`, user, { headers: this.requestHeader });
  }

  updateUser(user: User): Observable<any> {
    return this.http.put<any>(`https://townsquare-frontend.azurewebsites.net/api/user/update`, user);
  }

  deleteUser(userId: number): Observable<String> {
    return this.http.delete<String>(`https://townsquare-frontend.azurewebsites.net/api/user/delete/${userId}`);
  }
  
}
