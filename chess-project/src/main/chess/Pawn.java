package chess;

public class Pawn extends Piece{
	private PieceColour colour;
	private String symbol;

	public Pawn(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♙";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♟";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		boolean valid_pos_white = (i1 == i0 - 1 && j1 == j0 - 1) | (i1 == i0 - 1 && j1 == j0 + 1);
		boolean valid_pos_black = (i1 == i0 + 1 && j1 == j0 - 1) | (i1 == i0 + 1 && j1 == j0 + 1);
		// because our board starts from top(1) to bottom(8)
		//for pawn to go forward only we do j1==j0-1
		boolean enermy = false;
		if (Board.hasPiece(i1,j1)) {
			if(Board.getPiece(i0,j0).getColour().toString().equals(Board.getPiece(i1,j1).getColour().toString())){
					enermy = false;
			}
			else{
				enermy = true;
			}
		}
		
		
		boolean valid_cond = false;

		if(Board.getPiece(i0,j0).getColour().toString().equals("WHITE")){

			//white move upward 1 sqaure
		if (i1 == (i0-1) && j1 == j0) {
			if (!Board.hasPiece(i1, j1)) {
				valid_cond = true;
			}
		}
		//white move upward 2 squares
		else if (i1 == (i0 - 2)&&j0 == j1 ) {
			if (!(Board.hasPiece(i1-2, j0) && Board.hasPiece(i1+2, j0))) {
				valid_cond = true;
			}
		}
		// move diagonal
		else if (valid_pos_white && enermy) {
			valid_cond = true;
		}

		}

		if(Board.getPiece(i0,j0).getColour().toString().equals("BLACK")){

			//black move downward 1 sqaure
		if (i1 == (i0+1) && j1 == j0) {
			if (!Board.hasPiece(i1, j1)) {
				valid_cond = true;
			}
		}
		//black move downward 2 squares
		else if (i1 == (i0 + 2)&&j0 == j1 ) {
			if (!(Board.hasPiece(i1+2, j0) && Board.hasPiece(i1+2, j0))) {
				valid_cond = true;
			}
		}
		// move diagonal
		else if (valid_pos_black && enermy) {
			valid_cond = true;
		}

		}

		

		return valid_cond;
	}
}
