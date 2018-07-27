import jogo.*;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int numerofantasmas, mapa, modo, aux;

		System.out.print("\033[H\033[2J");
		System.out.flush();

		System.out.print("Digite o número de fantasmas: ");
		numerofantasmas = sc.nextInt();

		while(true){
			System.out.println(' ');
			System.out.println("Mapa 1: Original\nMapa 2: Pequeno\nMapa 3: Médio\nMapa 4: Grande\nMapa 5: ...");
			System.out.print("Escolha o mapa: ");
			aux = sc.nextInt();
			if (aux > 0 && aux < 6) break;
			System.out.println("Por favor, digite um mapa válido.");
		}
		mapa = aux;

		while(true){
			System.out.println(' ');
			System.out.println("1: Fácil\n2: Moderado\n3: Difícil\n4: Insano");
			System.out.print("Escolha a dificuldade: ");
			aux = sc.nextInt();
			if (aux > 0 && aux < 5) break;
			System.out.println("Por favor, digite uma dificuldade válida.");
		}
		modo = aux;

		GameManager gm = new GameManager(numerofantasmas, mapa, modo);
		gm.play();
	}
}
