package com.prowings.model;

public class Student {
private int id;
private int roll;
private String name;
private String address;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getRoll() {
	return roll;
}
public void setRoll(int roll) {
	this.roll = roll;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "Student [id=" + id + ", roll=" + roll + ", name=" + name + ", address=" + address + "]";
}

}
