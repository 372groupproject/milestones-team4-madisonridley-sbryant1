
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class numbers_generator {

	public static void main(String[] args) {
		
		int size = 10; ///MODIFY THIS NUMBER TO SET THE AMOUNT OF ELEMENTS TO GENERATE
		
		
		int [] randoms = new int[size];
		
		Random nbrs = new Random();
		
		
		for(int i = 0; i < size; i++) {
			randoms[i] = (nbrs.nextInt(size));
		}
		
		writeToFile(randoms);
		
		System.out.println("NUMBERS WRITTEN TO TXT FILE");
	}
	
	private static void writeToFile(int[] randoms) {
		try {
			FileWriter writer = new FileWriter("Numbers.txt");
			for(int i = 0; i < randoms.length; i++) {
				writer.write(Integer.toString(randoms[i])+"\n");
			}
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
