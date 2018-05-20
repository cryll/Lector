package control.logica;

import java.awt.event.ActionListener;

import control.accion.ListenerAvanzaPagina;
import control.accion.ListenerMarcarPagina;
import control.accion.ListenerRetrocedePagina;
import control.accion.ListenerVolverAMarca;
import modelo.Libro;
import modelo.Pagina;
import modelo.acceso.Gestor;
import vista.LectorUIEjemplo;

public class ParaUI extends LectorUIEjemplo {
	private Libro libro;

	public ParaUI(Libro libro) {
		super();
		this.libro = libro;
		this.gestor = new Gestor(this.libro.getLectura());
		this.btnAlante.addActionListener((ActionListener) this.avanzarPagina);
		this.btnMarcar.addActionListener(marcarPagina);
		this.btnAtras.addActionListener(retrocederPagina);
		this.btnIrAMarca.addActionListener(volverAMarca);
		actualizarVista();
	}

	public void actualizarVista() {
		Pagina pagina = this.libro.getPaginas().get(this.libro.getPaginas().size() - 1);
		System.out.println(pagina.getPrimer() + " " + pagina.getUltimo());
		this.textArea.setText(new Gestor(this.libro.getLectura()).sacaTexto().substring((int) pagina.getPrimer(),
				(int) pagina.getUltimo()));
		
	}

	private final int filas = 30;
	private final int columnas = 40;
	private int caracteres;
	private Gestor gestor;
	private ListenerAvanzaPagina avanzarPagina;
	private ListenerMarcarPagina marcarPagina;
	private ListenerRetrocedePagina retrocederPagina;
	private ListenerVolverAMarca volverAMarca;

	public int getCaracteres() {
		caracteres = this.filas * this.columnas;
		return caracteres;
	}

	public Libro getLibro() {
		return libro;
	}

}
