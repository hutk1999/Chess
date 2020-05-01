package com.YoelSiegel;

public class Queen extends Piece {

    private String type = "Queen";
    private boolean isattacklegal=true;

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
        if(( x==this.getX())&&(y==this.getY())){
            System.out.print("this move is illegal");
        }
        else
        {
            //it is doing the castle attack
            if(x==this.getX()||y==this.getY()){
                if((x==this.getX())&&(y>this.getY())){
                    for(int i=this.getY()+1;i<y;i++) {
                        if (temp.getChessboard()[x][i].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return;
                        }
                    }
                    if(!temp.getChessboard()[x][y].isPieceOn()){
                        System.out.print("this move is legal");
                        temp.getChessboard()[x][y]= temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    }
                    else{
                        isattacklegal=true;
                        attackPiece(temp, x, y);
                    }


                }
                //if they are on the same x tzir and the y is smaller
                else if((x==this.getX())&&(y<this.getY())) {
                    for (int i = y+1; i < getY(); i++) {
                        if (temp.getChessboard()[x][i].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return;
                        }
                    }
                    if(!temp.getChessboard()[x][y].isPieceOn()){
                        System.out.print("this move is legal");
                        temp.getChessboard()[x][y]= temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    }
                    else{
                        isattacklegal=true;
                        attackPiece(temp, x, y);
                    }
                }
                //if on the same y tzir and x is higher then ours
                else if((y==this.getY())&&(x>this.getX())){
                    for(int i=this.getX()+1;i<x;i++) {
                        if (temp.getChessboard()[i][y].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return;
                        }
                    }
                    if(!temp.getChessboard()[x][y].isPieceOn()){
                        System.out.print("this move is legal");
                        temp.getChessboard()[x][y]= temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    }
                    else{
                        isattacklegal=true;
                        attackPiece(temp, x, y);
                    }
                }
                //if they are on the same y tzir and the x is smaller then ours
                else if((y==this.getY())&&(x<this.getX())){
                    for(int i=x+1;i<getX();i++) {
                        if (temp.getChessboard()[i][y].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return;
                        }
                    }
                    if(!temp.getChessboard()[x][y].isPieceOn()){
                        System.out.print("this move is legal");
                        temp.getChessboard()[x][y]= temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    }
                    else{
                        isattacklegal=true;
                        attackPiece(temp, x, y);
                    }
                }
            }
            //if it is a bishop attack
            else if ((Math.abs(getX()-x))==(Math.abs(getY()-y))){

                //if xis smaller then target and y is also smaller
                if ((getX() < x) && (getY() < y)) {
                    for (int i =  1; i < x - getX(); i++) {
                        if (temp.getChessboard()[getX() + i][getY() + i].isPieceOn()) {
                            System.out.println("this move is illegal there is something in the way");
                            return;
                        }
                    }
                    if (!temp.getChessboard()[x][y].isPieceOn()) {
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {
                        isattacklegal = true;
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
                    if (!temp.getChessboard()[x][y].isPieceOn()) {
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {
                        isattacklegal = true;
                        attackPiece(temp, x, y);
                    }
                }
                //x is bigger and y is smaller
                else if ((getX() > x) && (getY() < y)) {
                    for (int i = 1 ; i < getX() - x; i++) {
                        if (temp.getChessboard()[getX() - i][getY() + i].isPieceOn()) {
                            System.out.println("this move is illegal");
                            return;
                        }
                    }
                    if (!temp.getChessboard()[x][y].isPieceOn()) {
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {
                        isattacklegal = true;
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
                    if (!temp.getChessboard()[x][y].isPieceOn()) {
                        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                        temp.getChessboard()[x][y].setPieceOn(true);
                        setX(x);
                        setY(y);
                    } else {
                        isattacklegal = true;
                        attackPiece(temp, x, y);
                    }
                }
            }
        }
        }

    //we dont need anything special...
    public void attackPiece(Board temp,int x,int y){
        if(!isattacklegal){
            System.out.println("this move is illegal cause you can't reach here");
            return;
        }
        if (temp.getChessboard()[x][y].getPiece().getPieceColor() == this.getPieceColor()) {
            System.out.println("this move is illegal you are attacking your own piece");
        } else {
            System.out.print("in the attack of castle");

            super.attackPiece(temp, x, y);
            temp.getChessboard()[x][y].setPiece(this);
            temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
            temp.getChessboard()[x][y].setPieceOn(true);
            setX(x);
            setY(y);
            isattacklegal=false;
        }


    }
    public void alltilesattacked(Board temp) {
        //this is the bishop part i dont think we can send to bishop...
        //checks if piece is white
        if (this.getPieceColor() == PieceColor.WHITE) {

            //checks if x is bigger and y is bigger
            for (int i = 1; (getX() + i < 8) && (getY() + i < 8); i++) {
                if (!temp.getChessboard()[getX() + i][getY() + i].isPieceOn()) {
                    temp.getChessboard()[getX() + i][getY() + i].attackedfromwhite = true;
                } else {
                    if (temp.getChessboard()[getX() + i][getY() + i].getPiece().getPieceColor() == PieceColor.BLACK) {
                        temp.getChessboard()[getX() + i][getY() + i].attackedfromwhite = true;
                    }
                    break;
                }
            }

            //out x is smaller then then location and y is smaller

            for (int i = 1; (getX() - i >= 0) && (getY() - i >= 0); i++) {
                if (!temp.getChessboard()[getX() - i][getY() - i].isPieceOn()) {
                    temp.getChessboard()[getX() - i][getY() - i].attackedfromwhite = true;
                } else {
                    if (temp.getChessboard()[getX() - i][getY() - i].getPiece().getPieceColor() == PieceColor.BLACK) {
                        temp.getChessboard()[getX() - i][getY() - i].attackedfromwhite = true;
                    }
                    break;
                }
            }
            //when x is bigger and y is smaller
            for (int i = 1; (i + getX() < 8) && (getY() - i > -1); i++) {
                if (!temp.getChessboard()[getX() + i][getY() - i].isPieceOn()) {
                    temp.getChessboard()[getX() + i][getY() - i].attackedfromwhite = true;
                } else {
                    if (temp.getChessboard()[getX() + i][getY() - i].getPiece().getPieceColor() == PieceColor.BLACK) {
                        temp.getChessboard()[getX() + i][getY() - i].attackedfromwhite = true;
                    }
                    break;
                }
            }
            //our x is smaller then the location and y is bigger
            for (int i = 1; i < 8; i++) {
                if (!temp.getChessboard()[getX() - i][getY() + i].isPieceOn()) {
                    temp.getChessboard()[getX() - i][getY() + i].attackedfromwhite = true;
                } else {
                    if (temp.getChessboard()[getX() - i][getY() + i].getPiece().getPieceColor() == PieceColor.BLACK) {
                        temp.getChessboard()[getX() - i][getY() + i].attackedfromwhite = true;
                    }
                    break;
                }
            }


        } else {
            //checks if x is bigger and y is bigger
            for (int i = 1; (getX() + i < 8) && (getY() + i < 8); i++) {
                if (!temp.getChessboard()[getX() + i][getY() + i].isPieceOn()) {
                    temp.getChessboard()[getX() + i][getY() + i].attackedfromblack = true;
                } else {
                    if (temp.getChessboard()[getX() + i][getY() + i].getPiece().getPieceColor() == PieceColor.WHITE) {
                        temp.getChessboard()[getX() + i][getY() + i].attackedfromblack = true;
                    }
                    break;
                }
            }

            //out x is smaller then then location and y is smaller

            for (int i = 1; (getX() - i >= 0) && (getY() - i >= 0); i++) {
                if (!temp.getChessboard()[getX() - i][getY() - i].isPieceOn()) {
                    temp.getChessboard()[getX() - i][getY() - i].attackedfromblack = true;
                } else {
                    if (temp.getChessboard()[getX() - i][getY() - i].getPiece().getPieceColor() == PieceColor.WHITE) {
                        temp.getChessboard()[getX() - i][getY() - i].attackedfromblack = true;
                    }
                    break;
                }
            }
            //when x is bigger and y is smaller
            for (int i = 1; (i + getX() < 8) && (getY() - i > -1); i++) {
                if (!temp.getChessboard()[getX() + i][getY() - i].isPieceOn()) {
                    temp.getChessboard()[getX() + i][getY() - i].attackedfromblack = true;
                    return;
                } else {
                    if (temp.getChessboard()[getX() + i][getY() - i].getPiece().getPieceColor() == PieceColor.WHITE) {
                        temp.getChessboard()[getX() + i][getY() - i].attackedfromblack = true;
                    }
                    break;
                }
            }
            //our x is smaller then the location and y is bigger
            for (int i = 1; i < 8; i++) {
                if (!temp.getChessboard()[getX() - i][getY() + i].isPieceOn()) {
                    temp.getChessboard()[getX() - i][getY() + i].attackedfromblack = true;
                } else {
                    if (temp.getChessboard()[getX() - i][getY() + i].getPiece().getPieceColor() == PieceColor.WHITE) {
                        temp.getChessboard()[getX() - i][getY() + i].attackedfromblack = true;
                    }
                    break;
                }
            }
        }
        //now we check it in castle
        //checks all the places on the same y axis going up for white
        if (this.getPieceColor() == PieceColor.WHITE) {
            int i = getX();
            while ((!temp.getChessboard()[i][getY()].isPieceOn()) && (i < 8)) {
                i = i + 1;
                if (!temp.getChessboard()[i][getY()].isPieceOn()) {
                    temp.getChessboard()[i][getY()].attackedfromwhite = true;
                } else {
                    if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.BLACK) {
                        temp.getChessboard()[i][getY()].attackedfromwhite = true;
                    }
                    break;
                }
            }
            //checks all the places on the y axis going down
            while ((!temp.getChessboard()[i][getY()].isPieceOn()) && (i > -1)) {
                i = i - 1;
                if (!temp.getChessboard()[i][getY()].isPieceOn()) {
                    temp.getChessboard()[i][getY()].attackedfromwhite = true;
                } else {
                    if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.BLACK) {
                        temp.getChessboard()[i][getY()].attackedfromwhite = true;
                    }
                    break;
                }
            }
            //checks all the places on the x axis going up
            while ((!temp.getChessboard()[getX()][i].isPieceOn()) && (i < 8)) {
                i = i + 1;
                if (!temp.getChessboard()[getX()][i].isPieceOn()) {
                    temp.getChessboard()[getX()][i].attackedfromwhite = true;
                } else {
                    if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.BLACK) {
                        temp.getChessboard()[getX()][i].attackedfromwhite = true;
                    }
                    break;
                }
            }
            //checks all the pieces on the x axis going down
            while ((!temp.getChessboard()[getX()][i].isPieceOn()) && (i > -1)) {
                i = i - 1;
                if (!temp.getChessboard()[getX()][i].isPieceOn()) {
                    temp.getChessboard()[getX()][i].attackedfromwhite = true;
                } else {
                    if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.BLACK) {
                        temp.getChessboard()[getX()][i].attackedfromwhite = true;
                    }
                    break;
                }
            }
        } else
        //now if the piece is black
        {
            int i = getX();
            while ((!temp.getChessboard()[i][getY()].isPieceOn()) && (i < 8)) {
                i = i + 1;
                if (!temp.getChessboard()[i][getY()].isPieceOn()) {
                    temp.getChessboard()[i][getY()].attackedfromblack = true;
                } else {
                    if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.WHITE) {
                        temp.getChessboard()[i][getY()].attackedfromblack = true;
                    }
                    break;
                }
            }
            //checks all the places on the y axis going down
            while ((!temp.getChessboard()[i][getY()].isPieceOn()) && (i > -1)) {
                i = i - 1;
                if (!temp.getChessboard()[i][getY()].isPieceOn()) {
                    temp.getChessboard()[i][getY()].attackedfromblack = true;
                } else {
                    if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.WHITE) {
                        temp.getChessboard()[i][getY()].attackedfromblack = true;
                    }
                    break;
                }
            }
            //checks all the places on the x axis going up
            while ((!temp.getChessboard()[getX()][i].isPieceOn()) && (i < 8)) {
                i = i + 1;
                if (!temp.getChessboard()[getX()][i].isPieceOn()) {
                    temp.getChessboard()[getX()][i].attackedfromblack = true;
                } else {
                    if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.WHITE) {
                        temp.getChessboard()[getX()][i].attackedfromblack = true;
                    }
                    break;
                }
            }
            //checks all the pieces on the x axis going down
            while ((!temp.getChessboard()[getX()][i].isPieceOn()) && (i > -1)) {
                i = i - 1;
                if (!temp.getChessboard()[getX()][i].isPieceOn()) {
                    temp.getChessboard()[getX()][i].attackedfromblack = true;
                } else {
                    if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.WHITE) {
                        temp.getChessboard()[getX()][i].attackedfromblack = true;
                    }
                    break;
                }
            }
        }
    }
}