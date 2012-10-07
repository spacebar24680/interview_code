import java.io.*;
public class circular_buffer {

	// Circular Buffer Data Structure
    public static String [] buffer;
    public static int length = 0;
    public static int head = 0;
    public static int tail = 0;
    public static int size = 0;
	
	
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        // N is the size of the buffer
        int N = Integer.parseInt(line);
        
        buffer = new String [N];
        length = N;
        String command = "";
        while((command = br.readLine()) != null){	
	        //String command = br.readLine();
	        command = command.trim(); // strip leading/trailing spaces
	        String [] parses = command.split(" ");
	        String first = parses[0];
	        switch(first){
	        	case "A":
	        		int numstr = Integer.parseInt(parses[1]);
	        		for(int c = 0; c < numstr; c++){
	        			String word = br.readLine();
	        			add(word);
	        		}
	        		break;
	        	case "R":
	        		int num = Integer.parseInt(parses[1]);
	        		for(int c = 0; c < num; c++){
	        			remove();
	        		}
	        		break;
	        	case "L":
	        		printBuffer();
	        		break;
	        	case "Q":
	        		System.exit(0);
	        		break;
	        		
	        }
        }
    
    }
    
    public static void add(String word){
//    	if(size == 0 && length > 0 && head==tail){ //empty
//    		buffer[tail] = word;
//    		size++;
//    		return;
//    	}
    	
    	// Find the place to insert the new word
//    	int curr = tail;
//    	curr = (curr + 1) % buffer.length;
    	
    	// Check if it equals head
    	head = (tail == head && size > 0) ? (head + 1) % length : head;
    	buffer[tail] = word;
    	tail = (tail+1) % length;
    	
    	
    	if(size < length)
    		size++;
    }
    
    /**
     * updates size
     * @param buffer
     * @param head
     * @param tail
     * @param size
     * @param num
     * @return
     */
    public static void remove(){
    	
		buffer[head] = "";
		
		// Increment current pointer
		head = (head + 1) % length;
		size--;
    }
    
    public static void printBuffer(){
    	int c = size;
    	int curr = head;
    	while(c > 0){
    		System.out.println(buffer[curr]);
    		
    		// increment the current pointer
    		curr = (curr + 1) % length;
    		c--;
    	}
    }
}