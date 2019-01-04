package annee.annee2018.jour20;

import java.util.ArrayList;
import java.util.List;

public class Piece {

	private Position position;
	private Piece pieceNord;
	private Piece pieceSud;
	private Piece pieceOuest;
	private Piece pieceEst;

	public Piece(int positionX, int positionY) {
		super();
		this.position = new Position(positionX, positionY);
	}

	public List<Piece> piecesAdjacentes() {
		List<Piece> pieces = new ArrayList<>(4);
		if (pieceEst != null) {
			pieces.add(pieceEst);
		}
		if (pieceSud != null) {
			pieces.add(pieceSud);
		}
		if (pieceNord != null) {
			pieces.add(pieceNord);
		}
		if (pieceOuest != null) {
			pieces.add(pieceOuest);
		}
		return pieces;
	}

	public int getPositionX() {
		return position.getPositionX();
	}

	public int getPositionY() {
		return position.getPositionY();
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Piece getPieceNord() {
		return pieceNord;
	}

	public void setPieceNord(Piece pieceNord) {
		this.pieceNord = pieceNord;
	}

	public Piece getPieceSud() {
		return pieceSud;
	}

	public void setPieceSud(Piece pieceSud) {
		this.pieceSud = pieceSud;
	}

	public Piece getPieceOuest() {
		return pieceOuest;
	}

	public void setPieceOuest(Piece pieceOuest) {
		this.pieceOuest = pieceOuest;
	}

	public Piece getPieceEst() {
		return pieceEst;
	}

	public void setPieceEst(Piece pieceEst) {
		this.pieceEst = pieceEst;
	}

}
