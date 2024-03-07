import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.type.NullType;

public class Board {
	private int boardSize = 5;
	private Orb[][] board = new Orb[boardSize][boardSize];
	private int score = 0;

	public Board() {

		for (int i = 0; i < this.boardSize; i++) {
			for (int j = 0; j < this.boardSize; j++) {

				this.board[i][j] = new Orb();
			}
		}
	}

	public Board(Orb[][] rows) {

		this.board = rows;

	}

	public boolean isAnyMatch() {
		boolean match=false;
		int rowCounter = 1;
		boolean rowMatch = false;
		boolean colMatch=false;
		int colCounter=1;
		for (int i = 0; i < this.boardSize; i++) {
			rowCounter = 1;
			colCounter=1;
			colMatch=false;
			rowMatch = false;
			for (int j = 0; j < this.board[i].length - 1; j++) {
				if (this.board[i][j].getColor() == this.board[i][j + 1].getColor()) {
					rowMatch = true;
					rowCounter++;
				} else {
					if (!(rowCounter >= 3)) {
						rowCounter = 1;
						rowMatch = false;
					}
				}
			}
			if (rowCounter >= 3) {
				match=true;
				System.out.println("Match at row level");
			}
			for(int j=0;j<this.board[i].length-1;j++) {
				if (this.board[j][i].getColor() == this.board[j+1][i].getColor()) {
					colMatch = true;
					colCounter++;
				} else {
					if (!(colCounter >= 3)) {
						colCounter = 1;
						colMatch = false;
					}
				}
			}
			if (colCounter >= 3) {
				match=true;
				System.out.println("Match at column level");
			}
		}
		
		return match;
	}

	public void move(int row, int column, String direction) {

		switch (direction) {
		case "up":
			Orb temp = this.board[row][column];
			this.board[row][column] = this.board[row - 1][column];
			this.board[row - 1][column] = temp;
			this.isAnyMatch();
			// moveAllowed(row,column,direction)
			break;
		case "down":
			temp = this.board[row][column];
			this.board[row][column] = this.board[row + 1][column];
			this.board[row + 1][column] = temp;
			this.isAnyMatch();

			// isMoveAllowed(row,column,direction)
			break;
		case "right":
			temp = this.board[row][column];
			this.board[row][column] = this.board[row][column + 1];
			this.board[row][column + 1] = temp;
			this.isAnyMatch();

			// isMoveAllowed(row,column,direction)
			break;
		case "left":
			temp = this.board[row][column];
			this.board[row][column] = this.board[row][column - 1];
			this.board[row][column - 1] = temp;
			this.isAnyMatch();

			// isMoveAllowed(row,column,direction)
			break;
		}

	}

	public boolean isMOveAllowed(int row, int column, String direction) {

		return false;
	}

	@Override
	public String toString() {
		String board = "";
		for (int i = 0; i < this.boardSize; i++) {
			for (int j = 0; j < this.boardSize; j++) {

				board += this.board[i][j] + " ";

			}
			board += "\n";
		}
		return board;
	}

	public static void main(String[] args) {

//		Board board = new Board();
		Orb[][] rows = Orb.orbArray();
		rows[0][0].setColor("Red");
		rows[1][0].setColor("Red");
		rows[2][0].setColor("Red");

		Board board = new Board(rows);
		System.out.println(board);
		Scanner input = new Scanner(System.in);
		System.out.print("Direction👉");
		var direction = input.nextLine();
		System.out.print("row👉");
		var row = input.nextInt();
		System.out.print("column👉");
		var column = input.nextInt();
		System.out.println();
		board.move(row, column, direction);
		System.out.println(board);
	}
}
