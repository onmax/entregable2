package lotos.excepciones;
@SuppressWarnings("serial")
public class FueraDeRango extends Exception
{
  public FueraDeRango ()
  {
  }
  public FueraDeRango (String msj)
  {
    super(msj);
    System.out.println(msj);
  }
}