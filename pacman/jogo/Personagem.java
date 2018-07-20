package jogo;

public class Personagem{
    int posy;
    int posx;
    Labirinto l;
    
    public Personagem(Labirinto l) throws Exception{
        this.l = l;
    }
    
    public void mover(){
        if (Controle.activedkey == 37) { //seta esq.
            if (posx > 0){
                l.mudarQuadrado('#', posy, posx);
                l.mudarQuadrado('C', posy, posx-1);
                posx--; 
            }
        }
        else if (Controle.activedkey == 38) { //seta cima
            if (posy > 0){
                l.mudarQuadrado('#', posy, posx);
                l.mudarQuadrado('C', posy-1, posx);
                posy--; 
            }
        }
        else if (Controle.activedkey == 39){ //seta dir.
            if (posx < l.getLargura()-1){
                l.mudarQuadrado('#', posy, posx);
                l.mudarQuadrado('C', posy, posx+1);
                posx++; 
            }
        }
        else if (Controle.activedkey == 40){ //seta baixo
            if (posy < l.getAltura()-1){
                l.mudarQuadrado('#', posy, posx);
                l.mudarQuadrado('C', posy+1, posx);
                posy++; 
            }
        }
    }
    
}
