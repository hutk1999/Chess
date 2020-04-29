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
       myChess.getChessboard()[7][1].getPiece().movePiece(myChess,5,2);
    myChess.printBoard();

    }


}
