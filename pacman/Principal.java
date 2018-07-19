import jogo.*;

public class Principal {
	public static void main(String[] args) throws Exception {
		Labirinto l = new Labirinto(15, 15);
		
		GameManager gm = new GameManager((l));
		gm.play();
	
	}
}
