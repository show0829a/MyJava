
public class F2_CopyOfSystem {

	public static void main(String[] args) {
		double[] org = {1.1, 2.2, 3.3, 4.4, 5.5};
		double[] cpy = new double[3];
		
		// �̸� ������� �ִ� �迭�� �����Ѵ�.
		System.arraycopy(org, 1, cpy, 0, 3);

		for(double d : cpy)
			System.out.print(d + "\t");
		System.out.println();
	}

}
