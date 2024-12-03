package ayed;

import java.util.ArrayList;
import java.util.List;

public class ParcialArbolGeneral {
	private GeneralTree<Integer> arbol;
	
	public ParcialArbolGeneral (GeneralTree<Integer> a) {
		arbol=a;
	}

	public List<Integer> nivel(int num){
		List<Integer> lista=null;
		if(!this.arbol.isEmpty()) {
			lista= new ArrayList<>();
			return buscarNivel(lista,num);
		}
		return lista;
	}

	private List<Integer> buscarNivel(List<Integer> l, int num) {
		Queue<GeneralTree<Integer>> cola=new Queue<>();
		GeneralTree<Integer> aux;
		cola.enqueue(this.arbol);
		cola.enqueue(null);// agrego un null para saber cuando termino un nivel
		boolean cumple=false;
		int cantNodos=cola.size()-1;
		int cantNodosCumplen=0;
		while(!cola.isEmpty()) {
			aux=cola.dequeue();
			if(aux!=null) {
				if(aux.getChildren().size()>=num) {
					cumple=true;
					cantNodosCumplen++;
					l.add(aux.getData());
				}
				if(!aux.isLeaf()) {
					for(GeneralTree<Integer> hijo : aux.getChildren()) {
						cola.enqueue(hijo);
					}
				}
				
			}else {
				if((cumple) && (cantNodos==cantNodosCumplen)) {
					return l;
				}else if(!cumple && !l.isEmpty()) {
					l.clear();
				}
				cantNodosCumplen=0;
				cantNodos=cola.size();
				cola.enqueue(null);//llego al final de el nivel, agrego un null para saber cuando termino otro nivel
			}
		}
		return l;
	}
}
