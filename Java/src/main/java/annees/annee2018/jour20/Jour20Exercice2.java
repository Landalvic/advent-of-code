package annees.annee2018.jour20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.util.FileUtils;

public class Jour20Exercice2 {

	public static void main(String[] args) {
		String cheminStr = FileUtils.lireFichier("./jour20/data.txt").get(0);
		List<Piece> sauvegarde = new ArrayList<>();
		HashMap<Position, Piece> pieces = new HashMap<>();
		Piece depart = new Piece(0, 0);
		Piece enCours = depart;
		for (int i = 1; i < cheminStr.length() - 1; i++) {
			if (StringUtils.equalsIgnoreCase("" + cheminStr.charAt(i), "N")) {
				Piece piece = nouvellePiece(pieces, enCours.getPositionX(), enCours.getPositionY() - 1);
				enCours.setPieceNord(piece);
				piece.setPieceSud(enCours);
				enCours = piece;
			} else if (StringUtils.equalsIgnoreCase("" + cheminStr.charAt(i), "E")) {
				Piece piece = nouvellePiece(pieces, enCours.getPositionX() + 1, enCours.getPositionY());
				enCours.setPieceEst(piece);
				piece.setPieceOuest(enCours);
				enCours = piece;
			} else if (StringUtils.equalsIgnoreCase("" + cheminStr.charAt(i), "S")) {
				Piece piece = nouvellePiece(pieces, enCours.getPositionX(), enCours.getPositionY() + 1);
				enCours.setPieceSud(piece);
				piece.setPieceNord(enCours);
				enCours = piece;
			} else if (StringUtils.equalsIgnoreCase("" + cheminStr.charAt(i), "W")) {
				Piece piece = nouvellePiece(pieces, enCours.getPositionX() - 1, enCours.getPositionY());
				enCours.setPieceOuest(piece);
				piece.setPieceEst(enCours);
				enCours = piece;
			} else if (StringUtils.equalsIgnoreCase("" + cheminStr.charAt(i), "(")) {
				sauvegarde.add(0, enCours);
			} else if (StringUtils.equalsIgnoreCase("" + cheminStr.charAt(i), "|")) {
				enCours = sauvegarde.get(0);
			} else if (StringUtils.equalsIgnoreCase("" + cheminStr.charAt(i), ")")) {
				enCours = sauvegarde.remove(0);
			}
		}

		List<Piece> cheminDepart = new ArrayList<>();
		cheminDepart.add(depart);
		List<List<Piece>> chemins = new ArrayList<>();
		List<List<Piece>> newChemins = new ArrayList<>();
		chemins.add(cheminDepart);
		newChemins.add(cheminDepart);
		List<Piece> piecesDejaVues = new ArrayList<>();
		piecesDejaVues.add(depart);
		int nbrPiecesLoins = 0;
		while (newChemins.size() != 0) {
			chemins = newChemins;
			newChemins = new ArrayList<>();
			for (List<Piece> chemin : chemins) {
				for (Piece pieceAdjacente : chemin.get(chemin.size() - 1).piecesAdjacentes()) {
					if (!piecesDejaVues.contains(pieceAdjacente)) {
						List<Piece> newChemin = new ArrayList<>(chemin);
						newChemin.add(pieceAdjacente);
						piecesDejaVues.add(pieceAdjacente);
						newChemins.add(newChemin);
						if (newChemin.size() >= 1001) {
							nbrPiecesLoins++;
						}
					}
				}
			}
		}
		System.out.println(nbrPiecesLoins);
	}

	private static Piece nouvellePiece(HashMap<Position, Piece> pieces, int positionX, int positionY) {
		Piece piece = pieces.get(new Position(positionX, positionY));
		if (piece == null) {
			piece = new Piece(positionX, positionY);
			pieces.put(piece.getPosition(), piece);
		}
		return piece;
	}

}
