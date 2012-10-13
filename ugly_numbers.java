import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ugly_numbers {
	public static void main(String [] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while((line = in.readLine()) != null){
			String [] lineArray = line.split("\\s");
			if(lineArray.length > 0){
				// Generate all permutations
				List<String> perms = generate(line);
				int uglyCount = 0;
				for(String s : perms){
					if(isUgly(evaluate(s))){
						//System.out.println(s);
						uglyCount++;
					}
				}
				System.out.println(uglyCount);
			}
			
		}
		
	}
	
	public static List<String> generate(String str){
		List<String> list = new ArrayList<String>();
		// Base case
		if(str.length() <= 1){
			list.add(str);
			return list;
		}
		
		// Recursive case
		char first = str.charAt(0);
		String rest = str.substring(1);
		List<String> intermediate = generate(rest);
		for(String s : intermediate){
			// Add first at the beginning with + - or nothing connecting
			list.add(first + s);
			list.add(first + "+" + s);
			list.add(first + "-" + s);
		}
		return list;
	}
	
	public static int evaluate(String expr){
		
		int sum = 0;
		int numIndex = 0;
		boolean first = true;
		String [] nums = expr.split("[+-]");
		String [] ops = expr.split("\\d+");
		if(ops.length == 0){
			return Integer.parseInt(expr);
		}
		for(int a = 1; a < ops.length; a++){
			if(first == true){
				if(ops[a].equals("+"))
					sum += Integer.parseInt(nums[numIndex++]) + Integer.parseInt(nums[numIndex++]);
				else
					sum += Integer.parseInt(nums[numIndex++]) - Integer.parseInt(nums[numIndex++]);
				
				first = false;
			}
			else{
				if(ops[a].equals("+")){
					sum += Integer.parseInt(nums[numIndex++]);
				}
				else
					sum -= Integer.parseInt(nums[numIndex++]);
			}
		}
		return sum;
	}
	
	public static boolean isUgly(int n){
		return n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0;
	}
}
