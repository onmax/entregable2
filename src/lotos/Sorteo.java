package lotos;
import fechas.*;
/**
 * Implementación de un Sorteo<br>
 * {@code Sorteo = (Loto loto, Fecha fecha)<br>
 * @since 16/02/2017
 * @version 1.0
 * @author JMB & JGF
 */
public class Sorteo 
{ 
  private Loto loto;
  private Fecha fecha;
  
  public Sorteo (Loto loto, Fecha fecha)
  {
    this.loto = loto;
    this.fecha = fecha;
  }
  /*
   * POST: Da el loto del Sorteo.
   */
  public Loto getLoto ()
  {
    return loto;
  }
  /*
   * POST: Da la fecha del Sorteo.
   */
  public Fecha getFecha ()
  {
    return fecha;
  }
  /*
   * POST: Visualizador de Sorteo.
   */
  public String toString ()
  {
    return "(" + loto.toString() + ", " + fecha.toString() + ")";
  }
}