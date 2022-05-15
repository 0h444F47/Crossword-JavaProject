import java.util.*;

public class Coordinate
{
    private Box[][] grid; // 2d row col sys
    private ArrayList<Word> dword;
    private ArrayList<Word> aword;

    public Coordinate(int row, int col)
    {
        grid = new Box[row][col];
        dword = new ArrayList<Word>();
        aword = new ArrayList<Word>();
    }


    /**
     * @param row
     *            begining row
     * @param col
     *            begining col
     * @param word
     *            the word
     */
    public void insertWord(Word word)
    {
        // if word direction is h increment col and place chars
        // if is v increment row and place chars
        // maybe check if plane has thing

        // structure of crossword.txt is x y not row col. warn.

        String w = word.getWord();
        int length = word.length();
        int idx = 0;
        int col = word.getXpos();
        int row = word.getYpos();
        boolean first = true;

        if (word.getDirection().equals("Across"))
        {
            aword.add(word);
            for (int c = col; c < col + length; c++)
            {
                if (first)
                {
                    grid[row][c] = new Box(
                        Character.toUpperCase(w.charAt(idx)),
                        word.getNumber());
                    first = false;
                }
                else
                {
                    grid[row][c] =
                        new Box(Character.toUpperCase(w.charAt(idx)), 0);
                }

                idx++;
            }

        }
        else
        {
            dword.add(word);
            for (int r = row; r < row + length; r++)
            {
                if (first)
                {
                    grid[r][col] = new Box(
                        Character.toUpperCase(w.charAt(idx)),
                        word.getNumber());
                    first = false;
                }
                else
                {
                    grid[r][col] =
                        new Box(Character.toUpperCase(w.charAt(idx)), 0);
                }
                idx++;
            }
        }
    }


    public int getRow()
    {
        return grid.length;
    }


    public int getCol()
    {
        return grid[0].length;
    }


    public Box getBox(int r, int c)
    {
        return grid[r][c];
    }


    public char charAt(int r, int c)
    {
        if (getBox(r, c) == null)
        {
            return '\0';
        }
        return getBox(r, c).getChar();
    }


    public String toString()
    {
        String str = "";
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                str += grid[r][c] + "\t";
            }
            str += "\n";
        }
        return str;
    }

    public ArrayList<Word> getDWords()
    {
        return dword;
    }

    public ArrayList<Word> getAWords()
    {
        return aword;
    }


    /**
     * @param row
     *            begining row
     * @param col
     *            begining col
     * @param dir
     *            the direction to look in (horizontal or vertical)
     * @return ON HOLD
     */
    public Word getWord(int row, int col, String dir)
    {
        // returns the word
        return null;
    }
}
