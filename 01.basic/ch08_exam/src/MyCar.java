class Car{
	int fuel;
	int velocity;
	
	Car(){
		fuel = 10;
		velocity = 0;
		
	}
	void doAccel() {
		velocity = velocity + 1;
		fuel = fuel - 1;
	}
	void doBreak() {
		velocity = velocity - 1;
	}
	void getStatus() {
		System.out.println("���ᷮ " + fuel);
		System.out.println("�ӵ�" + velocity);
	}
}
public class MyCar {
	public static void main(String[] args) {
		Car myCar1 = new Car();
		myCar1.getStatus();
		
		myCar1.doAccel();
		myCar1.doAccel();
		myCar1.getStatus();
		
		myCar1.doBreak();
		myCar1.getStatus();
		
		Car myCar2 = new Car();
		myCar2.doAccel();
		myCar2.doAccel();
		myCar2.doAccel();
		myCar2.doAccel();
		myCar2.getStatus();
		
		myCar1.getStatus();
	}
}
