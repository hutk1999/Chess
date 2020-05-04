package com.YoelSiegel;


import javax.swing.*;
import java.util.Scanner;

public class Main {
//there are lots of double code in the attacks and moves we need to make attack unaccesible at all except from move unless its pawn  idea is to say unless move sent it its illegal

    public static void main(String[] args) {
        Scanner scanNum = new Scanner(System.in);
        // int num1= scanNum.nextInt();
        //int num2 = scanNum.nextInt();

        Board myChess = new Board();
        myChess.makeBoard();
        myChess.gettile(1,1).getPiece().movePiece(myChess,3,1);
        myChess.printBoard();
    }


}
