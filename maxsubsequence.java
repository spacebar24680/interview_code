
public class maxsubsequence {
	public static void main(String [] args){
		int [] test = {-2, 11, -4, 13, -2, 5};
		System.out.println(subsequence(test));
		System.out.println(money(12));
	}
	
	public static int subsequence(int [] list){
		// Find the first positive number and start with that as our sum
		int sum = 0;
		int maxSum = 0;
		for(int c = 0; c < list.length; c++){
			sum += list[c];
			
			if(sum < 0){
				sum = 0;
			}
			else if(sum > maxSum){
				maxSum = sum;
			}
			
		}
		return maxSum;
	}
	
	public static int money(int n){
		if(n == 0)
			return 0;
		else if(n < 5)
			return 1;
		else if(n < 10)
			return money(n-5);
		else if(n < 25)
			return money(n-10);
		else 
			return money(n-25);
	}
}
