package com.YoelSiegel;

import java.util.Scanner;
/*
public class Game {
    public boolean gameover=false;
    public void playgame() {
        PieceColor winner=null;
        int turn=0;
        int tempx;
       int tempy;
       int tempx2;
       int tempy2;
        Scanner s=new Scanner(System.in);
    Board board =new Board();
    board.makeBoard();
    //starts game untill game is over
    for(turn=0;gameover!=true;turn++){
        //resets all tiles to no one attacking
        for(int i=0;i<8;i++){
            for(int j=0;j<8;i++){
                board.getChessboard()[i][j].attackedfromblack=false;
                board.getChessboard()[i][j].attackedfromwhite=false;
            }
        }
        //checks to see what moves are legal for king
    for(int i=0;i<8;i++){
        for(int j=0;j<8;i++){
            board.getChessboard()[i][j].getPiece().alltilesattacked(board);
        }
    }
        //checks who's turn it is
        if(turn%2==0) {
            System.out.println("its white's turn please enter the piece you want to move location on the  x axis");
            tempx = s.nextInt();
            //gets the x
            if ((tempx < 0) || (tempx > 7)) {
                System.out.println("this location in invalid");
                return;
            }
            //gets the y
            System.out.println("now please enter the pieces location on the y axis");
            tempy = s.nextInt();
            if ((tempy < 0) || (tempy > 7)) {
                System.out.println("this location in invalid");
                return;
            }

            //checks if that piece is occupied
            if (board.getChessboard()[tempx][tempy].isPieceOn() == false) {
                System.out.println("sorry there is no piece on that space please re enter coordinates");
                return;
            }
            //checks if that piece is yours;
            else if (board.getChessboard()[tempx][tempy].getPiece().getPieceColor() == PieceColor.BLACK) {
                System.out.println("sorry that piece is not your please re enter coordinates ");
                return;
            }
            //now if it works
            else {
                // we get the destinations x and y
                System.out.println("ok now please enter the coordinates for where you want to go");
                System.out.println("please enter the location on the x axis of where you want to go");
                tempx2 = s.nextInt();
                //check the x
                if ((tempx2 < 0) || (tempx2 > 7)) {
                    System.out.println("this location in invalid");
                    return;
                }
                System.out.println("please enter the location on the y axis of where you want to go");
                tempy2 = s.nextInt();
                //check the y
                if ((tempy2 < 0) || (tempy2 > 7)) {
                    System.out.println("this location in invalid");
                    return;
                }
                //check that your piece isn't there
                if (board.getChessboard()[tempx2][tempy2].getPiece().getPieceColor() == board.getChessboard()[tempx][tempy].getPiece().getPieceColor()) {
                    System.out.println("sorry this move is illegal your piece is there");
                    return;
                } else {
                    board.getChessboard()[tempx][tempy].getPiece().movePiece(board, tempx2, tempy2);
                }
            }
        }
        System.out.println("its blacks's turn please enter the piece you want to move location on the  x axis");
        tempx = s.nextInt();
        //gets the x
        if ((tempx < 0) || (tempx > 7)) {
            System.out.println("this location in invalid");
            return;
        }
        //gets the y
        System.out.println("now please enter the pieces location on the y axis");
        tempy = s.nextInt();
        if ((tempy < 0) || (tempy > 7)) {
            System.out.println("this location in invalid");
            return;
        }

        //checks if that piece is occupied
        if (board.getChessboard()[tempx][tempy].isPieceOn() == false) {
            System.out.println("sorry there is no piece on that space please re enter coordinates");
            return;
        }
        //checks if that piece is yours;
        else if (board.getChessboard()[tempx][tempy].getPiece().getPieceColor() == PieceColor.WHITE) {
            System.out.println("sorry that piece is not your please re enter coordinates ");
            return;
        }
        //now if it works
        else {
            // we get the destinations x and y
            System.out.println("ok now please enter the coordinates for where you want to go");
            System.out.println("please enter the location on the x axis of where you want to go");
            tempx2 = s.nextInt();
            //check the x
            if ((tempx2 < 0) || (tempx2 > 7)) {
                System.out.println("this location in invalid");
                return;
            }
            System.out.println("please enter the location on the y axis of where you want to go");
            tempy2 = s.nextInt();
            //check the y
            if ((tempy2 < 0) || (tempy2 > 7)) {
                System.out.println("this location in invalid");
                return;
            }
            //check that your piece isn't there
            if (board.getChessboard()[tempx2][tempy2].getPiece().getPieceColor() == board.getChessboard()[tempx][tempy].getPiece().getPieceColor()) {
                System.out.println("sorry this move is illegal your piece is there");
                return;
            } else {
                board.getChessboard()[tempx][tempy].getPiece().movePiece(board, tempx2, tempy2);
            }
        }
    }
    System.out.println("the winner is : "+winner);


            }
    }
*/



