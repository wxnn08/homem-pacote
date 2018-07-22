package jogo;
import java.io.BufferedReader;
import java.io.FileReader;

public class Labirinto {

	final int larguraMaxima = 500; 
	final int alturaMaxima = 500; 

	char[][] labirinto;
	private int altura;
	private int[] largura;
	private int[] posPacman = new int[2];
	private int[] posFantasma = new int[2];

	public Labirinto() throws Exception {

		labirinto = new char[larguraMaxima][alturaMaxima];
		largura = new int[larguraMaxima];

		BufferedReader arquivo = new BufferedReader(new FileReader("mapaTeste.txt"));
		
		String s;
		for(int i = 0;(s = arquivo.readLine()) != null ; i++) {
				
			if(s.length() >= larguraMaxima) {
				// lança exceção
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
			return '\u2588';
		else if (n=='G'){
			setPosFantasma(j, i);
			return '\u15E3';
		}
		else if (n=='C') {
			setPosPacman(j, i);
			return '\u228F';
		}
		else if (n=='N')
			return ' ';
		else
			return '\u2022';
	}

	public void setAltura(int valor) {
		this.altura = valor;
	}

	public int getAltura() {
		return this.altura;
	}

	public void setLargura(int linha, int valor) {
		this.largura[linha] = valor;
	}

	public int getLargura(int linha) {
		return this.largura[linha];
	}

	public void setPosFantasma(int x, int y) {
		this.posFantasma[0] = x;
		this.posFantasma[1] = y;
	}

	public int getPosFantasma(int i) {
		return posFantasma[i];
	}


	public void setPosPacman(int x, int y) {
		this.posPacman[0] = x;
		this.posPacman[1] = y;
	}

	public int getPosPacman(int i) {
		return posPacman[i];
	}

	public char getQuadrado(int x, int y) {
		return labirinto[y][x];
	}

	public void mostrarLabirinto() {

		for(int i = 0; i<this.getAltura(); i++) {
			for (int j = 0; j<this.getLargura(i); j++) {
				System.out.print(this.labirinto[i][j]);
			}

			System.out.println();
		}
	}

	public void mudarQuadrado(char novoSimbolo, int x, int y){ //para mudar um quadrado
		this.labirinto[y][x] = novoSimbolo;
	}

}
