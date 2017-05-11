package pruebas;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import lotos.Primitiva;

public class PrimitivaJUnitTest {

    @Rule //Se establece un time out general para todos los tests. Se debe comentar esta línea y la de abajo para depurar
    public TestRule  globalTimeout = new DisableOnDebug(Timeout.millis(100)); // 100 milisegundos máximos por test
        
    @Test
    public void prueba1consPrimitiva ()
    {
       int[] nums = {1, 3, 5, 7, 9, 11};
       assertEquals( 
        (Primitiva.consPrimitiva(nums, 10, 0)+""),("([1,3,5,7,9,11], 10, 0)"));
    }
    
    @Test
    public void prueba2consPrimitiva ()
    {
      int[] nums = {1, 2, 4, 6, 8, 11};
      assertEquals( 
        (Primitiva.consPrimitiva(nums, 5, 1)+""),
          ("([1,2,4,6,8,11], 5, 1)"));
    }
    
    @Test
    public void prueba3consPrimitiva ()
    {
      int[] nums = {1, 3, 5, 7, 9, 11};
      assertTrue( Primitiva.consPrimitiva(nums, 100, 0)==null);
    }
    
    @Test
    public void prueba4consPrimitiva ()
    {
      int[] nums = {1, 3, 5, 7, 9, 11};
      assertTrue( Primitiva.consPrimitiva(nums, 5, 100)==null);
    }
    
    @Test
    public void prueba5consPrimitiva ()
    {
      int[] nums = {11, 12, 13, 14, 15, 16, 17};  // Uno de mas
      assertTrue( Primitiva.consPrimitiva(nums,5,5) == null);
    }
    
    @Test
    public void prueba6consPrimitiva ()
    {
      int[] nums = {11, 12, 13, 14};  // Dos de menos
      assertTrue( Primitiva.consPrimitiva(nums,5,5) == null);
    }
    
    @Test
    public void prueba7consPrimitiva ()
    {
      int[] nums = {};  // Ninguno
      assertTrue( Primitiva.consPrimitiva(nums,5,5) == null);
    }
    
    @Test
    public void prueba8consPrimitiva ()
    {
      int[] nums = {44, 45, 46, 47, 48, 49};
      assertEquals( 
        (Primitiva.consPrimitiva(nums, 49, 9)+""),
          ("([44,45,46,47,48,49], 49, 9)"));
    }
    
    @Test
    public void prueba9consPrimitiva ()
    {
      int[] nums = {44, 45, 46, 47, 48, 49};
      assertEquals( 
        (Primitiva.consPrimitiva(nums, 49, 9)+""),
          ("([44,45,46,47,48,49], 49, 9)"));
    }
    
    @Test
    public void prueba10consPrimitiva ()
    {
      int[] nums = {44,45,46,47,48,49,50};         // Uno de mas
      assertTrue( Primitiva.consPrimitiva(nums,100,100) == null);  // Mal max y mal min
    }

}
