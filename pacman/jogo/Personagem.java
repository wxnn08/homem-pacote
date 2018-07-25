package jogo;

public abstract class Personagem{
    int spawny, spawnx;
	Labirinto lab = GameManager.lab;

	public Personagem(int spawny, int spawnx){
		this.spawny = spawny;
		this.spawnx = spawnx;
	}

	//captura o n proximo quadrado levando em consideracao a direcao dir
	//a partir de dada posição (x,y)
	protected char getProxQuad(int n, int dir, int posy, int posx){
		if (dir == 0) // Esquerda
			return lab.getQuadrado(posx-n, posy);
		if (dir == 1) // Cima
			return lab.getQuadrado(posx, posy-n);
		if (dir == 2) // Direita
			return lab.getQuadrado(posx+n, posy);
		return lab.getQuadrado(posx, posy+n); // Baixo
	}

    abstract void spawn();
    abstract void move();
}
