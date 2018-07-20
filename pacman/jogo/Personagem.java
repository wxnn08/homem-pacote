package jogo;

public abstract class Personagem{
    int posy = 1;
    int posx = 1;
    Labirinto labirinto;
    
    public Personagem(Labirinto labirinto) throws Exception{
        this.labirinto = labirinto;
    }
    
    protected abstract void mover();
}
