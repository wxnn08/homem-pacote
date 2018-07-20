package jogo;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controle extends JFrame implements KeyListener{
    //metodos da interface que não utilizaremos
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
    //

    Labirinto l = new Labirinto(15,15);
    GameManager gm = new GameManager(l);

    int posy;
    int posx;
    int activedkey;

    public Controle()throws Exception {
        setSize(0,0);
        setVisible(true);
        addKeyListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void keyPressed(KeyEvent e){
        int catched = e.getKeyCode();
        if (catched == 37) setActivedKey(37); //seta esq.
        else if (catched == 38) setActivedKey(38); //seta cima
        else if (catched == 39) setActivedKey(39); //seta dir.
        else if (catched == 40) setActivedKey(40); //seta baixo
    }
    
    public void setActivedKey(int key){
        this.activedkey = key;
    }

    public void mover(){
        if (activedkey == 37) { //seta esq.
            if (posx > 0){
                l.mudarQuadrado('#', posy, posx);
                l.mudarQuadrado('C', posy, posx-1);
                posx--; 
            }
        }
        else if (activedkey == 38) { //seta cima
            if (posy > 0){
                l.mudarQuadrado('#', posy, posx);
                l.mudarQuadrado('C', posy-1, posx);
                posy--; 
            }
        }
        else if (activedkey == 39){ //seta dir.
            if (posx < l.getLargura()-1){
                l.mudarQuadrado('#', posy, posx);
                l.mudarQuadrado('C', posy, posx+1);
                posx++; 
            }
        }
        else if (activedkey == 40){ //seta baixo
            if (posy < l.getAltura()-1){
                l.mudarQuadrado('#', posy, posx);
                l.mudarQuadrado('C', posy+1, posx);
                posy++; 
            }
        }
    }
}
