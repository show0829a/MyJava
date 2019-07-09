package chapter07;

import java.util.Scanner;
public class Quiz0704 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("º¯È¯ÇÒ È­¾¾ ¿Âµµ¸¦ ÀÔ·ÂÇÏ½Ã¿À");
		double fTemp = sc.nextDouble();
		System.out.println("È­¾¾ " + fTemp + "µµ´Â ¼·¾¾ " + FtoC(fTemp)+"µµÀÔ´Ï´Ù.");
		
		System.out.println("º¯È¯ÇÒ ¼·¾¾ ¿Âµµ¸¦ ÀÔ·ÂÇÏ½Ã¿À");
		double cTemp = sc.nextDouble();
		System.out.println("¼·¾¾ " + cTemp + "µµ´Â ¼·¾¾ " + CtoF(cTemp)+"µµÀÔ´Ï´Ù.");
		
		sc.close();
	}
	public static double FtoC(double fTemparature) {
		return (fTemparature-32)/1.8;
	}
	public static double CtoF(double cTemparature) {
		return (1.8*cTemparature + 32);
	}

}
