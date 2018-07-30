package jogo;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Paleta {
	private Map<String, String> paleta = new HashMap<String, String>();
	private Random rand = new Random();

	public Paleta(){
		adicionarCores();
	}
	
	public String getCor(String cor){
		return paleta.get(cor);
	}

	public String reset(){
		return "\u001B[0m";
	}

	private void adicionarCores(){
		paleta.put("Vermelho"	, "\u001B[31m");
		paleta.put("Vermelho2"	, "\u001B[91m");
		paleta.put("Verde"		, "\u001B[32m");
		paleta.put("Verde2"		, "\u001B[92m");
		paleta.put("Azul"		, "\u001B[34m");
		paleta.put("Magenta"	, "\u001B[35m");
		paleta.put("Ciano"		, "\u001B[36m");
		paleta.put("Branco"		, "\u001B[37m");
		paleta.put("Amarelo"	, "\u001B[93m");
	}

	
}
