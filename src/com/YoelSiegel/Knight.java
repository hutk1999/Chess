package com.YoelSiegel;

public class Knight extends Piece {
    boolean legalmove = false;
    boolean isLegal = false;
    private String type = "Knight";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void alllegalmoves(Board temp){
        if(this.getPieceColor()==PieceColor.WHITE)
        {
            temp.getChessboard()[getX() + 1][getY() + 2].attackedfromwhite = true;
            temp.getChessboard()[getX() + 2][getY() + 1].attackedfromwhite = true;
            temp.getChessboard()[getX() + 1][getY() - 2].attackedfromwhite = true;
            temp.getChessboard()[getX() + 2][getY() - 1].attackedfromwhite = true;
            temp.getChessboard()[getX() - 1][getY() + 2].attackedfromwhite = true;
            temp.getChessboard()[getX() - 1][getY() - 2].attackedfromwhite = true;
            temp.getChessboard()[getX() - 2][getY() + 1].attackedfromwhite = true;
            temp.getChessboard()[getX() - 2][getY() - 1].attackedfromwhite = true;
        }
        else
        {
            temp.getChessboard()[getX() + 1][getY() + 2].attatckedfromblack = true;
            temp.getChessboard()[getX() + 2][getY() + 1].attatckedfromblack = true;
            temp.getChessboard()[getX() + 1][getY() - 2].attatckedfromblack = true;
            temp.getChessboard()[getX() + 2][getY() - 1].attatckedfromblack = true;
            temp.getChessboard()[getX() - 1][getY() + 2].attatckedfromblack = true;
            temp.getChessboard()[getX() - 1][getY() - 2].attatckedfromblack= true;
            temp.getChessboard()[getX() - 2][getY() + 1].attatckedfromblack = true;
            temp.getChessboard()[getX() - 2][getY() - 1].attatckedfromblack = true;
        }
    }

    //checks all the possibilities that rook has
    public boolean isMoveLegal(int x, int y) {
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
        if (legalmove == true) {
            return true;
        } else
            return false;
    }

    public Knight(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y);
    }

    public void movePiece(Board temp, int x, int y) {
        isLegal= isMoveLegal(x,y);
        if (isLegal == false)
        {
            System.out.println("this move is illegal");
            return;
        }
        else
            {
            if (temp.getChessboard()[x][y].isPieceOn() == false)
            {
                System.out.println("this move is legal");
                temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[x][y].setPieceOn(true);
                setX(x);
                setY(y);
            }
            else
                {
                System.out.println("that move is illegal there is a piece there");
            }
        }
    }

    public void attackPiece(Board temp, int x, int y)
    {
        if (isMoveLegal(x, y) == false)
        {
            return;
        }
        else
            {
            if (temp.getChessboard()[x][y].isPieceOn() == false)
            {
                System.out.println("this move is illegal because its not a attack");
                return;
            }
            else
                {
                if (temp.getChessboard()[x][y].getPiece().getPieceColor() == this.getPieceColor())
                {
                    System.out.println("this is illegal because its your piece");
                }
                else
                    {
                    temp.getChessboard()[x][y].setPiece(this);
                    temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[x][y].setPieceOn(true);
                    setX(x);
                    setY(y);
                }
            }
        }
    }

        public void printPiece()
        {
            System.out.print(this.getPieceColor() == PieceColor.WHITE ? "w" : "b");
            System.out.print("h ");
        }
    }

