package ayed;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	public BinaryTree() {
		super();
	}
	public BinaryTree(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	public BinaryTree<T> getRightChild() {
		return rightChild;
	}
	public void addLeftChild(BinaryTree<T> child){
		this.leftChild = child;
	}
	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}
	public void removeLeftChild() {
		this.leftChild = null;
	}
	public void removeRightChild() {
		this.rightChild = null;
	}
	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}
	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}
	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}
	public void printPreorden() {
		System.out.println(this.getData());
		if (this.hasLeftChild()) {
			this.getLeftChild().printPreorden();
		}
		if (this.hasRightChild()) {
			this.getRightChild().printPreorden();
		}
	}
	public void printLevelTraversal() {
		BinaryTree<T> ab = null;
		Queue<BinaryTree<T>> cola = new LinkedList<>();
		cola.add(this);
		cola.add(null);
		while (!cola.isEmpty()) {
			ab = cola.remove();
			if (ab != null) {
				System.out.print("-"+ab.getData()+"-");
				if (ab.hasLeftChild()) {
					cola.add(ab.getLeftChild());
				}
				if (ab.hasRightChild()) {
					cola.add(ab.getRightChild());
				}
			} else if (!cola.isEmpty()) {
				System.out.println();
				cola.add(null);
			}
		}
	}



}
