
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;


public class merge_sort {

	public static void main(String[] args) {


		sortFunction();


	}

	private static ArrayList readFile() {
		ArrayList nbrs = new ArrayList();

		try {
			File nbrs_file = new File("Numbers9.txt");
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


	public static void sortFunction() {


		ArrayList nbrs = new ArrayList();
		nbrs = readFile();
		ArrayList sortedNbrs = new ArrayList();
		/////////////UNCOMMENT TO SEE ALL OF THE UNSORTED MERGE NUMBERS
		/*
		System.out.println("\n---UNSORTED MERGE---\n");

		
		for(int i = 0; i < randoms.length; i++) {
			System.out.println(randoms[i]);
		}
		 */


		long mergeStart = System.currentTimeMillis();

		sortedNbrs = merge(nbrs);

		long mergeEnd = System.currentTimeMillis();
		
		////////////UNCOMMMENT TO SEE ALL THE SORTED NUMBERS
		
		/*
		System.out.println();

		System.out.println("\n---SORTED MERGE---\n");

		
		for(int i = 0; i < sortedNbrs.size(); i++) {
			System.out.println(sortedNbrs.get(i));
		}
		 
		*/

		System.out.println("\nMerge Sorting Time: " + (mergeEnd - mergeStart) + " milliseconds");

	}

	//recursive function for merge sorting
	public static ArrayList merge(ArrayList nbrs) {
		//System.out.println("nbrs size is now " + nbrs.size());
		if(nbrs.size() == 1) {
			return nbrs;
		}

		ArrayList<Integer> firstList = new ArrayList<Integer>();
		ArrayList<Integer> secondList = new ArrayList<Integer>();

		int i = 0;
		int j = nbrs.size()/2;
		
		
		while(i < nbrs.size()/2) {
			firstList.add((Integer) nbrs.get(i));
			i+=1;
			
			
		}
		

		while(j < nbrs.size()) {
			secondList.add((Integer) nbrs.get(j));
			j+=1;
		}
		

		firstList = merge(firstList);
		secondList = merge(secondList);

		return mergeHelper(firstList,secondList);

	}


	//helper function for merge sort
	public static ArrayList<Integer> mergeHelper(ArrayList<Integer> firstArrayList, ArrayList<Integer> secondArrayList) {


		ArrayList<Integer> finalArrayList = new ArrayList<Integer>();
		
		while (firstArrayList.size() > 0 && secondArrayList.size() > 0) {
			if(firstArrayList.get(0) <= secondArrayList.get(0)) {
				finalArrayList.add(firstArrayList.remove(0));
			}
			else {
				finalArrayList.add(secondArrayList.remove(0));
			}

		}
		
		
		while(!firstArrayList.isEmpty()) {
			finalArrayList.add(firstArrayList.remove(0));
		}

		while(!secondArrayList.isEmpty()) {
			finalArrayList.add(secondArrayList.remove(0));
		}


		return finalArrayList;

	}

}
