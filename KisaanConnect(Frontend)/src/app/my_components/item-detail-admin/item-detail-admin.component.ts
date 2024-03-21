import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-item-detail-admin',
  templateUrl: './item-detail-admin.component.html',
  styleUrls: ['./item-detail-admin.component.css']
})
export class ItemDetailAdminComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  product = {
    id: '',
    name: '',
    company: '',
    volumeVariants: [] as { variant: string, quantity: number, price: number, discount: number }[],
    image: '',
    content: '',
    features: [] as string[],
    usage: '',
    crops: '',
    timeOfApplication: '',
    dosage: ''
  };
  newFeature:string = '';

  submitForm() {
    console.log(this.product);
  }

  addVolumeVariant() {
    this.product.volumeVariants.push({ variant: '', quantity: 0 , price: 0, discount: 0});
  }

  removeVolumeVariant(index: number) {
    this.product.volumeVariants.splice(index, 1);
  }

  addFeature() {
    if (this.newFeature.trim() !== '') {
      this.product.features.push(this.newFeature.trim());
      this.newFeature = '';
    }
  }
}
