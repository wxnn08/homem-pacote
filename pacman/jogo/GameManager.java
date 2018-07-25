package jogo;
import java.util.concurrent.TimeUnit;

public class GameManager{

    static Labirinto lab;
    private static int pontos = 0;
    private static int vidas = 3;

    public GameManager() throws Exception{
        lab = new Labirinto();
    }

    void setVidas(int n){
        this.vidas = n;
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

    public void play(){
        try{
			Controle c = new Controle();
			Personagem pacman = new Pacman(lab.getSpawnPacman(0), lab.getSpawnPacman(1));
			Personagem fantasma = new Fantasma(lab.getSpawnFantasma(0), lab.getSpawnFantasma(1));
			pacman.spawn();
			fantasma.spawn();
	        while(true){
				if (start() == true){
				    pacman.move();
			        fantasma.move();
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
        } catch (Exception e){}
    }
}
