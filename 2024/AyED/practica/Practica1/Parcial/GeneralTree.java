package Parcial;

import java.util.*;

public class GeneralTree<T> {
	
	 private T dato; 
	 
	 private List<GeneralTree<T>> hijos =
		 new LinkedList<GeneralTree<T>>();
		 public GeneralTree(T dato) {
		 this.dato = dato;
	 }
	 public GeneralTree(T dato, List<GeneralTree<T>> hijos){
		 this(dato);
		 if (hijos==null)
			 this.hijos = new LinkedList<GeneralTree<T>>();
		 else
			 this.hijos = hijos;
	 }
	 public T getValue() {
		 return dato;
	 }
	 public void setValue(T dato) {
		 this.dato = dato;
	 }
	 public void setChildNodes(List<GeneralTree<T>> hijos) {
		 if (hijos==null)
			 this.hijos = new LinkedList<GeneralTree<T>>();
		 else
			 this.hijos = hijos;
	 }
	 	public List<GeneralTree<T>> getChildNodes() {
	 		return this.hijos;
	 	}
		public void addChildNode(GeneralTree<T> unHijo) {
			this.getChildNodes().add(unHijo);
		}
		public boolean isLeaf() {
			return !this.hasChildNodes();
		}
		  
		public boolean hasChildNodes() {
			return this.hijos!=null && !this.hijos.isEmpty();
		}
		  
		public boolean isEmpty() {
			return this.dato == null && !this.hasChildNodes();
		}
		  
		public void removeChildNode(GeneralTree<T> hijo) {
			if (this.hasChildNodes()) {
				List<GeneralTree<T>> hijos = this.getChildNodes();
				if (hijos.contains(hijo))
				hijos.remove(hijo);
			}
		}
}
