import jogo.*;
import java.util.Scanner;
import java.util.Random;

public class Principal {

	public static int escolhaNumeroFantasmas(Scanner sc) {
		System.out.print("Digite o número de fantasmas: ");
		return sc.nextInt();
	}

	public static int escolhaMapa(Scanner sc) {
		int tipoMapa;
		while(true) {
			System.out.println(' ');
			System.out.println("Mapa 1: Original\nMapa 2: Pequeno\nMapa 3: Médio\nMapa 4: Grande\nMapa 5: Hardcore\nMapa 6: Aleatório");
			System.out.print("Escolha o mapa: ");
			tipoMapa = sc.nextInt();
			if (tipoMapa > 0 && tipoMapa < 7){
				if (tipoMapa == 6){
					Random rand = new Random();
					tipoMapa = rand.nextInt(5)+1;
				}
				return tipoMapa;
			}
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

	public static boolean escolhaJogarNovamente(Scanner sc){
		char escolha;
		while(true) {	
			System.out.println(' ');
			System.out.print("Deseja jogar novamente? (S/N): ");
			escolha = sc.next().charAt(0);
			if (escolha == 'S' || escolha == 's') return true;
			if (escolha == 'N' || escolha == 'n') return false;
			System.out.println("Por favor, digite uma resposta válida.");
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int numeroFantasmas, mapa, modo;
		while(true){
			System.out.print("\033[H\033[2J");
			System.out.flush();

			numeroFantasmas = escolhaNumeroFantasmas(sc);
			mapa = escolhaMapa(sc);
			modo = escolhaDificuldade(sc);

			GameManager gm = new GameManager(numeroFantasmas, mapa, modo);
			gm.play();

			if(escolhaJogarNovamente(sc) == false) System.exit(0);
		}
	}

}
