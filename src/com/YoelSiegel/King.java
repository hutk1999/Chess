package com.YoelSiegel;

public class King extends Piece {
    private String type="King";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public King(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y);
    }
    public void whatPiece(){
        System.out.print("king");
    }
}
