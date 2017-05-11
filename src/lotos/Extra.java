package lotos;

import lotos.excepciones.FueraDeRango;

/**
 * Implementacion de un Extra: un numero entero y su rango permitido
 * Extra = (Entero numero, min, max)
 * INV(Extra) = numero IN [min,max]
 * @since  3/5/2016
 * @version 1.0
 * @author JMB & JGF
 */
public class Extra
{
  private int numero;
  private int min; 
  private int max;
  /*
   * PRE: min<=numero<=max
   */
  public Extra (int numero, int min, int max)
    throws FueraDeRango
  {
    if (numero < min || numero > max) 
      throw new FueraDeRango("Numero de Extra fuera de rango["+min+","+max+"]");
    else
    {
      this.numero = numero;
      this.min = min;
      this.max = max;
    }
  }
  /*
   * POST: resultado es el numero del Extra.
   */
  public int getNumero ()
  {
    return numero;
  }
  /*
   * POST: resultado es la cadena de caracteres formada por los
   *       atributos del objeto
   */
  public String toString ()
  {
    return "(" + numero + " , " + min + " , " + max + ")";
  }
  /*
   * POST: Determina si el Extra es igual a "num".
   */
  public boolean esIgual (Extra num)
  {
    return numero == num.numero && min == num.min && max == num.max;
  } 
  
}

