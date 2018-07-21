package jogo;

public class Pacman extends Personagem{

	static int posy;
	static int posx;

	public Pacman(Labirinto labirinto, int spx, int spy) throws Exception{
		super(labirinto);
		this.spawny = spy;
		this.spawnx = spx;
	}

	@Override
	public void spawn(){
		this.posy = spawny;
		this.posx = spawnx;
	}

	@Override
	public void move(){

		if (Controle.activedkey == 37) { //seta esq.
            if (labirinto.getCasa(posx-1, posy)!='\u2588'){
                labirinto.mudarQuadrado(' ', posx, posy);
                labirinto.mudarQuadrado('\u2290', posx-1, posy);
                posx--;
            }
        }
        else if (Controle.activedkey == 38) { //seta cima
            if (labirinto.getCasa(posx, posy-1)!='\u2588'){
                labirinto.mudarQuadrado(' ', posx, posy);
                labirinto.mudarQuadrado('\u2294', posx, posy-1);
                posy--;
            }
        }
        else if (Controle.activedkey == 39){ //seta dir.
            if (labirinto.getCasa(posx+1, posy)!='\u2588'){
                labirinto.mudarQuadrado(' ', posx, posy);
                labirinto.mudarQuadrado('\u228F', posx+1, posy);
                posx++;
            }
        }
        else if (Controle.activedkey == 40){ //seta baixo
            if (labirinto.getCasa(posx, posy+1)!='\u2588'){
                labirinto.mudarQuadrado(' ', posx, posy);
                labirinto.mudarQuadrado('\u2293', posx, posy+1);
                posy++;
            }
        }
	}
}
