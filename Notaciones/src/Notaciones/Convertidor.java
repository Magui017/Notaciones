package Notaciones;

public class Convertidor {

	public static String convertirApostfija(String infija){
		String postfija= "";
		PilaE pila= new PilaE(30);
		 
		for (int i=0; i<infija.length(); i++){
			char letra= infija.charAt(i); //lee caracter por caracter
			if (esOperador(letra)){ //si es un operador
				if (letra== ')'){
					while(pila.getTope()!= '(') //mientras no sea ( 
						postfija += pila.pop();// retira elementos de la pila y lo guarda en el string postfija
		                if(pila.getTope()== '(')
		                pila.pop();//retira elemento de la pila y no se guarda
		        }		 
		        if (pila.vacia()){       // si la pila esta vacia
		        	if (letra!= ')')
		        		pila.push(letra);// se guarda en la pila
		        } else{
		        	if (letra!= ')'){                //si la pila no esta vacia  
		        		int pe= prioridadExp(letra);//comprueba prioridad del nuevo operador 
		                int pp= prioridadPila((char)pila.getTope()); //comprobar prioridad del operador en la pila
		                if (pe > pp){ 
		                	pila.push(letra); //se guarda el operador en la pila
		                } else {                     //si pp es mayor que pe
		                	postfija += pila.pop();  // se retira el pp de la pila y se guarda en el string posfija
		                    pila.push(letra);        //se guarda pe en la pila
		                }
		            }		 
		        }		 
		   }else  //si no es un operador se guarda en postfija
			   postfija += letra;		 
		}
				 
		while (!pila.vacia()){  //mientras la pila no este vacia
			postfija += pila.pop(); // sacar operadores de la pila y guardarlos en postfija
		}
		return postfija;
		}
		 
		public static String convertirAprefija(String infija){
			String prefija= "";
		    String invertida="";
		    PilaE pila= new PilaE(30);
		    for (int i = infija.length()-1; i > -1; i--){ //comienza del ultimo caracter de la expresion infija
		    	char letra= infija.charAt(i);             //lee caracter por caracter 
		    	if (esOperador(letra)){                   // si es un operador
		    		if (letra== '('){
		    			while(pila.getTope()!= ')')       //mientras no sea )
		    				prefija += pila.pop();       // retira elementos de la pila y lo guarda en el string prefija
		                if(pila.getTope()== ')')
		                pila.pop();
		            }		 
		            if (pila.vacia()){
		            	if (letra!= '(')
		            		pila.push(letra);
		            } else{
		            	if (letra!= '('){
		            		int pe= prioridadExp(letra);
		                    int pp= prioridadPila((char)pila.getTope());
		                    if (pe > pp){
		                    	pila.push(letra);
		                    } else {
		                    	prefija += pila.pop();
		                        pila.push(letra);
		                    }
		                }		 
		           }		 
		      }else
		    	  prefija += letra;		 
		    }
		    while (!pila.vacia()){
		    	prefija += pila.pop();
		    }
		    for (int r=prefija.length()-1; r>=0;r--) //al final se invierte el string prejija 
		    	invertida += prefija.charAt(r);
		    return invertida;
		}
		 
		public static int prioridadExp(char x){ //comprobar prioridad de la expresion
			if (x == '^') return 4;
		    if (x == '*' || x == '/') return 2;
		    if (x == '+' || x == '-') return 1;
		    if (x == '(') return 5;
		    if (x== ')') return 5;
		    return 0;
		}
		 
		public static int prioridadPila(char x){ //comprobar la prioridad de la pila
			if (x == '^') return 3;
		    if (x == '*' || x == '/') return 2;
		    if (x == '+' || x == '-') return 1;
		    if (x == '(') return 0;
		    if (x== ')') return 0;
		    return 0;
		}
		 
		
		public static boolean esOperador(char letra){ //comprobar si es un operador
			if (letra == '*' || letra == '/' || letra == '+' || letra == '-' || letra == '^' || letra == '(' || letra == ')'){
				return true;
		    }else
		    	return false;
		    }
		}
