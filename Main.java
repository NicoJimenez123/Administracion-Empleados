
package trabajadores;

public class Main {
    public static void main(String[] args) {
        
        //creo una Empresa, por ende, una lista
        Empresa empresa=new Empresa();
        
        //creo tres tabajadores
        Trabajador trabajador1=new Trabajador("Juan");
        Trabajador trabajador2=new Trabajador("Pepe");
        Trabajador trabajador3=new Trabajador("Tito");
        
        //los sumo a la empresa-lista
        empresa.agregarEmpleado(trabajador1);
        empresa.agregarEmpleado(trabajador2);
        empresa.agregarEmpleado(trabajador3);
        
        //muestro la empresa-lista
        empresa.mostrarNombres();

        //borro a Juan
        System.out.println("Borro a Juan");
        empresa.quitarEmpleado(trabajador1);
        empresa.mostrarNombres();
        
        //agrego a Pepo
        System.out.println("Agrego a Pepo");
        Trabajador trabajador4=new Trabajador("Pepo");
        empresa.agregarEmpleado(trabajador4);
        empresa.mostrarNombres();

        
        
        
    }
}
