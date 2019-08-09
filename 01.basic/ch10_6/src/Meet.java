
interface Greet
{
	void greet();
}

interface Bye extends Greet
{
	void bye();
}

class Greeting implements Greet, Bye
{
	public void greet()
	{
		System.out.println("�ȳ��ϼ���!");
	}
	public void bye()
	{
		System.out.println("�ȳ��� �輼��.");
	}

}
public class Meet {

	public static void main(String[] args) {
		Greeting greeting = new Greeting();
		greeting.greet();
		greeting.bye();
	}

}
