package jogo;

public abstract class Personagem{
    int spawny;
	int spawnx;
	public abstract void spawn();

    Labirinto lab;

    public Personagem(Labirinto lab) throws Exception{
        this.lab = lab;
    }

    protected abstract void move();
}
