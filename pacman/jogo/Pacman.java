package jogo;

public class Pacman extends Personagem{

	private static int posy, posx;

	public Pacman(int spawny, int spawnx){
		super(spawny, spawnx);
	}

	static int[] getPosicao(){
		int[] posicao = new int[2];
		posicao[0] = posy;
		posicao[1] = posx;
		return posicao;
	}

	@Override
	void spawn() {
		posy = spawny;
		posx = spawnx;
	}

	@Override
	void mover(){
		int teclaAtual = Controle.getTeclaAtiva();
		char proximoQuadrado = getProxQuad(1, teclaAtual-37, posy, posx);
		if (proximoQuadrado != simb.getParede()){
			if (proximoQuadrado == simb.getPonto()) GameManager.adicionaPontos(10);
			switch (teclaAtual){
				case 37: // Esquerda
					lab.setQuadrado(simb.getVazio(), posy, posx);
					lab.setQuadrado(simb.getPacman('e'), posy, posx-1);
					posx--;	break;
				case 38: // Cima
					lab.setQuadrado(simb.getVazio(), posy, posx);
					lab.setQuadrado(simb.getPacman('c'), posy-1, posx);
					posy--;	break;
				case 39: // Direita
					lab.setQuadrado(simb.getVazio(), posy, posx);
					lab.setQuadrado(simb.getPacman('d'), posy, posx+1);
					posx++;	break;
				case 40: // Baixo
					lab.setQuadrado(simb.getVazio(), posy, posx);
						lab.setQuadrado(simb.getPacman('b'), posy+1, posx);
					posy++;	break;
			}
		}
	}
}
