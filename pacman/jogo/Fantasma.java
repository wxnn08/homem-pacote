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

	int[] getPositions(){
		int[] positions = new int[2];
		positions[0] = posy;
		positions[1] = posx;
		return positions;
	}

	void setUltimoQuadrado (char c){
		ultimoQuadrado = c;
	}

	char getUltimoQuadrado (){
		return ultimoQuadrado;
	}

	//função que verifica se este fantasma pegou o pacman
	void verificaMatouPacman(){
		int y = Pacman.getPositions()[0]; //captura posicao y do pacman
		int x = Pacman.getPositions()[1]; //captura posicao x do pacman
		if (posy == y && posx == x) //compara com as posições do fantasma
			GameManager.mortePacman(posy, posx); //chama função de morte eles ocupam a mesma posição
	}

	private int sorteiaNumero() {
		boolean[] posPossivel = new boolean[4]; // [Esq, Cim, Dir, Baixo]
		int numPosPossiveis = 0;
		if (getProxQuad(1, ultimaEscolha, posy, posx) != '\u2588' &&
		getProxQuad(1, ultimaEscolha, posy, posx) != '\u15E3') //se há outro fantasma na frente, então ele não avança
			posPossivel[ultimaEscolha] = true;
		if (ultimaEscolha % 2 == 0){
			if (getProxQuad(1, 1, posy, posx) != '\u2588' &&
			getProxQuad(1, 1, posy, posx) != '\u15E3') posPossivel[1] = true; //considera outro fantasma como obstáculo
			if (getProxQuad(1, 3, posy, posx) != '\u2588' &&
			getProxQuad(1, 3, posy, posx) != '\u15E3') posPossivel[3] = true; //considera outro fantasma como obstáculo
		}
		else {
			if (getProxQuad(1, 0, posy, posx) != '\u2588' &&
			getProxQuad(1, 0, posy, posx) != '\u15E3') posPossivel[0] = true; //considera outro fantasma como obstáculo
			if (getProxQuad(1, 2, posy, posx) != '\u2588' &&
			getProxQuad(1, 2, posy, posx) != '\u15E3') posPossivel[2] = true; //considera outro fantasma como obstáculo
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
		verificaMatouPacman(); //verifica se pegou o pacman antes de se mover
		ultimaEscolha = sorteiaNumero();
		char quadGuardado = getProxQuad(1, ultimaEscolha, posy, posx);
		if (quadGuardado == '\u15E3') quadGuardado = '\u2022'; //se por acaso cruzar com outro fantasma, entao ele printa um ponto
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
		verificaMatouPacman(); //verifica se pegou o pacman depois de se mover
	}
}
