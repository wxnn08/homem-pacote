package jogo;
import java.util.concurrent.TimeUnit;

public class GameManager{

	static Labirinto lab;
	static Pacman pacman;
	static Fantasma fantasma;
    private static int pontos = 0;
    private static int vidas = 3;

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

	static void mortePacman(int posy, int posx){
		setVidas(getVidas()-1);
		pacman.spawn();
		fantasma.spawn();
		fantasma.setUltimoQuadrado(' ');
		lab.mudarQuadrado(' ', posx, posy);
		Controle.setActivedKey(0);
	}

    public void play(){
        try{
			Controle c = new Controle();
			pacman = new Pacman(lab.getSpawnPacman(0), lab.getSpawnPacman(1));
			fantasma = new Fantasma(lab.getSpawnFantasma(0), lab.getSpawnFantasma(1));
			pacman.spawn();
			fantasma.spawn();
	        while(vidas != 0){
				if (start() == true){
					fantasma.move();
				    pacman.move();
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
