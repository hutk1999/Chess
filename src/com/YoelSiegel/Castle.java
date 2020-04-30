package com.YoelSiegel;

public class Castle extends Piece {

    private boolean ismovelegal=true;
    private String type="Castle";
    private boolean isattacklegal=false;

    public Castle(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y);
    }
    public void printPiece(){
        System.out.print(this.getPieceColor()==PieceColor.WHITE?"w":"b");
        System.out.print("c ");
    }

    public boolean isIsmovelegal() {
        return ismovelegal;
    }
    public void setIsmovelegal(boolean ismovelegal) {
        this.ismovelegal = ismovelegal;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }




    //all important functions are under here

    public void movePiece(Board temp,int x,int y){
        //if they are not on the same tzir
        if(( x!=this.getX())&&(y!=this.getY())){
            System.out.print("this move is illegal");
        }
        //if this isnt moving anywhere
        else if(( x==this.getX())&&(y==this.getY())){
            System.out.print("this move is illegal");
        }
        //if they are on the same x and the y is higher
        else if((x==this.getX())&&(y>this.getY())){
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

    @Override
    public void attackPiece(Board temp, int x, int y) {
        if(!isattacklegal){
            System.out.println("this funtction is unaccesable from anywhere");
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


    //checks all the places this guy is threatning
    //i checked and this function is perfect
    public void alltilesattacked(Board temp)
    {
        //checks all the places on the same y axis going up for white
        if (this.getPieceColor() == PieceColor.WHITE)
        {
            int i = getX();
            while ((!temp.getChessboard()[i][getY()].isPieceOn()) && (i < 8))
            {
                i = i + 1;
                if (!temp.getChessboard()[i][getY()].isPieceOn())
                {
                    temp.getChessboard()[i][getY()].attackedfromwhite = true;
                }
                else
                    {
                    if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.BLACK)
                    {
                        temp.getChessboard()[i][getY()].attackedfromwhite = true;
                    }
                    break;
                }
            }
            //checks all the places on the y axis going down
            while ((!temp.getChessboard()[i][getY()].isPieceOn()) && (i > -1))
            {
                i = i - 1;
                if (!temp.getChessboard()[i][getY()].isPieceOn())
                {
                    temp.getChessboard()[i][getY()].attackedfromwhite = true;
                }
                else
                    {
                    if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.BLACK)
                    {
                        temp.getChessboard()[i][getY()].attackedfromwhite = true;
                    }
                    break;
                }
            }
            //checks all the places on the x axis going up
            while ((!temp.getChessboard()[getX()][i].isPieceOn()) && (i < 8))
            {
                i = i + 1;
                if (!temp.getChessboard()[getX()][i].isPieceOn())
                {
                    temp.getChessboard()[getX()][i].attackedfromwhite = true;
                }
                else
                    {
                    if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.BLACK)
                    {
                        temp.getChessboard()[getX()][i].attackedfromwhite = true;
                    }
                        break;
                    }
            }
            //checks all the pieces on the x axis going down
            while ((!temp.getChessboard()[getX()][i].isPieceOn()) && (i > -1))
            {
                i = i - 1;
                if (!temp.getChessboard()[getX()][i].isPieceOn())
                {
                    temp.getChessboard()[getX()][i].attackedfromwhite = true;
                }
                else
                    {
                    if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.BLACK)
                    {
                        temp.getChessboard()[getX()][i].attackedfromwhite = true;
                    }
                            break;
                }
            }
        }
        else
            //now if the piece is black
            {
                int i = getX();
                while ((!temp.getChessboard()[i][getY()].isPieceOn()) && (i < 8))
                {
                    i = i + 1;
                    if (!temp.getChessboard()[i][getY()].isPieceOn())
                    {
                        temp.getChessboard()[i][getY()].attackedfromblack = true;
                    }
                    else
                        {
                        if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.WHITE)
                        {
                            temp.getChessboard()[i][getY()].attackedfromblack = true;
                        }
                                 break;
                    }
                }
                //checks all the places on the y axis going down
                while ((!temp.getChessboard()[i][getY()].isPieceOn()) && (i > -1))
                {
                    i = i -1;
                    if (!temp.getChessboard()[i][getY()].isPieceOn())
                    {
                        temp.getChessboard()[i][getY()].attackedfromblack = true;
                    }
                    else
                        {
                        if (temp.getChessboard()[i][getY()].getPiece().getPieceColor() == PieceColor.WHITE)
                        {
                            temp.getChessboard()[i][getY()].attackedfromblack = true;
                        }
                        break;
                    }
                }
                //checks all the places on the x axis going up
                while ((!temp.getChessboard()[getX()][i].isPieceOn()) && (i <8))
                {
                    i = i +1;
                    if (!temp.getChessboard()[getX()][i].isPieceOn())
                    {
                        temp.getChessboard()[getX()][i].attackedfromblack = true;
                    }
                    else
                        {
                        if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.WHITE)
                        {
                            temp.getChessboard()[getX()][i].attackedfromblack = true;
                        }
                        break;
                    }
                }
                //checks all the pieces on the x axis going down
                while ((!temp.getChessboard()[getX()][i].isPieceOn()) && (i > -1))
                {
                    i = i -1;
                    if (!temp.getChessboard()[getX()][i].isPieceOn())
                    {
                        temp.getChessboard()[getX()][i].attackedfromblack = true;
                    }
                    else
                        {
                        if (temp.getChessboard()[getX()][i].getPiece().getPieceColor() == PieceColor.WHITE)
                        {
                            temp.getChessboard()[getX()][i].attackedfromblack = true;
                        }
                        break;
                    }
                }
            }
    }


}


