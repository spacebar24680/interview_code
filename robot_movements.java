
public class robot_movements {
	public static void main(String [] args){
		int [][] grid = new int [4][4];
		int solution = robot(0,0,3,3,grid);
		System.out.println(solution);
	}
	
	public static int robot(int currX, int currY, int destX, int destY, int [][] grid){
		int moves = 0;
		// Mark current space as visited
		grid[currX][currY] = 1;
		//System.out.println("[" + currX + ","+ currY + "]");
		printGrid(grid);
		if(currX == destX && currY == destY){
			return 1;
		}
		else{
			// Mark current position as visited
			int condition = 0x0; // L|R|D|U
			// Try Left
			if(currY-1 >= 0 && grid[currX][currY - 1] != 1){
				//moves += robot(currX, currY - 1, destX, destY, grid);
				condition |= 0x8;
			}
			
			// Try Right
			if(currY + 1 <= destY && grid[currX][currY + 1] != 1){
				//moves += robot(currX, currY + 1, destX, destY, grid);
				condition |= 0x4;
			}
			
			// Try Down
			if(currX + 1 <= destX && grid[currX + 1][currY] != 1){
				//moves += robot(currX + 1, currY, destX, destY, grid);
				condition |= 0x2;
			}
			
			// Try Up
			if(currX - 1 >= 0 && grid[currX - 1][currY] != 1){
				//moves += robot(currX - 1, currY, destX, destY, grid);
				condition |= 0x1;
			}
			System.out.println(condition + " " + currX + " " +  currY);
			
			switch(condition){
				case 0xF: //LRDU
					return robot(currX, currY - 1, destX, destY, grid) + robot(currX, currY + 1, destX, destY, grid) +
							robot(currX + 1, currY, destX, destY, grid) + robot(currX - 1, currY, destX, destY, grid);
				case 0xE: //LRD-
					return robot(currX, currY - 1, destX, destY, grid) + robot(currX, currY + 1, destX, destY, grid) +
							robot(currX + 1, currY, destX, destY, grid);
				case 0xD: //LR-U
					return robot(currX, currY - 1, destX, destY, grid) + robot(currX, currY + 1, destX, destY, grid) +
							robot(currX - 1, currY, destX, destY, grid);
				case 0xC: //LR--
					return robot(currX, currY - 1, destX, destY, grid) + robot(currX, currY + 1, destX, destY, grid);
				case 0xB: //L-DU
					return robot(currX, currY - 1, destX, destY, grid) +
							robot(currX + 1, currY, destX, destY, grid) + robot(currX - 1, currY, destX, destY, grid);
				case 0xA: //L-D-
					return robot(currX, currY - 1, destX, destY, grid) +
							robot(currX + 1, currY, destX, destY, grid);
				case 0x9: //L--U
					return robot(currX, currY - 1, destX, destY, grid) + 
																			robot(currX - 1, currY, destX, destY, grid);
				case 0x8: //L---
					return robot(currX, currY - 1, destX, destY, grid);
				case 0x7: //-RDU
					return robot(currX, currY + 1, destX, destY, grid) +
							robot(currX + 1, currY, destX, destY, grid) + robot(currX - 1, currY, destX, destY, grid);
				case 0x6: //-RD-
					return robot(currX, currY + 1, destX, destY, grid) +
							robot(currX + 1, currY, destX, destY, grid);
				case 0x5: //-R-U
					return robot(currX, currY + 1, destX, destY, grid) +
							robot(currX - 1, currY, destX, destY, grid);
				case 0x4: //-R--
					return robot(currX, currY + 1, destX, destY, grid);
				case 0x3: //--DU
					return robot(currX + 1, currY, destX, destY, grid) + robot(currX - 1, currY, destX, destY, grid);
				case 0x2: //--D-
					return robot(currX + 1, currY, destX, destY, grid);
				case 0x1: //---U
					return robot(currX - 1, currY, destX, destY, grid);
				default:  //----
					return 0;
			}
			//return 0;
		}
	}
	
	public static void printGrid(int [][] grid){
		for(int r = 0; r < grid.length; r++){
			for(int c = 0; c < grid[r].length; c++){
				System.out.print(grid[r][c] + " ");
			}
			System.out.println();
		}
	}
}
