package jogo;
import java.util.concurrent.TimeUnit;


public class GameManager {

    private int pontos;
    private Labirinto lab;
    private int vidas;

    public GameManager(int altura, int largura) throws Exception {
        lab = new Labirinto(altura, largura);
        setVidas(3);;
        setPontos(0);;
    }
    
    public void setVidas(int n) {
        this.vidas = n;
    }

    public int getVidas() {
        return this.vidas;
    }

    public void setPontos(int n) {
        this.pontos = n;
    }

    public int getPontos() {
        return this.pontos;
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
            Controle c = new Controle();
            Personagem pacman = new Pacman(lab);
            while(true){
                pacman.mover();
                clear();
                tela();
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (Exception e){}
    }
}

