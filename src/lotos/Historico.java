package lotos;

import fechas.*;
import list.ArrayList;

/**
 * Implementación de un Histórico de Sorteo(s)<br>
 * {@code Historico = Lista(Sorteo)<br>
 * 
 * @since 17/02/2017
 * @version 1.1.1 22/03/2017 JGF
 * @author JMB & JGF
 */
public class Historico {
	private ArrayList<Sorteo> sorteos;

	public Historico() {
		this.sorteos = new ArrayList<lotos.Sorteo>();
	}

	public Sorteo get(int index) {
		return sorteos.get(index);
	}

	public int size() {
		return sorteos.size();
	}

	public void add(int index, Sorteo sorteo) {
		sorteos.add(index, sorteo);
	}

	/*
	 * POST: Visualizador del Historico.
	 */
	public String toString() {
		return sorteos.toString();
	}

	/**
	 * POST: Determina si fecha está en el intervalo [fecha1, fecha2].
	 */
	private static boolean estaEnIntervalo(Fecha fecha, Fecha fecha1, Fecha fecha2) {
		return fecha1.esMenorOIgual(fecha) && fecha.esMenorOIgual(fecha2);
	}

	/**
	 * PRE: fecha1<=fecha2 POST: Calcula las frecuencias de los reintegros en un
	 * intervalo de fechas [fecha1, fecha2] en sorteos de la primitiva.
	 */
	public int[] frecuenciasReintegro(Fecha fecha1, Fecha fecha2) {
		int dia1 = fecha1.getDia();
		int mes1 = fecha1.getMes();
		int anio1 = fecha1.getAnio();
		int dia2 = fecha2.getDia();
		int mes2 = fecha2.getMes();
		int anio2 = fecha2.getAnio();

		int[] frecuenciasReintegro = new int[10];

		for (int i = 0; i < this.sorteos.size(); i++) {
			if (this.sorteos.get(i).getLoto() instanceof Primitiva) {

				Primitiva prim = (Primitiva) this.sorteos.get(i).getLoto();
				Fecha fechaFinal = this.sorteos.get(i).getFecha();
				if (estaEnIntervalo(fechaFinal, fecha1, fecha2)) {
					frecuenciasReintegro[prim.getReintegro().getNumero()]++;
				}

			}
		}
		return frecuenciasReintegro;
	}

}