package game;

import java.util.Scanner;

public class Velha {
	
	private char [][] velha = new char [3][3];
	private int currentPlayer = 1;
	
	public char[][] getVelha() {
		return velha;
	}

	public void setVelha(char[][] velha) {
		this.velha = velha;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public boolean currentPlayer1() {
		if(currentPlayer % 2 == 1) 
			return true;
		else
			return false;
	}
	
	public boolean validateMove(int row, int colunm, char flag) {
		if(velha[row][colunm] == 'x' || velha[row][colunm] == 'o')
			return false;
		else {
			velha[row][colunm] = flag;
			currentPlayer++;
			return true;
		}
	}
	
	public int validateValue(String typeValue, Scanner scan) {
		int value = 0;
		boolean validatedValue = false;
		System.out.println("Entre com " + typeValue + " (1,2,3)");
		value = scan.nextInt();
		while(!validatedValue) {
			if(value >= 1 && value <= 3)
				validatedValue = true;
			else
				System.out.println("Valor inapropriado, insira (1,2,3)");
		}
		value--;
		return value;
	}
	
	public void printBoard() {
		for (int i = 0; i < velha.length; i++) {
			for (int j = 0; j < velha.length; j++) {
				System.out.print(velha[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
	public boolean winner(char flag) {
		if((velha[0][0] == flag && velha[1][1] == flag && velha[2][2] == flag) ||
			(velha[0][2] == flag && velha[1][1] == flag && velha[0][2] == flag) ||
			(velha[0][0] == flag && velha[1][0] == flag && velha[2][0] == flag) ||
			(velha[0][1] == flag && velha[1][1] == flag && velha[2][1] == flag) ||
			(velha[0][2] == flag && velha[1][2] == flag && velha[2][2] == flag) ||
			(velha[0][0] == flag && velha[0][1] == flag && velha[0][2] == flag) ||
			(velha[1][0] == flag && velha[1][1] == flag && velha[1][2] == flag) ||
			(velha[2][0] == flag && velha[2][1] == flag && velha[2][2] == flag) 
			) 
			return true;
		
		else
			return false;
	}
}
