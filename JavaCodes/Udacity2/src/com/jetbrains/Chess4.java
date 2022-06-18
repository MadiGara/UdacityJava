package com.jetbrains;

public class Chess4 {

    class Game {
        Piece [][] board;
        //Constructor creates an empty board
        Game() {
            board = new Piece[8][8];
        }
    }
    class Position {
        int row;
        int column;
        //Constructor using row and column values
        Position(int r, int c) {
            this.row = r;
            this.column = c;
        }
    }
    class Piece {
        protected int column;
        protected int row;

        boolean isValidMove(Position newPosition) {
            if(newPosition.row > 0 && newPosition.column > 0 &&
                    newPosition.row < 8 && newPosition.column < 8) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    class Rook extends Piece{
        boolean isValidMove(Position newPosition){
            // First call the parent's method to check for the board bounds
            if(!super.isValidMove(newPosition)){
                return false;
            }
            // If we passed the first test then check for the specific rook movement
            if(newPosition.column == this.column && newPosition.row == this.row){
                return true;
            }
            else{
                return false;
            }
        }
    }

    class Queen extends Piece {
        boolean isValidMove(Position newPosition) {
            if(!super.isValidMove(newPosition)) {
                return false;
            }
            if((Math.abs(newPosition.column - this.column) ==
                    Math.abs(newPosition.row - this.row))
                    // Checks for if valid diagonal move
                    || (newPosition.column == this.column || newPosition.row ==
                            this.row)) {
                    // Checks for if valid straight line move
                return true;
            }
            else {
                return false;
            }
            // this is their code, they're declaring something that isn't working
            // but whatever, I was just asked to rework the Queen class
        }
    }
}
