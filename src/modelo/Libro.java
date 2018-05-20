package modelo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import control.logica.ParaUI;
import modelo.acceso.Gestor;


public class Libro implements Legible {

	private String lectura;
	private int actual = 0;
	private int marca = 0;
	private ArrayList<Pagina> paginas;
	private int incremento;
	private ParaUI paraUi;
	private Gestor gestor;

	public Libro() {
		super();
		lectura = "src/JuegoTronos.txt";
		paginas = new ArrayList<>();
		this.paraUi = paraUi;
		
	}

	@Override
	public void avanzarPagina() {
		if (!comprobarUltimaPagina()) {
			cargarSiguientePagina();
		}

	}

	private void cargarSiguientePagina() {
		this.actual++;
		generarPagina(this.actual);
	}

	private void generarPagina(int actual) {
		int inicio = this.actual * paraUi.getCaracteres();
		int fin = this.actual * paraUi.getCaracteres() + paraUi.getCaracteres();
		this.paginas.add(new Pagina(inicio, fin));

	}

	private boolean comprobarUltimaPagina() {
		boolean ultima = false;
		int tamanoTotal = this.paraUi.getLibro().gestor.sacaTexto().length();
		return ultima;
	}

	private boolean comprobarPrimeraPagina() {
		boolean primera = false;
		if (actual == 0) {
			primera = true;
		}
		return primera;
	}

	@Override
	public void retrocederPagina() {
		if (comprobarPrimeraPagina() == false) {
			actual = actual - 1;
		}

	}

	@Override
	public void marcarPagina() {
		this.marca = this.actual;

	}

	@Override
	public void irAPagina() {
		this.actual = this.marca;
		 this.paginas.add(new Pagina(marca, actual));
		generarPagina(this.actual);
	}

	public String getLectura() {
		return lectura;
	}

	public int getActual() {
		return actual;
	}

	public int getMarca() {
		return marca;
	}

	public ArrayList<Pagina> getPaginas() {
		return paginas;
	}
public static void main(String[] args) {
	File file = new File("src/JuegoTronos.txt");
	FileReader flujoR = null;
	try {
		 flujoR = new FileReader(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int contador =0;
	int letraActual =0;
	int i=0;
	int paginaActual = 15;
	try {
		letraActual = flujoR.read();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	while(letraActual!=-1) {
		contador++;
		try {
			letraActual = flujoR.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
		if(contador>letraActual*500&&contador<letraActual*501)
			System.out.print(Character.valueOf((char) letraActual));
		
	}
	System.out.println(contador);
}

}
