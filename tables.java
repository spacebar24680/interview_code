
public class tables {
	public static void main(String [] args){
		for(int a = 1; a <= 12; a++){
			for(int b = 1; b <= 12; b++){

					System.out.format("%4d", a*b);
			}
			if(a + 1 <= 12)
			System.out.println();
		}
	}
}
