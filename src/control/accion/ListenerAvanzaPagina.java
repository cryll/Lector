package control.accion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.logica.ParaUI;

public class ListenerAvanzaPagina implements ActionListener{
	ParaUI paraUi;

	public ListenerAvanzaPagina(ParaUI paraUI) {
		super();
		this.paraUi = paraUi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUi.getLibro().avanzarPagina();
		this.paraUi.actualizarVista();
	}
}
