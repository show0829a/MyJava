package chapter07;

import java.util.Scanner;
public class Quiz0704 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȯ�� ȭ�� �µ��� �Է��Ͻÿ�");
		double fTemp = sc.nextDouble();
		System.out.println("ȭ�� " + fTemp + "���� ���� " + FtoC(fTemp)+"���Դϴ�.");
		
		System.out.println("��ȯ�� ���� �µ��� �Է��Ͻÿ�");
		double cTemp = sc.nextDouble();
		System.out.println("���� " + cTemp + "���� ���� " + CtoF(cTemp)+"���Դϴ�.");
		
		sc.close();
	}
	public static double FtoC(double fTemparature) {
		return (fTemparature-32)/1.8;
	}
	public static double CtoF(double cTemparature) {
		return (1.8*cTemparature + 32);
	}

}
