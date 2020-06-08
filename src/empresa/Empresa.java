package empresa;
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
    
    public void agregarTrabajador(ITrabajador trabajador) {
    	// Creo este metodo para no tener que llamar a varios metodos desde el main
    	// Desde el main tengo que controlar que el DNI sea valido
    	TipoCargo cargo = trabajador.getCargo();
    	if(cargo == TipoCargo.DIRECTOR_DEPARTAMENTO || cargo == TipoCargo.DIRECTOR_GENERAL) {
    		this.agregarDirectivo(trabajador);
    	}
    	else { // Si llega hasta aca es porque el cargo del trabajador es uno de los otros 3
    		this.agregarEmpleado(trabajador);    		
    	}
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
        NodoTrabajador n = this.primerDirectivo;
//      Tambien hay que recorrer los directivos
        while(n!=null){
            if(n.getPersona().getDni()==dni){                
                trabajador=n.getPersona();                
            }            
            n=n.siguiente;
        }
//      ahora recorro los empleados
        n = this.primero;
        while(n!=null){
            if(n.getPersona().getDni()==dni){                
                trabajador=n.getPersona();                
            }            
            n=n.siguiente;
        }
        return trabajador;
    }

    @Override
    public void liquidarSueldos() {
        //recorro la lista-empresa y seteo el atributo sueldo de cada trabajador 
        
        //pago a empleados
        NodoTrabajador n = this.primero;
        while(n!=null){
            n.persona.setMontoACobrar(0);
            
            n=n.siguiente;
        }    
        
        //pago a directivos
        n=this.primerDirectivo;
        while(n!=null){
            n.persona.setMontoACobrar(0);
            
            n=n.siguiente;
        }                
    }

    @Override
    public double obtenerMontoTotalAPagar() {
        //recorro la lista-empresa y sumo los montos a pagar
        double contador=0;
        
//        ITrabajador trabajador = new Trabajador();        
//       Primero recorro a los directivos
        NodoTrabajador n = this.primerDirectivo;
        while(n!=null){
            contador += n.persona.getMontoACobrar();
            
            n=n.siguiente;
        }  
//        Ahora a los empleados
        n = this.primero;
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
        ITrabajador trabajadorMinimo = null; //guarda al trabajador con salario minimo
        
        ITrabajador trabajador = null;   //para la iteracion      
      
        NodoTrabajador n = this.primero;
        while(n!=null){
            if(n.persona.getSalario() < minimo){
                minimo = n.persona.getSalario();
                trabajadorMinimo = n.persona;                
            }
            
            n=n.siguiente;
        }  

        n = this.primerDirectivo;
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
        ITrabajador trabajadorMaximo = null; //guarda al trabajador con salario máximo
        
        ITrabajador trabajador = null;   //para la iteración      
      
        NodoTrabajador n = this.primero;
        while(n!=null){
            if(n.persona.getSalario() >= maximo){
                maximo = n.persona.getSalario();
                trabajadorMaximo = n.persona;                
            }
            n=n.siguiente;
        }  

        n = this.primerDirectivo;
        while(n!=null){
            if(n.persona.getSalario() >= maximo){
                maximo = n.persona.getSalario();
                trabajadorMaximo = n.persona;                
            }
            n=n.siguiente;
        }  
        
        return trabajadorMaximo;
    }
    
    public double obtenerSalarioMinimo() {
    	return this.obtenerTrabajadorSalarioMinimo().getSalario();
    }
    
    public double obtenerSalarioMaximo() {
    	return this.obtenerTrabajadorSalarioMaximo().getSalario();
    }

    @Override
    public double obtenerPromedioSalarios() {
        //recorro la lista-empresa chequeo cada salario
        double sumatoria=0;   
        ITrabajador trabajador = null;   //para la iteración      
        
        NodoTrabajador n = this.primero;
        while(n!=null){
            sumatoria += n.persona.getSalario();
            n=n.siguiente;
        }  

        n = this.primerDirectivo;
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
        ITrabajador trabajadorMaximo = null; //guarda al trabajador con mayor antiguedad
        
        ITrabajador trabajador = null;   //para la iteración      
      
        NodoTrabajador n = this.primero;
        while(n!=null){
            if(n.persona.getMesesAntiguedad() >= maximo){
                maximo = n.persona.getMesesAntiguedad();
                trabajadorMaximo = n.persona;                
            }
            n=n.siguiente;
        }  
        
        n = this.primerDirectivo;
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
        ITrabajador trabajadorMinimo = null; //guarda al trabajador con menor antiguedad
        
        ITrabajador trabajador = null;   //para la iteración      
      
        NodoTrabajador n = this.primero;
        while(n!=null){
            if(n.persona.getMesesAntiguedad() <= maximo){
                maximo = n.persona.getMesesAntiguedad();
                trabajadorMinimo = n.persona;                
            }
            n=n.siguiente;
        }  

        n = this.primerDirectivo;
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

        n = this.primerDirectivo;

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

        n = this.primerDirectivo;

        while(n != null){
            contador++;
                n=n.siguiente;
        }        
        
        return contador;
    }
    
    public void listarTrabajadores() {
    	// Recorro primero los directivos
    	NodoTrabajador d = this.primerDirectivo;
    	while(d != null) {
    		System.out.println(d.getPersona().toString());
    		System.out.println();
    		d = d.getSiguiente();
    	}
    	// Ahora los empleados
    	NodoTrabajador e = this.primero;
    	while(e != null) {
    		System.out.println(e.getPersona().toString());
    		System.out.println();
    		e = e.getSiguiente();
    	}
    }
    public void listarNombresYDni() {
    	// Recorro primero los directivos
    	NodoTrabajador d = this.primerDirectivo;
    	while(d != null) {
    		System.out.println(d.getPersona().getNombre()+" "+d.getPersona().getApellido()+" "+d.getPersona().getDni());
    		System.out.println();
    		d = d.getSiguiente();
    	}
    	// Ahora los empleados
    	NodoTrabajador e = this.primero;
    	while(e != null) {
    		System.out.println(e.getPersona().getNombre()+" "+e.getPersona().getApellido()+" "+e.getPersona().getDni());
    		System.out.println();
    		e = e.getSiguiente();
    	}
    }
    
    public void listaPorTipoCargo() {
    	ArrayList<ITrabajador> directorGeneral = new ArrayList<ITrabajador>();
    	ArrayList<ITrabajador> directorDepartamento = new ArrayList<ITrabajador>();
    	ArrayList<ITrabajador> jefes = new ArrayList<ITrabajador>();
    	ArrayList<ITrabajador> supervisor = new ArrayList<ITrabajador>();
    	ArrayList<ITrabajador> operario = new ArrayList<ITrabajador>();
    	ArrayList<ITrabajador> listaTrabajadores = new ArrayList<ITrabajador>();
    	// Primero recorro los directores
    	NodoTrabajador d = this.primerDirectivo;
    	boolean empleadosRecorridos = false;
    	while(d != null) {
    		TipoCargo cargoTrabajador = d.getPersona().getCargo();
    		if(cargoTrabajador == TipoCargo.DIRECTOR_DEPARTAMENTO) {
    			directorDepartamento.add(d.getPersona());
    		}
    		if(cargoTrabajador == TipoCargo.DIRECTOR_GENERAL) {
    			directorGeneral.add(d.getPersona());
    		}
    		if(cargoTrabajador == TipoCargo.JEFES) {
    			jefes.add(d.getPersona());
    		}
    		if(cargoTrabajador == TipoCargo.SUPERVISOR) {
    			supervisor.add(d.getPersona());
    		}
    		if(cargoTrabajador == TipoCargo.OPERARIO) {
    			operario.add(d.getPersona());
    		}
    		if(d.getSiguiente() == null) {
    			if(empleadosRecorridos) {
    				break;
    			}
    			d = this.primero;
    			empleadosRecorridos = true;
    		}
    		else {
    			d = d.getSiguiente();
    		}    		
    	}
    	listaTrabajadores.addAll(directorGeneral);
    	listaTrabajadores.addAll(directorDepartamento);
    	listaTrabajadores.addAll(jefes);
    	listaTrabajadores.addAll(supervisor);
    	listaTrabajadores.addAll(operario);
    	for(ITrabajador t : listaTrabajadores) {
    		System.out.println(t);
    		System.out.println();
    	}
    }
    public void definirMontoACobrarDeTodos(){
        NodoTrabajador n = this.primero;
        while(n!=null){
            n.persona.setMontoACobrar(n.persona.getSalario() + n.persona.getPremio());
            /*test*/ System.out.println("Monto a cobrar de "+n.persona.getNombre()+": "+(n.persona.getSalario() + n.persona.getPremio()));

            n=n.siguiente;
        }  

    }
    public void generarNomina(long dni) {
    	ITrabajador t = this.obtenerTrabajador(dni);
    	System.out.println("DNI: "+t.getDni());
    	System.out.println("Nombre: "+t.getNombre());
    	System.out.println("Apellido: "+t.getApellido());
    	System.out.println("Cargo: "+t.getCargo());
    	System.out.println("Antig�edad: "+t.getMesesAntiguedad()+" meses");
    	System.out.println("Periodo de Pago: "+"<Insertar Fecha>");
    	System.out.println("Conceptos de Pago:");
    	System.out.println("\tSalario por Cargo:\t"+t.getSalario());
    	System.out.println("\tPremios:\t\t"+t.getPremio());
    	System.out.println("\tSalario a Percibir:\t"+t.getMontoACobrar());
    }
}



