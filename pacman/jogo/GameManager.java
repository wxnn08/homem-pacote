package jogo;
import java.util.concurrent.TimeUnit;

public class GameManager {

    private static int pontos;
    private Labirinto lab;
    private int vidas;

    public GameManager() throws Exception {
        lab = new Labirinto();
        setVidas(3);;
        setPontos(0);;
    }

    public void setVidas(int n) {
        this.vidas = n;
    }

    public int getVidas() {
        return this.vidas;
    }

    public static void setPontos(int n) {
        pontos += n;
    }

    public int getPontos() {
        return pontos;
    }

    static void clear () {
		System.out.print("\033[H\033[2J");
		System.out.flush();
    }

    void tela() {
        System.out.println("Vidas: "+getVidas());
        lab.mostrarLabirinto();
        System.out.println("Pontuação: "+getPontos());
    }

    public void play(){
        try{
            Controle c = new Controle(lab);
            Personagem pacman = new Pacman(lab, lab.getPosPacman(0), lab.getPosPacman(1));
            Personagem fantasma = new Fantasma(lab, lab.getPosFantasma(0), lab.getPosFantasma(1));
			pacman.spawn();
			fantasma.spawn();
            while(true){
                pacman.move();
                fantasma.move();
                clear();
                tela();
                TimeUnit.MILLISECONDS.sleep(150);
            }
        } catch (Exception e){}
    }
}
