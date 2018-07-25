package jogo;

import java.util.Random;

public class Fantasma extends Personagem {

	private Random rand = new Random();
	private int posy, posx;
	private int ultimaEscolha;
	private char ultimoQuadrado = ' ';

	public Fantasma (int spawny, int spawnx){
		super(spawny, spawnx);
		ultimaEscolha = rand.nextInt(4);
	}

	private int sorteiaNumero() {
		boolean[] posPossivel = new boolean[4]; // [Esq, Cim, Dir, Baixo]
		int numPosPossiveis = 0;
		if (getProxQuad(1, ultimaEscolha, posy, posx) != '\u2588')
			posPossivel[ultimaEscolha] = true;
		if (ultimaEscolha % 2 == 0){
			if (getProxQuad(1, 1, posy, posx) != '\u2588') posPossivel[1] = true;
			if (getProxQuad(1, 3, posy, posx) != '\u2588') posPossivel[3] = true;
		}
		else {
			if (getProxQuad(1, 0, posy, posx) != '\u2588') posPossivel[0] = true;
			if (getProxQuad(1, 2, posy, posx) != '\u2588') posPossivel[2] = true;
		}
		for (int i = 0; i < 4; i++)
			if (posPossivel[i] == true) numPosPossiveis++;
		if (numPosPossiveis == 0) return (ultimaEscolha + 2) % 4;
		while (true) {
			int num = rand.nextInt(4);
			if (posPossivel[num] == true) return num;
		}
	}

	@Override
	void spawn() {
		posy = spawny;
		posx = spawnx;
	}

	@Override
	void move(){
		ultimaEscolha = sorteiaNumero();
		char quadGuardado = getProxQuad(1, ultimaEscolha, posy, posx);
		lab.mudarQuadrado(ultimoQuadrado, posx, posy);
		switch (ultimaEscolha) {
			case 0: // Esquerda
				lab.mudarQuadrado('\u15E3', posx-1, posy);
				posx--; break;
			case 1: // Cima
				lab.mudarQuadrado('\u15E3', posx, posy-1);
				posy--; break;
			case 2: // Direita
				lab.mudarQuadrado('\u15E3', posx+1, posy);
				posx++; break;
			case 3: // Baixo
				lab.mudarQuadrado('\u15E3', posx, posy+1);
				posy++; break;
			}
			ultimoQuadrado = quadGuardado;
	}
}
