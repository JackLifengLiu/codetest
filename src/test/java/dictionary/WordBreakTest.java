package dictionary;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import codetest.WordBreak;

public class WordBreakTest {

	@Test
	public void testString1UseDictionary1() {
		WordBreak codeTest = new WordBreak();
		String[] dictionary = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man", "go" };
		String str = "ilikesamsungmobile";

		List<String> result = codeTest.searchWord(str, dictionary);
		String[] array = { "i like sam sung mobile", "i like samsung mobile" };
		Assert.assertArrayEquals(array, result.toArray());
	}

	@Test
	public void testString2UseDictionary1() {
		WordBreak codeTest = new WordBreak();
		String[] dictionaryArray = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man",
				"go" };
		String str = "ilikeicecreamandmango";
		List<String> result = codeTest.searchWord(str, dictionaryArray);
		String[] array = { "i like ice cream and man go" };
		Assert.assertArrayEquals(array, result.toArray());
	}

	@Test
	public void testUserDictionary1() {
		WordBreak codeTest = new WordBreak();
		String[] dictionary = { "i", "like", "sam", "sung", "mobile", "icecream", "and", "man go", "mango" };
		String str = "ilikeicecreamandmango";
		List<String> result = codeTest.searchWord(str, dictionary);
		String[] array = { "i like icecream and mango" };
		Assert.assertArrayEquals(array, result.toArray());
	}

	@Test
	public void testUserDictionary2() {
		WordBreak codeTest = new WordBreak();
		String[] dictionary = { "i", "like", "sam", "sung", "mobile", "icecream", "and", "man", "go", "mango" };
		String str = "ilikeicecreamandmango";
		List<String> result = codeTest.searchWord(str, dictionary);
		String[] array = { "i like icecream and man go", "i like icecream and mango" };
		Assert.assertArrayEquals(array, result.toArray());
	}

	@Test
	public void testDoubleDictionary() {
		WordBreak codeTest = new WordBreak();
		String[] dictionary1 = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man", "go" };
		String[] dictionary2 = { "i", "like", "sam", "sung", "mobile", "icecream", "and", "man", "go", "mango" };
		String str = "ilikeicecreamandmango";
		List<String> result = codeTest.searchWord(str, dictionary1, dictionary2);
		String[] array = { "i like ice cream and man go", "i like ice cream and mango", "i like icecream and man go",
				"i like icecream and mango" };
		Assert.assertArrayEquals(array, result.toArray());
	}

	@Test
	public void testWithoutHit() {
		WordBreak codeTest = new WordBreak();
		String[] dictionary1 = { "our", "me", "summer", "song" };

		String str = "ilikeicecreamandmango";
		List<String> result = codeTest.searchWord(str, dictionary1);
		String[] array = { "" };
		Assert.assertArrayEquals(array, result.toArray());
	}

	@Test
	public void testHalfHit() {
		WordBreak codeTest = new WordBreak();
		String[] dictionary1 = { "i", "like", "ice" };

		String str = "ilikeicecreamandmango";
		List<String> result = codeTest.searchWord(str, dictionary1);
		String[] array = {};
		Assert.assertArrayEquals(array, result.toArray());
	}
}
