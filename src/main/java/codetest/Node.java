package codetest;

import java.util.List;

public class Node{
	private int startIndex;
	private int endIndex;
	private String word;
	private List<Node> nextNode = null;
	
	public Node(int startIndex, int endIndex, String word)
	{
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.word = word;
	}
	
	public void add(Node node){
		nextNode.add(node);
	}
	
	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public List<Node> getChildNode() {
		return nextNode;
	}

	public void setChildNode(List<Node> nextNode) {
		this.nextNode = nextNode;
	}

}