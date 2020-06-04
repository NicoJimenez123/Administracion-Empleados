
import java.util.ArrayList;
import java.util.Arrays;

import ayp3.tp.*;

public class Empresa implements IEmpresa{
    
    NodoTrabajador primero;
    NodoTrabajador ultimo;
    NodoTrabajador primerDirectivo;
    NodoTrabajador ultimoDirectivo;
    
    
    public Empresa() {
            this.primero = null;
    }
    
    
    @Override
    public void agregarEmpleado(ITrabajador trabajador) {
            // Primero creo un nodo con el trabajador a insertar
            NodoTrabajador nuevoTrabajador = new NodoTrabajador(trabajador);
            // Me fijo si hay algun trabajador en la lista
            if(this.primero == null) {
                    // Si no lo hay, tomo al nuevo trabajador y lo seteo como primero y ultimo en la lista
                    this.primero = nuevoTrabajador;
                    this.ultimo = nuevoTrabajador;
            }
            else {
                    // Enlazo al nuevo trabajador con el ultimo en la lista
                    this.ultimo.setSiguiente(nuevoTrabajador);
                    // Tambien enlazo al ultimo de la lista con el nuevo
                    nuevoTrabajador.setAnterior(this.ultimo);
                    // Ahora el nuevo pasa a ser el ultimo
                    this.ultimo = nuevoTrabajador;
            }
    }
    
    @Override
    public void agregarDirectivo(ITrabajador trabajador) {
        // Primero creo un nodo con el trabajador a insertar
            NodoTrabajador nuevoTrabajador = new NodoTrabajador(trabajador);
            // Me fijo si hay algun trabajador en la lista
            if(this.primerDirectivo == null) {
                    // Si no lo hay, tomo al nuevo trabajador y lo seteo como primero y ultimo en la lista
                    this.primerDirectivo = nuevoTrabajador;
                    this.ultimoDirectivo = nuevoTrabajador;
            }
            else {
                    // Enlazo al nuevo trabajador con el ultimo en la lista
                    this.ultimoDirectivo.setSiguiente(nuevoTrabajador);
                    // Tambien enlazo al ultimo de la lista con el nuevo
                    nuevoTrabajador.setAnterior(this.ultimoDirectivo);
                    // Ahora el nuevo pasa a ser el ultimo
                    this.ultimoDirectivo = nuevoTrabajador;
            }
    }

    public void quitarTrabajador(long dni) {
    	// Creo este metodo para no tener que llamar a varios metodos desde el main
    	// Desde el main tengo que controlar que el DNI sea valido
    	ITrabajador trabajador = this.obtenerTrabajador(dni);
    	TipoCargo cargo = trabajador.getCargo();
    	if(cargo == TipoCargo.DIRECTOR_DEPARTAMENTO || cargo == TipoCargo.DIRECTOR_GENERAL) {
    		this.quitarDirectivo(trabajador);
    	}
    	else { // Si llega hasta aca es porque el cargo del trabajador es uno de los otros 3
    		this.quitarEmpleado(trabajador);    		
    	}
    }
    
    @Override
    public void quitarEmpleado(ITrabajador trabajador) {
        
        
        //verifico si la lista-empresa esta vacía
        if(this.primero==null){/*tirar exepcion*/}
        
        //creo los nodos que me serviran en la iteración
        NodoTrabajador este= this.primero;  
    	NodoTrabajador previo= null;  

    	while(este!=null){
            if(este.persona.equals(trabajador)){  //si el nodo "tocado" contiene al trabajador buscado
                if(previo==null){   
                    this.primero = this.primero.getSiguiente();    
                    este.setSiguiente(null);    
                    este=this.primero;  
                }else{
                    previo.setSiguiente(este.getSiguiente());
                    este.setSiguiente(null);
                    este= previo.getSiguiente();
                }                
            }else{  //reacomodo los nodos para continuar con la iteración
                previo=este;
                este=este.getSiguiente();
            }
        }
    }

    @Override
    public void quitarDirectivo(ITrabajador trabajador) {
                
        //verifico si la lista-empresa esta vacía
        if(this.primerDirectivo==null){/*tirar exepcion*/}
        
        //creo los nodos que me serviran en la iteración
        NodoTrabajador este= this.primero;  
    	NodoTrabajador previo= null;  

    	while(este!=null){
            if(este.persona.equals(trabajador)){  //si el nodo "tocado" contiene al trabajador buscado
                if(previo==null){   
                    this.primero = this.primerDirectivo.getSiguiente();    
                    este.setSiguiente(null);    
                    este=this.primerDirectivo;  
                }else{
                    previo.setSiguiente(este.getSiguiente());
                    este.setSiguiente(null);
                    este= previo.getSiguiente();
                }                
            }else{  //reacomodo los nodos para continuar con la iteración
                previo=este;
                este=este.getSiguiente();
            }
        }
    }

    @Override
    public void quitarEmpleado(long dni) {
        
        
        //verifico si la lista-empresa esta vacía
        if(this.primero==null){/*tirar exepcion*/}
        
        //creo los nodos que me serviran en la iteración
        NodoTrabajador este= this.primero;  
    	NodoTrabajador previo= null;  

    	while(este!=null){
            if(este.persona.getDni()==(dni)){  //si el nodo "tocado" contiene al dni buscado
                if(previo==null){   
                    this.primero = this.primero.getSiguiente();    
                    este.setSiguiente(null);    
                    este=this.primero;  
                }else{
                    previo.setSiguiente(este.getSiguiente());
                    este.setSiguiente(null);
                    este= previo.getSiguiente();
                }                
            }else{
                previo=este;
                este=este.getSiguiente();
            }
        }
    }

    @Override
    public void quitarDirectivo(long dni) {
        //verifico si la lista-empresa esta vacía
        if(this.primerDirectivo==null){/*tirar exepcion*/}
        
        //creo los nodos que me serviran en la iteración
        NodoTrabajador este= this.primerDirectivo;  
    	NodoTrabajador previo= null;  

    	while(este!=null){
            if(este.persona.getDni()==(dni)){  //si el nodo "tocado" contiene al dni buscado
                if(previo==null){   
                    this.primerDirectivo = this.primerDirectivo.getSiguiente();    
                    este.setSiguiente(null);    
                    este=this.primerDirectivo;  
                    previo.setSiguiente(este.getSiguiente());
                    este.setSiguiente(null);
                    este= previo.getSiguiente();
                }                
            }else{
                previo=este;
                este=este.getSiguiente();
            }
        }
    }

    @Override
    public ITrabajador obtenerTrabajador(long dni) {
    	// Correccion al declarar esta variable
        ITrabajador trabajador = null;
        
        //recorro la pila hasta obtener el trabajador con el DNI buscado
        NodoTrabajador n = this.primero;
        while(n!=null){
            if(n.persona.getDni()==dni){                
                trabajador=n.persona;                
            }            
            n=n.siguiente;
        }
        return trabajador;
    }

    @Override
    public void liquidarSueldos() {
        //recorro la lista-empresa y seteo el atributo sueldo de cada trabajador 
        
        NodoTrabajador n = this.primero;
        while(n!=null){
            n.persona.setSalario(n.persona.getSalario() + n.persona.getMontoACobrar());
            
            n=n.siguiente;
        }                
    }

    @Override
    public double obtenerMontoTotalAPagar() {
        //recorro la lista-empresa y sumo los montos a pagar
        double contador=0;
        
        ITrabajador trabajador = new Trabajador();        
      
        NodoTrabajador n = this.primero;
        while(n!=null){
            contador += n.persona.getMontoACobrar();
            
            n=n.siguiente;
        }  
        
        return contador;
    }

    @Override
    public ITrabajador obtenerTrabajadorSalarioMinimo() {
        
        //recorro la lista-empresa chequeo cada salario
        double minimo=100000;   //uso el maximo valor de salario que se puede ganar, como referencia
        ITrabajador trabajadorMinimo = new Trabajador(); //guarda al trabajador con salario minimo
        
        ITrabajador trabajador = new Trabajador();   //para la iteración      
      
        NodoTrabajador n = this.primero;
        while(n!=null){
            if(n.persona.getSalario() < minimo){
                minimo = n.persona.getSalario();
                trabajadorMinimo = n.persona;                
            }
            
            n=n.siguiente;
        }  
        
        return trabajadorMinimo;
    }

    @Override
    public ITrabajador obtenerTrabajadorSalarioMaximo() {
        //recorro la lista-empresa chequeo cada salario
        double maximo=0;   
        ITrabajador trabajadorMaximo = new Trabajador(); //guarda al trabajador con salario máximo
        
        ITrabajador trabajador = new Trabajador();   //para la iteración      
      
        NodoTrabajador n = this.primero;
        while(n!=null){
            if(n.persona.getSalario() >= maximo){
                maximo = n.persona.getSalario();
                trabajadorMaximo = n.persona;                
            }
            n=n.siguiente;
        }  
        
        return trabajadorMaximo;
    }

    @Override
    public double obtenerPromedioSalarios() {
        //recorro la lista-empresa chequeo cada salario
        double sumatoria=0;   
        ITrabajador trabajador = new Trabajador();   //para la iteración      
      
        NodoTrabajador n = this.primero;
        while(n!=null){
            sumatoria += n.persona.getSalario();
            n=n.siguiente;
        }  
        
        return sumatoria / this.longitud();
    }

    @Override
    public ITrabajador obtenerTrabajadorMasAntiguo() {
        //recorro la lista-empresa chequeo cada antiguedad
        double maximo=0;   
        ITrabajador trabajadorMaximo = new Trabajador(); //guarda al trabajador con mayor antiguedad
        
        ITrabajador trabajador = new Trabajador();   //para la iteración      
      
        NodoTrabajador n = this.primero;
        while(n!=null){
            if(n.persona.getMesesAntiguedad() >= maximo){
                maximo = n.persona.getMesesAntiguedad();
                trabajadorMaximo = n.persona;                
            }
            n=n.siguiente;
        }  
        
        return trabajadorMaximo;
    }

    @Override
    public ITrabajador obtenerTrabajadorMasReciente() {
        //recorro la lista-empresa chequeo cada antiguedad
        double maximo=1000000;   
        ITrabajador trabajadorMinimo = new Trabajador(); //guarda al trabajador con menor antiguedad
        
        ITrabajador trabajador = new Trabajador();   //para la iteración      
      
        NodoTrabajador n = this.primero;
        while(n!=null){
            if(n.persona.getMesesAntiguedad() <= maximo){
                maximo = n.persona.getMesesAntiguedad();
                trabajadorMinimo = n.persona;                
            }
            n=n.siguiente;
        }  
        
        return trabajadorMinimo;
    }
    
    //METODOS ÚTILES, FUERA DE LOS PEDIDOS POR LA CONSIGNA
    public void mostrarNombres(){ //muestra los nombres de los trabjadores dentro de la lista
        NodoTrabajador n = this.primero;

    	while(n != null){
    		System.out.println(n.persona.getNombre()+", ");
    		n=n.siguiente;
    	}
    }
    
    public int longitud(){  //calcula la cantidad de nodos de la lista
        int contador=0;
        NodoTrabajador n = this.primero;

    	while(n != null){
    		contador++;
                n=n.siguiente;
    	}        
        
        return contador;
    }
    
    public ArrayList<ITrabajador> obtenerListaTrabajadores() {
    	ArrayList<ITrabajador> listaTrabajador = new ArrayList<ITrabajador>();
    	// Recorro primero los directivos
    	NodoTrabajador d = this.primerDirectivo;
    	while(d != null) {
    		listaTrabajador.add(d.getPersona());
    		d = d.getSiguiente();
    	}
    	// Ahora los empleados
    	NodoTrabajador e = this.primero;
    	while(e != null) {
    		listaTrabajador.add(e.getPersona());
    		e = e.getSiguiente();
    	}
    	return listaTrabajador;
    }
    
}





