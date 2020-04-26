package com.YoelSiegel;


import javax.swing.*;
//make an enum for pieceColor!!!!!!!!!!!!!
//^^^^^^^^^^^^^^^^^^^^^^
//^^^^^^^^^^^^^^^^^^^^^^

public class Main {


    public static void main(String[] args) {
        Board myChess=new Board();
        myChess.assignColors();
        Pawn temp0=new Pawn(false, 1,0);
        myChess.getChessboard()[1][0].setPiece(temp0);
        Pawn temp1=new Pawn(false, 1,1);
        myChess.getChessboard()[1][1].setPiece(temp1);
        Pawn temp2=new Pawn(false, 1,2);
        myChess.getChessboard()[1][2].setPiece(temp2);
        Pawn temp3=new Pawn(false, 1,3);
        myChess.getChessboard()[1][3].setPiece(temp3);
        Pawn temp4=new Pawn(false, 1,4);
        myChess.getChessboard()[1][4].setPiece(temp4);
        Pawn temp5=new Pawn(false, 1,5);
        myChess.getChessboard()[1][5].setPiece(temp5);
        Pawn temp6=new Pawn(false, 1,6);
        myChess.getChessboard()[1][6].setPiece(temp6);
        Pawn temp7=new Pawn(false, 1,7);
        myChess.getChessboard()[1][7].setPiece(temp7);
        //myChess.getChessboard()[1][2].getPiece().movePiece(myChess);
        myChess.printBoard();


    }


}
