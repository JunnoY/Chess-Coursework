package chess;

public class Knight extends Piece{
	private PieceColour colour;
	private String symbol;

 	public Knight(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♘";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♞";
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
		int absolute_i = Math.abs(i1 - i0);
		int absolute_j = Math.abs(j0 - j1);
		boolean s1 = absolute_i == 1 && absolute_j == 2;
		boolean s2 = absolute_i == 2 && absolute_j == 1;
		boolean enermy = true;
		if (Board.hasPiece(i1,j1)) {
			if(Board.getPiece(i0,j0).getColour().toString().equals(Board.getPiece(i1,j1).getColour().toString())){
					enermy = false;
			}
			else{
				enermy = true;
			}
			
		}
		return (s1 | s2) && enermy;
		//knight can pass through any pieces, so no need to check vacant
	}
}
