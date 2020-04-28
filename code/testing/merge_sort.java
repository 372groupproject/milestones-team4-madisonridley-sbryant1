
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


	public static void sortFunction() {


		ArrayList nbrs = new ArrayList();
		nbrs = readFile();

		/////////////UNCOMMENT TO SEE ALL OF THE UNSORTED MERGE NUMBERS
		/*
		System.out.println("\n---UNSORTED MERGE---\n");

		
		for(int i = 0; i < randoms.length; i++) {
			System.out.println(randoms[i]);
		}
		 */


		long mergeStart = System.currentTimeMillis();

		merge(nbrs);

		long mergeEnd = System.currentTimeMillis();
		
		////////////UNCOMMMENT TO SEE ALL THE SORTED NUMBERS
		/*
		System.out.println();

		System.out.println("\n---SORTED MERGE---\n");

		
		for(int i = 0; i < randomsQuick.length; i++) {
			System.out.println(randomsQuick[i]);
		}
		 */


		System.out.println("\nMerge Sorting Time: " + (mergeEnd - mergeStart) + " milliseconds");

	}

	//recursive function for merge sorting
	public static ArrayList merge(ArrayList nbrs) {

		if(nbrs.size() == 1) {
			return nbrs;
		}

		ArrayList<Integer> firstList = new ArrayList<Integer>();
		ArrayList<Integer> secondList = new ArrayList<Integer>();

		int i = 0;
		int j = nbrs.size()/2;
		
		//System.out.println("nbrs size " + nbrs.size());
		//System.out.println("i is " + i);
		//System.out.println("j is " + j);
		

		while(i < nbrs.size()/2) {
			firstList.add((Integer) nbrs.get(i));
			i+=1;
		}
		
		/*
		for(int k = 0 ; k < firstList.size(); k++) {
			System.out.println(firstList.get(k));
		}
		*/

		while(j < nbrs.size()) {
			secondList.add((Integer) nbrs.get(j));
			j+=1;
		}
		
		//System.out.println("\n\n\n\n");

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

		for(int k = 0 ; k < finalArrayList.size(); k++) {
			System.out.println(finalArrayList.get(k));
		}
		
		System.out.println("\n\n\n\n");
		
		while(!firstArrayList.isEmpty()) {
			finalArrayList.add(firstArrayList.remove(0));
		}

		while(!secondArrayList.isEmpty()) {
			finalArrayList.add(secondArrayList.remove(0));
		}


		return finalArrayList;

	}




}
