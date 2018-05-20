package control.accion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.logica.ParaUI;

public class ListenerMarcarPagina implements ActionListener {
	private ParaUI paraUi;

	public ListenerMarcarPagina(ParaUI parauI) {
		super();
		this.paraUi = paraUi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUi.getLibro().marcarPagina();
		this.paraUi.actualizarVista();
	}
}
