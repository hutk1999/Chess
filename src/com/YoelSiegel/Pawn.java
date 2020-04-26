package com.YoelSiegel;

public class Pawn extends Piece {

    private String type ="Pawn";

    public Pawn(boolean pieceColor, int x, int y) {
        super(pieceColor, x, y);
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void movePiece(Board temp){
        System.out.println(getX() + "" + getY());
        if(!temp.getChessboard()[getX() + 1][getY()].isPieceOn()){
            System.out.println("can move legally");
            temp.getChessboard()[getX()+1][getY()]= temp.getChessboard()[getX()][getY()];
            temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].isTileColor());
            temp.getChessboard()[getX()+1][getY()].setPieceOn(true);
            setX(getX()+1);
        }
        else
            System.out.println("this move is illegal");

            }
        public void attackpiece(Board temp){
        System.out.println(getX()+" "+getY());
        if ((temp.getChessboard()[getX()+1][getY()+1].isPieceOn())&&(temp.getChessboard()[getX()+1][getY()+1].getPiece().pieceColor!=pieceColor)){
            System.out.println("you can eat away");
            temp.getChessboard()[getX()+1][getY()+1].getPiece().x=100;
            temp.getChessboard()[getX()+1][getY()+1].getPiece().y=100;
            temp.getChessboard()[getX()+1][getY()+1].setPiece(null);
            temp.getChessboard()[getX()+1][getY()+1]= temp.getChessboard()[getX()][getY()];
            temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].isTileColor());
            temp.getChessboard()[getX()+1][getY()+1].setPieceOn(true);
            setX(getX()+1);
            setY(getY()+1);
        }
        else if ((temp.getChessboard()[getX()+1][getY()-1].isPieceOn())&&(temp.getChessboard()[getX()+1][getY()-1].getPiece().pieceColor!=pieceColor)) {
            System.out.println("you can eat away");
            temp.getChessboard()[getX() + 1][getY() - 1].getPiece().x = 100;
            temp.getChessboard()[getX() + 1][getY() - 1].getPiece().y = 100;
            temp.getChessboard()[getX() + 1][getY() - 1].getPiece().isalive = false;
            temp.getChessboard()[getX() + 1][getY() - 1] = temp.getChessboard()[getX()][getY()];
            temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].isTileColor());
            temp.getChessboard()[getX() + 1][getY() - 1].setPieceOn(true);
            setX(getX() - 1);
            setY(getY() - 1);
        }
        else
            System.out.println("that move is illegal");

        }
    public void whatPiece(){
        System.out.print("pawn");
    }

    public void printPeice(){
        System.out.println("X="+getX());
        System.out.println("y="+getY());
        System.out.println("The piece is a "+getType());
        System.out.println("The piece color is "+isPieceColor());
    }


}
