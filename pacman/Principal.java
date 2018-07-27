import jogo.*;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("\033[H\033[2J");
		System.out.flush();

		System.out.print("Digite o número de fantasmas: ");
		int numerofantasmas = sc.nextInt();

		GameManager gm = new GameManager(numerofantasmas);
		gm.play();
	}
}
