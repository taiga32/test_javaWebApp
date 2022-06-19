package model;

public class Circle {
	//メソッドの定義
	public double area(double radius) {
		return radius * radius * 3.14;
	}
	
	public double circum(double radius) {
		return 2 * 3.14 * radius;
	}
	
	public double cube(double radius) {
		return 3.0 / 4.0 * 3.14 * radius * radius * radius;
	}
}
