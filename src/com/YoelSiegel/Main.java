package com.YoelSiegel;


import javax.swing.*;


public class Main {


    public static void main(String[] args) {
        Board myChess=new Board();
        myChess.assignColors();
        Pawn temp0=new Pawn(PieceColor.BLACK, 1,0);
        myChess.getChessboard()[1][0].setPiece(temp0);
        Pawn temp1=new Pawn(PieceColor.BLACK, 1,1);
        myChess.getChessboard()[1][1].setPiece(temp1);
        Pawn temp2=new Pawn(PieceColor.BLACK, 1,2);
        myChess.getChessboard()[1][2].setPiece(temp2);
        Pawn temp3=new Pawn(PieceColor.BLACK, 1,3);
        myChess.getChessboard()[1][3].setPiece(temp3);
        Pawn temp4=new Pawn(PieceColor.BLACK, 1,4);
        myChess.getChessboard()[1][4].setPiece(temp4);
        Pawn temp5=new Pawn(PieceColor.BLACK, 1,5);
        myChess.getChessboard()[1][5].setPiece(temp5);
        Pawn temp6=new Pawn(PieceColor.BLACK, 1,6);
        myChess.getChessboard()[1][6].setPiece(temp6);
        Pawn temp7=new Pawn(PieceColor.BLACK, 1,7);
        myChess.getChessboard()[1][7].setPiece(temp7);
        Pawn temp=new Pawn(PieceColor.WHITE, 2,2);
        myChess.getChessboard()[2][2].setPiece(temp);
        //myChess.getChessboard()[1][1].getPiece().attackPiece(myChess);
        //myChess.getChessboard()[2][2].getPiece().movePiece(myChess);
        myChess.printBoard();


    }


}
