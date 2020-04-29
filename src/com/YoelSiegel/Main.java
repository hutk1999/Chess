package com.YoelSiegel;


import javax.swing.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
       Scanner scanNum = new Scanner(System.in);
       // int num1= scanNum.nextInt();
        //int num2 = scanNum.nextInt();

        Board myChess=new Board();
       myChess.makeBoard();
       //myChess.getChessboard()[7][1].getPiece().movePiece(myChess,5,2);
        myChess.getChessboard()[1][0].getPiece().movePiece(myChess, 3,0);
        myChess.getChessboard()[0][0].getPiece().movePiece(myChess, 2, 0);
        myChess.getChessboard()[2][0].getPiece().movePiece(myChess, 2, 2);
        myChess.getChessboard()[2][2].getPiece().movePiece(myChess, 6, 2);
         myChess.printBoard();

    }


}
