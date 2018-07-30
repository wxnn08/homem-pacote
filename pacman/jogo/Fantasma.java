package jogo;

import java.util.Random;

public class Fantasma extends Personagem {

	private Random rand = new Random();
	private int posy, posx;
	private int ultimaEscolha;
	private char quadradoSalvo = simb.getVazio();

	public Fantasma (int spawny, int spawnx){
		super(spawny, spawnx);
		ultimaEscolha = rand.nextInt(4);
	}

	int[] getPosicao(){
		int[] posicao = new int[2];
		posicao[0] = posy;
		posicao[1] = posx;
		return posicao;
	}

	void setQuadradoSalvo (char c){
		quadradoSalvo = c;
	}

	char getQuadradoSalvo (){
		return quadradoSalvo;
	}

	boolean verificaMatouPacman(){
		int[] pacPos = Pacman.getPosicao();
		if (posy == pacPos[0] && posx == pacPos[1]){
			GameManager.mortePacman(posy, posx);
			return true;
		}
		return false;
	}

	private int sorteiaNumero() {
		boolean[] posPossiveis = new boolean[4]; // [Esq, Cim, Dir, Baixo]
		int numPosPossiveis = 0;
		if (getProxQuad(1, ultimaEscolha, posy, posx) != simb.getParede() &&
		getProxQuad(1, ultimaEscolha, posy, posx) != simb.getFantasma())
			posPossiveis[ultimaEscolha] = true;
		if (ultimaEscolha % 2 == 0){
			if (getProxQuad(1, 1, posy, posx) != simb.getParede() &&
			getProxQuad(1, 1, posy, posx) != simb.getFantasma()) posPossiveis[1] = true;
			if (getProxQuad(1, 3, posy, posx) != simb.getParede() &&
			getProxQuad(1, 3, posy, posx) != simb.getFantasma()) posPossiveis[3] = true;
		}
		else {
			if (getProxQuad(1, 0, posy, posx) != simb.getParede() &&
			getProxQuad(1, 0, posy, posx) != simb.getFantasma()) posPossiveis[0] = true;
			if (getProxQuad(1, 2, posy, posx) != simb.getParede() &&
			getProxQuad(1, 2, posy, posx) != simb.getFantasma()) posPossiveis[2] = true;
		}
		for (int i = 0; i < 4; i++)
			if (posPossiveis[i] == true) numPosPossiveis++;
		if (numPosPossiveis == 0) return (ultimaEscolha + 2) % 4;
		while (true) {
			int sorteado = rand.nextInt(4);
			if (posPossiveis[sorteado] == true) return sorteado;
		}
	}

	@Override
	void spawn() {
		posy = spawny;
		posx = spawnx;
	}

	@Override
	void mover(){
		if (verificaMatouPacman()) return;
		ultimaEscolha = sorteiaNumero();
		char quadGuardado = getProxQuad(1, ultimaEscolha, posy, posx);
		if (quadGuardado == simb.getFantasma()) quadGuardado = ' ';
		lab.setQuadrado(quadradoSalvo, posy, posx);
		switch (ultimaEscolha) {
			case 0: // Esquerda
				lab.setQuadrado(simb.getFantasma(), posy, posx-1);
				posx--; break;
			case 1: // Cima
				lab.setQuadrado(simb.getFantasma(), posy-1, posx);
				posy--; break;
			case 2: // Direita
				lab.setQuadrado(simb.getFantasma(), posy, posx+1);
				posx++; break;
			case 3: // Baixo
				lab.setQuadrado(simb.getFantasma(), posy+1, posx);
				posy++; break;
		}
		quadradoSalvo = quadGuardado;
		if (verificaMatouPacman()) return;
	}
}
