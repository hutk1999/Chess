package com.YoelSiegel;

public class Pawn extends Piece {

    private String type ="Pawn";
    private int z=0;
    private int originalPlacement=0;
    public Pawn(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y);
        if(pieceColor==PieceColor.WHITE){
            setZ(-1);
            setOriginalPlacement(6);
        }
        else{
            setZ(1);
            setOriginalPlacement(1);
        }
    }


    public int getZ() {
        return z;
    }

    public int getOriginalPlacement() {
        return originalPlacement;
    }

    public void setOriginalPlacement(int originalPlacement) {
        this.originalPlacement = originalPlacement;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void movePiece(Board temp, int x, int y){
        if(getY()==getOriginalPlacement()) {
             if (!temp.getChessboard()[getX() + getZ()][getY()].isPieceOn()) {
                 int doubleJump=1;
                 if(y==(getOriginalPlacement() + getZ()*2) && !temp.getChessboard()[getX() + getZ()*2][getY()].isPieceOn()){
                     doubleJump=2;
                 }
                 else{
                     System.out.println("illegal move");
                     return;
                 }

                System.out.println("can move legally");
                temp.getChessboard()[getX() + (getZ()*doubleJump)][getY()] = temp.getChessboard()[getX()][getY()];
                temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[getX() + (getZ()*doubleJump)][getY()].setPieceOn(true);
                setX(getX() + (getZ()*doubleJump));
            }
        }
        else {
            System.out.println("this move is illegal");
        }
    }
        public void attackPiece(Board temp, int x, int y){
        if((getY()+1) == y) {
            if ((temp.getChessboard()[getX() + getZ()][getY() + 1].isPieceOn()) && (temp.getChessboard()[getX() + getZ()][getY() + 1].getPiece().getPieceColor() != getPieceColor())) {
                temp.getChessboard()[getX() + getZ()][getY() + 1].setPiece(this);
                temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[getX() + 1][getY() + getZ()].setPieceOn(true);
                setX(getX() + getZ());
                setY(getY() + 1);
            }
        }
        else if((getY()-1) == y){
                if ((temp.getChessboard()[getX() + getZ()][getY() - 1].isPieceOn()) && (temp.getChessboard()[getX() + getZ()][getY() - 1].getPiece().getPieceColor() != getPieceColor())) {
                    temp.getChessboard()[getX() + getZ()][getY() - 1].setPiece(this);
                    temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[getX() + getZ()][getY() - 1].setPieceOn(true);
                    setX(getX() + getZ());
                    setY(getY() - 1);
                }
        }
        else
            System.out.println("that move is illegal");

        }
    public void whatPiece(){
        System.out.print("pawn" + getPieceColor());
    }

    public void printPeice(){
        System.out.println("X="+getX());
        System.out.println("y="+getY());
        System.out.println("The piece is a "+getType());
        System.out.println("The piece color is "+ getPieceColor());
    }


}
