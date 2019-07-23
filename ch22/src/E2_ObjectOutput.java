import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class E2_ObjectOutput {

	public static void main(String[] args) {
		
		try(ObjectInputStream oi = 
				new ObjectInputStream(new FileInputStream("Object.bin"))) { 
			E1_SBox box1 = (E1_SBox) oi.readObject();
			System.out.println(box1.get());
			
			E1_SBox box2 = (E1_SBox) oi.readObject();
			System.out.println(box2.get());
		}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
