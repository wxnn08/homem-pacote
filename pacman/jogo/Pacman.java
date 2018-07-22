package jogo;

public class Pacman extends Personagem{

	static int posy;
	static int posx;

	public Pacman(Labirinto lab, int spx, int spy) throws Exception{
		super(lab);
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
            if (lab.getQuadrado(posx-1, posy)!='\u2588'){
                if(lab.getQuadrado(posx-1, posy) == '\u2022')
                    GameManager.setPontos(10);
                lab.mudarQuadrado(' ', posx, posy);
                lab.mudarQuadrado('\u2290', posx-1, posy);
                posx--;
            }
        }
        else if (Controle.activedkey == 38) { //seta cima
            if (lab.getQuadrado(posx, posy-1)!='\u2588'){
                if(lab.getQuadrado(posx, posy-1)=='\u2022')
                    GameManager.setPontos(10);
                lab.mudarQuadrado(' ', posx, posy);
                lab.mudarQuadrado('\u2294', posx, posy-1);
                posy--;
            }
        }
        else if (Controle.activedkey == 39){ //seta dir.
            if (lab.getQuadrado(posx+1, posy)!='\u2588'){
                if(lab.getQuadrado(posx+1, posy)=='\u2022')
                    GameManager.setPontos(10);
                lab.mudarQuadrado(' ', posx, posy);
                lab.mudarQuadrado('\u228F', posx+1, posy);
                posx++;
            }
        }
        else if (Controle.activedkey == 40){ //seta baixo
            if (lab.getQuadrado(posx, posy+1)!='\u2588'){
                if(lab.getQuadrado(posx, posy+1)=='\u2022')
                    GameManager.setPontos(10);
                lab.mudarQuadrado(' ', posx, posy);
                lab.mudarQuadrado('\u2293', posx, posy+1);
                posy++;
            }
        }
	}
}
