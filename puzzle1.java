import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
public class puzzle1 extends CrossWordPuzzle
{
    private ArrayList<Word> arr;
    private char[][] squares;
    
    public puzzle1() throws FileNotFoundException
    {
        arr = super.getArrayList();
        squares = new char[11][16];
    }

    public void create()
    {
        for (int i = 0; i < 16; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                squares[0][1] = 'X';
                if (i == 1 && j < 12)
                {
                    squares[i][j] = 'X';
                }
                squares[2][1] = 'X';
                squares[2][3] = 'X';
                squares[2][5] = 'X';
                squares[2][11] = 'X';
                squares[2][15] = 'X';
                squares[3][1] = 'X';
                squares[3][3] = 'X';
                squares[3][5] = 'X';
                if (i == 3 && j >= 7)
                {
                    squares[i][j] = 'X';
                }
                squares[4][3] = 'X';
                squares[4][11] = 'X';
                squares[4][15] = 'X';
                if (i == 5 && j >= 2 && j < 7)
                {
                    squares[i][j] = 'X';
                }
                squares[5][8] = 'X';
                squares[5][11] = 'X';
                squares[5][15] = 'X';
                squares[6][6] = 'X';
                squares[6][8] = 'X';
                squares[6][15] = 'X';
                squares[7][6] = 'X';
                squares[7][8] = 'X';
                squares[7][15] = 'X';
                if (i == 8 && j > 2 && j < 12)
                {
                    squares[i][j] = 'X';
                }
                squares[8][15] = 'X';
                squares[9][8] = 'X';
                if (i == 10 && j > 2 && j < 9)
                {
                    squares[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        puzzle1 temp = new puzzle1();
        temp.create();
        for (int i = 0; i < temp.squares.length; i++)
        {
            for (int j = 0; j < temp.squares[0].length; j++)
            {
                if (temp.squares[i][j] == 'X')
                {
                    System.out.print(temp.squares[i][j]);
                }
                else
                {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    
}
