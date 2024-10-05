package Parcial2;

import java.util.*;
import java.util.Queue;

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
		Queue<BinaryTree<Integer>> cola=new LinkedList<>();
		Queue<BinaryTree<Integer>> colaResul=new LinkedList<>();
		cola.add(arbol);
		colaResul.add(resul);
		while(!cola.isEmpty()) {
			aux=cola.remove();
			auxResul= colaResul.remove();
			
			if(aux.hasLeftChild()) {
				auxResul.addLeftChild(new BinaryTree<Integer>(aux.getLeftChild().getData()));
				cola.add(aux.getLeftChild());
				colaResul.add(auxResul.getLeftChild());
			}
			if(aux.hasRightChild()) {
				if(aux.hasLeftChild()) {
					auxResul.addRightChild(new BinaryTree<Integer>(aux.getLeftChild().getData()+aux.getRightChild().getData()));
				}
				else {
					auxResul.addRightChild(new BinaryTree<Integer>(aux.getRightChild().getData()));
				}
				cola.add(aux.getRightChild());
				colaResul.add(auxResul.getRightChild());
			}
	
		}
		return resul;
	}
}
