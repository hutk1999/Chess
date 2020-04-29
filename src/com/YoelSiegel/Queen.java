package com.YoelSiegel;

public class Queen extends Piece{

    private String type="Queen";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Queen(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y);
    }
    public void printPiece() {
        System.out.print(this.getPieceColor()==PieceColor.WHITE?"w":"b");
        System.out.print("q ");
    }
}
