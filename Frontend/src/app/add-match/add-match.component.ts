import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { DateObj } from '../find-match/dateObj';
import { LeagueServiceService } from '../league-service.service';
import { matchDet } from '../leagueDet';

let ELEMENT_DATA: matchDet[];

@Component({
  selector: 'app-add-match',
  templateUrl: './add-match.component.html',
  styleUrls: ['./add-match.component.scss']
})
export class AddMatchComponent implements OnInit {

  splitDate?:string[];
  str?:string;
  date?:Date;
  matchdateObj?:DateObj;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  displayedColumns: String[] = ['matchDate','club1','club1Score','club2','club2Score']

  dataSource = new MatTableDataSource<matchDet>(ELEMENT_DATA);

  constructor(private service:LeagueServiceService){}

  ngOnInit() {
    this.getmatchData();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  datesplit(){
    this.str= this.date?.toLocaleDateString();
    console.log(this.str);
    this.splitDate = this.str?.split("/",3);
    this.datePass()
  }

  datePass(){
    this.matchdateObj = new DateObj();
    if (this.splitDate) {
      this.matchdateObj.day = Number(this.splitDate[0]);
    }
    if (this.splitDate) {
      this.matchdateObj.month = Number(this.splitDate[1]);
    }
    if (this.splitDate) {
      this.matchdateObj.year = Number(this.splitDate[2]);
    }
    this.addmatch();
  }

  public addmatch(){
    let feedback = this.service.addRandomMatch(this.matchdateObj);
    feedback.subscribe(data => this.matchdateObj = data);
    this.getmatchData();
  }

  public getmatchData(){
    let resp = this.service.matchTable();
    resp.subscribe(report=>this.dataSource.data=report  as matchDet[])
  }
}