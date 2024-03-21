import { AfterViewInit, Component, OnInit } from '@angular/core';
import { ItemDetail } from 'src/app/model/item-detail.model';
import { ItemDetailService } from 'src/app/service/item-detail.service';
import $ from 'jquery';
import 'datatables.net';
import 'datatables.net-dt';
import DataTable from 'datatables.net-dt';

@Component({
  selector: 'app-item-detail-admin',
  templateUrl: './item-detail-admin.component.html',
  styleUrls: ['./item-detail-admin.component.css']
}) 
export class ItemDetailAdminComponent implements OnInit, AfterViewInit {

  constructor(private itemdetailService: ItemDetailService) { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    new DataTable('#example', {
      order: [[3, 'desc']]
  }); // Initialize DataTable
  }


  product = new ItemDetail()
  newFeature: string = '';
  newProductVariant = { variant: "", quantity: 0, price: 0, discount: 0 }

  submitForm() {
    console.log(this.product);
    this.itemdetailService.sendProductDetail(this.product).subscribe(
      (response: any) => {
        alert("product added successfully")
      },
      (error: any) => {
        console.error('Error fetching product:', error);
      }
    );
  }

  addVolumeVariant() {
    this.product.productVariants.push(this.newProductVariant);

  }

  removeVolumeVariant(index: number) {
    this.product.productVariants.splice(index, 1);
  }

  addFeature() {
    if (this.newFeature.trim() !== '') {
      this.product.features.push(this.newFeature.trim());
      this.newFeature = '';
    }
  }
}
