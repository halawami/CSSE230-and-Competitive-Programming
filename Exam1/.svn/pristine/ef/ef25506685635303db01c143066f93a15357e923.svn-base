package countDuplicates;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.Test;


public class Testing {

	private static int countDuplicatesPoints = 0;

	@Test
	public void testEmptyAndFew() {
		ArrayList<String> a1 = new ArrayList<String>();
		String a1ansString = "[]";
		assertEquals(a1ansString,Main.countDuplicates(a1).toString());
		a1.add("apple");
		a1ansString = "[(apple,1)]";
		assertEquals(a1ansString,Main.countDuplicates(a1).toString());
		a1.add("apple");
		a1ansString = "[(apple,2)]";
		assertEquals(a1ansString,Main.countDuplicates(a1).toString());
		a1.add("banana");
		a1ansString = "[(apple,2), (banana,1)]";
		assertEquals(a1ansString,Main.countDuplicates(a1).toString());
		countDuplicatesPoints += 2;
	}

	
	@Test
	public void testCountDuplicatesSorted() {
		ArrayList<String> a1 = new ArrayList<String>();
		String a1ansString;
		a1.add("apple");
		a1.add("apple");
		a1.add("apple");
		a1.add("apple");
		a1.add("apple");
		a1.add("banana");
		a1.add("banana");
		a1.add("banana");
		a1.add("carrot");
		a1ansString = "[(apple,5), (banana,3), (carrot,1)]";
		assertEquals(a1ansString,Main.countDuplicates(a1).toString());
		countDuplicatesPoints += 3;
		a1.add("carrot");
		a1.add("durian");
		a1.add("durian");
		a1.add("durian");
		a1ansString = "[(apple,5), (banana,3), (carrot,2), (durian,3)]";
		assertEquals(a1ansString,Main.countDuplicates(a1).toString());
		countDuplicatesPoints += 3;
	}
	

	@Test
	public void testCountDuplicatesDoesntChangeInput() {
		ArrayList<String> a1 = new ArrayList<String>();
		String a1ansString;
		a1.add("banana");
		a1.add("apple");
		a1.add("carrot");
		a1.add("apple");
		a1.add("apple");
		a1.add("banana");
		a1.add("apple");
		a1.add("banana");
		ArrayList<String> a2 = new ArrayList<String>();
		a2.addAll(a1);
		a1ansString = "[(apple,4), (banana,3), (carrot,1)]";
		assertEquals(a1ansString,Main.countDuplicates(a1).toString());
		assertEquals(a2,a1);
		countDuplicatesPoints += 3;
	}
	
	@Test
	public void testCountDuplicatesNotSorted() {
		ArrayList<String> a1 = new ArrayList<String>();
		String a1ansString;
		a1.add("banana");
		a1.add("apple");
		a1.add("carrot");
		a1.add("apple");
		a1.add("apple");
		a1.add("banana");
		a1.add("apple");
		a1.add("banana");
		a1ansString = "[(apple,4), (banana,3), (carrot,1)]";
		assertEquals(a1ansString,Main.countDuplicates(a1).toString());
		a1.add("apple");
		a1ansString = "[(apple,5), (banana,3), (carrot,1)]";
		assertEquals(a1ansString,Main.countDuplicates(a1).toString());
		countDuplicatesPoints += 2;
		a1.add("durian");
		a1.add("carrot");
		a1.add("durian");
		a1.add("durian");
		a1ansString = "[(apple,5), (banana,3), (carrot,2), (durian,3)]";
		assertEquals(a1ansString,Main.countDuplicates(a1).toString());
		countDuplicatesPoints += 3;
	}


	@Test
	public void testCountDuplicatesManyRandom() {
		// Constructs a random test case "backwards" by adding random multiplicities
		// of strings to an array, then shuffles them.
		int NUMTESTS = 10;
		int NUMSTRINGS_DEDUPED = 10000;
		Random ran = new Random();
		
		for (int testnum = 0; testnum < NUMTESTS; testnum++) {
			ArrayList<String> input = new ArrayList<String>(); // to contain input list
			StringBuilder ans = new StringBuilder(); // build the output string as we go
			ans.append("[");
			
			// Take integers to be our strings for convenience. 
			// With leading zeros, alphabetical order is same as numerical order.
			for (int num = 0; num < NUMSTRINGS_DEDUPED; num++) {
				String numString = String.format("%05d", num);
				int multiplicity = ran.nextInt(10);
				if (multiplicity > 0) {
					ans.append("(");
					ans.append(numString);
					ans.append(",");
					ans.append(String.valueOf(multiplicity));
					ans.append("), ");
				}
				for (int i = 0; i < multiplicity; i++) {
					input.add(numString);
				}
			}
			ans.delete(ans.length()-2, ans.length());
			ans.append("]");
			Collections.shuffle(input);
			assertEquals(ans.toString(),Main.countDuplicates(input).toString());
		}
		
		countDuplicatesPoints += 10;
	}
	
	
	
	@AfterClass
	public static void displayPoints() {
		System.out.printf("***   countDuplicates unit tests:                            %2d/26\n", countDuplicatesPoints);
		System.out.println("***   countDuplicates analysis (write it on your paper):      ?/ 8 [graded by instructor]");	
	}
}
