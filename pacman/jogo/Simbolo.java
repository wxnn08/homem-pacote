package jogo;

public class Simbolo {

	private final char[] pacman = new char[] {'\u2290', '\u2294', '\u228F', '\u2293'};
	private final char fantasma = '\u15E3';
	private final char parede = '\u2588';
	private final char ponto = '\u2022';
	private final char vazio = ' ';

	public char getPacman(char lado){
		//e -> esquerda -> 0 , c -> cima -> 1, d -> direita -> 2, b -> baixo -> 3
		if(lado == 'e') return this.pacman[0];
		else if(lado == 'c') return this.pacman[1];
		else if(lado == 'd') return this.pacman[2];
		else return this.pacman[3];
	}

	public char getFantasma(){
		return this.fantasma;
	}

	public char getParede(){
		return this.parede;
	}

	public char getPonto(){
		return this.ponto;
	}

	public char getVazio(){
		return this.vazio;
	}
}
