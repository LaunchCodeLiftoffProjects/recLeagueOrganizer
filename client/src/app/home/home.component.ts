import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {//anyone can paste image links in this array whenever they want
    let imageLinks = ["https://lonelyplanetimages.imgix.net/a/g/hi/t/2a4c3ab8e9a1f0bd49579d04a079ed01-gateway-arch-jefferson-national-expansion-memorial.jpg", 
    "https://besthqwallpapers.com/Uploads/2-8-2018/60222/thumb2-flag-of-st-louis-4k-silk-texture-american-city-red-silk-flag.jpg",
    "https://www.pixelstalk.net/wp-content/uploads/2016/06/ST-Louis-Cardinals-Logo-Backgrounds-Free-Download.jpg"]
    let link = imageLinks[Math.floor(Math.random()*imageLinks.length)];  
    let txt = "<img src = '" + link + "'";
    txt += "width =  '" + window.innerWidth + "'";
    txt += "height = '" + window.innerHeight + "'";
    txt += "class = 'center'>";
    document.getElementById("frontPage").innerHTML = txt; 
  }

}
