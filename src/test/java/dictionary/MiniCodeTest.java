package dictionary;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import minicodetest.DigitToTetters;

public class MiniCodeTest {

	@Test
	public void test1() {
		DigitToTetters digitToTetters = new DigitToTetters();
		int[] arr = { 2, 3 };
		String[] strarra = { "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf" };

		List<String> result = digitToTetters.convertDigitToTetters(arr);

		Assert.assertArrayEquals(strarra, result.toArray());
	}

	@Test
	public void test2() {
		DigitToTetters digitToTetters = new DigitToTetters();
		int[] arr = { 9 };
		String[] strarra = { "w", "x", "y", "z" };

		List<String> result = digitToTetters.convertDigitToTetters(arr);

		Assert.assertArrayEquals(strarra, result.toArray());
	}

	@Test
	public void test3() {
		DigitToTetters digitToTetters = new DigitToTetters();
		int[] arr = { 1, 0 };
		String[] strarra = {""};

		List<String> result = digitToTetters.convertDigitToTetters(arr);

		Assert.assertArrayEquals(strarra, result.toArray());
	}

	@Test
	public void test4() {
		DigitToTetters digitToTetters = new DigitToTetters();
		int[] arr = { 1, 9 };
		String[] strarra = { "w", "x", "y", "z" };

		List<String> result = digitToTetters.convertDigitToTetters(arr);

		Assert.assertArrayEquals( strarra, result.toArray());
	}

	@Test
	public void test5() {
		DigitToTetters digitToTetters = new DigitToTetters();
		int[] arr = { 1, 299 };

		List<String> result = digitToTetters.convertDigitToTetters(arr);

       boolean isFail = result.isEmpty();
	   Assert.assertTrue(isFail);
	}
}
