package control.accion;

import vista.LectorUI;
import modelo.Libro;

public class LectorBridge extends LectorUI {
	private Libro libro;
	private final int filas = 30;
	private final int columnas = 40;
	private final int caracteres = this.filas * this.columnas;

}
