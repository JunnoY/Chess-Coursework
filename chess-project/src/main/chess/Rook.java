package chess;

public class Rook extends Piece{
	private PieceColour colour;
	private String symbol;

	public Rook(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♖";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♜";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

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

		//move up and down
		if(j1==j0){
			if(i1>i0){
				for (int i=i0+1; i<i1; i++){
					if (Board.hasPiece(i,j0)){
						vacant_path = false;
						break;
					}
				}
			}

			else if (i1<i0){
				for (int i=i0-1; i>i1; i--){
					if (Board.hasPiece(i,j0)){
						vacant_path = false;
						break;
					}
				}
			}

		}
		//move left and right
		else if(i1==i0){
			if(j1>j0){
				for (int j=j0+1; j<j1; j++){
					if (Board.hasPiece(i0,j)){
						vacant_path = false;
						break;
					}
				}
			}
			else if (j1<j0){
				for (int j=j0-1; j>j1; j--){
					if (Board.hasPiece(i0,j)){
						vacant_path = false;
						break;
					}
				}
			}

		}

		return (i1==i0|j1==j0)&&vacant_path&&enermy;// now if the piece stays where it is, it is valid

}

}

