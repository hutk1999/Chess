package com.YoelSiegel;

import javax.swing.*;

public class Castle extends Piece {
boolean ismovelegal=true;
    private String type="Castle";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void movepiece(Board temp,int x,int y){
        //if they are not on the same tzir
        if(( x!=this.getX())&&(y!=this.getY())){
            System.out.print("this move is illegal");
            ismovelegal=false;
            return;
        }
        //if this isnt moving anywhere
        else if(( x==this.getX())&&(y==this.getY())){
            System.out.print("this move is illegal");
            ismovelegal=false;
            return;
        }
        else if ((temp.getChessboard()[x][y].isPieceOn()==true))
        {
            System.out.println("this move is illegal there is a piece is there");
        }
        //if they are on the same x and the y is higher
        else if((x==this.getX())&&(y>this.getY())){
                for(int i=this.getY();i<y;i++) {
                    if (temp.getChessboard()[x][i].isPieceOn() == true) {
                        System.out.print("this move is illegal");
                        ismovelegal = false;
                        return;
                    }
                }
                        if(temp.getChessboard()[x][y].isPieceOn()==false){
                            System.out.print("this move is legal");
                            temp.getChessboard()[x][y]= temp.getChessboard()[getX()][getY()];
                            temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                            temp.getChessboard()[x][y].setPieceOn(true);
                            setX(x);
                            setY(y);
                        }


        }
        //if they are on the same x tzir and the y is smaller
        else if((x==this.getX())&&(y<this.getY())){
            for(int i=y;i<getY();i++) {
                if (temp.getChessboard()[x][i].isPieceOn() == true) {
                    System.out.print("this move is illegal");
                    ismovelegal = false;
                    return;
                }
            }
            if(temp.getChessboard()[x][y].isPieceOn()==false){
                System.out.print("this move is legal");
                temp.getChessboard()[x][y]= temp.getChessboard()[getX()][getY()];
                temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[x][y].setPieceOn(true);
                setX(x);
                setY(y);
            }


            }
            //if on the same y tzir and x is higher then ours
             else if((y==this.getY())&&(x>this.getX())){
                for(int i=this.getX();i<x;i++) {
                    if (temp.getChessboard()[i][y].isPieceOn() == true) {
                        System.out.print("this move is illegal");
                        ismovelegal = false;
                        return;
                    }
                }
                if(temp.getChessboard()[x][y].isPieceOn()==false){
                    System.out.print("this move is legal");
                    temp.getChessboard()[x][y]= temp.getChessboard()[getX()][getY()];
                    temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[x][y].setPieceOn(true);
                    setX(x);
                    setY(y);
                }


            }
            //if they are on the same y tzir and the x is smaller then ours
            else if((y==this.getY())&&(x<this.getX())){
                for(int i=x;i<getX();i++) {
                    if (temp.getChessboard()[i][y].isPieceOn() == true) {
                        System.out.print("this move is illegal");
                        ismovelegal = false;
                        return;
                    }
                }
                if(temp.getChessboard()[x][y].isPieceOn()==false){
                    System.out.print("this move is legal");
                    temp.getChessboard()[x][y]= temp.getChessboard()[getX()][getY()];
                    temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[x][y].setPieceOn(true);
                    setX(x);
                    setY(y);
                }
            }
    }


    @Override
    public void attackPiece(Board temp, int x, int y) {
        System.out.print("in the attck of castle");

        super.attackPiece(temp, x, y);
        temp.getChessboard()[x][y].setPiece(this);
        temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
        temp.getChessboard()[x][y].setPieceOn(true);
        setX(x);
        setY(y);
    }
    //checks all the places this guy is threatning
    public void alllegalmoves(Board temp)
    {
        //checks all the places on the same y axis going up for white
        if (this.getPieceColor() == PieceColor.WHITE)
        {
            int i = getX();
            while ((temp.getChessboard()[i][getY()].isPieceOn() != true) && (i < 8))
            {
                i = i + 1;
                if (temp.getChessboard()[i][getY()].isPieceOn() == false)
                {
                    temp.getChessboard()[i][getY()].attackedfromwhite = true;
                }
                else
                    {
                    if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.BLACK)
                    {
                        temp.getChessboard()[i][getY()].attackedfromwhite = true;
                    }
                }
            }
            //checks all the places on the y axis going down
            while ((temp.getChessboard()[i][getY()].isPieceOn() != true) && (i > -1))
            {
                i = i - 1;
                if (temp.getChessboard()[i][getY()].isPieceOn() == false)
                {
                    temp.getChessboard()[i][getY()].attackedfromwhite = true;
                }
                else
                    {
                    if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.BLACK)
                    {
                        temp.getChessboard()[i][getY()].attackedfromwhite = true;
                    }
                }
            }
            //checks all the places on the x axis going up
            while ((temp.getChessboard()[getX()][i].isPieceOn() != true) && (i < 8))
            {
                i = i + 1;
                if (temp.getChessboard()[getX()][i].isPieceOn() == false)
                {
                    temp.getChessboard()[getX()][i].attackedfromwhite = true;
                }
                else
                    {
                    if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.BLACK)
                    {
                        temp.getChessboard()[getX()][i].attackedfromwhite = true;
                    }
                }
            }
            //checks all the pieces on the x axis going down
            while ((temp.getChessboard()[getX()][i].isPieceOn() != true) && (i > -1))
            {
                i = i - 1;
                if (temp.getChessboard()[getX()][i].isPieceOn() == false)
                {
                    temp.getChessboard()[getX()][i].attackedfromwhite = true;
                }
                else
                    {
                    if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.BLACK)
                    {
                        temp.getChessboard()[getX()][i].attackedfromwhite = true;
                    }
                }
            }
        }
        else
            //now if the piece is black
            {
                int i = getX();
                while ((temp.getChessboard()[i][getY()].isPieceOn() != true) && (i < 8))
                {
                    i = i + 1;
                    if (temp.getChessboard()[i][getY()].isPieceOn() == false)
                    {
                        temp.getChessboard()[i][getY()].attatckedfromblack = true;
                    }
                    else
                        {
                        if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.BLACK)
                        {
                            temp.getChessboard()[i][getY()].attatckedfromblack = true;
                        }
                    }
                }
                //checks all the places on the y axis going down
                while ((temp.getChessboard()[i][getY()].isPieceOn() != true) && (i > -1))
                {
                    i = i -1;
                    if (temp.getChessboard()[i][getY()].isPieceOn() == false)
                    {
                        temp.getChessboard()[i][getY()].attatckedfromblack = true;
                    }
                    else
                        {
                        if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.BLACK)
                        {
                            temp.getChessboard()[i][getY()].attatckedfromblack = true;
                        }
                    }
                }
                //checks all the places on the x axis going up
                while ((temp.getChessboard()[getX()][i].isPieceOn() != true) && (i <8))
                {
                    i = i +1;
                    if (temp.getChessboard()[getX()][i].isPieceOn() == false)
                    {
                        temp.getChessboard()[getX()][i].attatckedfromblack = true;
                    }
                    else
                        {
                        if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.BLACK)
                        {
                            temp.getChessboard()[getX()][i].attatckedfromblack = true;
                        }
                    }
                }
                //checks all the pieces on the x axis going down
                while ((temp.getChessboard()[getX()][i].isPieceOn() != true) && (i > -1))
                {
                    i = i -1;
                    if (temp.getChessboard()[getX()][i].isPieceOn() == false)
                    {
                        temp.getChessboard()[getX()][i].attatckedfromblack = true;
                    }
                    else
                        {
                        if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.BLACK)
                        {
                            temp.getChessboard()[getX()][i].attatckedfromblack = true;
                        }
                    }
                }
            }
    }

    public Castle(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y);
    }
    public void printPiece(){
        System.out.print(this.getPieceColor()==PieceColor.WHITE?"w":"b");
        System.out.print("c ");
    }
}


