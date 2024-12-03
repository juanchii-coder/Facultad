package ayed;

import java.util.*;

public class ParcialArbol {
	BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> NuevoTree(){
		BinaryTree<Integer>aux=new BinaryTree<Integer>();
		if(arbol!=null) {
			return CrearArbol(aux);
		}else {
			return aux;
		}
	}

	private BinaryTree<Integer> CrearArbol(BinaryTree<Integer> resul) {
		BinaryTree<Integer> aux,auxResul;
		Queue<BinaryTree<Integer>> cola=new Queue<>();
		Queue<BinaryTree<Integer>> colaResul=new Queue<>();
		cola.enqueue(arbol);
		colaResul.enqueue(resul);
		while(!cola.isEmpty()) {
			aux=cola.dequeue();
			auxResul= colaResul.dequeue();
			
			if(aux.hasLeftChild()) {
				auxResul.addLeftChild(new BinaryTree<Integer>(aux.getLeftChild().getData()));
				cola.enqueue(aux.getLeftChild());
				colaResul.enqueue(auxResul.getLeftChild());
			}
			if(aux.hasRightChild()) {
				if(aux.hasLeftChild()) {
					auxResul.addRightChild(new BinaryTree<Integer>(aux.getLeftChild().getData()+aux.getRightChild().getData()));
				}
				else {
					auxResul.addRightChild(new BinaryTree<Integer>(aux.getRightChild().getData()));
				}
				cola.enqueue(aux.getRightChild());
				colaResul.enqueue(auxResul.getRightChild());
			}
	
		}
		return resul;
	}
}
