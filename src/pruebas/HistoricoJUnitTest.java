package pruebas;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import org.junit.Before;

import fechas.Fecha;
import lotos.Historico;
import lotos.Loto;
import lotos.Primitiva;
import lotos.Sorteo;

public class HistoricoJUnitTest {

	@Rule //Se establece un time out general para todos los tests. Se debe comentar esta línea y la de abajo para depurar
    public TestRule  globalTimeout = new DisableOnDebug(Timeout.millis(100)); // 100 milisegundos máximos por test
	
    private Historico hist1;
    private Historico hist2;

    private Fecha f1, f2, f3, f4, f6; 

    private Fecha fecha1, fecha2, fecha3, fecha4, fecha5;
    private Fecha fecha6, fecha7, fecha8, fecha9, fecha10;
    private Fecha fecha11, fecha12, fecha14, fecha15;
    private Fecha fecha20;
    private Fecha fecha21, fecha22, fecha23, fecha24, fecha25;
    private Fecha fecha26, fecha27, fecha28, fecha29, fecha30;
    
    private int[] n1 = {1,2,3,4,5,6};
    private int[] n2 = {1,3,5,7,9,11};
    private int[] n3 = {2,4,6,8,10,12};
    private int[] n4 = {13,14,15,16,17,18};
    private int[] n5 = {14,16,18,20,22,24};
    private int[] n6 = {13,15,17,19,21,23};
    private int[] n7 = {1,2,14,13,3,4};
    private int[] n8 = {3,5,6,14,16,15};
    private int[] n9 = {4,7,8,15,18,17};
    private int[] n10 = {3,13,23,12,22,32};

    private Loto p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
    private Loto p11, p12, p13, p14, p15, p16, p17, p18, p19, p20;

    private Loto lot1, lot2, lot3, lot5;
    private Loto lot6;

    private Sorteo sorte1, sorte2, sorte3, sorte4;

    private Sorteo sorteo1, sorteo2, sorteo3, sorteo4, sorteo5;
    private Sorteo sorteo6, sorteo7, sorteo8, sorteo9, sorteo10;
    private Sorteo sorteo11, sorteo12, sorteo13, sorteo14, sorteo15;
    private Sorteo sorteo16, sorteo17, sorteo18, sorteo19, sorteo20;

    private Primitiva primit1, primit2, primit3, primit5;
    private Primitiva primit6;
    

    private void resetearPrimitiva()
    {
        int[] n1 = {1, 3, 5, 7, 9, 11};
        int[] n2 = {1, 2, 4, 6, 8, 11};
        int[] n3 = {5, 11, 15, 22, 33, 35};
        int[] n4 = {11, 13, 15, 17, 19,21};
        int[] n5 = {20, 22, 24, 26, 28, 30};
        int[] n6 = {5, 11, 22, 33, 44, 1};
        int[] n7 = {31, 33, 35, 37, 39, 41};
        int[] n8 = {40, 42, 44, 46, 48, 1};
        int[] n9 = {9, 19, 29, 39, 49, 1};
        int[] n10 = {10, 20, 30, 40, 15, 25};
       
        primit1 = Primitiva.consPrimitiva(n1, 10, 0);
        primit2 = Primitiva.consPrimitiva(n2, 5, 1);
        primit3 = Primitiva.consPrimitiva(n3, 9, 2);
      
        Primitiva.consPrimitiva(n4, 10, 0);
        primit5 = Primitiva.consPrimitiva(n5, 10, 0);
        primit6 = Primitiva.consPrimitiva(n6, 5, 1);
        Primitiva.consPrimitiva(n7, 9, 2);
        Primitiva.consPrimitiva(n8, 9, 2);
        Primitiva.consPrimitiva(n9, 10, 0);
        Primitiva.consPrimitiva(n10, 5, 1);
       
    }


    private void resetearSorteo()
    {
        f1 = new Fecha(31, 1, 2016); 
        f2 = new Fecha(1, 2, 2016); 
        f3 = new Fecha(3, 4, 2016); 
        f4 = new Fecha(4, 7, 2016); 
        new Fecha(18, 9, 2016); 
        f6 = new Fecha(31, 12, 2016); 

        resetearPrimitiva();

        lot1 = primit1;
        lot2 = primit2;
        lot3 = primit3;
        lot5 = primit5;
        lot6 = primit6;
        new Sorteo(lot5, f3);
        new Sorteo(lot6, f4);
        new Sorteo(lot3, f3);

        sorte1 = new Sorteo(lot1, f1);
        sorte2 = new Sorteo(lot2, f2);
        sorte3 = new Sorteo(lot5, f3);
        sorte4 = new Sorteo(lot6, f4);

        fecha1  = new Fecha(1,2,2017);
        fecha2  = new Fecha(2,2,2017);
        fecha3  = new Fecha(3,2,2017);
        fecha4  = new Fecha(4,2,2017);
        fecha5  = new Fecha(5,2,2017);
        fecha6  = new Fecha(6,2,2017);
        fecha7  = new Fecha(7,2,2017);
        fecha8  = new Fecha(8,2,2017);
        fecha9  = new Fecha(9,2,2017);
        fecha10 = new Fecha(10,2,2017);
        fecha11 = new Fecha(11,2,2017);
        fecha12 = new Fecha(12,2,2017);
        new Fecha(13,2,2017);
        fecha14 = new Fecha(14,2,2017);
        fecha15 = new Fecha(15,2,2017);
        new Fecha(16,2,2017);
        new Fecha(17,2,2017);
        new Fecha(18,2,2017);
        new Fecha(19,2,2017);
        fecha20 = new Fecha(20,2,2017);
        fecha21 = new Fecha(21,2,2017);
        fecha22 = new Fecha(22,2,2017);
        fecha23 = new Fecha(23,2,2017);
        fecha24 = new Fecha(24,2,2017);
        fecha25 = new Fecha(25,2,2017);
        fecha26 = new Fecha(26,2,2017);
        fecha27 = new Fecha(27,2,2017);
        fecha28 = new Fecha(28,2,2017);
        fecha29 = new Fecha(1,3,2017);
        fecha30 = new Fecha(2,3,2017);
        new Fecha(3,3,2017);
        new Fecha(4,3,2017);
        new Fecha(5,3,2017);
        new Fecha(6,3,2017);
        new Fecha(7,3,2017);
        new Fecha(8,3,2017);
        new Fecha(9,3,2017);
        new Fecha(10,3,2017);
        new Fecha(11,3,2017);
        new Fecha(12,3,2017);

        p1 = Primitiva.consPrimitiva(n1,49,0);
        p2 = Primitiva.consPrimitiva(n2,48,1);
        p3 = Primitiva.consPrimitiva(n3,47,2);
        p4 = Primitiva.consPrimitiva(n4,46,3);
        p5 = Primitiva.consPrimitiva(n5,45,4);
        p6 = Primitiva.consPrimitiva(n6,44,3);
        p7 = Primitiva.consPrimitiva(n7,43,3);
        p8 = Primitiva.consPrimitiva(n8,42,2);
        p9 = Primitiva.consPrimitiva(n9,41,2);
        p10 = Primitiva.consPrimitiva(n10,40,2);
        p11 = Primitiva.consPrimitiva(n1,39,0);
        p12 = Primitiva.consPrimitiva(n2,38,1);
        p13 = Primitiva.consPrimitiva(n3,37,2);
        p14 = Primitiva.consPrimitiva(n4,36,3);
        p15 = Primitiva.consPrimitiva(n5,35,4);
        p16 = Primitiva.consPrimitiva(n6,34,5);
        p17 = Primitiva.consPrimitiva(n7,33,4);
        p18 = Primitiva.consPrimitiva(n8,32,7);
        p19 = Primitiva.consPrimitiva(n9,31,7);
        p20 = Primitiva.consPrimitiva(n10,30,4);

        sorteo1 = new Sorteo(p1,fecha1);
        sorteo2 = new Sorteo(p2,fecha2);
        sorteo3 = new Sorteo(p3,fecha3);
        sorteo4 = new Sorteo(p4,fecha4);
        sorteo5 = new Sorteo(p5,fecha5);
        sorteo6 = new Sorteo(p6,fecha6);
        sorteo7 = new Sorteo(p7,fecha7);
        sorteo8 = new Sorteo(p8,fecha8);
        sorteo9 = new Sorteo(p9,fecha9);
        sorteo10 = new Sorteo(p10,fecha10);
        sorteo11 = new Sorteo(p11,fecha21);
        sorteo12 = new Sorteo(p12,fecha22);
        sorteo13 = new Sorteo(p13,fecha23);
        sorteo14 = new Sorteo(p14,fecha24);
        sorteo15 = new Sorteo(p15,fecha25);
        sorteo16 = new Sorteo(p16,fecha26);
        sorteo17 = new Sorteo(p17,fecha27);
        sorteo18 = new Sorteo(p18,fecha28);
        sorteo19 = new Sorteo(p19,fecha29);
        sorteo20 = new Sorteo(p20,fecha30);
    }

    @Before
    public void resetear () 
    {
        resetearSorteo();

        hist1 = new Historico();
        hist1.add(0, sorte1);
        hist1.add(1, sorte2);
        hist1.add(2, sorte3);
        hist1.add(3, sorte4);

        hist2 = new Historico();

        hist2.add(0, sorteo1);
        hist2.add(1, sorteo2);
        hist2.add(2, sorteo3);
        hist2.add(3, sorteo4);
        hist2.add(4, sorteo5);
        hist2.add(5, sorteo6);
        hist2.add(6, sorteo7);
        hist2.add(7, sorteo8);
        hist2.add(8, sorteo9);
        hist2.add(9, sorteo10);
        hist2.add(10, sorteo11);
        hist2.add(11, sorteo12);
        hist2.add(12, sorteo13);
        hist2.add(13, sorteo14);
        hist2.add(14, sorteo15);
        hist2.add(15, sorteo16);
        hist2.add(16, sorteo17);
        hist2.add(17, sorteo18);
        hist2.add(18, sorteo19);
        hist2.add(19, sorteo20);
    }

    @Test
    public void prueba1frecuenciasReintegro ()
    {            
      assertArrayEquals(hist1.frecuenciasReintegro(f1,
                                           f6), 
                new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0});                          
    }
    
    @Test
    public void prueba2frecuenciasReintegro ()
    {
      
      assertArrayEquals(hist2.frecuenciasReintegro(fecha10,
                                           fecha20), 
                new int[]{0,0,1,0,0,0,0,0,0,0});
    }
    
    @Test
    public void prueba3frecuenciasReintegro ()
    {
      
      assertArrayEquals(hist2.frecuenciasReintegro(fecha1,
                                           fecha12), 
                new int[]{1,1,4,3,1,0,0,0,0,0});
    }
    
    @Test
    public void prueba4frecuenciasReintegro ()
    {
      
      assertArrayEquals(hist2.frecuenciasReintegro(fecha3,
                                           fecha7), 
                new int[]{0,0,1,3,1,0,0,0,0,0});
    }
    
    @Test
    public void prueba5frecuenciasReintegro ()
    {
      
      assertArrayEquals(hist2.frecuenciasReintegro(fecha7,
                                           fecha14), 
                new int[]{0, 0, 3, 1, 0, 0, 0, 0, 0, 0});
    }
    
    @Test
    public void prueba6frecuenciasReintegro ()
    {
      
      assertArrayEquals(hist2.frecuenciasReintegro(fecha15,
                                           fecha25), 
                new int[]{1, 1, 1, 1, 1, 0, 0, 0, 0, 0});
    }
    
    @Test
    public void prueba7frecuenciasReintegro ()
    {
      
      assertArrayEquals(hist2.frecuenciasReintegro(fecha10,
                                           fecha30), 
                new int[]{1, 1, 2, 1, 3, 1, 0, 2, 0, 0});
    }
    
    @Test
    public void prueba8frecuenciasReintegro ()
    {
      
      assertArrayEquals(hist2.frecuenciasReintegro(fecha11,
                                           fecha20), 
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

}
