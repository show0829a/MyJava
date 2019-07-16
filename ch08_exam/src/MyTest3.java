
public class MyTest3 {

	public static void main(String[] args) {
		int[][] num = new int[3][9];
		for (int i=0; i<3; i++) {
			for(int j=0; j<9; j++) {
				num[i][j] = (i + 2) * (j + 1);
			}
		}
	}

}
