package padaoDemo;

public class Principal {

	public static void main(String[] args) {
		
		//1° Clique do botão
		abrirJanela("Janela 1");
		
		//2° Clique no botão
		abrirJanela("Janela 2");
		
		System.out.println(Janela.obterInstanciaUnica().getTexto().size());
	}

	private static void abrirJanela(String text) {
		 Janela.obterInstanciaUnica().setTexto(text);
	}	
}
