package com.YoelSiegel;


public class Tiles {
    private boolean isPieceOn;

    public boolean isPieceOn() {
        return isPieceOn;
    }

    public void setPieceOn(boolean pieceOn) {
        this.isPieceOn=pieceOn;
    }

    public Piece getPiece() {
        return piece;
    }
    private Piece piece;
    private boolean tileColor;

    public void setPiece(Piece piece) {
        this.piece = piece;
        if (piece==null)
            setPieceOn(false);
        else
            setPieceOn(true);
    }

    public boolean isTileColor() {
        return tileColor;
    }

    public void setTileColor(boolean tileColor) {

        if (tileColor) {
            this.tileColor = true;
            System.out.println("white");
        }
        else {
            this.tileColor = false;
            System.out.println("black");
        }
    }

    public Tiles(boolean tileColor){
        this.isPieceOn = false;
        this.piece = null;
        this.tileColor = tileColor;
    }

    public Tiles(boolean isPieceOn, Piece piece, boolean tileColor) {
        this.isPieceOn = isPieceOn;
        this.piece = piece;
        this.tileColor = tileColor;
    }
}
