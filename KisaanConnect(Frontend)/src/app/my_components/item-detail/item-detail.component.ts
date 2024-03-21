import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.css']
})
export class ItemDetailComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  technicalContent: string = "Amino acid and nutrient-based biostimulants";
  features: string[] = [
    "Photosynthesis & Action on Stomas - Increase Chlorophyll Concentration only, resulting in Crop Lush Green.",
    "Pollination & Fruit Formation - Helping transportation of pollen, good fruit set, early harvest.",
    "Chelating Effect - Easy uptake and transportation of Micronutrients.",
    "Activators - Ethylene Synthesis, Induces Synthesis of Flower and Fruit-related Hormones.",
    "Stress Resistance - Prevention and Recovery."
  ];
  usage: string = "Isabion helps the crops in mitigating the damage done by hail, phytotoxicity, parasites and diseases, drought, etc. It is easily absorbed by the plant immediately after application.";
  crops: string = "Organic biostimulant of roots, leaves, flowers, and fruits on every kind of crop: Fruit trees - Citrus, Grapes, Mango, Apple, Pomegranate & other fruits; Vegetables- Tomato, Chilli, Brinjal, Cole crops, Potato, Cucurbits, Onion and all leafy vegetables, field crops, etc.";
  timeOfApplication: string = "Isabion is recommended during the active growth phases of the production cycle, in nurseries, and in young plantations. Isabion allows flexibility of usage as a foliar spray. The number of applications & timings depends on the crop, however, application at the time of transplantation, flowering, fruit set, and ripening are the most important.";
  dosage: string = "Spray 400 ml/acre or 2 ml/lit in foliar application.";


}
