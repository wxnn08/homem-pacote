import jogo.*;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int numeroFantasmas, mapa, modo;

		System.out.print("\033[H\033[2J");
		System.out.flush();

		numeroFantasmas = escolhaNumeroFantasmas(sc);
		mapa = escolhaMapa(sc);
		modo = escolhaDificuldade(sc);

		GameManager gm = new GameManager(numeroFantasmas, mapa, modo);
		gm.play();
	}

	public static int escolhaNumeroFantasmas(Scanner sc) {
		System.out.print("Digite o número de fantasmas: ");
		return sc.nextInt();
	}

	public static int escolhaMapa(Scanner sc) {
		int tipoMapa;
		while(true) {
			System.out.println(' ');
			System.out.println("Mapa 1: Original\nMapa 2: Pequeno\nMapa 3: Médio\nMapa 4: Grande\nMapa 5: ...");
			System.out.print("Escolha o mapa: ");
			tipoMapa = sc.nextInt();
			if (tipoMapa > 0 && tipoMapa < 6) 
				return tipoMapa;
			System.out.println("Por favor, digite um mapa válido.");
		}

	}

	public static int escolhaDificuldade(Scanner sc) {
		int dificuldade;
		while(true){
			System.out.println(' ');
			System.out.println("1: Fácil\n2: Moderado\n3: Difícil\n4: Insano");
			System.out.print("Escolha a dificuldade: ");
			dificuldade = sc.nextInt();
			if (dificuldade > 0 && dificuldade < 5) 
				return dificuldade;
			System.out.println("Por favor, digite uma dificuldade válida.");
		}

	}
}
