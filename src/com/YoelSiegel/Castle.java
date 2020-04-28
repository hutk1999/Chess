package com.YoelSiegel;

public class Castle extends Piece {

    private String type="Castle";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Castle(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y);
    }
    public void whatPiece(){
        System.out.print("castle");
    }
}

//this is to
