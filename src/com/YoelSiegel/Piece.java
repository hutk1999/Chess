package com.YoelSiegel;

public class Piece {
    protected boolean pieceColor;
    int x;
    int y;
    protected boolean isalive;

    public Piece(boolean pieceColor, int x, int y) {
        this.pieceColor = pieceColor;
        this.x = x;
        this.y = y;
        isalive=true;
    }

    public boolean isPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(boolean pieceColor) {
        this.pieceColor = pieceColor;
    }

    public void movePiece(Board temp){
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void whatPiece(){

    }
}
