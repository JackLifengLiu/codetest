package codetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Given a valid sentence without any spaces between 
 * the words and a dictionary of valid English words,
 * find all possible ways to break the sentence in 
 * individual dictionary words.
 * 
 * @author Jack
 *
 */
public class WordBreak {

	public List<String> searchWord(String testWord, String[]... dictionarys) {
		List<String> dictionaryList = new ArrayList<String>();
		for(String[] array : dictionarys)
		{
			dictionaryList.addAll(Arrays.asList(array));
		}
		List<String> listAllDistinct = dictionaryList.stream().distinct().collect(Collectors.toList());
		Node root = null;
		Node node = null;
		int slength = testWord.length() + 1;
		boolean[] stauts = new boolean[slength];

		Queue<Integer> queue = new LinkedList<Integer>();
		Utils.getStartIndex(queue, root);
		int size = 0;

		while (!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				int startPosition = queue.poll().intValue();

				for (String word : listAllDistinct) {
					int endIndex = startPosition + word.length();
					if (endIndex > slength) {
						continue;
					} else if (endIndex == slength) {
						endIndex = endIndex - 1;
					}
					String result = testWord.substring(startPosition, endIndex);
					if (!result.equals(word)) {
						continue;
					}
					stauts[startPosition] = true;  // hit or not hie while the and
					node = new Node(startPosition, endIndex, result);
					root = Utils.addNode(root, node);
					
				}
				
				// while  finish it is need hit
				if (startPosition == slength - 1) {
					stauts[startPosition] = true;
				}
				
				if (!stauts[startPosition]) {
					if (null == root)
					{
						root = new Node(0, -1, ""); 
					}else
					{
						Utils.deleteNode(startPosition, root);
					}				
				}
			}

			if (!stauts[slength - 1]) {
				 Utils.getStartIndex(queue, root);
			}
		}

		List<String> checkResultList = new ArrayList<String>();
		
		Utils.outString(new StringBuffer(""), root, checkResultList);
				
		return  checkResultList;
	}
}
