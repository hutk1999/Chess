package com.YoelSiegel;

public class Pawn extends Piece {

    private String type ="Pawn";
    //z at 1 means you are black and at the top
    // z at -1 means you are white and at the bottom
    private int z=0;
    private int originalPlacement=0;



    public Pawn(PieceColor pieceColor, int x, int y)
    {
        super(pieceColor, x, y);
        if(pieceColor==PieceColor.WHITE)
        {
            setZ(-1);
            setOriginalPlacement(6);
        }
        else{
            setZ(1);
            setOriginalPlacement(1);
        }
    }


    public int getZ()
    {
        return z;
    }

    public void setZ(int z)
    {
        this.z = z;
    }

    public int getOriginalPlacement()
    {
        return originalPlacement;
    }

    public void setOriginalPlacement(int originalPlacement)
    {
        this.originalPlacement = originalPlacement;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void printPiece()
    {
        System.out.print(this.getPieceColor()==PieceColor.WHITE?"w": "b");
        System.out.print("p ");
    }

    //need to merge these somehow
    //all important functions are here and down
    public void movePiece(Board temp, int x, int y)
    {
        if(getX()==getOriginalPlacement())
        {
            if (!temp.getChessboard()[getX() + getZ()][getY()].isPieceOn())
            {
                int doubleJump=1;
                if((x==(getOriginalPlacement() + getZ()*2)) && !temp.getChessboard()[getX() + getZ()*2][getY()].isPieceOn()){
                    doubleJump=2;
                    temp.getChessboard()[getX() + (getZ()*2)][getY()] = temp.getChessboard()[getX()][getY()];
                    temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[getX() + (getZ()*2)][getY()].setPieceOn(true);
                    setX(getX() + (getZ()*2));
                }
                else if((x==(getOriginalPlacement() + getZ())) && !temp.getChessboard()[getX() + getZ()][getY()].isPieceOn()) {
                    temp.getChessboard()[getX() + (getZ())][getY()] = temp.getChessboard()[getX()][getY()];
                    temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[getX() + (getZ())][getY()].setPieceOn(true);
                    setX(getX() + (getZ()));
                }
                else {
                    System.out.println("illegal move");
                    return;
                }
            }

        }
        else {
            if(!temp.getChessboard()[getX() + getZ()][getY()].isPieceOn()){
                temp.getChessboard()[getX() + (getZ())][getY()] = temp.getChessboard()[getX()][getY()];
                temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[getX() + (getZ())][getY()].setPieceOn(true);
                setX(getX() + (getZ()));
            }
            else{
                System.out.println("illegal move");
                return;
            }
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


    //the all legal moves in pawn is not all legal moves it's all the moves that pawn can attack he can go to more places but we dont care cause the king can go there
    public void alltilesattacked(Board temp){
        if(getPieceColor()==PieceColor.WHITE) {
            if (temp.getChessboard()[getX() + (1 * z)][getY() + 1].isPieceOn()==false){
                temp.getChessboard()[getX() + (1 * z)][getY() + 1].attackedfromwhite=true;
            }
            else{
                if( temp.getChessboard()[getX() + (1 * z)][getY() + 1].getPiece().getPieceColor()==PieceColor.BLACK){
                    temp.getChessboard()[getX() + (1 * z)][getY() + 1].attackedfromwhite=true;
                }
            }
            if (temp.getChessboard()[getX() + (1 * z)][getY() - 1].isPieceOn()==false){
                temp.getChessboard()[getX() + (1 * z)][getY() - 1].attackedfromwhite=true;
            }
            else{
                if( temp.getChessboard()[getX() + (1 * z)][getY() - 1].getPiece().getPieceColor()==PieceColor.BLACK){
                    temp.getChessboard()[getX() + (1 * z)][getY() - 1].attackedfromwhite=true;
                }
            }

        }
        else{

                if (temp.getChessboard()[getX() + (1 * z)][getY() + 1].isPieceOn()==false){
                    temp.getChessboard()[getX() + (1 * z)][getY() + 1].attackedfromblack=true;
                }
                else{
                    if( temp.getChessboard()[getX() + (1 * z)][getY() + 1].getPiece().getPieceColor()==PieceColor.WHITE){
                        temp.getChessboard()[getX() + (1 * z)][getY() + 1].attackedfromblack=true;
                    }
                }
                if (temp.getChessboard()[getX() + (1 * z)][getY() - 1].isPieceOn()==false){
                    temp.getChessboard()[getX() + (1 * z)][getY() - 1].attackedfromblack=true;
                }
                else{
                    if( temp.getChessboard()[getX() + (1 * z)][getY() - 1].getPiece().getPieceColor()==PieceColor.WHITE){
                        temp.getChessboard()[getX() + (1 * z)][getY() - 1].attackedfromblack=true;
                    }
                }

            }


        }
    }





