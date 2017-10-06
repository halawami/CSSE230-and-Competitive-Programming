package bst;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Test;

public class Testing {

	private static int numPosMinusNumNegPoints = 0;
	private static int containsStrictlyInRangePoints = 0;
	private static int removeSingleParentsPoints = 0;

	
	private BinarySearchTree buildTree() {
		BinarySearchTree b = new BinarySearchTree();
		b.insert(20);
		b.insert(-50);
		b.insert(30);
		b.insert(10);
		b.insert(-40);
		b.insert(60);
		b.insert(40);
		b.insert(-10);
		b.insert(15);
		b.insert(35);
		b.insert(-70);
		b.insert(45);
		return b;
	}
	
	
	private BinarySearchTree buildDegenerateTree() {
		BinarySearchTree b = new BinarySearchTree();
		for (int i = 0; i < 50; i += 2) {
			b.insert(i);
			b.insert(100-i);
		}
		b.insert(50);
		return b;
	}
	

	@Test
	public void testNumPosMinusNumNegPointsNegValues() {
		BinarySearchTree b = new BinarySearchTree();
		b.insert(-5);
		assertEquals(-1, b.numPosMinusNumNeg());	// test root only
		numPosMinusNumNegPoints += 1;
		b.insert(-25);
		b.insert(-10);
		b.insert(-15);
		b.insert(-45);
		b.insert(-2);
		assertEquals(-6, b.numPosMinusNumNeg());	// test all negative
		numPosMinusNumNegPoints += 2;
	}
	
	@Test
	public void testNumPosMinusNumNegPointsPosValues() {
		BinarySearchTree b = new BinarySearchTree();
		b.insert(15);
		assertEquals(1, b.numPosMinusNumNeg());	// test root only
		numPosMinusNumNegPoints += 1;
		b.insert(30);
		b.insert(5);
		b.insert(20);
		b.insert(35);
		b.insert(25);
		b.insert(10);
		assertEquals(7, b.numPosMinusNumNeg());	// test all positive
		numPosMinusNumNegPoints += 2;
	}
	
	@Test
	public void testNumPosMinusNumNegPointsZeroValue() {
		BinarySearchTree b = new BinarySearchTree();
		assertEquals(0, b.numPosMinusNumNeg());		// test empty tree
		numPosMinusNumNegPoints += 2;
		b.insert(0);
		assertEquals(0, b.numPosMinusNumNeg());		// test root only
		numPosMinusNumNegPoints += 2;
		b = buildTree();
		b.insert(0);
		assertEquals(4, b.numPosMinusNumNeg());	// test zero
		numPosMinusNumNegPoints += 2;
	}
	
	@Test
	public void testNumPosMinusNumNegPointsExampleTree() {
		BinarySearchTree b = buildTree();
		assertEquals(4, b.numPosMinusNumNeg());
		numPosMinusNumNegPoints += 2;
		b.insert(-60);
		assertEquals(3, b.numPosMinusNumNeg());
		b.insert(-80);
		assertEquals(2, b.numPosMinusNumNeg());
		b.insert(25);
		assertEquals(3, b.numPosMinusNumNeg());
		numPosMinusNumNegPoints += 2;
	}
	
	@Test
	public void testContainsStrictlyInRangePointsExampleTree() {
		BinarySearchTree b = buildTree();
		assertTrue(b.containsStrictlyInRange(39,42));
		assertTrue(b.containsStrictlyInRange(18,22));
		assertFalse(b.containsStrictlyInRange(23,27));
		containsStrictlyInRangePoints += 3;
		assertTrue(b.containsStrictlyInRange(25,55));
		assertTrue(b.containsStrictlyInRange(-12,-8));
		assertTrue(b.containsStrictlyInRange(-80,0));
		assertFalse(b.containsStrictlyInRange(80,200));
		b.insert(100);
		assertTrue(b.containsStrictlyInRange(80,200));
		containsStrictlyInRangePoints += 3;
	}
	
	@Test
	public void testContainsStrictlyInRangePointsExampleTreeStrict() {
		BinarySearchTree b = buildTree();
		assertTrue(b.containsStrictlyInRange(-10,15));
		assertFalse(b.containsStrictlyInRange(20,30));
		assertFalse(b.containsStrictlyInRange(-80,-70));
		assertTrue(b.containsStrictlyInRange(15,30));
		containsStrictlyInRangePoints += 3;
	}
	
	@Test
	public void testContainsStrictlyInRangePointsEmptyTree() {
		BinarySearchTree b = new BinarySearchTree();
		assertFalse(b.containsStrictlyInRange(5,10));
		b.insert(8);
		assertTrue(b.containsStrictlyInRange(5,10));
		containsStrictlyInRangePoints += 1;
	}
	

	@Test
	public void testRemoveSingleParentsExampleTree() {
		BinarySearchTree b = buildTree();
		assertEquals("[-70, -50, -40, -10, 10, 15, 20, 30, 35, 40, 45, 60]",b.toString());
		b.removeSingleParents();
		assertEquals("[-70, -50, -10, 10, 15, 20, 35, 40, 45]",b.toString());
		b.removeSingleParents();  // test to make sure no more edits are made
		assertEquals("[-70, -50, -10, 10, 15, 20, 35, 40, 45]",b.toString());
		removeSingleParentsPoints += 10;
	}
	

	@Test
	public void testRemoveSingleParentsDegenerateTree() {
		BinarySearchTree b = buildDegenerateTree();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= 100; i += 2) {
			list.add(i);
		}
		assertEquals(list.toString(),b.toString());
		b.removeSingleParents();
		assertEquals("[50]",b.toString());
		removeSingleParentsPoints += 4;
		b = buildDegenerateTree();
		b.insert(1);  // 2's L child. Now 2 has two children
		b.insert(61); // 60's R child. Now 60 has two children
		b.removeSingleParents();
		assertEquals("[1, 2, 50, 60, 61]",b.toString());
		removeSingleParentsPoints += 4;
	}
	
	@Test
	public void testRemoveSingleParentsEmptyAndSmallTrees() {
		BinarySearchTree b = new BinarySearchTree();
		assertEquals("[]",b.toString());
		b.insert(5);
		b.insert(2);
		assertEquals("[2, 5]",b.toString());
		b.removeSingleParents();
		assertEquals("[2]",b.toString());
		b.insert(5);
		assertEquals("[2, 5]",b.toString());
		b.removeSingleParents();
		assertEquals("[5]",b.toString());
		removeSingleParentsPoints += 2;
	}


	@AfterClass
	public static void displayPoints() {
		System.out.printf("%2d/16 numPosMinusNumNegPoints correctness points\n", numPosMinusNumNegPoints);
		System.out.printf("%2d/10 containsStrictlyInRangePoints correctness points\n", containsStrictlyInRangePoints);
		System.out.printf(" _/10 containsStrictlyInRangePoints efficiency will be checked by the instructor\n");
		System.out.printf("%2d/20 removeSingleParentsPoints correctness points\n", removeSingleParentsPoints);
		System.out.printf(" _/ 4  elegance will be checked by the instructor\n");

	}
}
