/*
*random numbers generator for CSC372 final project
*/


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class numbers_generator {

	public static void main(String[] args) {

		int size = 100000; ///MODIFY THIS NUMBER TO SET THE AMOUNT OF ELEMENTS TO GENERATE
		int nbrOfFiles = 10; ///MODIFY THIS NUMBER TO SET THE AMOUNT RANDOM NUMBER FILES TO GENERATE

		int [] randoms = new int[size];

		Random nbrs = new Random();




		for(int i = 0; i < nbrOfFiles; i++) {
			for(int j = 0; j < size; j++) {
				randoms[j] = (nbrs.nextInt(size));
			}
			writeToFile(randoms,i);
			randoms = new int[randoms.length];
		}


		System.out.println("NUMBERS WRITTEN TO TXT FILE");
	}

	private static void writeToFile(int[] randoms, int fileNumber) {
		try {
			FileWriter writer = new FileWriter("Numbers" + Integer.toString(fileNumber) + ".txt");
			for(int i = 0; i < randoms.length; i++) {
				writer.write(Integer.toString(randoms[i])+"\n");
			}
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
