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
			return lab.getQuadrado(posy, posx-n);
		if (dir == 1) // Cima
			return lab.getQuadrado(posy-n, posx);
		if (dir == 2) // Direita
			return lab.getQuadrado(posy, posx+n);
		return lab.getQuadrado(posy+n, posx); // Baixo
	}

	abstract void spawn();
	abstract void mover();
}
