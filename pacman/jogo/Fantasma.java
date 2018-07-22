package jogo;

import java.util.Random;

public class Fantasma extends Personagem {
	
	private int posy, posx;
	private Random rand = new Random();
	private int ultimaEscolha;
	private char ultimoQuadrado = '\u2022';

	public Fantasma (Labirinto lab, int spx, int spy) throws Exception{
		super(lab);
		this.spawny = spy;
		this.spawnx = spx;
		ultimaEscolha = rand.nextInt(4);
	}

	@Override
	public void spawn(){
		this.posy = spawny;
		this.posx = spawnx;
	}
	

	@Override
	public void move(){
		switch(ultimaEscolha) {
			case 0:
				// Esquerda
				ultimaEscolha = rand.nextInt(4);
				if(lab.getQuadrado(posx-1, posy) != '\u2588') {
					char quadGuardado = lab.getQuadrado(posx-1, posy);
					lab.mudarQuadrado(ultimoQuadrado, posx, posy);
					lab.mudarQuadrado('\u15E3', posx-1, posy);
					ultimoQuadrado = quadGuardado;
					posx--;
				}
				break;
			case 1:
				// Direita
				ultimaEscolha = rand.nextInt(4);
				if(lab.getQuadrado(posx+1, posy) != '\u2588') {
					char quadGuardado = lab.getQuadrado(posx+1, posy);
					lab.mudarQuadrado(ultimoQuadrado, posx, posy);
					lab.mudarQuadrado('\u15E3', posx+1, posy);
					ultimoQuadrado = quadGuardado;
					posx++;
				}
				break;
			case 2:
				// Cima
				ultimaEscolha = rand.nextInt(4);
				if(lab.getQuadrado(posx, posy-1) != '\u2588') {
					char quadGuardado = lab.getQuadrado(posx, posy-1);
					lab.mudarQuadrado(ultimoQuadrado, posx, posy);
					lab.mudarQuadrado('\u15E3', posx, posy-1);
					ultimoQuadrado = quadGuardado;
					posy--;
				}
				break;
			case 3:
				// Baixo
				ultimaEscolha = rand.nextInt(4);
				if(lab.getQuadrado(posx, posy+1) != '\u2588') {
					char quadGuardado = lab.getQuadrado(posx, posy+1);
					lab.mudarQuadrado(ultimoQuadrado, posx, posy);
					lab.mudarQuadrado('\u15E3', posx, posy+1);
					ultimoQuadrado = quadGuardado;
					posy++;
				}
				break;
		}
	}
}

