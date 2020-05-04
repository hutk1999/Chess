package com.YoelSiegel;

public class Knight extends Piece {
    private String type = "Knight";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Knight(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y);
    }

    public void printPiece() {
        System.out.print(this.getPieceColor() == PieceColor.WHITE ? "w" : "b");
        System.out.print("h ");
    }


    public void movePiece(Board temp, int x, int y) {
        boolean legalmove = false;
        if (this.getX() + 1 == x && this.getY() + 2 == y) {
            legalmove = true;
        } else if (this.getX() + 2 == x && this.getY() + 1 == y) {
            legalmove = true;
        } else if (this.getX() - 1 == x && this.getY() - 2 == y) {
            legalmove = true;
        } else if (this.getX() - 2 == x && this.getY() - 1 == y) {
            legalmove = true;
        } else if (this.getX() + 1 == x && this.getY() - 2 == y) {
            legalmove = true;
        } else if (this.getX() + 2 == x && this.getY() - 1 == y) {
            legalmove = true;
        } else if (this.getX() - 1 == x && this.getY() + 2 == y) {
            legalmove = true;
        } else if (this.getX() - 2 == x && this.getY() + 1 == y) {
            legalmove = true;
        }
        if(legalmove==false) {
            System.out.println("this move is illegal");
            return;
        }
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
        if (!temp.getChessboard()[x][y].isPieceOn()) {
            System.out.println("this move is legal");
            temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
            temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
            temp.getChessboard()[x][y].setPieceOn(true);
            setX(x);
            setY(y);
        } else {
            attackPiece(temp, x, y);
        }
    }



    public void attackPiece(Board temp, int x, int y) {

        if (!temp.getChessboard()[x][y].isPieceOn()) {
            System.out.println("this move is illegal because its not a attack");
        } else {
            if (temp.getChessboard()[x][y].getPiece().getPieceColor() == this.getPieceColor()) {
                System.out.println("this is illegal because its your piece");
            } else
                {
                    if(temp.gettile(x,y).getPiece().getPieceColor()==PieceColor.WHITE){
                    temp.whiteList.remove(temp.gettile(x,y).getPiece());
                }
                else
                {
                    temp.blackList.remove(temp.gettile(x,y).getPiece());
                }
                temp.getChessboard()[x][y].setPiece(this);
                temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[x][y].setPieceOn(true);
                setX(x);
                setY(y);
            }
        }
    }


}

