package jogo;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controle extends JFrame implements KeyListener{

    private static int activedKey;
	Labirinto lab = GameManager.lab;

    public Controle(){
        setSize(0,0);
        setVisible(true);
        addKeyListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	static void setActivedKey(int key){
		activedKey = key;
	}

	static int getActivedKey(){
		return activedKey;
	}

	private boolean permitedChange(int dir){
		int y = Pacman.getPositions()[0];
		int x = Pacman.getPositions()[1];
		if (dir == 1) return (lab.getQuadrado(x-1,y) != '\u2588'); // Esquerda
		if (dir == 2) return (lab.getQuadrado(x,y-1) != '\u2588'); // Cima
		if (dir == 3) return (lab.getQuadrado(x+1,y) != '\u2588'); // Direita
		if (dir == 4) return (lab.getQuadrado(x,y+1) != '\u2588'); // Baixo
		return false;
	}

	public void keyPressed(KeyEvent e){
	    int catched = e.getKeyCode();
	    if (catched == 37 && permitedChange(1)) setActivedKey(37); // Seta esq.
	    else if (catched == 38 && permitedChange(2)) setActivedKey(38); // Seta cima
	    else if (catched == 39 && permitedChange(3)) setActivedKey(39); // Seta dir.
	    else if (catched == 40 && permitedChange(4)) setActivedKey(40); // Seta baixo
	}

    //metodos da interface que não utilizaremos
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}

}
