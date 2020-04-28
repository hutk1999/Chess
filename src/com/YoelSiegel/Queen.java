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
    public void whatPiece(){
        System.out.print("queen");
    }
}
