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
        if ((x == getX()) || (y == getY())) {
            //castles code for move
        } else if ((getX() - x) == (getY() - y)) {
            //code for bishop
        } else {
            System.out.println("this move is illegal");
            return;
        }

    }
    //clearly needs work
    public void attackPiece(Board temp,int x,int y){

    }
    //this should be good i copied in the code for castle and bishop
    public void alltilesattacked(Board temp) {
        //this is the bishop part i dont think we can send to bishop...
        //checks if piece is white
        if (this.getPieceColor() == PieceColor.WHITE) {

            //checks if x is bigger and y is bigger
            for (int i = 1; (getX() + i < 8) && (getY() + i < 8); i++) {
                if (temp.getChessboard()[getX() + i][getY() + i].isPieceOn() == false) {
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
                if (temp.getChessboard()[getX() - i][getY() - i].isPieceOn() == false) {
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
                if (temp.getChessboard()[getX() + i][getY() - i].isPieceOn() == false) {
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
                if (temp.getChessboard()[getX() - i][getY() + i].isPieceOn() == false) {
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
                if (temp.getChessboard()[getX() + i][getY() + i].isPieceOn() == false) {
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
                if (temp.getChessboard()[getX() - i][getY() - i].isPieceOn() == false) {
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
                if (temp.getChessboard()[getX() + i][getY() - i].isPieceOn() == false) {
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
                if (temp.getChessboard()[getX() - i][getY() + i].isPieceOn() == false) {
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