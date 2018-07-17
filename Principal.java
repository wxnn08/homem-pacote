import jogo.*;

public class Principal {
	public static void main(String[] args) {
		Labirinto l = new Labirinto(20);
		
		GameManager gm = new GameManager((l));
		gm.Play();
	
	}
}
