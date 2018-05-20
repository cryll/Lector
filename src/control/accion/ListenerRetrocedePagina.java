package control.accion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.logica.ParaUI;

public class ListenerRetrocedePagina implements ActionListener{
	private ParaUI paraUi;

	public ListenerRetrocedePagina(ParaUI paraUi) {
		super();
		this.paraUi = paraUi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUi.getLibro().retrocederPagina();
		this.paraUi.actualizarVista();
	}
}
