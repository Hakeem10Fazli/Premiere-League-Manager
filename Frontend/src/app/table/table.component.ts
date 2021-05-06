import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { leagueDets } from '../leagueDet';
import { MatPaginator } from '@angular/material/paginator';
import { LeagueServiceService } from '../league-service.service';

let ELEMENT_DATA: leagueDets[];
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})

export class TableComponent implements AfterViewInit , OnInit {
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  displayedColumns: String[] = ['clubName','location','wins','losses','draws', 'goalsReceived','goalsScored','goalsReceived','pointsScored']

  dataSource = new MatTableDataSource<leagueDets>(ELEMENT_DATA);

  constructor(private service:LeagueServiceService){}

  ngOnInit() {
    this.getleagueData();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  public getleagueData(){
    let resp = this.service.leagueTable();
    resp.subscribe(report=>this.dataSource.data=report  as leagueDets[])
  }
  public getleagueWins(){
    let resp = this.service.tableWins();
    resp.subscribe(report=>this.dataSource.data=report  as leagueDets[])
  }

  public getleagueGoals(){
    let resp = this.service.tableGoals();
    resp.subscribe(report=>this.dataSource.data=report  as leagueDets[])
  }


}
