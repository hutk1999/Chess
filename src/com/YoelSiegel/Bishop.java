package com.YoelSiegel;
import java.lang.*;
import java.lang.Math;

public class Bishop extends Piece {

    private String type ="Bishop";
    public boolean ismovelegal=false;
    boolean isattacklegal=false;



    public Bishop(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void printPiece()
    {
        System.out.print(this.getPieceColor()==PieceColor.WHITE?"w":"b");
        System.out.print("b ");
    }


    //all important functions are here and lower
    public void movePiece(Board temp,int x,int y) {
        //they are not moving anywhere
        if ((getX()==x)&&(getY()==y))
        {
        System.out.println("this move is legal your not moving anywhere");
        }
        //they arent on the same axis
       else if ((Math.abs(getX()-x))!=(Math.abs(getY()-y)))
        {
            System.out.println("this move is illegal");
            return;
        }
        else
        {
            //if xis smaller then target and y is also smaller
            if ((getX() < x) && (getY() < y)) {
                int k = 1;
                for (int i = getX() + 1; i < x - 1; i++) {
                    if (temp.getChessboard()[getX() + k][getY() + k].isPieceOn()) {
                        System.out.println("this move is illegal there is something in the way");
                        return;
                    }
                    k++;
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
                int k = 1;
                for (int i = x; i < getX() - 1; i++) {
                    if (temp.getChessboard()[getX() - k][getY() - k].isPieceOn()) {
                        System.out.println("this move is illegal");
                        return;
                    }
                    k++;
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
                int k = 1;
                for (int i = x + 1; i < getX() - 1; i++) {
                    if (temp.getChessboard()[getX() - k][getY() + i].isPieceOn()) {
                        System.out.println("this move is illegal");
                        return;
                    }
                    k++;
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
                for (int i = x + 1; i < getX() - 1; i++) {
                    int k = 1;
                    if (temp.getChessboard()[getX() - k][getY() + k].isPieceOn()) {
                        System.out.println("this move is illegal");
                        return;
                    }
                    k++;
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

    public void attackPiece(Board temp, int x, int y){
        if(!isattacklegal){
            System.out.println("this move is illegal");
        }
        else{
            System.out.println("in attack function");
            if(temp.getChessboard()[x][y].getPiece().getPieceColor()==getPieceColor()){
                System.out.println("this move is illegal because you are attacking own piece");
            }
            else{
                temp.getChessboard()[x][y].setPiece(this);
                temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[x][y].setPieceOn(true);
                setX(x);
                setY(y);
                isattacklegal=false;
            }
        }



    }
// went over this its a good code
    public void alltilesattacked(Board temp) {
            //checks if piece is white
            if (this.getPieceColor() == PieceColor.WHITE) {

                //checks if x is bigger and y is bigger
                        for (int i = 1; (getX()+i < 8)&&(getY()+i<8); i++) {
                            if (!temp.getChessboard()[getX() + i][getY() + i].isPieceOn()) {
                                temp.getChessboard()[getX() + i][getY() + i].attackedfromwhite = true;
                            }
                            else
                                {
                               if(temp.getChessboard()[getX()+i][getY()+i].getPiece().getPieceColor()==PieceColor.BLACK)
                               {
                                    temp.getChessboard()[getX() + i][getY() + i].attackedfromwhite = true;
                                }
                               break;
                            }
                        }

                    //out x is smaller then then location and y is smaller

                        for (int i = 1; (getX()-i >=0)&&(getY()-i>=0); i++) {
                            if (!temp.getChessboard()[getX() - i][getY() - i].isPieceOn())
                            {
                                temp.getChessboard()[getX() - i][getY() - i].attackedfromwhite = true;
                            }
                            else
                                {
                                if (temp.getChessboard()[getX() - i][getY() - i].getPiece().getPieceColor() == PieceColor.BLACK)
                                {
                                    temp.getChessboard()[getX() -i][getY() - i].attackedfromwhite = true;
                                }
                                break;
                            }
                        }
                        //when x is bigger and y is smaller
                        for (int i = 1; (i+getX() < 8)&&(getY()-i>-1); i++) {
                        if (!temp.getChessboard()[getX() + i][getY() - i].isPieceOn())
                        {
                            temp.getChessboard()[getX() + i][getY() - i].attackedfromwhite = true;
                        }
                        else
                            {
                            if (temp.getChessboard()[getX() + i][getY() - i].getPiece().getPieceColor() == PieceColor.BLACK)
                            {
                                 temp.getChessboard()[getX() + i][getY() - i].attackedfromwhite = true;
                                     }
                            break;
                        }
                    }
                //our x is smaller then the location and y is bigger
                for (int i = 1; i < 8; i++) {
                        if (!temp.getChessboard()[getX() - i][getY() + i].isPieceOn()) {
                            temp.getChessboard()[getX() - i][getY() + i].attackedfromwhite = true;
                        }
                        else
                            {
                            if (temp.getChessboard()[getX() - i][getY() + i].getPiece().getPieceColor() == PieceColor.BLACK)
                            {
                                temp.getChessboard()[getX() - i][getY() + i].attackedfromwhite = true;
                            }
                            break;
                        }
                    }


                }
        else  {
            //checks if x is bigger and y is bigger
            for (int i = 1; (getX()+i < 8)&&(getY()+i<8); i++) {
                if (!temp.getChessboard()[getX() + i][getY() + i].isPieceOn()) {
                    temp.getChessboard()[getX() + i][getY() + i].attackedfromblack = true;
                }
                else
                {
                    if (temp.getChessboard()[getX() + i][getY() + i].getPiece().getPieceColor() == PieceColor.WHITE)
                    {
                        temp.getChessboard()[getX() + i][getY() + i].attackedfromblack = true;
                    }
                    break;
                }
            }

            //out x is smaller then then location and y is smaller

            for (int i = 1; (getX()-i >=0)&&(getY()-i>=0); i++) {
                if (!temp.getChessboard()[getX() - i][getY() - i].isPieceOn())
                {
                    temp.getChessboard()[getX() - i][getY() - i].attackedfromblack = true;
                }
                else
                {
                    if (temp.getChessboard()[getX() - i][getY() - i].getPiece().getPieceColor() == PieceColor.WHITE)
                    {
                        temp.getChessboard()[getX() -i][getY() - i].attackedfromblack = true;
                    }
                    break;
                }
            }
            //when x is bigger and y is smaller
            for (int i = 1; (i+getX() < 8)&&(getY()-i>-1); i++) {
                if (!temp.getChessboard()[getX() + i][getY() - i].isPieceOn())
                {
                    temp.getChessboard()[getX() + i][getY() - i].attackedfromblack = true;
                    return;
                }
                else
                {
                    if (temp.getChessboard()[getX() + i][getY() - i].getPiece().getPieceColor() == PieceColor.WHITE)
                    {
                        temp.getChessboard()[getX() + i][getY() - i].attackedfromblack = true;
                    }
                    break;
                }
            }
            //our x is smaller then the location and y is bigger
            for (int i = 1; i < 8; i++) {
                if (!temp.getChessboard()[getX() - i][getY() + i].isPieceOn())
                {
                    temp.getChessboard()[getX() - i][getY() + i].attackedfromblack = true;
                }
                else
                {
                    if (temp.getChessboard()[getX() - i][getY() + i].getPiece().getPieceColor() == PieceColor.WHITE)
                    {
                        temp.getChessboard()[getX() - i][getY() + i].attackedfromblack = true;
                    }
                    break;
                }
            }


        }

            }


        }



