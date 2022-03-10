package chess;

public class King extends Piece{
	private PieceColour colour;
	private String symbol;

	public King(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♔";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♚";
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
		//King can only one square, so doesnt need to check if its path is vacant
		boolean enermy = true;
		if (Board.hasPiece(i1,j1)) {
			if(Board.getPiece(i0,j0).getColour().toString().equals(Board.getPiece(i1,j1).getColour().toString())){
					enermy = false;
			}
			else{
				enermy = true;
			}
			
		}
		//the color of the piece being taken has to be the opposite to that of the one which attacks
		//situations like white pawn takes white pawn won't happen
		if (i0==i1+1|i0==i1-1|j1==j0+1|j1==j0-1&&enermy){
			return true;
		}
		else{
			return false;
		}
	}
}
