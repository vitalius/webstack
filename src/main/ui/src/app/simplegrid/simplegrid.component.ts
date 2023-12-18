import { Component, OnInit} from '@angular/core';
import { SimplegridService } from '../simplegrid.service'
import { GridItem } from '../griditem';
 
@Component({
  selector: 'app-simplegrid',
  standalone: true,
  imports: [],
  providers: [SimplegridService],
  templateUrl: './simplegrid.component.html',
  styleUrl: './simplegrid.component.css'
})

export class SimplegridComponent implements OnInit {

  items: GridItem[] = [];
  selectedItem: GridItem|undefined;

  constructor (private gridService: SimplegridService) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    //this.gridService.getList().subscribe(x => this.items);
    this.items = this.gridService.getListMock(); 
  }
}
