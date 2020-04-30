package com.YoelSiegel;
import java.lang.Math;
public class King extends Piece {
    boolean isattacklegal=false;
    private String type="King";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public King(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y);
    }
    public void printPiece(){
        System.out.print(this.getPieceColor()==PieceColor.WHITE?"w":"b");
        System.out.print("k ");
    }
    public void movePiece(Board temp,int x,int y){
        if((x==getX())&&(y==getY())){
            System.out.println("you arent moving anywhere");
            return;
        }
        else if((Math.abs(x-getX())>1)||((Math.abs(y-getY())>1))){
            System.out.println("this move is illegal");
            return;
        }
        else{
            if(temp.getChessboard()[x][y].isPieceOn())
            {
            isattacklegal=true;
            attackpiece(temp,x,y);
        }
            else {
                System.out.print("this move is legal");
                temp.getChessboard()[x][y]= temp.getChessboard()[getX()][getY()];
                temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[x][y].setPieceOn(true);
                setX(x);
                setY(y);
            }
    }
    }
    public void attackpiece(Board temp,int x,int y){
        if(isattacklegal==false){
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
}
