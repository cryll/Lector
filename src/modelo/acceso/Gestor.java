package modelo.acceso;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Gestor {
	private String ruta;

	public Gestor(String ruta) {
		super();
		this.ruta = ruta;
	}

	public String sacaTexto() {
		File file = new File(this.ruta);
		StringBuilder Builder = new StringBuilder();
		FileInputStream flujoR = null;
		BufferedInputStream bufferR = null;
		if (file.exists()) {
			try {
				flujoR = new FileInputStream(file);
				bufferR = new BufferedInputStream(flujoR);
				int libro = bufferR.read();
				while (libro != -1) {
					Builder.append(String.valueOf(Character.toChars(libro)));
					libro = bufferR.read();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bufferR.close();
				flujoR.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return Builder.toString();
	}

	public String getRuta() {
		return ruta;
	}
}
