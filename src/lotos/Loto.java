package lotos;

import anotacion.Programacion2;
import lotos.excepciones.BadSize;
import lotos.excepciones.FueraDeRango;

@Programacion2(nombreAutor1 = "Raúl", apellidoAutor1 = "Carbajosa González", emailUPMAutor1 = "raul.cgonzalez@alumnos.upm.es", nombreAutor2 = "Máximo", apellidoAutor2 = "García Martínez", emailUPMAutor2 = "maximo.garcia.martinez@alumnos.upm.es")

/**
 * ImplementaciÃ³n de una Loto<br>
 * {@code Loto = (Entero[] numeros,
 *                Entero min, Entero max)}<br>
 * 
 * @since 3/5/2016
 * @version 1.0
 * @author JMB & JGF
 */
public class Loto {
	private int[] numeros;
	private int min, max; // Rango de los numeros
	/*
	 * PRE: longitud(numeros)=numerosSorteo /\ todosEnRango (numeros, min, max)
	 * POST:
	 * 
	 * @throws BadSize si longitud(numeros)!=numerosSorteo
	 * 
	 * @throws FueraDeRango si NO todosEnRango (numeros, min, max) eoc -->
	 * Construye una Loto
	 */

	public Loto(int numerosSorteo, int[] numeros, int min, int max) throws BadSize, FueraDeRango {
		// TODO

		this.numeros = new int[numerosSorteo];

		if (numerosSorteo != numeros.length) {
			throw new BadSize("La longitud no es apropiada");

		}

		else if (!todosEnRango(numeros, min, max)) {
			throw new FueraDeRango("El número escapa el rango de Loto");
		} 
		else {
			this.numeros = numeros;
			this.min = min;
			this.max = max;
		}

	}

	/*
	 * POST: resultado = min<=n<=max
	 */
	private static boolean enRango(int n, int min, int max) {
		return min <= n && n <= max;
	}

	/*
	 * POST: Determina si todos los <numeros> estan en el rango [min, max]
	 */
	private static boolean todosEnRango(int[] numeros, int min, int max) {
		// TODO

		boolean resultado = true;

		for (int i = 0; i < numeros.length && resultado; i++) {
			if (!enRango(numeros[i], min, max)) {
				resultado = false;
			}
		}

		return resultado;
	}

	/*
	 * POST: Manejador del constructor de Loto.
	 */
	public static Loto consLoto(int numero, int[] numeros, int min, int max) {
		Loto loto = null;
		try {
			loto = new Loto(numero, numeros, min, max);
		} catch (FueraDeRango e) {
			System.err.println("Error al crear una instancia de Loto. " + e.getMessage());
		} catch (BadSize e) {
			System.err.println("Error al crear una instancia de Loto. " + e.getMessage());
		}
		return loto;
	}

	/*
	 * POST: resultado es el limite inferior del rango de los numeros
	 */
	public int getMin() {
		return min;
	}

	/*
	 * POST: resultado es el limite superior del rango de los numeros
	 */
	public int getMax() {
		return max;
	}

	/*
	 * POST: Proporciona los numeros de Loto
	 */
	public int[] getNumeros() {
		return numeros;
	}

	/*
	 * PRE: pos IN [0,size()-1] POST: devuelve el elemento del objeto que esta
	 * en la posiciÃ³n "pos".
	 */
	public int get(int pos) {
		int resultado = (pos >= 0 && pos < this.size()) ? numeros[pos] : -1;
		return resultado;
	}

	/*
	 * PRE: pos IN [0,size()-1] POST: modifica el elemento del objeto que esta
	 * en la posiciÃ³n "pos".
	 */
	public void set(int pos, int elem) {
		numeros[pos] = elem;
	}

	/*
	 * POST: Resultado es el tamaÃ±o del objeto.
	 */
	public int size() {
		return numeros.length;
	}

	/*
	 * PRE: ganadora.size() == this.size() POST: Decide si la Loto es igual a la
	 * "ganadora".
	 */
	public boolean esGanadora(Loto ganadora) {
		return this.mismosNumeros(ganadora);
	}

	/*
	 * POST: Decide si "x" forma parte de la Loto
	 */
	public boolean aparece(int buscado) {
		int i = 0;
		boolean esta = false;
		while ((i < numeros.length) && !esta)
			if (buscado == numeros[i])
				esta = true;
			else
				i = i + 1;
		return esta;
	}

	/**
	 * POST: resultado es cierto si "this" es igual a "otra" (mismos elementos
	 * en las mismas posiciones) y es falso e.o.c.
	 */
	private boolean mismosNumeros(Loto otra) {
		boolean iguales = this.size() == otra.size();
		for (int i = 0; i < this.size() && iguales; i++) {
			iguales = this.numeros[i] == otra.numeros[i];
		}
		return iguales;
	}

	/*
	 * POST: Decide si "loto" es igual a esta Loto
	 */
	public boolean esIgual(Loto loto) {
		return this.mismosNumeros(loto) && min == loto.getMin() && max == loto.getMax();
	}

	/*
	 * POST: resultado es la cadena de caracteres formada por los atributos del
	 * objeto
	 */
	public String toString() {
		String resultado = "[";
		for (int i = 0; i < numeros.length; i++) {
			resultado = resultado + numeros[i];
			if (i < numeros.length - 1)
				resultado = resultado + ",";
		}
		return resultado + "]";
	}
}