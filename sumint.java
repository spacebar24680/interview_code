import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class sumint {
	public static void main(String [] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		
		int sum = 0;
		while((line = in.readLine()) != null){
			String [] lineArray = line.split("\\s");
			if(lineArray.length > 0){
				// Process input
				sum += Integer.parseInt(lineArray[0]);
			}
		}
		System.out.println(sum);
	}
}
