package jogo;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controle extends JFrame implements KeyListener{

	private static int teclaAtiva;
	private Labirinto lab = GameManager.lab;

	public Controle(){	
		setSize(0,0);
		setVisible(true);
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	static private void setTeclaAtiva(int tecla){
		teclaAtiva = tecla;
	}

	static private int getTeclaAtiva(){
		return teclaAtiva;
	}

	private boolean podeMudar(int dir){
		int[] pacPos = Pacman.getPosicao();
		int y = pacPos[0];
		int x = pacPos[1];
		if (dir == 1) return (lab.getQuadrado(y,x-1) != '\u2588'); // Esquerda
		if (dir == 2) return (lab.getQuadrado(y-1,x) != '\u2588'); // Cima
		if (dir == 3) return (lab.getQuadrado(y,x+1) != '\u2588'); // Direita
		if (dir == 4) return (lab.getQuadrado(y+1,x) != '\u2588'); // Baixo
		return false;
	}

	public void keyPressed(KeyEvent e){
		int teclaApertada = e.getKeyCode();
		if (teclaApertada == 37 && podeMudar(1)) setTeclaAtiva(37); // Seta esq.
		else if (teclaApertada == 38 && podeMudar(2)) setTeclaAtiva(38); // Seta cima
		else if (teclaApertada == 39 && podeMudar(3)) setTeclaAtiva(39); // Seta dir.
		else if (teclaApertada == 40 && podeMudar(4)) setTeclaAtiva(40); // Seta baixo
	}

	//metodos da interface que não utilizaremos
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}

}
