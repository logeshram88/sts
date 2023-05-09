package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mobilegadgets {

private String model;
private String brand;
@Id
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "Mobilegadgets [Model=" + model + ", Brand=" + brand + ", id=" + id + ", Price=" + price + "]";
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
private String price;
}
