import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.TimeZone;

public class Fecha{
    int dia;
    int mes;
    int anio;
    public Fecha(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        if(!comprobar_fecha()){
            this.dia = 0;
            this.mes = 0;
            this.anio = 0;
        }
    }
    public boolean comprobar_fecha(){
        if(this.dia > 0 && this.dia < 31){
            switch(this.mes){
                // Mes de 28 días (en general)
                case 2: if(this.dia > 28){ return false; } 
                        break;
                // Meses de 30 dias
                case 4: if(this.dia > 30){ return false; }
                case 6:
                case 9:
                case 11: break;
                // Meses de 31 dias, aunque creo que no es necesario hacer algo
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: break;
                default: return false;
            }
            return true;
        }
        return false;
    }
    public void imprimir(){
        System.out.println(this.dia+","+this.mes+","+this.anio);
    }
    @Override
    public String toString() {
    	String s = this.dia+","+this.mes+","+this.anio;
    	return s;
    }
    public static boolean comparar_fechas(Fecha f1, Fecha f2){
        if((f1.dia == f2.dia) && (f1.mes == f2.mes) && (f1.anio == f2.anio)){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Fecha f = new Fecha(30,4,2000);
        f.imprimir();
    }
    
    public int calcularMeses() {
    	  Calendar today = Calendar.getInstance();
    	  Calendar fIngreso= Calendar.getInstance();
    	  fIngreso.set(anio, mes-1, dia);
          int difanio = today.get(Calendar.YEAR) -  fIngreso.get(Calendar.YEAR);
          int difmeses = (difanio*12)+today.get(Calendar.MONTH) - fIngreso.get(Calendar.MONTH);
          int difdia = today.get(Calendar.DAY_OF_MONTH) - fIngreso.get(Calendar.DAY_OF_MONTH);

          
         
          return difmeses;
    }
	
    
}
