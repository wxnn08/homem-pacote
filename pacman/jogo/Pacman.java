package jogo;

public class Pacman extends Personagem{

	private static int posy, posx;

	public Pacman(int spawny, int spawnx){
		super(spawny, spawnx);
	}

	static int[] getPositions(){
		int[] positions = new int[2];
		positions[0] = posy;
		positions[1] = posx;
		return positions;
	}

	@Override
	void spawn() {
		posy = spawny;
		posx = spawnx;
	}

	@Override
	void move(){
		int teclaAtual = Controle.getActivedKey();
		char proximoQuadrado = getProxQuad(1, teclaAtual-37, posy, posx);
		if (proximoQuadrado != '\u2588'){
			if (proximoQuadrado == '\u2022') GameManager.adicionaPontos(10);
			switch (teclaAtual){
				case 37: // Esquerda
					lab.mudarQuadrado(' ', posx, posy);
					lab.mudarQuadrado('\u2290', posx-1, posy);
					posx--;	break;
				case 38: // Cima
					lab.mudarQuadrado(' ', posx, posy);
					lab.mudarQuadrado('\u2294', posx, posy-1);
					posy--;	break;
				case 39: // Direita
					lab.mudarQuadrado(' ', posx, posy);
					lab.mudarQuadrado('\u228F', posx+1, posy);
					posx++;	break;
				case 40: // Baixo
					lab.mudarQuadrado(' ', posx, posy);
					lab.mudarQuadrado('\u2293', posx, posy+1);
					posy++;	break;
			}
		}
	}
}
