import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class F1_FinallyCase1 {

	public static void main(String[] args) {
		Path file = Paths.get("D:\\hwan0829a\\java\\Simple.txt");
	
		
		BufferedWriter writer = null;		

		try {
		
		writer = Files.newBufferedWriter(file);
			
		writer.write('A');
		writer.write('Z');
				
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		finally
		{
//			if(writer != null)
//				writer.close();
		}
	}

}
