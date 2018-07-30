package jogo;
import java.io.BufferedReader;
import java.io.FileReader;

public class Labirinto {

	private final int larguraMaxima = 500;
	private final int alturaMaxima = 500;
	private Paleta paleta = new Paleta();
	private Simbolo simb = new Simbolo();

	char[][] labirinto;
	private int altura;
	private int[] largura;
	private int[] spawnPacman = new int[2];
	private int[] spawnFantasma = new int[2];
	private int numPontos = 0;

	public Labirinto(int mapa) throws Exception {

		labirinto = new char[larguraMaxima][alturaMaxima];
		largura = new int[larguraMaxima];

		BufferedReader arquivo = new BufferedReader(new FileReader("mapa1.txt"));
		switch (mapa){
			case 2: arquivo = new BufferedReader(new FileReader("mapa2.txt")); break;
			case 3: arquivo = new BufferedReader(new FileReader("mapa3.txt")); break;
			case 4: arquivo = new BufferedReader(new FileReader("mapa4.txt")); break;
			case 5: arquivo = new BufferedReader(new FileReader("mapa5.txt")); break;
		}

		String s;
		for(int i = 0;(s = arquivo.readLine()) != null ; i++) {

			if(s.length() >= larguraMaxima) {
				throw new Exception("O tamanho desse mapa é maior do que o limite (500x500)!");
			}
			for (int j = 0; j<s.length(); j++) {
				labirinto[i][j] = devolveChar(s.charAt(j), j, i);
			}
			setAltura(getAltura()+1);
			setLargura(i, s.length());
		}

		arquivo.close();
	}

	private char devolveChar(char n, int j, int i) {
		if (n=='#')
			return simb.getParede();
		else if (n=='G'){
			setSpawnFantasma(i, j);
			return simb.getFantasma();
		}
		else if (n=='C') {
			setSpawnPacman(i, j);
			return simb.getPacman('d');
		}
		else if (n=='N')
			return simb.getVazio();
		else{
			numPontos++;
			return simb.getPonto();
		}
	}

	void setNumPontos(int numPontos){
		this.numPontos = numPontos;
	}

	int getNumPontos(){
		return numPontos;
	}

	private void setAltura(int valor) {
		altura = valor;
	}

	private int getAltura() {
		return altura;
	}

	private void setLargura(int linha, int valor) {
		largura[linha] = valor;
	}

	private int getLargura(int linha) {
		return largura[linha];
	}

	private void setSpawnFantasma(int y, int x) {
		spawnFantasma[0] = y;
		spawnFantasma[1] = x;
	}

	int[] getSpawnFantasma() {
		return spawnFantasma;
	}

	private void setSpawnPacman(int y, int x) {
		spawnPacman[0] = y;
		spawnPacman[1] = x;
	}

	protected int[] getSpawnPacman() {
		return spawnPacman;
	}

	protected void setQuadrado(char novoSimbolo, int y, int x){
		labirinto[y][x] = novoSimbolo;
	}

	protected char getQuadrado(int y, int x) {
		return labirinto[y][x];
	}

	private void imprimePosicao(char pos) {
		// Aplica cor
		if(pos == simb.getParede()) {
			System.out.print(paleta.getCor("Azul"));
		}
		else if(pos == simb.getFantasma()) {
			System.out.print(paleta.getCor("Verde2"));
		}
		else if(pos==simb.getPacman('e') || pos==simb.getPacman('c') || pos==simb.getPacman('d') || pos==simb.getPacman('b')) {
			System.out.print(paleta.getCor("Amarelo"));
		}
		// Imprime posicao
		System.out.print(pos);
		// Reseta cor
		System.out.print(paleta.reset());
	}

	protected void mostrarLabirinto() {
		for (int i = 0; i < getAltura(); i++) {
			for (int j = 0; j < getLargura(i); j++) {
				imprimePosicao(labirinto[i][j]);
			}
			System.out.println();
		}
	}

}
