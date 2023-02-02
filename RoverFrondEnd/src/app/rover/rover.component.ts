import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-rover',
  templateUrl: './rover.component.html',
  styleUrls: ['./rover.component.scss']
})
export class RoverComponent {




  RoverHistory : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;
  

  x: Number =0;
  y: Number =0;
  direction:string ="";
  path:string ="";
  destination:string ="";
  lastUpdate:string ="";
  currentroverid = "";
  
  


  constructor(private http: HttpClient )
  {
    this.getRovers();
  }
 
  getRovers()
  {
    
    this.http.get("http://localhost:8083/api/v1/rover/getAllrovers")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultData);
        this.RoverHistory = resultData;
    });
  }




  newData()
  {
  
    let bodyData = {
      "roverid":this.currentroverid,
      "x": this.x,
      "y": this.y,
      "direction":this.direction,
      "path":this.path
    };


    this.http.post("http://localhost:8083/api/v1/rover/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Rover history Successfully");
        this.getRovers();
         

        this.x=0;
        this.y=0;
        this.direction='';
        this.path='';
        
    });
  }



  setUpdate(data: any)
  {
   this.x = data.x;
   this.y = data.y;
   this.direction = data.direction;
   this.path = data.path;
   this.currentroverid = data.roverid;
  }





  UpdateRecords()
  {
    let bodyData = {
      "x": this.x,
      "y": this.y,
      "direction":this.direction,
      "path":this.path
    };
    
    this.http.put("http://localhost:8083/api/v1/rover/replay",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("History updated")
        this.getRovers();
        this.x = 0;
        this.y = 0;
        this.direction  = '';
        this.path  = '';
    });
  }

  save()
  {
    if(this.currentroverid == '')
    {
        this.newData();
    }
      else
      {
       this.UpdateRecords();
      }      
  }


  setDelete(data: any)
  {
    
    
    this.http.delete("http://localhost:8083/api/v1/rover/delete"+ "/"+ data.roverid,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("History Deleted ")
        this.getRovers();
 
        this.x = 0;
        this.y = 0;
        this.direction  = '';
        this.path  = '';
  
    });
  }
}



