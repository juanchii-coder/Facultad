package ayed;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//       40
		//     /    \
		//    25     78
		//   /  \
		//  10  32
		/*
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
		*/
		
		GeneralTree<Integer> nodo1=new GeneralTree<Integer>(5);
		nodo1.addChild(new GeneralTree<Integer>(-6));
		nodo1.addChild(new GeneralTree<Integer>(2));
		nodo1.addChild(new GeneralTree<Integer>(8));
		GeneralTree<Integer> nodo2=new GeneralTree<Integer>(22);
		nodo2.addChild(new GeneralTree<Integer>(28));
		nodo2.addChild(new GeneralTree<Integer>(55));
		nodo2.addChild(new GeneralTree<Integer>(18));
		GeneralTree<Integer> nodo3=new GeneralTree<Integer>(19);
		nodo3.addChild(new GeneralTree<Integer>(4));
		nodo3.addChild(new GeneralTree<Integer>(2));
		nodo3.addChild(new GeneralTree<Integer>(8));
		
		GeneralTree<Integer> nodo4=new GeneralTree<Integer>(8);
		nodo4.addChild(nodo1);
		nodo4.addChild(nodo2);
		GeneralTree<Integer> nodo5=new GeneralTree<Integer>(-5);
		nodo5.addChild(nodo3);
		GeneralTree<Integer> nodo=new GeneralTree<Integer>(10);
		nodo.addChild(nodo4);
		nodo.addChild(nodo5);
		
		
		ParcialArbolGeneral arbol= new ParcialArbolGeneral(nodo);
		System.out.println(arbol.nivel(3).toString());
		System.out.println(arbol.nivel(2).toString());
		System.out.println(arbol.nivel(4).toString());
	}

}
