package com.YoelSiegel;

public class Pawn extends Piece {

    private String type = "Pawn";
    //z at 1 means you are black and at the top
    // z at -1 means you are white and at the bottom
    private int z = 0;
    private int originalPlacement = 0;


    public Pawn(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y);
        if (pieceColor == PieceColor.WHITE) {
            setZ(-1);
            setOriginalPlacement(6);
        } else {
            setZ(1);
            setOriginalPlacement(1);
        }
    }


    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getOriginalPlacement() {
        return originalPlacement;
    }

    public void setOriginalPlacement(int originalPlacement) {
        this.originalPlacement = originalPlacement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void printPiece() {
        System.out.print(this.getPieceColor() == PieceColor.WHITE ? "w" : "b");
        System.out.print("p ");
    }

    //need to merge these somehow
    //all important functions are here and down
    public void movePiece(Board temp, int x, int y) {
        if ((y == getY() + 1) || (y == getY() - 1)) {
            if((temp.getChessboard()[x][y].getPiece()==temp.arrofKings[0])||(temp.getChessboard()[x][y].getPiece()==temp.arrofKings[0])){
                if(temp.getChessboard()[getX()][getY()].getTileColor()==PieceColor.BLACK){
                    if((temp.getChessboard()[x][y].getPiece()==temp.arrofKings[1])){
                        System.out.println("This move endangers the white king");
                        return;
                    }
                }
                else{
                    if((temp.getChessboard()[x][y].getPiece()==temp.arrofKings[0])){
                        System.out.println("This move endangers the black king");
                        return;
                    }
                }

            }
            attackPiece(temp, x, y);
            return;
        }
        if (getX() == getOriginalPlacement()) {
            if (!temp.getChessboard()[getX() + getZ()][getY()].isPieceOn()) {
                int doubleJump = 1;
                if ((x == (getOriginalPlacement() + getZ() * 2)) && !temp.getChessboard()[getX() + getZ() * 2][getY()].isPieceOn()) {
                    doubleJump = 2;
                    temp.getChessboard()[getX() + (getZ() * 2)][getY()] = temp.getChessboard()[getX()][getY()];
                    temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[getX() + (getZ() * 2)][getY()].setPieceOn(true);
                    setX(getX() + (getZ() * 2));
                } else if ((x == (getOriginalPlacement() + getZ())) && !temp.getChessboard()[getX() + getZ()][getY()].isPieceOn()) {
                    temp.getChessboard()[getX() + (getZ())][getY()] = temp.getChessboard()[getX()][getY()];
                    temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[getX() + (getZ())][getY()].setPieceOn(true);
                    setX(getX() + (getZ()));
                } else {
                    System.out.println("illegal move");
                }
            }

        } else {
            if (!temp.getChessboard()[getX() + getZ()][getY()].isPieceOn()) {
                temp.getChessboard()[getX() + (getZ())][getY()] = temp.getChessboard()[getX()][getY()];
                temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[getX() + (getZ())][getY()].setPieceOn(true);
                setX(getX() + (getZ()));
            } else {
                System.out.println("illegal move");
            }
        }
    }

    public void attackPiece(Board temp, int x, int y) {
        if ((getY() + 1) == y) {
            if ((temp.getChessboard()[getX() + getZ()][getY() + 1].isPieceOn()) && (temp.getChessboard()[getX() + getZ()][getY() + 1].getPiece().getPieceColor() != getPieceColor())) {
                temp.getChessboard()[getX() + getZ()][getY() + 1].setPiece(this);
                temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[getX() + 1][getY() + getZ()].setPieceOn(true);
                setX(getX() + getZ());
                setY(getY() + 1);
            }
        } else if ((getY() - 1) == y) {
            if ((temp.getChessboard()[getX() + getZ()][getY() - 1].isPieceOn()) && (temp.getChessboard()[getX() + getZ()][getY() - 1].getPiece().getPieceColor() != getPieceColor())) {
                temp.getChessboard()[getX() + getZ()][getY() - 1].setPiece(this);
                temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[getX() + getZ()][getY() - 1].setPieceOn(true);
                setX(getX() + getZ());
                setY(getY() - 1);
            }
        } else
            System.out.println("that move is illegal");

    }
}





