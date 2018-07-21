package jogo;

public abstract class Personagem{
    int spawny;
	int spawnx;
	public abstract void spawn();

    Labirinto labirinto;

    public Personagem(Labirinto labirinto) throws Exception{
        this.labirinto = labirinto;
    }

    protected abstract void move();
}
