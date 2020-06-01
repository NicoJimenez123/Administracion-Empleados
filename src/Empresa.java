
import ayp3.tp.*;


public class Empresa implements IEmpresa{
    
    NodoTrabajador primero;
    NodoTrabajador ultimo;
    
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            }else{
                previo=este;
                este=este.getSiguiente();
            }
        }
    }

    @Override
    public void quitarDirectivo(ITrabajador trabajador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void quitarEmpleado(long dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void quitarDirectivo(long dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITrabajador obtenerTrabajador(long dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liquidarSueldos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double obtenerMontoTotalAPagar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITrabajador obtenerTrabajadorSalarioMinimo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITrabajador obtenerTrabajadorSalarioMaximo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double obtenerPromedioSalarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITrabajador obtenerTrabajadorMasAntiguo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITrabajador obtenerTrabajadorMasReciente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //METODOS ÚTILES, FUERA DE LOS PEDIDOS POR LA CONSIGNA
    public void mostrarNombres(){
        NodoTrabajador n = this.primero;

    	while(n != null){
    		System.out.println(n.persona.getNombre()+", ");
    		n=n.siguiente;
    	}
    }
    
    
    
}
