//Samuel Bryant
//CSCV 345
//lAB 2

//program generates an array and an array list of random number that are 
//then sorted by merge sort and quick sort



import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;

public class quick_sort {

	public static void main(String[] args) {
		
		
	int size = 10; ///MODIFY THIS NUMBER TO SET THE AMOUNT OF ELEMENTS TO SORT
	
	sortFunction(size);
	
		
	}
	
	
	//function responsible for creating lists that have the random numbers that need to 
	//be sorted
	public static void sortFunction(int size) {
		

		
		int [] randomsQuick = new int[size];
		
		Random nbrsQuick = new Random();
		
		
		for(int i = 0; i < size; i++) {
			randomsQuick[i] = (nbrsQuick.nextInt(size));
		}
		
		writeToFile(randomsQuick);
	
		
		System.out.println("\n---UNSORTED QUICK---\n");
		
		for(int i = 0; i < randomsQuick.length; i++) {
			System.out.println(randomsQuick[i]);
		}
		
		long quickStart = System.currentTimeMillis();
		
		quick(randomsQuick,0,randomsQuick.length-1);
		
		long quickEnd = System.currentTimeMillis();
		
		System.out.println();
		
		System.out.println("\n---SORTED QUICK---\n");
		
		for(int i = 0; i < randomsQuick.length; i++) {
			System.out.println(randomsQuick[i]);
		}
		
		
		System.out.println("\nQuick Sorting Time: " + (quickEnd - quickStart) + " milliseconds");
		
		for(int i = 0; i <= 9; i++) {
			System.out.println(i);
		}
		
		
	}
	
	private static void writeToFile(int[] randomsQuick) {
		try {
			FileWriter writer = new FileWriter("Numbers.txt");
			for(int i = 0; i < randomsQuick.length; i++) {
				writer.write(Integer.toString(randomsQuick[i])+"\n");
			}
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}



	
	//recursive function for quick sorting
	public static void quick(int[] randomsQuick, Integer low, Integer high) {
		
		if(low < high) {
			int index = quickHelper(randomsQuick, low, high);
			
			quick(randomsQuick, low, index - 1);
			quick(randomsQuick, index + 1, high);
			
		}
		
	}
	
	//helper function for quick function
	public static Integer quickHelper(int[] randomsQuick, Integer low, Integer high) {
		
		int pivot = randomsQuick[high];
		
		int index = low - 1;
		System.out.println("high - 1 ----> " + (high - 1));
		for(int i = low; i <= high - 1; i++) {
			if(randomsQuick[i] < pivot) {
				index++;
				
				int temp1 = randomsQuick[index];
				randomsQuick[index] = randomsQuick[i];
				randomsQuick[i] = temp1;
						
			}
		}
		
		int temp2 = randomsQuick[index + 1];
		randomsQuick[index + 1] = randomsQuick[high];
		randomsQuick[high] = temp2;
			
		return (index + 1);
		
		
		
	}

}
