import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { LeagueServiceService } from '../league-service.service';
import { matchDet } from '../leagueDet';
import { DateObj } from './dateObj';

let ELEMENT_DATA: matchDet[];
@Component({
  selector: 'app-find-match',
  templateUrl: './find-match.component.html',
  styleUrls: ['./find-match.component.scss']
})
export class FindMatchComponent implements OnInit {

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

  test(){
    this.str= this.date?.toLocaleDateString();
    console.log(this.str);
    this.splitDate = this.str?.split("/",3);
    console.log(this.splitDate);
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
    console.log(this.matchdateObj);
    this.findmatch();
  }

  public findmatch(){
    let feedback = this.service.findDate(this.matchdateObj);
    feedback.subscribe(data => this.matchdateObj = data);
    this.getmatchData();
  }

  public getmatchData(){
    let resp = this.service.find();
    resp.subscribe(report=>this.dataSource.data=report  as matchDet[])
  }
}
