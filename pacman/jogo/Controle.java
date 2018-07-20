package jogo;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controle extends JFrame implements KeyListener{

    static int activedkey;
   
    public Controle(){
        setSize(0,0);
        setVisible(true);
        addKeyListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void keyPressed(KeyEvent e){
        int catched = e.getKeyCode();
        if (catched == 37) Controle.setActivedKey(37); //seta esq.
        else if (catched == 38) Controle.setActivedKey(38); //seta cima
        else if (catched == 39) Controle.setActivedKey(39); //seta dir.
        else if (catched == 40) Controle.setActivedKey(40); //seta baixo
    }
    
    public static void setActivedKey(int key){
        Controle.activedkey = key;
    }
    
    //metodos da interface que não utilizaremos
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
    //

}
