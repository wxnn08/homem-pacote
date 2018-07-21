package jogo;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controle extends JFrame implements KeyListener{

    static int activedkey;
	Labirinto labirinto;

    public Controle(Labirinto l){
		this.labirinto = l;
        setSize(0,0);
        setVisible(true);
        addKeyListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	private boolean permitedChange(int dir){
		int x = Pacman.posx;
		int y = Pacman.posy;
		if (dir == 1) return (labirinto.getCasa(x-1,y) != '\u2588'); //esq
		if (dir == 2) return (labirinto.getCasa(x,y-1) != '\u2588'); //cima
		if (dir == 3) return (labirinto.getCasa(x+1,y) != '\u2588'); //dir
		if (dir == 4) return (labirinto.getCasa(x,y+1) != '\u2588'); //baixo
		return false;
	}

	public void keyPressed(KeyEvent e){
	    int catched = e.getKeyCode();
	    if (catched == 37 && permitedChange(1)) Controle.setActivedKey(37); //seta esq.
	    else if (catched == 38 && permitedChange(2)) Controle.setActivedKey(38); //seta cima
	    else if (catched == 39 && permitedChange(3)) Controle.setActivedKey(39); //seta dir.
	    else if (catched == 40 && permitedChange(4)) Controle.setActivedKey(40); //seta baixo
	}

    public static void setActivedKey(int key){
        Controle.activedkey = key;
    }

    //metodos da interface que não utilizaremos
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
    //

}
