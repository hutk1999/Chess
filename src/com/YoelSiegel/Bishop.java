package com.YoelSiegel;

public class Bishop extends Piece {
    private String type ="Bishop";

    public Bishop(boolean pieceColor, int x, int y) {
        super(pieceColor, x, y);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void movePiece(Board temp){

    }

    public void whatPiece(){
        System.out.print("bishop");
    }
}
