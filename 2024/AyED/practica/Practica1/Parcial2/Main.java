package Parcial2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//       40
		//     /    \
		//    25     78
		//   /  \
		//  10  32
		
		BinaryTree<Integer> ab = new BinaryTree<Integer>(1);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(2);
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(4));
		
		BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(3);
		hijoDerecho.addRightChild(new BinaryTree<Integer>(7));
		hijoDerecho.getRightChild().addLeftChild(new BinaryTree<Integer>(8));
		hijoDerecho.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(9));
		hijoDerecho.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(10));
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		ParcialArbol a=new ParcialArbol();
		BinaryTree<Integer> nuevo = new BinaryTree<Integer>();
		a.arbol=ab;
		nuevo=a.NuevoTree();
		nuevo.printLevelTraversal();
	}

}
