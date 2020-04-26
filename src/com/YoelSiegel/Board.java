package com.YoelSiegel;


public class Board {
    public Tiles[][] getChessboard() {
        return chessboard;
    }

    public void setChessboard(Tiles[][] chessboard) {
        this.chessboard = chessboard;
    }

    private Tiles[][] chessboard =new Tiles[8][8];

    public void assignColors(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (((i+j)%2)==0) {
                    chessboard[i][j]=new Tiles(true);
                } else{
                    chessboard[i][j]=new Tiles(false);
                }
            }
        }
    }
    public void printBoard(){

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessboard[i][j].isPieceOn()==true)
                    chessboard[i][j].getPiece().whatPiece();
                System.out.print(chessboard[i][j].isPieceOn()+"   ");

            }
            System.out.println();
        }
    }


}
