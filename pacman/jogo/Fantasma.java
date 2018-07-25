package jogo;

import java.util.Random;

public class Fantasma extends Personagem {
	
	private int posy, posx;
	private Random rand = new Random();
	private int ultimaEscolha;
	private char ultimoQuadrado = ' ';

	public Fantasma (Labirinto lab, int spx, int spy) throws Exception {
		super(lab);
		this.spawny = spy;
		this.spawnx = spx;
		ultimaEscolha = rand.nextInt(4);
	}

	@Override
	public void spawn() {
		this.posy = spawny;
		this.posx = spawnx;
	}
	

	@Override
	public void move(){
		
		char quadGuardado;
		ultimaEscolha = sorteiaNumero();

		switch(ultimaEscolha) {
			case 0:
				// Esquerda
				quadGuardado = lab.getQuadrado(posx-1, posy);
				lab.mudarQuadrado(ultimoQuadrado, posx, posy);
				lab.mudarQuadrado('\u15E3', posx-1, posy);
				ultimoQuadrado = quadGuardado;
				posx--;
				break;

			case 1:
				// Cima
				quadGuardado = lab.getQuadrado(posx, posy-1);
				lab.mudarQuadrado(ultimoQuadrado, posx, posy);
				lab.mudarQuadrado('\u15E3', posx, posy-1);
				ultimoQuadrado = quadGuardado;
				posy--;
				break;

			case 2:
				// Direita
				quadGuardado = lab.getQuadrado(posx+1, posy);
				lab.mudarQuadrado(ultimoQuadrado, posx, posy);
				lab.mudarQuadrado('\u15E3', posx+1, posy);
				ultimoQuadrado = quadGuardado;
				posx++;
				break;
			
			case 3:
				// Baixo
				quadGuardado = lab.getQuadrado(posx, posy+1);
				lab.mudarQuadrado(ultimoQuadrado, posx, posy);
				lab.mudarQuadrado('\u15E3', posx, posy+1);
				ultimoQuadrado = quadGuardado;
				posy++;
				break;
			}
	}
	
	// Retorna verdadeiro se puder ir pra cima
	private int sorteiaNumero() {

		boolean[] posPossivel = new boolean[4];

		switch (ultimaEscolha) {
			case 0:
				if(lab.getQuadrado(this.posx-1, this.posy) != '\u2588')
					posPossivel[ultimaEscolha] = true;
				break;
			case 1:
				if(lab.getQuadrado(this.posx, this.posy-1) != '\u2588')
					posPossivel[ultimaEscolha] = true;
				break;
			case 2:
				if(lab.getQuadrado(this.posx+1, this.posy) != '\u2588')
					posPossivel[ultimaEscolha] = true;
				break;
			case 3:
				if(lab.getQuadrado(this.posx, this.posy+1) != '\u2588')
					posPossivel[ultimaEscolha] = true;
				break;
		}
		
		// Esquerda ou direita
		if (ultimaEscolha == 0 || ultimaEscolha == 2) {
			if(lab.getQuadrado(this.posx, this.posy-1) != '\u2588')
				posPossivel[1] = true;
			if(lab.getQuadrado(this.posx, this.posy+1) != '\u2588')
				posPossivel[3] = true;
		}

		// Cima ou baixo
		if (ultimaEscolha == 1 || ultimaEscolha == 3) {
			if(lab.getQuadrado(this.posx-1, this.posy) != '\u2588')
				posPossivel[0] = true;
			if(lab.getQuadrado(this.posx+1, this.posy) != '\u2588')
				posPossivel[2] = true;
		}
		
		int qtd = 0;
		for(int i=0; i<4; i++) {
			if(posPossivel[i]) qtd++;
		}

		if(qtd==0) 
			return (ultimaEscolha+2)%4;

		while(true) {
			int num = rand.nextInt(4);
			if(posPossivel[num]==true)
				return num;
		}
	}
}

