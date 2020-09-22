package padaoDemo;

import java.util.ArrayList;
import java.util.List;

public class Janela {
	
	private static Janela instancia;
	private List<String> textos = new ArrayList<String>();
	
	public static Janela obterInstanciaUnica() {
		if(instancia == null) {
			instancia = new Janela();
		}
		
		return instancia;
	}
	
	public List<String> getTexto() {
		return textos;
	}

	public void setTexto(String texto) {
		this.textos.add(texto);
	}	
}
