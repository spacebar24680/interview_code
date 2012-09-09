
public class StringRotate {
	public static void main(String [] args){
		String result = rotateString("abcdef", 2);
		System.out.println(result);
	}
	
	public static String rotateString(String str, int places){
		
		/* Mod by length of string since rotating by more than the length is redundant */
		int num = places % str.length();
		
		/* Rotating is the same as taking the substring from the end and inserting it in the beginning */
		String tail = str.substring(str.length() - num);
		String head = str.substring(0, str.length() - num);
		
		return tail + head;
	}
}
