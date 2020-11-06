package minicodetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an integer array containing digits from [0, 9], 
 * the task is to print all possible letter combinations 
 * that the numbers could represent. A mapping of digit 
 * to letters (just like on the telephone buttons) is being 
 * followed. Note that 0 and 1 do not map to any letters
 * 
 * 
 * @author Jack
 * @version 1.0.0
 */
public class DigitToTetters {
	
	int[] sizeTable = {0, 99}; 
	
	
	private void checkInput(int[] inputArray) throws Exception
	{
		if(0 == inputArray.length)
		{
			throw new Exception("input one null array, please check");
		}
	}
	
	public List<String> convertDigitToTetters(int[] inputArray)
	{
		List<List<String>> lists = new ArrayList<List<String>>();
		List<String> resultList = new ArrayList<>();
		try {
			checkInput(inputArray);
			List<String> subList = null;
			for(int x : inputArray)
			{
				subList = digitSpilt(x);
				lists.add(subList);
			}
			
			
			for (List<String> list : lists) {
	            if (resultList.isEmpty()) {
	            	resultList = list;
	            } else {
	            	resultList = resultList.stream().flatMap(item -> list.stream().map(item2 -> item + item2)).collect(Collectors.toList());
	            }
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return resultList;
		}	
	}

	public List<String> digitSpilt(int digit) throws Exception
	{
		int max = Arrays.stream(sizeTable).max().getAsInt();
		int min = Arrays.stream(sizeTable).min().getAsInt();
		
		if (digit < min || digit > max)
		{
			throw new Exception("the Value out of range, please check it again.");
		}
		
		List<Character> list = String.valueOf(digit).chars().mapToObj(item -> (char)item).collect(Collectors.toList());
	
		List<String> tettleList = new ArrayList<String>();
		list.stream().forEach(x -> {
			String[] array = DigitEnum.getValue(Character.getNumericValue(x)).split(", ");
			tettleList.addAll(Arrays.asList(array));
		});
		
		return tettleList;
	} 

}
