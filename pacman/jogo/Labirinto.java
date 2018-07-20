package jogo;
import java.io.BufferedReader;
import java.io.FileReader;

public class Labirinto {

	char[][] labirinto;
	private int altura, largura;
	private int[] posPacman = new int[2];

	public Labirinto(int a, int l) throws Exception {
	
		this.setAltura(a);
		this.setLargura(l);
		labirinto = new char[this.getAltura()][this.getLargura()];

		BufferedReader arquivo = new BufferedReader(new FileReader("mapa.txt"));
		
		for(int i = 0; i<this.getAltura(); i++) {
			for (int j = 0; j<this.getLargura(); j++) {
				labirinto[i][j] = devolveChar((char)arquivo.read());

				if(labirinto[i][j] == 'C')
					setPosPacman(j, i);
			}
			arquivo.read(); //Jogando fora o caractere '/n'
		}
		arquivo.close();	
	}
	
	private char devolveChar(char n) {
		if (n=='#')
			return '#';
		else if (n=='C')
			return 'C';
		else if (n=='G')
			return 'G';
		else
			return '.';
	}

	public void setAltura(int n) {
		this.altura = n;
	}
	
	public int getAltura() {
		return this.altura;
	}

	public void setLargura(int n) {
		this.largura = n;
	}
	
	public int getLargura() {
		return this.largura;
	}

	public void setPosPacman(int x, int y) {
		this.posPacman[0] = x;
		this.posPacman[1] = y;
	}

	public int[] getPosPacman() {
		return posPacman;
	}
	
	public char getCasa(int x, int y) {
		return labirinto[y][x];
	}

	public void mostrarLabirinto() {
		
		for(int i = 0; i<this.getAltura(); i++) {
			for (int j = 0; j<this.getLargura(); j++) {
				System.out.print(this.labirinto[i][j]);
			}
			
			System.out.println();
		}
	}	
	
	public void mudarQuadrado(char novoSimbolo, int x, int y){ //para mudar um quadrado
		this.labirinto[y][x] = novoSimbolo;
	}
	
}
