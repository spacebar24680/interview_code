
public class tables {
	public static void main(String [] args){
		for(int a = 1; a <= 3; a++){
			for(int b = 1; b <= 12; b++){
				if(b == 1)
					System.out.print(a*b);
				else
					System.out.format("%4d", a*b);
			}
			System.out.println();
		}
	}
}
