package com.YoelSiegel;

public class Queen extends Piece {

    private String type = "Queen";


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Queen(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y);
    }

    public void printPiece() {
        System.out.print(this.getPieceColor() == PieceColor.WHITE ? "w" : "b");
        System.out.print("q ");
    }


    //all important functions are here and lower
    //needa work on this

    public void movePiece(Board temp, int x, int y) {
        if ((x == this.getX()) && (y == this.getY())) {
            System.out.print("this move is illegal");
        } else {
            //it is doing the castle attack
            if (x == this.getX() || y == this.getY()) {
                if ((x == this.getX()) && (y > this.getY())) {
                    for (int i = this.getY() + 1; i < y; i++) {
                        if (temp.getChessboard()[x][i].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return;
                        }
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
                        System.out.print("this move is legal");
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {

                        attackPiece(temp, x, y);
                    }


                }
                //if they are on the same x tzir and the y is smaller
                else if ((x == this.getX()) && (y < this.getY())) {
                    for (int i = y + 1; i < getY(); i++) {
                        if (temp.getChessboard()[x][i].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return;
                        }
                    }
                    if (!temp.getChessboard()[x][y].isPieceOn()) {
                        System.out.print("this move is legal");
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {
                        attackPiece(temp, x, y);
                    }
                }
                //if on the same y tzir and x is higher then ours
                else if ((y == this.getY()) && (x > this.getX())) {
                    for (int i = this.getX() + 1; i < x; i++) {
                        if (temp.getChessboard()[i][y].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return;
                        }
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
                        System.out.print("this move is legal");
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {
                        attackPiece(temp, x, y);
                    }
                }
                //if they are on the same y tzir and the x is smaller then ours
                else if ((y == this.getY()) && (x < this.getX())) {
                    for (int i = x + 1; i < getX(); i++) {
                        if (temp.getChessboard()[i][y].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return;
                        }
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
                        System.out.print("this move is legal");
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {
                        attackPiece(temp, x, y);
                    }
                }
            }
            //if it is a bishop attack
            else if ((Math.abs(getX() - x)) == (Math.abs(getY() - y))) {

                //if xis smaller then target and y is also smaller
                if ((getX() < x) && (getY() < y)) {
                    for (int i = 1; i < x - getX(); i++) {
                        if (temp.getChessboard()[getX() + i][getY() + i].isPieceOn()) {
                            System.out.println("this move is illegal there is something in the way");
                            return;
                        }
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
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {
                        attackPiece(temp, x, y);
                    }
                }
                //x is bigger and y is bigger than target
                else if ((getX() > x) && (getY() > y)) {
                    for (int i = 1; i < getX() - x; i++) {
                        if (temp.getChessboard()[getX() - i][getY() - i].isPieceOn()) {
                            System.out.println("this move is illegal");
                            return;
                        }
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
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {
                        attackPiece(temp, x, y);
                    }
                }
                //x is bigger and y is smaller
                else if ((getX() > x) && (getY() < y)) {
                    for (int i = 1; i < getX() - x; i++) {
                        if (temp.getChessboard()[getX() - i][getY() + i].isPieceOn()) {
                            System.out.println("this move is illegal");
                            return;
                        }
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
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {
                        attackPiece(temp, x, y);
                    }
                } else if ((getX() > x) && (getY() < y))
                //out x is bigger then the location
                {
                    for (int i = 1; i < getX() - x; i++) {

                        if (temp.getChessboard()[getX() - i][getY() + i].isPieceOn()) {
                            System.out.println("this move is illegal");
                            return;
                        }
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
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {
                        attackPiece(temp, x, y);
                    }
                }
            }
        }
    }

    //we dont need anything special...
    public void attackPiece(Board temp, int x, int y) {
        if (temp.getChessboard()[x][y].getPiece().getPieceColor() == this.getPieceColor()) {
            System.out.println("this move is illegal you are attacking your own piece");
        } else {
            System.out.print("in the attack of castle");
            if(temp.gettile(x,y).getPiece().getPieceColor()==PieceColor.WHITE){
                temp.whiteList.remove(temp.gettile(x,y).getPiece());
            }
            else
            {
                temp.blackList.remove(temp.gettile(x,y).getPiece());
            }
            super.attackPiece(temp, x, y);
            temp.getChessboard()[x][y].setPiece(this);
            temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
            temp.getChessboard()[x][y].setPieceOn(true);
            setX(x);
            setY(y);
        }


    }

}