import { Component} from '@angular/core';
import { clubDet} from '../clubDets';
import { LeagueServiceService } from '../league-service.service';

@Component({
  selector: 'app-addclub',
  templateUrl: './addclub.component.html',
  styleUrls: ['./addclub.component.scss']
})
export class AddclubComponent {
  clubs:clubDet = new clubDet("","");
  clubm :any;

  constructor(private service:LeagueServiceService) {}

  public addclubs(){
    let feedback = this.service.postclub(this.clubs);
    feedback.subscribe(data=> this.clubm=data);
    this.clubs.clubName=""
    this.clubs.location=""
    alert('Club Added !!');
  }
}
