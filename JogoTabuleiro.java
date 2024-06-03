package prjGame.pctjogo;

import java.util.Random;
import java.util.Scanner;

public class JogoTabuleiro {
	public static void main(String[] args) {
		final int NUM_CASAS = 30;
		final int AVANCO_SORTE = 2;
		final int RECUSA_AZAR = 2;

		boolean jogoTerminado = false;
		int posicaoJogador1 = 0;
		int posicaoJogador2 = 0;
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		// Jogo principal
		while (!jogoTerminado) {
			// Turno do jogador 1
			System.out.println("Jogador 1, pressione Enter para jogar o dado.");
			scanner.nextLine();
			int dado = random.nextInt(6) + 1;
			posicaoJogador1 += dado;
			if (posicaoJogador1 >= NUM_CASAS) {
				System.out.println("Jogador 1 venceu!");
				jogoTerminado = true;
				break;
			}
			System.out.println("Jogador 1 rolou " + dado + " e está na posição " + posicaoJogador1);
			int resultadoCasa = verificarCasa(posicaoJogador1);
			if (resultadoCasa == 1) {
				System.out.println("Casa de sorte! Avance 2 casas.");
				posicaoJogador1 += AVANCO_SORTE;
			} else if (resultadoCasa == -1) {
				System.out.println("Casa de azar! Volte 2 casas.");
				posicaoJogador1 -= RECUSA_AZAR;
			}

			// Turno do jogador 2
			System.out.println("Jogador 2, pressione Enter para jogar o dado.");
			scanner.nextLine();
			dado = random.nextInt(6) + 1;
			posicaoJogador2 += dado;
			if (posicaoJogador2 >= NUM_CASAS) {
				System.out.println("Jogador 2 venceu!");
				jogoTerminado = true;
				break;
			}
			System.out.println("Jogador 2 rolou " + dado + " e está na posição " + posicaoJogador2);
			resultadoCasa = verificarCasa(posicaoJogador2);
			if (resultadoCasa == 1) {
				System.out.println("Casa de sorte! Avance 2 casas.");
				posicaoJogador2 += AVANCO_SORTE;
			} else if (resultadoCasa == -1) {
				System.out.println("Casa de azar! Volte 2 casas.");
				posicaoJogador2 -= RECUSA_AZAR;
			}
		}

		scanner.close();
	}

	// Função para verificar casas de sorte e azar usando switch-case
	public static int verificarCasa(int posicao) {
		switch (posicao) {
		// Casas de sorte
		case 3:
		case 7:
		case 11:
		case 15:
		case 18:
		case 21:
		case 23:
		case 25:
		case 27:
		case 29:
			return 1;
		// Casas de azar
		case 2:
		case 5:
		case 8:
		case 12:
		case 14:
		case 16:
		case 19:
		case 22:
		case 24:
		case 28:
			return -1;
		// Casa neutra
		default:
			return 0;
		}
	}
}
