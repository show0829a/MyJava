
import java.util.Arrays;
import java.util.Scanner;

public class Puzzle3x3 {
	
	public static void main(String[] args) {
		
		String[][] ar = {	{"1", "2", "3"},
							{"4", "5", "x"},
							{"7", "8", "6"} };
	
		String[][] ans =  {	{"1", "2", "3"},
							{"4", "5", "6"},
							{"x", "7", "8"} };	
		
		Scanner sc = new Scanner(System.in);
		String key;
		
		int xPos = 1;	//��ǥ
		int yPos = 2;	//��ǥ
		String tmp;
		
		Boolean gameSwitch = true;
		while(gameSwitch) {
			ShowPuzzle(ar);
			System.out.println("[ Move ] a:Left s:Right w:Up z:Down");
			System.out.println("[ Exit ] k:Exit");
			System.out.println("�̵�Ű�� �Է��ϼ��� : ");
			
			key = sc.next();
			
			switch(key) {
				case "a" :
				{	//Left
					if(yPos <= 0)
						yPos = 0;
					
					else if(yPos <= 2) {
						//�迭 ����ġ
						tmp = ar[xPos][yPos-1];
						ar[xPos][yPos-1] = ar[xPos][yPos];
						ar[xPos][yPos] = tmp;
						
					
						//��ǥ�� ����
						yPos = yPos - 1;					
					} 
					
					
					break;
				}
				case "s" :
				{
					if(yPos >= 2)
						yPos = 2;
					else if(yPos <= 2) {
						//�迭 ����ġ
						tmp = ar[xPos][yPos+1];
						ar[xPos][yPos+1] = ar[xPos][yPos];
						ar[xPos][yPos] = tmp;
						
						//��ǥ�� ����
						yPos = yPos + 1;
						
					}
					break;
				}
				case "w" :
				{
					if(xPos <= 0)
						xPos = 0;
					else if(xPos <= 2) {
						//�迭 ����ġ
						tmp = ar[xPos-1][yPos];
						ar[xPos-1][yPos] = ar[xPos][yPos];
						ar[xPos][yPos] = tmp;
						
						//��ǥ�� ����
						xPos = xPos - 1;
						
					} 
					break;
				}
				case "z" :
				{
					if(xPos >= 2)
						xPos = 2;
					else if(xPos <= 2) {
						//�迭 ����ġ
						tmp = ar[xPos+1][yPos];
						ar[xPos+1][yPos] = ar[xPos][yPos];
						ar[xPos][yPos] = tmp;
						
						//��ǥ�� ����
						xPos = xPos + 1;
						
					} 
					
					
					break;
				}
				
				case "k" :
				{
					gameSwitch = false;
					System.out.println(" ������ �����մϴ�.");
					break;
			
				}
				default :
					break;
			
			}
			
			if(Arrays.deepEquals(ar, ans)) {
				System.out.println("�����Դϴ�. ������ �����մϴ�.");
				System.out.println("Good Bye~");
				gameSwitch = false;
				break;
			}
		}
	}
	
	public static void ShowPuzzle(String[][] ar) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print(ar[i][j] + " ");
			System.out.println();
		}
	}
	
	
	
}
