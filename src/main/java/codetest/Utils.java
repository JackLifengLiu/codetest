package codetest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Utils {

	public static Node addNode(Node root, Node node) {
		if (null == root) {
			root = node;
		} else {
			addChildNode(root, node);
		}

		return root;
	}

	public static void addChildNode(Node root, Node node) {
		
		if(root.getEndIndex() == node.getStartIndex())
		{
			if (null == root.getChildNode()) {
				List<Node> nlist = new ArrayList<Node>();
				root.setChildNode(nlist);
				root.add(node);
			} else{
				boolean isAdd = true;
				for(Node child : root.getChildNode())
				{
					if (child.getStartIndex() == node.getStartIndex() && child.getEndIndex() == node.getEndIndex() &&
							child.getWord().equals(node.getWord()))
					{
						isAdd = false;
						break;
					}
				}
				if (isAdd)
				{
					root.getChildNode().add(node); 
				}
				
			}
		} else if(null != root.getChildNode()){
			for (Node child : root.getChildNode()) {
				addChildNode(child, node);
			}

		}
	}

	public static Queue<Integer> getStartIndex(Queue<Integer> queue, Node node) {
		if (null == node) {
			queue.add(0);
		} else if (null == node.getChildNode()) {
			if (node.getEndIndex() != -1) {
				queue.add(node.getEndIndex());
			}
		} else {
			for (Node childNode : node.getChildNode()) {
				getStartIndex(queue, childNode);
			}
		}
		return queue;
	}

	public static void deleteNode(int deleteIndex, Node root) {
		
		if (deleteIndex == root.getEndIndex()) {
			root = null;
		} else if (null != root.getChildNode()) {
			Iterator<Node> iterator = root.getChildNode().iterator();
	        while (iterator.hasNext()) {
	        	Node childNode  = iterator.next();
	            if (deleteIndex == childNode.getEndIndex()) {
	                iterator.remove();
	            }else
				{
					deleteNode(deleteIndex, childNode);
				}
	        }
		}
	}

	public static void outString(StringBuffer sb, Node node, List<String> listBuffer) {

		if (null == node.getChildNode()) {
			sb.append(" " + node.getWord());
			listBuffer.add(sb.delete(0, 1).toString());

		} else {
			sb.append(" " + node.getWord());
			for (Node childNode : node.getChildNode()) {

				outString(new StringBuffer(sb), childNode, listBuffer);
			}

		}

		// return sb.toString();
	}

}
