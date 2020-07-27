package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean xWin = false,
                oWin = false,
                Draw = false,
                notFinished = true,
                X_or_O = true; //if true X turn, if false O turn
        Scanner scanner = new Scanner(System.in);
        int[][] field = new int[3][3];

        //filling the field
        {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    field[i][j] = 0;
                }
            }
        }

        while (notFinished) {
            printTheField(field);


//            //checking for impossible
//            {
//                if (xWin == true && oWin == true) {
//                    Impossible = true;
//                }
//                int xocounter = 0;
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        if (field[i][j] == 1) {
//                            xocounter++;
//                        }
//                        if (field[i][j] == 2) {
//                            xocounter--;
//                        }
//                    }
//                }
//                if (xocounter > 1 || xocounter < -1) {
//                    Impossible = true;
//                }
//            }
            System.out.println("Enter the coordinates: ");
            int X = 111, Y = 111;
            X = scanner.nextInt();
            Y = scanner.nextInt();

            while (X > 3 || X < 1 || Y > 3 || Y < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                X = scanner.nextInt();
                Y = scanner.nextInt();

            }
            boolean isoccupied = true;
            boolean isnumbers = true;
            boolean ismore13 = true;
            while (isoccupied || isnumbers || ismore13 ) {
                if(X == 111|| Y == 111){
                    System.out.println("You should enter numbers!");
                    X = scanner.nextInt();
                    Y = scanner.nextInt();
                    isnumbers = true;
                }
                else {
                    isnumbers = false;
                }
                if ((X > 3 || X < 1 || Y > 3 || Y < 1) && !isnumbers ) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    X = scanner.nextInt();
                    Y = scanner.nextInt();
                    ismore13 = true;
                }
                else {
                    ismore13 = false;
                }
                if(!ismore13 && !isnumbers) {
                    switch (Y) {
                        case 3:
                            if (field[0][X - 1] != 0) {
                                System.out.println("This cell is occupied! Choose another one!");
                                X = scanner.nextInt();
                                Y = scanner.nextInt();
                            } else {
                                isoccupied = false;
                                field = change(field, X, Y, X_or_O);
                            }
                            break;
                        case 2:
                            if (field[1][X - 1] != 0) {
                                System.out.println("This cell is occupied! Choose another one!");
                                X = scanner.nextInt();
                                Y = scanner.nextInt();
                            } else {
                                isoccupied = false;
                                field = change(field, X, Y, X_or_O);
                            }
                            break;
                        case 1:
                            if (field[2][X - 1] != 0) {
                                System.out.println("This cell is occupied! Choose another one!");
                                X = scanner.nextInt();
                                Y = scanner.nextInt();
                            } else {
                                isoccupied = false;
                                field = change(field, X, Y, X_or_O);
                            }
                            break;
                    }
                }
            }
            X_or_O = !X_or_O;
            //checking who is winning
            {
                for (int i = 0; i < 3; i++) {
                    if (field[0][i] == 1 && field[1][i] == 1 && field[2][i] == 1) {
                        xWin = true;
                    }
                    if (field[i][0] == 1 && field[i][1] == 1 && field[i][2] == 1) {
                        xWin = true;
                    }
                    if (field[0][i] == 2 && field[1][i] == 2 && field[2][i] == 2) {
                        oWin = true;
                    }
                    if (field[i][0] == 2 && field[i][1] == 2 && field[i][2] == 2) {
                        oWin = true;
                    }
                }
                if (field[0][0] == 1 && field[1][1] == 1 && field[2][2] == 1) {
                    xWin = true;
                }
                if (field[2][0] == 1 && field[1][1] == 1 && field[0][2] == 1) {
                    xWin = true;
                }
                if (field[0][0] == 2 && field[1][1] == 2 && field[2][2] == 2) {
                    oWin = true;
                }
                if (field[2][0] == 2 && field[1][1] == 2 && field[0][2] == 2) {
                    oWin = true;
                }
            }

            //checking for draw and finished
            {
                int zerocounter = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (field[i][j] == 0) {
                            zerocounter++;
                        }
                    }
                }
                if (zerocounter == 0 && (!xWin && !oWin)) {
                    Draw = true;
                }
                if(Draw || xWin || oWin){
                    notFinished = false;
                }
            }

        }
        printTheField(field);
        if (Draw) {
            System.out.println("Draw");
        }
            else if (xWin){
            System.out.println("X wins");
        }
        else {
            System.out.println("O wins");
        }
    }

    public static void printTheField(int[][] field){
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                if(field[i][j] == 1) {
                    System.out.print("X ");
                }
                else if(field[i][j] == 2) {
                    System.out.print("O ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static int[][] change(int[][] field, int X, int Y, boolean XO){
        if(XO){
            switch (Y){
                case 3:
                    field[0][X-1] = 1;
                    break;
                case 2:
                    field[1][X-1] = 1;
                    break;
                case 1:
                    field[2][X-1] = 1;
                    break;
            }
        } else {
            switch (Y){
                case 3:
                    field[0][X-1] = 2;
                    break;
                case 2:
                    field[1][X-1] = 2;
                    break;
                case 1:
                    field[2][X-1] = 2;
                    break;
            }
        }

        return field;
    }

}
