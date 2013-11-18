package com.baidu.chunlei.exercise;

import java.util.ArrayList;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-5-13
 * @version
 * @todo 
 */
public class TreeNode<T> {
	private T data = null;
	private TreeNode<T> parent = null;
	private ArrayList<TreeNode<T>> children = null;
	
	public TreeNode(T data){
		this.data = data;
		this.children = new ArrayList<TreeNode<T>>();
	}
	
	public T getData(){
		return data;
	}
	
	public void setData(T data){
		this.data = data;
	}
	
	public TreeNode<T> getParent(){
		return parent;
	}
	
	public void addChild(TreeNode<T> child){
		children.add(child);
//		child.setParent(this);
		child.parent = this;
	}
	
	public void removeChild(TreeNode<T> node){
		int childrenSize = children.size();
		for(int i = 0; i < childrenSize; i++){
			if(children.get(i) == node){
				children.remove(i);
			}
		}
	}
	
	private void insertFrontWhitespace(TreeNode<T> root, TreeNode<T> node, StringBuffer sb){
		int number = 2 + node.parent.data.toString().length();
		for (int i = 0; i < number; i++){
			sb.append(" ");
		}
		if (node.parent == root){
			return ;
		}
		sb.append("│");
		insertFrontWhitespace(root, node.parent, sb);
	}
	
	private void drawFamily(StringBuffer sb, TreeNode<T> root){
		int childrenSize = children.size();
		
		// draw itself
		sb.append("─" + data);
		if(childrenSize == 0){
			sb.append("\n");
			return ;
		}
		
		// draw the first child
		if (childrenSize == 1){
			sb.append("──");
		}else{
			sb.append("─┬");
		}
		children.get(0).drawFamily(sb, root);
		
		// draw middle children
		int i = 1;
		for(; i < childrenSize - 1; i++){
			StringBuffer t = new StringBuffer();
			insertFrontWhitespace(root, children.get(i), t);
			sb.append(t.reverse());
			sb.append("├");
			children.get(i).drawFamily(sb, root);
		}
		
		// draw the last child
		if (childrenSize > 1){
			StringBuffer t = new StringBuffer();
			insertFrontWhitespace(root, children.get(i), t);
			sb.append(t.reverse());
			sb.append("└");
			children.get(i).drawFamily(sb, root);
		}
	}
	
	public void drawTree(){
		StringBuffer sb = new StringBuffer();
		drawFamily(sb, this);
		System.out.println(sb);
	}
	
	//支持回调
	public void preorderTraversal(){
		System.out.println("" + data);
		
		int childrenSize = children.size();
		for(int i = 0; i < childrenSize; i++){
			children.get(i).preorderTraversal();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Map map = new HashMap();
//		Iterator iter = map.entrySet().iterator();
//		while (iter.hasNext()) {
//			Entry entry = (Entry) iter.next();
//			Object key = entry.getKey();
//			Object val = entry.getValue();
//		}
		
		// test create a multi-way tree, like below
//		─0─┬─1─┬─333
//		   │   └─4444───88888888
//		   ├─22─┬─55555
//		   │    └─666666
//		   └─7777777
		TreeNode<String> root = new TreeNode<String>("0");
		TreeNode<String> node1 = new TreeNode<String>("1");
		TreeNode<String> node2 = new TreeNode<String>("22");
		TreeNode<String> node3 = new TreeNode<String>("333");
		TreeNode<String> node4 = new TreeNode<String>("4444");
		TreeNode<String> node5 = new TreeNode<String>("55555");
		TreeNode<String> node6 = new TreeNode<String>("666666");
		TreeNode<String> node7 = new TreeNode<String>("7777777");
		TreeNode<String> node8 = new TreeNode<String>("88888888");
		root.addChild(node1);
		root.addChild(node2);
		root.addChild(node7);
		node1.addChild(node3);
		node1.addChild(node4);
		node2.addChild(node5);
		node2.addChild(node6);
		node4.addChild(node8);
		
		// test draw tree
		root.drawTree();
		node1.drawTree();
		node4.drawTree();
		node7.drawTree();
		
		// test remove child
		node1.removeChild(node4);
		root.drawTree();
	}

}
