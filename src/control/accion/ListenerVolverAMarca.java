package control.accion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.logica.ParaUI;

public class ListenerVolverAMarca implements ActionListener {
	private ParaUI paraUi;

	public ListenerVolverAMarca(ParaUI paraUi) {
		super();
		this.paraUi = paraUi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUi.getLibro().irAPagina();
		this.paraUi.actualizarVista();
	}
}
