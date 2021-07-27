package application;

import java.util.Scanner;

import game.Velha;

public class Program {
public static void main(String[] args) {
		
		Velha velha = new Velha();
		Scanner scan = new Scanner(System.in);
		char flag;
		boolean winner = false;
		
		System.out.println("Jogador 1 = x");
		System.out.println("Jogador 2 = o");
		
		int row, colunm;
		
		while(!winner) {
			if(velha.currentPlayer1()) {
				System.out.println("Vez do jogador 1");
				flag = 'x';
			}
			else {
				System.out.println("Vez do jogador 2");
				flag = 'o';
			}
			
			row = velha.validateValue("linha", scan);
			colunm = velha.validateValue("coluna", scan);
			
			velha.validateMove(row, colunm, flag);
			
			velha.printBoard();
			
			if(velha.winner('x')) {
				winner = true;
				System.out.println("Jogador 1 venceu");
			}
			else if(velha.winner('o')) {
				winner = true;
				System.out.println("Jogador 2 venceu");
			}
			else if(velha.getCurrentPlayer() > 9) {
				winner = true;
				System.out.println("EMPATE");
			}
		}
	}
}
