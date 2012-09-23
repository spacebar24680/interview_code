
public class tables {
	public static void main(String [] args){
		for(int a = 1; a <= 3; a++){
			for(int b = 1; b <= 12; b++){
				System.out.format("%4d", a*b);
			}
			System.out.println();
		}
	}
}
