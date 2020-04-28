package com.YoelSiegel;

public class Bishop extends Piece {
    private String type ="Bishop";

    public Bishop(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y);
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

    public void movePiece(Board temp, int x, int y) {

    }








}
