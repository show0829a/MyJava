package com.company.length;

public class Circle {
	double rad;
	final double PI;
	
	public Circle(double r) {
		rad = r;
		PI = 3.14;
	}
	
	//���� ���� ��ȯ
	public double getPerimeter() {
		return (rad * 2) * PI;
	}
}
