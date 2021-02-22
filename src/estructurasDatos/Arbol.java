package estructurasDatos;




public class Arbol<k extends Comparable<k>,v> {
	
		private Nodo primerElemento;      

		private class  Nodo   { 

			private k key;          
			private v valor;         
			private Nodo nIzquierda, nDerecha;    
			private int numeroElementos;               
			public Nodo(k key, v pValor, int numeroElementos)     
			{ 
				this.key = key; this.valor = pValor; this.numeroElementos = numeroElementos; 
			} 

		} 

		public int size()  {

			return size(primerElemento); 
		}  

		private int size(Nodo pNodo) {    

			if (pNodo == null)
			{
				return 0; 
			}	  
			else 
			{
				return pNodo.numeroElementos; 
			}

		}

		public  v get(k key) {  

			return get(primerElemento, key); 

		}

		private v get(Nodo pNodo, k key) {  

			if (pNodo == null) 
			{
				return null;  
			}

			int rComparacion = key.compareTo(pNodo.key);  

			if (rComparacion < 0) 
			{
				return get(pNodo.nIzquierda, key);  
			}
			else if (rComparacion > 0) 
			{
				return get(pNodo.nDerecha, key);  
			}
			else
			{
				return pNodo.valor; 
			}

		} 

		public void put(k key, v pValor){  

			primerElemento = put(primerElemento, key, pValor); 

		} 

		private Nodo put(Nodo pNodo, k key, v pValor) {  

			if (pNodo == null) 
			{
				return new Nodo(key, pValor, 1); 
			}

			int cmp = key.compareTo(pNodo.key); 

			if (cmp < 0) 
			{
				pNodo.nIzquierda  = put(pNodo.nIzquierda,  key, pValor);  
			}
			else if(cmp > 0) 
			{
				pNodo.nDerecha = put(pNodo.nDerecha, key, pValor); 
			}
			else
			{
				pNodo.valor = pValor;  
			}

			pNodo.numeroElementos = size(pNodo.nIzquierda) + size(pNodo.nDerecha) + 1; 
			return pNodo;

		}

		public k min() {    

			return min(primerElemento).key; 

		} 

		private Nodo min(Nodo x) {  

			if (x.nIzquierda == null) 
			{
				return x;  
			}
			return min(x.nIzquierda);

		} 

		public int height() {
			return height(primerElemento);
		}
		private int height(Nodo x) {
			if (x == null) return -1;
			return 1 + Math.max(height(x.nIzquierda), height(x.nDerecha));
		}

		public k floor(k key) {     

			Nodo x = floor(primerElemento, key);  
			if (x == null) 
			{
				return null;   
			}
			return x.key; 

		} 

		private Nodo floor(Nodo pNodo, k key){  

			if (pNodo == null) 
			{
				return null;  
			}

			int rComparacion = key.compareTo(pNodo.key);   
			if (rComparacion == 0) 
			{
				return pNodo;   
			}
			if (rComparacion < 0) 
			{
				return floor(pNodo.nIzquierda, key);   
			}

			Nodo nTemporal = floor(pNodo.nDerecha, key);  
			if (nTemporal != null) 
			{
				return nTemporal;  
			}
			else  
			{
				return pNodo; 
			}

		}

		public k select(int posKey) {     

			return select(primerElemento, posKey).key; 

		} 

		private Nodo select(Nodo pNodo, int posKey) {  

			if (pNodo == null)
			{
				return null;    
			}

			int posTemporal = size(pNodo.nIzquierda);   
			if(posTemporal > posKey) 
			{
				return select(pNodo.nIzquierda,  posKey);  
			}
			else if (posTemporal < posKey) 
			{
				return select(pNodo.nDerecha, posKey-posTemporal-1);  
			}
			else 
			{
				return pNodo; 
			}

		} 

		public int rank(k key){  

			return rank(key, primerElemento); 

		}

		private int rank(k key, Nodo pNodo) {  

			if (pNodo == null) 
			{
				return 0;   
			}

			int cmp = key.compareTo(pNodo.key);   
			if (cmp < 0) 
			{
				return rank(key, pNodo.nIzquierda); 
			}
			else if (cmp > 0) 
			{
				return 1 + size(pNodo.nIzquierda) + rank(key, pNodo.nDerecha);  
			}
			else 
			{
				return size(pNodo.nIzquierda); 
			}

		}

		public void deleteMin(){    

			primerElemento = deleteMin(primerElemento); 

		} 

		private Nodo deleteMin(Nodo pNodo) {  

			if (pNodo.nIzquierda == null) 
			{
				return pNodo.nDerecha; 
			}

			pNodo.nIzquierda = deleteMin(pNodo.nIzquierda);  
			pNodo.numeroElementos = size(pNodo.nIzquierda) + size(pNodo.nDerecha) + 1; 
			return pNodo; 

		} 

		public void delete(k key) { 

			primerElemento = delete(primerElemento, key); 

		} 

		private Nodo delete(Nodo pNodo, k key){   

			if (pNodo == null) 
			{
				return null;   
			}

			int rComparacion = key.compareTo(pNodo.key);  
			if(rComparacion < 0) 
			{
				pNodo.nIzquierda  = delete(pNodo.nIzquierda,  key);  
			}
			else if (rComparacion > 0) 
			{
				pNodo.nDerecha = delete(pNodo.nDerecha, key); 
			}
			else    
			{   
				if (pNodo.nDerecha == null) 
				{
					return pNodo.nIzquierda;  
				}
				if (pNodo.nIzquierda == null)
				{
					return pNodo.nDerecha;     
				}
				Nodo nTemporal = pNodo;  
				pNodo = min(nTemporal.nDerecha); 
				pNodo.nDerecha = deleteMin(nTemporal.nDerecha);   
				pNodo.nIzquierda = nTemporal.nIzquierda;   
			} 

			pNodo.numeroElementos = size(pNodo.nIzquierda) + size(pNodo.nDerecha) + 1;
			return pNodo; 
		}

		public boolean contains(k key) {
			if (key == null) throw new IllegalArgumentException("argument to contains() is null");
			return get(key) != null;
		}

		public k max1() {

			return max(primerElemento).key;
		} 

		private Nodo max(Nodo x) {
			if (x.nDerecha == null)
			{
				return x; 
			}
			return max(x.nDerecha); 
		}

	}

