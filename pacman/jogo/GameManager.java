package jogo;
import java.util.concurrent.TimeUnit;

public class GameManager{

	static Labirinto lab;
	//declaracao estática dos personagens: precisa fazer funcao que recebe o num
	//de fantasmas como paramtro
	static Pacman pacman;
	static Fantasma[] fantasmas = new Fantasma[10];

    private static int pontos = 0;
    private static int vidas = 3;
	private static int fantasmasSpawn = 0;

    public GameManager() throws Exception{
        lab = new Labirinto();
    }

    static void setVidas(int n){
        vidas = n;
    }

	private static int getVidas(){
		return vidas;
	}

    static void adicionaPontos(int n){
        pontos += n;
    }

    private void clear(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
    }

    private void tela(){
        System.out.println("Vidas: " + vidas);
        lab.mostrarLabirinto();
        System.out.println("Pontuação: " + pontos);
    }

	private boolean start(){
		if (Controle.getActivedKey() != 0) return true;
	 	return false;
	}

	//funcao de morte do pacman
	static void mortePacman(int posy, int posx){
		setVidas(getVidas()-1); //atualiza vidas
		pacman.spawn(); //reseta posição do pacaman
		for (int i = 0; i < fantasmas.length; i++){
			int fposy = fantasmas[i].getPositions()[0]; //captura posicao y do fantasma i
			int fposx = fantasmas[i].getPositions()[1]; //captura posicao x do fantasma i
			lab.mudarQuadrado(fantasmas[i].getUltimoQuadrado(), fposx, fposy); //faz com que todos os fantasmas sumam
		    fantasmas[i] = null; //anula o vetor de fantasmas para recomeçar o jogo
			fantasmasSpawn = 0; //anula o contador de fantasmas spawnados
		}
		lab.mudarQuadrado(' ', posx, posy); //apaga o quadrado onde houve morte do pacman
		Controle.setActivedKey(0); //anula a tecla do controlador para pausar o fluxo de jogo
	}

    public void play(){
        try{
			Controle c = new Controle(); //faz a janela do swing aparecer
			pacman = new Pacman(lab.getSpawnPacman(0), lab.getSpawnPacman(1)); //cria o pacman
			pacman.spawn(); //spawna o pacman
	        while(vidas != 0){ //loop que controla o game over
				if (start() == true){ //determina o fluxo do jogo, se start() = false o jogo esta pausado
					if (fantasmasSpawn != fantasmas.length){ //se ainda existem fantasmas nao spawnados
						if (fantasmasSpawn == 0){ //se nenhum foi spawnado
							fantasmas[0] = new Fantasma(lab.getSpawnFantasma(0), lab.getSpawnFantasma(1)); //instancia o 1st fantasma
							fantasmas[0].spawn(); //spawna o primeiro fantasma
						}
						else{ //se já spawnou algum fantasma, então
						    if(lab.getQuadrado(lab.getSpawnFantasma(1),lab.getSpawnFantasma(0)) != '\u15E3'){ //se nao tem fantasma no spawn
								fantasmas[fantasmasSpawn] = new Fantasma(lab.getSpawnFantasma(0), lab.getSpawnFantasma(1)); //instancia novo fantasma
								fantasmas[fantasmasSpawn].spawn(); //spawna novo fantasma
							}
						}
						fantasmasSpawn++; //atualiza numero de fantasmas spawnados
					}
					for (int i = 0; i < fantasmas.length; i++){ //para todos os fantasmas
						if (fantasmas[i] != null) //se o fantasma em questão foi spawnado
							fantasmas[i].move(); //então ele pode se mover
					}
				    pacman.move(); //o pacman se move
			        clear();
			        tela();
			    }

			    else { // o jogo está pausado
			        clear();
			        tela();
			        System.out.println("Utilize as setas para começar!");
			    }
			    TimeUnit.MILLISECONDS.sleep(150); //taxa de atualização da tela (independe do fluxo do jogo)
			}

			if (vidas == 0){ //fora do loop que controla o game over, se as vidas são zeradas, então
				System.out.println("Game over!");
				c.setVisible(false); //fecha o swing
			}

        } catch (Exception e){}
    }
}
