package lotos.excepciones;
@SuppressWarnings("serial")
public class BadSize extends Exception
{
  public BadSize ()
  {
  }
  public BadSize (String msj)
  {
    super(msj);
    System.out.println(msj);
  }
}