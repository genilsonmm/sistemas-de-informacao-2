package padaoDemo;

public class Janela {

	private static Janela instance;
	
	private Janela() {
		System.out.println("Abriu a janela");
	}
	
	public static Janela getInstance() {
		if(instance == null)
		{
			instance = new Janela();
		}
		
		return instance;
	}
	
	
	
}
