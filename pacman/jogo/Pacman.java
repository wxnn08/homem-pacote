package jogo;

public class Pacman extends Personagem{
	
	public Pacman(Labirinto labirinto) throws Exception{
		super(labirinto);
	}
	
	@Override
	public void mover(){

		if (Controle.activedkey == 37) { //seta esq.
            if (posx > 0 && labirinto.getCasa(posx-1, posy)!='#'){
                labirinto.mudarQuadrado(' ', posx, posy);
                labirinto.mudarQuadrado('\u2290', posx-1, posy);
                posx--; 
            }
        }
        else if (Controle.activedkey == 38) { //seta cima
            if (posy > 0 && labirinto.getCasa(posx, posy-1)!='#'){
                labirinto.mudarQuadrado(' ', posx, posy);
                labirinto.mudarQuadrado('\u2294', posx, posy-1);
                posy--; 
            }
        }
        else if (Controle.activedkey == 39){ //seta dir.
            if (posx < labirinto.getLargura()-1 && labirinto.getCasa(posx+1, posy)!='#'){
                labirinto.mudarQuadrado(' ', posx, posy);
                labirinto.mudarQuadrado('\u228F', posx+1, posy);
                posx++; 
            }
        }
        else if (Controle.activedkey == 40){ //seta baixo
            if (posy < labirinto.getAltura()-1 && labirinto.getCasa(posx, posy+1)!='#'){
                labirinto.mudarQuadrado(' ', posx, posy);
                labirinto.mudarQuadrado('\u2293', posx, posy+1);
                posy++; 
            }
        }
	}
}
