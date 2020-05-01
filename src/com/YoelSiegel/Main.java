package com.YoelSiegel;


import javax.swing.*;
import java.util.Scanner;

public class Main {
//there are lots of double code in the attacks and moves we need to make attack unaccesible at all except from move unless its pawn  idea is to say unless move sent it its illegal

    public static void main(String[] args) {
       Scanner scanNum = new Scanner(System.in);
       // int num1= scanNum.nextInt();
        //int num2 = scanNum.nextInt();

        Board myChess=new Board();
       myChess.makeBoard();
      myChess.getChessboard()[1][0].getPiece().movePiece(myChess, 3, 0);
        myChess.getChessboard()[0][0].getPiece().movePiece(myChess, 2, 0);
        myChess.getChessboard()[2][0].getPiece().movePiece(myChess, 2, 2);
        myChess.getChessboard()[2][2].getPiece().movePiece(myChess, 5, 2);
        myChess.getChessboard()[6][1].getPiece().movePiece(myChess, 5, 2);
        myChess.getChessboard()[7][2].getPiece().movePiece(myChess, 5, 0);
        myChess.getChessboard()[0][1].getPiece().movePiece(myChess, 2, 2);
        myChess.getChessboard()[6][4].getPiece().movePiece(myChess, 4, 4);
        myChess.getChessboard()[7][3].getPiece().movePiece(myChess, 3, 7);
        myChess.getChessboard()[5][0].getPiece().movePiece(myChess, 2, 3);
        myChess.getChessboard()[6][7].getPiece().movePiece(myChess, 4, 7);
        myChess.getChessboard()[2][3].getPiece().movePiece(myChess, 6, 7);
        myChess.getChessboard()[7][5].getPiece().movePiece(myChess, 2, 0);
        myChess.printBoard();
    }


}
