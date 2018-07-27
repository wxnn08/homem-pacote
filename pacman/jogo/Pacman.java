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
		if (proximoQuadrado != '\u2588'){
			if (proximoQuadrado == '\u2022') GameManager.adicionaPontos(10);
			switch (teclaAtual){
				case 37: // Esquerda
					lab.setQuadrado(' ', posy, posx);
					lab.setQuadrado('\u2290', posy, posx-1);
					posx--;	break;
				case 38: // Cima
					lab.setQuadrado(' ', posy, posx);
					lab.setQuadrado('\u2294', posy-1, posx);
					posy--;	break;
				case 39: // Direita
					lab.setQuadrado(' ', posy, posx);
					lab.setQuadrado('\u228F', posy, posx+1);
					posx++;	break;
				case 40: // Baixo
					lab.setQuadrado(' ', posy, posx);
					lab.setQuadrado('\u2293', posy+1, posx);
					posy++;	break;
			}
		}
	}
}
