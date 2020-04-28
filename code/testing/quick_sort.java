//Samuel Bryant



import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;


public class quick_sort {

	public static void main(String[] args) {
		
	
	sortFunction();
	
		
	}
	
	
	//function responsible for creating lists that have the random numbers that need to 
	//be sorted
	public static void sortFunction() {
		

		ArrayList nbrs = new ArrayList();
		nbrs = readFile();
		
		Integer [] randoms = (Integer[]) nbrs.toArray(new Integer[0]);
		
		//UNCOMMENT TO SEE ALL THE UNSORTED NUMBERS
		/*
		System.out.println("\n---UNSORTED QUICK---\n");
		
		for(int i = 0; i < randoms.length; i++) {
			System.out.println(randoms[i]);
		}
		*/
		
		
		long quickStart = System.currentTimeMillis();
		
		quick(randoms,0,randoms.length-1);
		
		long quickEnd = System.currentTimeMillis();
		
		
		////////////UNCOMMENT TO SEE ALL THE SORTED NUMBERS
		/*
		System.out.println();
		
		System.out.println("\n---SORTED QUICK---\n");
		
		
		for(int i = 0; i < randomsQuick.length; i++) {
			System.out.println(randomsQuick[i]);
		}
		*/
		
		
		System.out.println("\nQuick Sorting Time: " + (quickEnd - quickStart) + " milliseconds");
		
	}
	
	private static ArrayList readFile() {
		ArrayList nbrs = new ArrayList();
		
		try {
			File nbrs_file = new File("Numbers.txt");
			Scanner myScanner = new Scanner(nbrs_file);
			while(myScanner.hasNextLine()) {
				int line = Integer.parseInt(myScanner.nextLine().replace("\n",""));
				nbrs.add(line);
			}
			
			myScanner.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return nbrs;
		
	}
	
	//recursive function for quick sorting
	public static void quick(Integer[] randoms, Integer low, Integer high) {
		
		if(low < high) {
			int index = quickHelper(randoms, low, high);
			
			quick(randoms, low, index - 1);
			quick(randoms, index + 1, high);
			
		}
		
	}
	
	//helper function for quick function
	public static Integer quickHelper(Integer[] randoms, Integer low, Integer high) {
		
		int pivot = randoms[high];
		
		int index = low - 1;
		
		for(int i = low; i <= high - 1; i++) {
			if(randoms[i] < pivot) {
				index++;
				
				int temp1 = randoms[index];
				randoms[index] = randoms[i];
				randoms[i] = temp1;
						
			}
		}
		
		int temp2 = randoms[index + 1];
		randoms[index + 1] = randoms[high];
		randoms[high] = temp2;
			
		return (index + 1);
		
		
		
	}

}
