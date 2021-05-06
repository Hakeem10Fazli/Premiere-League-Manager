import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { leagueDets, matchDet } from './leagueDet';
import { clubDet } from './clubDets';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LeagueServiceService {

  constructor(private http:HttpClient) {}

  public tableWins(){
    return this.http.get<leagueDets[]>("http://localhost:8080/tableWins")
  }

  public tableGoals(){
    return this.http.get<leagueDets[]>("http://localhost:8080/tableGoals")
  }


  public leagueTable(){
    return this.http.get<leagueDets[]>("http://localhost:8080/table")
  }

  public matchTable(){
    return this.http.get<matchDet[]>("http://localhost:8080/match")
  }

  public postclub(clubDet:any):Observable<any>{
    return this.http.post<clubDet[]>("http://localhost:8080/club",clubDet,{responseType:'text' as 'json'})
  }

  public findDate(date:any):Observable<any>{
  return this.http.post<Date[]>("http://localhost:8080/findmatch",date,{responseType:'text' as 'json'})
  }

  public find(){
    return this.http.get<matchDet[]>("http://localhost:8080/finddate")
  }

  public addRandomMatch(date :any): Observable<any>{
    return this.http.post<Date []>("http://localhost:8080/addmatch",date,{responseType:'text' as 'json'})
  }
}
