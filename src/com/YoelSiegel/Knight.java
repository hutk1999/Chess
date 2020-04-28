package com.YoelSiegel;

public class Knight extends Piece {

    private String type="Knight";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Knight(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y);
    }
    public void whatPiece(){
        System.out.print("knight");
    }
}
