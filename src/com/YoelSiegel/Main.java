package com.YoelSiegel;


import javax.swing.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanNum = new Scanner(System.in);
        int num1= scanNum.nextInt();
        int num2 = scanNum.nextInt();

        Board myChess=new Board();
        myChess.makeBoard(myChess);

        //myChess.getChessboard()[1][1].getPiece().attackPiece(myChess);

        //myChess.getChessboard()[1][3].getPiece().movePiece(myChess, num1, num2);
       // myChess.getChessboard()[4][4].getPiece().movePiece(myChess, num1, num2);
        //myChess.getChessboard()[2][3].getPiece().attackPiece(myChess, num1, num2);
        myChess.printBoard();


    }




}










