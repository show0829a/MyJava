import java.util.Random;
import java.util.Scanner;

public class RPS_Game {

	static int gameResult = 1;
	
	public static void main(String[] args) {
		
		int hNum;
		int cNum;
		
		
		Scanner sc = new Scanner(System.in);
		
		Random computer = new Random();
		
		while(gameResult != 0) {
			System.out.println("������ ���ڽ��ϱ� ? (1:���� 2:���� 3:�� 0:����)");
			hNum = sc.nextInt();
			cNum = computer.nextInt(3) + 1;
			RPS(hNum,cNum);
			
			
		}
		sc.close();
	}
	
	static void RPS(int num1, int num2) {
		switch(num1) {
			case 0 :
			{
				System.out.println("������ �����ϰڽ��ϴ�.");
				gameResult = 0;			
				break;
			}
			case 1 : 
			{
				if(num2 == 1) {
					System.out.println("�����: " + "����" + "��ǻ��: " + "����" );
					System.out.println("�����ϴ�");
				} else if (num2 == 2) {
					System.out.println("�����: " + "����" + "��ǻ��: " + "����" );
					System.out.println("�̰���ϴ�");				
				}else {
					System.out.println("�����: " + "����" + "��ǻ��: " + "��" );
					System.out.println("�����ϴ�");
				}
				break;
			} 
			case 2 : 
			{
				if(num2 == 1) {
					System.out.println("�����: " + "����" + "��ǻ��: " + "����" );
					System.out.println("�����ϴ�");
				} else if (num2 == 2) {
					System.out.println("�����: " + "����" + "��ǻ��: " + "����" );
					System.out.println("�����ϴ�");
				}
				else {
					System.out.println("�����: " + "����" + "��ǻ��: " + "��" );
					System.out.println("�̰���ϴ�");
				}
				break;
			} 
			case 3 : 
			{
				if(num2 == 1) {
					System.out.println("�����: " + "��" + "��ǻ��: " + "����" );
					System.out.println("�̰���ϴ�");
				}
					else if (num2 == 2) {
					System.out.println("�����: " + "��" + "��ǻ��: " + "����" );
					System.out.println("�����ϴ�");
				} else {
					System.out.println("�����: " + "��" + "��ǻ��: " + "��" );
					System.out.println("�����ϴ�");
				}
				break;
			} 
			default : 		
				System.out.println("�ٽ� �Է��ϼ���");
		}	
	}

}
//RPS �κ� ������ ǥ���Ҷ� ���밪�̳� + �� ���ؼ� �Ҽ� �ִ�. �غ���
