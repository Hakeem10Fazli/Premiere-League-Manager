import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { matchDet } from '../leagueDet';
import { LeagueServiceService } from '../league-service.service';

let ELEMENT_DATA: matchDet[];
@Component({
  selector: 'app-match-table',
  templateUrl: './match-table.component.html',
  styleUrls: ['./match-table.component.scss']
})
export class MatchTableComponent implements AfterViewInit, OnInit {
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

  public getmatchData(){
    let resp = this.service.matchTable();
    resp.subscribe(report=>this.dataSource.data=report  as matchDet[])
  }





}