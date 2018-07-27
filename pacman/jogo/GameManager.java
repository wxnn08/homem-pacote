package jogo;
import java.util.concurrent.TimeUnit;

public class GameManager{

	static Labirinto lab;
	static Pacman pacman;
	static Fantasma[] fantasmas;

	private static int pontos;
	private static int vidas;
	private static int fSpawnados;

	public GameManager(int numfantasmas) throws Exception{
		lab = new Labirinto();
		fantasmas = new Fantasma[numfantasmas];
		pontos = 0;
		vidas = 3;
		fSpawnados = 0;
	}

	private boolean start(){
		if (Controle.getTeclaAtiva() != 0) return true;
		return false;
	}

	static void setVidas(int n){
		vidas = n;
	}

	static int getVidas(){
		return vidas;
	}

	static void adicionaPontos(int n){
		pontos += n;
	}

	static int getPontos(){
		return pontos;
	}

	private void clear(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private void tela(){
		System.out.println("Vidas: " + getVidas());
		lab.mostrarLabirinto();
		System.out.println("Pontuação: " + getPontos());
	}

	static void mortePacman(int y, int x){
		setVidas(getVidas()-1);
		pacman.spawn();
		for (int i = 0; i < fantasmas.length; i++){
			int[] fpos = fantasmas[i].getPosicao();
			lab.setQuadrado(fantasmas[i].getQuadradoSalvo(), fpos[0], fpos[1]);
			fantasmas[i] = null;
			fSpawnados = 0;
		}
		lab.setQuadrado(' ', y, x);
		Controle.setTeclaAtiva(0);
	}

	public void play(){
		try{
			Controle c = new Controle();
			int[] pacSpawn = lab.getSpawnPacman();
			pacman = new Pacman(pacSpawn[0], pacSpawn[1]);
			pacman.spawn();
			while(vidas != 0){
				if (start() == true){
					if (fSpawnados != fantasmas.length){
						int[] fantSpawn = lab.getSpawnFantasma();
						if (fSpawnados == 0){
							fantasmas[0] = new Fantasma(fantSpawn[0], fantSpawn[1]);
							fantasmas[0].spawn();
						}
						else{
							if(lab.getQuadrado(fantSpawn[0], fantSpawn[1]) != '\u15E3'){
								fantasmas[fSpawnados] = new Fantasma(fantSpawn[0], fantSpawn[1]);
								fantasmas[fSpawnados].spawn();
							}
						}
						fSpawnados++;
					}

					for (int i = 0; i < fantasmas.length; i++)
						if (fantasmas[i] != null) fantasmas[i].mover();

					pacman.mover();
					clear();
					tela();
				}

				else {
					clear();
					tela();
					System.out.println("Utilize as setas para começar!");
				}

				TimeUnit.MILLISECONDS.sleep(150);
			}

			if (vidas == 0){
				System.out.println("Game over!");
				c.setVisible(false);
			}

		} catch (Exception e){}
	}
}
