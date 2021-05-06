export interface leagueDets{
    clubName:String,
    location:String,
    wins:number,
    losses:number,
    draws:number,
    goalsReceived:number,
    goalsScored:number,
    pointsScored:number,
    matchPlayed:number
}

export interface matchDet{
    club1:String,
    club2:String,
    club1Score:number ,
    club2Score:number ,
    matchDate:Date[]
}

export interface Date{
    day: number
    month: number
    year: number
}

