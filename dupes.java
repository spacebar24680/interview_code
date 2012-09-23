import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;


public class dupes {
	public static void main(String [] args) throws NumberFormatException, IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		
		int sum = 0;
		while((line = in.readLine()) != null){
			String [] lineArray = line.split(",");
			if(lineArray.length > 0){
				// Process input
				ArrayList<String> list = new ArrayList<String>();
				for(int c = 0; c < lineArray.length; c++){
					if(!list.contains(lineArray[c])){
						list.add(lineArray[c]);
					}
				}
				for(int c = 0; c < list.size(); c++){
					System.out.print(list.get(c));
					if(c+1 < list.size())
						System.out.print(",");
				}
				System.out.println();
			}
		}
	}
}
