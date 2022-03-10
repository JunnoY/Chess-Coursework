package chess;

public class Bishop extends Piece{
	private PieceColour colour;
	private String symbol;

	public Bishop(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♗";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♝";
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
		boolean enermy = true;
		if (Board.hasPiece(i1,j1)) {
			if(Board.getPiece(i0,j0).getColour().toString().equals(Board.getPiece(i1,j1).getColour().toString())){
					enermy = false;
			}
			else{
				enermy = true;
			}
			
		}

		boolean vacant_path = true;
		//SE
		if (i1 > i0 && j1 > j0) {
			for (int i = i0 + 1; i < i1; i++) {
				for (int j = j0 + 1; j < j1; j++) {
					if (Board.hasPiece(i, j)&&Math.abs(i-i0) == Math.abs(j-j0)) {
						vacant_path = false;
						break;
					}
				}
			}
		}
		//NW
		else if (i1 < i0 && j1 < j0) {
			for (int i = i0 - 1; i > i1; i--) {
				for (int j = j0 - 1; j > j1; j--) {
					if (Board.hasPiece(i, j)&&Math.abs(i-i0) == Math.abs(j-j0)) {
						vacant_path = false;
						break;
					}
				}
			}
		}
		//SW
		else if (i1 > i0 && j1 < j0) {
			for (int i = i0 + 1; i < i1; i++) {
				for (int j = j0 - 1; j > j1; j--) {
					if (Board.hasPiece(i, j)&&Math.abs(i-i0) == Math.abs(j-j0)) {
						vacant_path = false;
						break;
					}
				}
			}
		}
		//NE
		else if (i1 < i0 && j1 > j0) {
			for (int i = i0 - 1; i > i1; i--) {
				for (int j = j0 + 1; j < j1; j++) {
					if (Board.hasPiece(i, j)&&Math.abs(i-i0) == Math.abs(j-j0)) {
						vacant_path = false;
						break;
					}
				}
			}
		}


		return (Math.abs(i1-i0) == Math.abs(j0-j1) && vacant_path && enermy);
	}
}
