import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class A5_Write7toFile3 {

	public static void main(String[] args) throws IOException {
		try(OutputStream out = new FileOutputStream("data.dat")){
			out.write(65);	//ASCII 코드 65 = 'a'
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
