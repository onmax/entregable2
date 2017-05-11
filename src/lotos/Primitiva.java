package lotos;

import lotos.excepciones.BadSize;
import lotos.excepciones.FueraDeRango;

/**
 * Implementación de una Primitiva<br>
 * {@code Primitiva = (Extra complementario, reintegro}<br>
 * 
 * @since 3/5/2016
 * @version 1.0
 * @author JMB & JGF
 */
public class Primitiva extends Loto {
	private Extra complementario, reintegro;

	/*
	 * PRE: numeros.length == 6 && 1 <= complementario <= 49 && 0<= reintegro <=
	 * 9
	 */
	public Primitiva(int[] numeros, int complementario, int reintegro) throws BadSize, FueraDeRango {
		super(6, numeros, 1, 49);
		this.complementario = new Extra(complementario, 1, 49);
		this.reintegro = new Extra(reintegro, 0, 9);
	}

	/*
	 * PRE: numeros.length == 6 && 1 <= complementario <= 49 && 0<= reintegro <=
	 * 9 POST: Manejador del constructor de la Primitiva (si se cumple la PRE se
	 * retorna una instancia de primitiva, si no se cumple se retorna null)
	 */
	public static Primitiva consPrimitiva(int[] numeros, int comple, int reinte) {
		Primitiva primitiva = null;
		try {
			primitiva = new Primitiva(numeros, comple, reinte);
		} catch (FueraDeRango e) {
			System.err.println("Error al crear una instancia de Primitiva. " + e.getMessage());
		} catch (BadSize e) {
			System.err.println("Error al crear una instancia de Primitiva. " + e.getMessage());
		}
		return primitiva;
	}

	/*
	 * POST: Proporciona el complementario de la Primitiva
	 */
	public Extra getComplementario() {
		return complementario;
	}

	/*
	 * POST: Proporciona el reintegro de la Primitiva
	 */
	public Extra getReintegro() {
		return reintegro;
	}

	/*
	 * PRE: ganadora.size() == this.size() POST: Decide si la Primitiva tiene el
	 * premio mayor: Que coincidan sus 6 numeros principales y el complementario
	 * con los de la "ganadora"
	 */
	public boolean esGanadora(Primitiva ganadora) {
		return super.esGanadora(ganadora) && complementario.getNumero() == ganadora.complementario.getNumero();
		// ganadora.getComplementario().getNumero());

	}

	/*
	 * POST: Decide si la Primitiva tiene el reintegro (el de la ganadora)
	 */
	public boolean tieneReintegro(Primitiva ganadora) // No hace falta
	{
		return reintegro.getNumero() == ganadora.getReintegro().getNumero();
	}

	/*
	 * POST: Decide si "x" forma parte de la Primitiva
	 */
	public boolean aparece(int x) {
		return super.aparece(x) || (complementario.getNumero() == x);
	}

	/*
	 * POST: Decide si "x" forma parte de la Primitiva
	 */
	public boolean esIgual(Primitiva primit) {
		return super.esIgual(primit) && complementario.esIgual(primit.getComplementario())
				&& reintegro.esIgual(primit.getReintegro());
	}

	/*
	 * POST: resultado es la cadena de caracteres formada por los atributos del
	 * objeto
	 */
	public String toString() {
		return "(" + super.toString() + ", " + complementario.getNumero() + ", " + reintegro.getNumero() + ")";
	}
}