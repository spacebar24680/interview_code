import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class prime_palindrome {
	public static void main(String [] args) throws IOException{
		int array [] = new int [1000];
		for(int c = 2; c < 1000; c++){
			array[c] = c;
		}
		
		for(int c = 2; c < 1000; c++){
			for(int d = 2 * c; d < 1000; d+=c){
				array[d] = -1;
			}
		}
		
//		for(int c = 0; c < 1000; c++){
//			System.out.println(array[c]);
//		}
		
		
		for(int c = 999; c >= 2; c--){
			if(array[c] != -1){
				if(isPalindrome(array[c])){
					System.out.println(array[c]);
					break;
				}
			}
		}
	}
	
	public static boolean isPalindrome(int num){
		int rev = 0;
		int x = num;
		
		while(x > 0){
			int digit = x % 10;
			rev = rev * 10 + digit;
			x = x / 10;
		}
		return rev == num;
	}
}
