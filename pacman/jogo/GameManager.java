package jogo;
import java.util.concurrent.TimeUnit;

public class GameManager{

	static Controle c;
	static Labirinto lab;
	static Pacman pacman;
	static Fantasma[] fantasmas;
	static int taxaDeAtualizacao;

	private static int pontos;
	private static int vidas;
	private static int fSpawnados;

	public GameManager(int numfantasmas, int mapa, int modo) throws Exception{
		lab = new Labirinto(mapa);
		c = new Controle();
		fantasmas = new Fantasma[numfantasmas];
		pontos = 0;
		vidas = 3;
		fSpawnados = 0;
		setTaxaDeAtualizacao(modo);
	}

	private void setTaxaDeAtualizacao(int modo){
		switch (modo){
			case 1: taxaDeAtualizacao = 200; break; //facil
			case 2: taxaDeAtualizacao = 150; break; //medio
			case 3: taxaDeAtualizacao = 100; break; //dificil
			case 4: taxaDeAtualizacao = 75; break; //insano
		}
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
			if (fantasmas[i] != null){
				int[] fpos = fantasmas[i].getPosicao();
				lab.setQuadrado(fantasmas[i].getQuadradoSalvo(), fpos[0], fpos[1]);
			}
			fantasmas[i] = null;
			fSpawnados = 0;
		}
		lab.setQuadrado(' ', y, x);
		c.setVisible(false);
		Controle.setTeclaAtiva(0);
	}

	private void instanciaFantasmas(){
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
	}

	public void play(){
		try{
			int[] pacSpawn = lab.getSpawnPacman();
			pacman = new Pacman(pacSpawn[0], pacSpawn[1]);
			pacman.spawn();

			while(vidas != 0){
				if (start() == true){
					instanciaFantasmas();
					for (int i = 0; i < fantasmas.length; i++){
						if (fantasmas[i] != null) fantasmas[i].mover();
					}
					pacman.mover();
					clear();
					tela();
					if (lab.getNumPontos()*10 == getPontos()) break;
				}
				else {
					clear();
					tela();
					if (vidas != 3) System.out.println("Você morreu!");
					System.out.println("Utilize as setas para começar!");
					TimeUnit.MILLISECONDS.sleep(200);
					c.setVisible(true);
				}
				TimeUnit.MILLISECONDS.sleep(taxaDeAtualizacao);
			}

			if (vidas == 0) {
				System.out.println(" ");
				System.out.println("Game over!\nSua pontuação: " + getPontos());
			}
			else System.out.println("Você venceu!");
			c.setTeclaAtiva(0);
			c.setVisible(false);

		} catch (Exception e){
			System.out.println("Ocorreu um erro: " + e.toString());
		}
	}
}
