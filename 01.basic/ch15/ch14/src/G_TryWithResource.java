import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class G_TryWithResource {

	public static void main(String[] args) {
		Path file = Paths.get("D:\\hwan0829a\\Java\\Simple.txt");
		
		try(BufferedWriter writer = Files.newBufferedWriter(file);) {
			writer.write('A');
			writer.write('Z');
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
