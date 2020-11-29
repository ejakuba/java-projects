package erik.jakuba;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        drawPlayingArray(6);
    }

    public static void drawPlayingArray(int rows) {

        char array[][] = new char[rows + 1][rows + 2]; //[y][x]

        System.out.println("Printing " + rows + " x " + rows + " array...");


        char number = '1';
        char letter = 'A';
        array[0][0] = ' ';
        array[0][1] = ' ';


        // oznacenie osi y
        for (int i = 1; i <= rows; i++) {
            array[i][0] = letter;
            letter++;
        }


        //oznacenie osi x
        for (int j = 2; j <= rows + 1; j++) {
            array[0][j] = number;
            number++;
        }

        //nastavenie hodnot pola -
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows + 1; j++) {
                array[i][j] = '-';
            }
        }

        for (int i = 1; i <= rows; i++) {
            array[i][1] = ' ';
        }

        array[1][2] = 'O';
        array[1][3] = 'O';
        array[1][4] = 'O';

        array[2][2] = 'X';
        array[3][2] = 'X';
        array[4][2] = 'O';
        array[5][2] = 'O';
        array[6][2] = 'O';


        //vykreslenie pola
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= rows + 1; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

        System.out.println(checkHorizontal(array, 3));
        System.out.println(checkVertical(array,3));

    }

//    public static char checkIfIsWon(char array[][], int difficulty) {
//        if (array != null) {
//
//        }
//        return "";
//    }

    public static char checkHorizontal(char array[][], int difficulty) {
        int lengthX = array.length + 1;
        int lengthY = array.length;

        System.out.println("Horizontal check...");

        for (int i = 1; i < lengthY; i++) {
            for (int j = 2; j < lengthX; j++) {
                if (((j + difficulty) - 1) < lengthX) {
                    int counterX = 0;
                    int counterO = 0;
                    for (int k = 0; k < difficulty; k++) {
                        if (array[i][k + j] == 'X') {
                            counterX++;
                        } else if (array[i][k + j] == 'O') {
                            counterO++;
                        }
                        if (counterX == difficulty) {
                            return 'X';
                        }
                        if (counterO == difficulty) {
                            return 'O';
                        }
                    }
                }
            }
        }
        return 'N';
    }

    public static char checkVertical(char array[][], int difficulty) {
        int lengthX = array.length + 1;
        int lengthY = array.length;

        System.out.println("Vertical check...");

        for (int i = 2; i < lengthX; i++) {
            for (int j = 1; j < lengthY; j++) {
                if (((j + difficulty) - 1) < lengthY) {
                    int counterX = 0;
                    int counterO = 0;
                    for (int k = 0; k < difficulty; k++) {
                        if (array[k + j][i] == 'X') {
                            counterX++;
                        } else if (array[k + j][i] == 'O') {
                            counterO++;
                        }
                        if (counterX == difficulty) {
                            return 'X';
                        }
                        if (counterO == difficulty) {
                            return 'O';
                        }
                    }
                }
            }
        }
        return 'N';
    }


}

