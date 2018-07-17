package jogo;
import java.util.concurrent.TimeUnit;

public class GameManager {

    int pontos;
    Labirinto lab;
    int vidas;

    public GameManager(Labirinto lab) {
        this.lab = lab;
        vidas = 3;
        pontos = 0;
    }

    private static void clear () {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

    public void Play() {

        GameManager.clear();
        while (vidas>0) {
			try {
				lab.mostrarLabirinto();
				TimeUnit.MILLISECONDS.sleep(33);
				GameManager.clear();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

    }
}
