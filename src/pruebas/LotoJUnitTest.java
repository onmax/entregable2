package pruebas;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import lotos.Loto;
import lotos.excepciones.BadSize;
import lotos.excepciones.FueraDeRango;

public class LotoJUnitTest {
    
    @Rule //Se establece un time out general para todos los tests. Se debe comentar esta línea y la de abajo para depurar
    public TestRule  globalTimeout = new DisableOnDebug(Timeout.millis(100)); // 100 milisegundos máximos por test
    

    @Test
    public void prueba1ConsLoto() throws BadSize, FueraDeRango {
        int[] n1 = {1, 3, 5, 7, 9, 11};
        new Loto(6,n1,1,12);
    }
    
    @Test (expected=BadSize.class)
    public void prueba2ConsLoto () throws BadSize, FueraDeRango {     
      int[] n1 = {1, 3, 5, 7, 9, 11};
      new Loto(8,n1,1,12) ;
    }
    
    @Test (expected=FueraDeRango.class)
    public void prueba3ConsLoto () throws BadSize, FueraDeRango
    {
     
      int[] n2 = {1, 2, 4, 6};
      new Loto(4,n2,1,3) ;
    }
    
    @Test (expected=FueraDeRango.class)
    public void prueba4ConsLoto () throws BadSize, FueraDeRango
    {
      
      int[] n3 = {5, 11, 15, 22, 33, 35, 90};
      new Loto(7,n3,50,100) ;
    }
        
    @Test (expected=BadSize.class)
    public void prueba5ConsLoto () throws BadSize, FueraDeRango
    {
      
      int[] n3 = {5, 11, 15, 22, 33, 35, 90};
      new Loto(3,n3,50,100) ;
    }
    
    @Test
    public void prueba6ConsLoto () throws BadSize, FueraDeRango
    {
      
      int[] n2 = {1, 2, 4, 6};
      new Loto(4,n2,0,9) ;
    }
    
    @Test
    public void prueba7ConsLoto () throws BadSize, FueraDeRango
    {
      
      int[] n2 = {1, 2, 4, 6};
      new Loto(4,n2,1,6) ;
    }
    
    @Test
    public void prueba8ConsLoto () throws BadSize, FueraDeRango
    {
      
      int[] n2 = {9};
      new Loto(1,n2,0,9) ;
    }
    
    @Test
    public void prueba9ConsLoto () throws BadSize, FueraDeRango
    {
      
      int[] n2 = {};
      new Loto(0,n2,0,9) ;
    }
    
    @Test (expected=BadSize.class)
    public void prueba10ConsLoto () throws BadSize, FueraDeRango
    {
      
      int[] n2 = {1, 2, 4, 6};
      new Loto(3,n2,3,5) ;
    }
    

}
