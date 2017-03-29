import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;

public class Testing {

	private static int points = 0;
	private static int depthPoints = 0;

	@Test
	public void testCountPositivesBaseCase() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		assertEquals(0, b.countPositives());
		points += 1;
	}

	@Test
	public void testCountPositivesZeroAndPositive() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		for (int i = -1000; i < 1; i++) {
			b.insert(i);
		}
		assertEquals(0, b.countPositives());
		for (int i = 1; i <= 1000; i++) {
			b.insert(i);
		}
		assertEquals(1000, b.countPositives());
		points += 1;
	}

	@Test
	public void testCountPositivesPositiveAndZero() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		b = new BinarySearchTree<Integer>();
		for (int i = 1000; i > 0; i--) {
			b.insert(i);
		}
		assertEquals(1000, b.countPositives());
		for (int i = 0; i >= -1000; i--) {
			b.insert(i);
		}
		assertEquals(1000, b.countPositives());
		points += 1;
	}

	@Test
	public void testCountPositivesMix() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		b = new BinarySearchTree<Integer>();
		b.insert(0);
		int size = 16;// 128
		int v = size / 2;
		int temp;
		while (v > 0) {
			temp = v;
			while (temp < size) {
				b.insert(temp);
				b.insert(-temp);
				temp += v;
			}
			v = v / 2;
		}
		assertEquals(15, b.countPositives());
		points += 1;
	}

	@Test
	public void testGetDepth() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(40);
		b.insert(38);
		b.insert(5);
		b.insert(15);
		b.insert(50);
		assertEquals(0, b.getDepth(20));
		assertEquals(1, b.getDepth(10));
		assertEquals(1, b.getDepth(30));
		depthPoints += 1;
		assertEquals(2, b.getDepth(40));
		assertEquals(3, b.getDepth(38));
		depthPoints += 1;
		assertEquals(2, b.getDepth(5));
		assertEquals(2, b.getDepth(15));
		assertEquals(3, b.getDepth(50));
		depthPoints += 1;
	}

	@Test
	public void testGetDepthNotFound() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		assertEquals(-1, b.getDepth(20));
		depthPoints += 1;
		b.insert(20);
		b.insert(10);
		b.insert(30);
		b.insert(40);
		b.insert(38);
		b.insert(5);
		b.insert(15);
		b.insert(50);
		assertEquals(-1, b.getDepth(99));
		depthPoints += 1;
	}

	@Test
	public void testNumChildrenOfEachNodeBaseCases() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		assertEquals("", b.numChildrenOfEachNode());
		b.insert(10);
		assertEquals("0", b.numChildrenOfEachNode());
		points += 1;
	}

	@Test
	public void testNumChildrenOfEachNodeInc() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		for (int i = 1; i < 11; i++) {
			b.insert(i);
		}
		assertEquals("1111111110", b.numChildrenOfEachNode());
		points += 1;
	}

	@Test
	public void testNumChildrenOfEachNodeDec() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		for (int i = 10; i > 0; i--) {
			b.insert(i);
		}
		assertEquals("1111111110", b.numChildrenOfEachNode());
		points += 1;
	}

	@Test
	public void testNumChildrenOfEachNodeFull() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		int size = 16;// 128
		int v = size / 2;
		int temp;
		while (v > 0) {
			temp = v;
			while (temp < size) {
				b.insert(temp);
				temp += v;
			}
			v = v / 2;
		}
		assertEquals("222002002200200", b.numChildrenOfEachNode());
		points += 1;
	}

	@Test
	public void testZigZagBaseCases() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		assertTrue(b.isZigZag());
		b.insert(10);
		assertTrue(b.isZigZag());
		b.insert(1);
		points += 1;
	}

	@Test
	public void testZigZagSimplePositive() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		b.insert(10);
		b.insert(1);
		assertTrue(b.isZigZag());
		b.insert(9);
		assertTrue(b.isZigZag());
		b.insert(2);
		assertTrue(b.isZigZag());
		b.insert(7);
		assertTrue(b.isZigZag());
		points += 1;
	}

	@Test
	public void testZigZagSimpleNegative() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		b.insert(10);
		assertTrue(b.isZigZag());
		b.insert(1);
		b.insert(9);
		b.insert(2);
		b.insert(7);
		b.insert(8);
		assertFalse(b.isZigZag());
		b.insert(11);
		assertFalse(b.isZigZag());

		b = new BinarySearchTree<Integer>();
		b.insert(10);
		b.insert(9);
		b.insert(11);
		assertFalse(b.isZigZag());
		points += 1;
	}

	@Test
	public void testZigZagNegative() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		b.insert(10);
		assertTrue(b.isZigZag());
		b.insert(5);
		b.insert(2);
		b.insert(3);
		b.insert(4);
		assertFalse(b.isZigZag());
		points += 1;
	}

	@Test
	public void testZigZagNegative2() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		b.insert(10);
		b.insert(2);
		assertTrue(b.isZigZag());
		b.insert(8);
		b.insert(6);
		b.insert(1);
		assertFalse(b.isZigZag());
		points += 1;
	}

	@Test
	public void testZigZagBigTreeLeaf() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		assertTrue(b.isZigZag());
		for (int i = 1; i < 9; i++) {
			b.insert(i);
			b.insert(20 - i);
		}
		b.insert(10);
		b.insert(9);
		assertFalse(b.isZigZag());
		points += 1;
	}

	@Test
	public void testZigZagBigTreeMiddle() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		for (int i = 1; i < 4; i++) {
			b.insert(i);
			b.insert(20 - i);
		}
		assertTrue(b.isZigZag());
		b.insert(5);
		for (int i = 7; i < 10; i++) {
			b.insert(i);
			b.insert(20 - i);
		}
		assertFalse(b.isZigZag());
		points += 1;
	}

	@AfterClass
	public static void displayPoints() {
		System.out.printf("Points: %d/20\n", (points + depthPoints));
	}
}