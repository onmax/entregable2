package lotos;

import fechas.*;
import list.ArrayList;
/**
 * Implementación de un Histórico de Sorteo(s)<br>
 * {@code Historico = Lista(Sorteo)<br>
 * @since 17/02/2017
 * @version 1.1.1         22/03/2017  JGF
 * @author JMB & JGF
 */
public class Historico 
{ 
  private ArrayList<Sorteo> sorteos;
  
  public Historico ()
  {
    this.sorteos = new ArrayList<lotos.Sorteo>();  
  }
  public Sorteo get (int index) 
  {
    return sorteos.get(index);
  }
  public int size () 
  {
    return sorteos.size(); 
  }
  public void add (int index, Sorteo sorteo)
  {
    sorteos.add(index, sorteo);
  }
  /*
   * POST: Visualizador del Historico.
   */
  public String toString ()
  {
    return sorteos.toString();
  }
  /**
   * POST: Determina si fecha está en el intervalo 
   *       [fecha1, fecha2].
   */         
  private static boolean estaEnIntervalo (Fecha fecha, 
                                   Fecha fecha1, 
                                   Fecha fecha2) { 
    return fecha1.esMenorOIgual(fecha) && 
           fecha.esMenorOIgual(fecha2);
  }  
  /**
   * PRE: fecha1<=fecha2
   * POST: Calcula las frecuencias de los reintegros en un intervalo
   *       de fechas [fecha1, fecha2] en sorteos de la primitiva.
   */
  public int[] frecuenciasReintegro (Fecha fecha1, Fecha fecha2)
  {
    //TODO
	
	
    return null;
  }

}