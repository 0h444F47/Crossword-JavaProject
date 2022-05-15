import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

/**
 * Class responsible for creating the UI of each crossword puzzle
 */
public class CrosswordUI
    extends JPanel
{

    private JLabel[][] j;
    private Coordinate grid;
    // private ArrayList<LinkedList<JTextField>> dwords; // accesser for words
    // ranked by num
    // private ArrayList<LinkedList<JTextField>> awords;
    // private ArrayList<Word> record;
    private int[]      curr; // starting at 0,0 (fine since java autofocus)
    private boolean    across;

    public CrosswordUI(int row, int col)
    {
        super();
        this.grid = new Coordinate(row, col);
        j = new JLabel[getRow()][getCol()];
        // dwords = new ArrayList<LinkedList<JTextField>>();
        // awords = new ArrayList<LinkedList<JTextField>>();
        // record = new ArrayList<Word>();
        curr = new int[2];
        across = true;

        setBounds(0, 20, 400, 380);
        setLayout(new GridLayout(row, col, 1, 1));
        setVisible(true);
        setBackground(new Color(255, 255, 255));
    }


    public void insertWord(Word word)
    {
        // grid is answer key
        // j is dum field for users to play with
        // code takes 2x time..
        grid.insertWord(word);
        // record.add(word);
    }


    public void loadCrossword()
    {

        int row = getRow();
        int col = getCol(); // Local storage

        GridListener gridListener = new GridListener(this); // key listener
                                                            // (triggers word
                                                            // check)
        MouseListener mouseListener = new MouseListener(this);
        for (int r = 0; r < row; r++)
        {
            for (int c = 0; c < col; c++)
            {
                JLabel temp = new JLabel();
                CustomJTextField t = new CustomJTextField(r, c);

                temp.setLayout(new GridLayout());
                temp.add(t);
                setLabel(r, c, temp);

                add(temp);
                t.addKeyListener(gridListener);
                t.addMouseListener(mouseListener);

                Box box = getGrid().getBox(r, c);

                if (box == null)
                {
                    temp.setVisible(false);
                }
                else if (box.isHead())
                {
                    temp.setText(Integer.toString(grid.getBox(r, c).getNum()));
                    temp.setFont(new Font("Arial", Font.PLAIN, 8));
                    temp.setVerticalAlignment(JLabel.TOP);
                }

                temp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                t.setEditable(false);
            }
        }
        // loadConnectors();
        labelAt(currentRow(), currentCol())
            .setBackground(new Color(0, 0, 255, 80));
    }


    public void clearGrid()
    {
        for (int r = 0; r < j.length; r++)
        {
            for (int c = 0; c < j[r].length; c++)
            {
                getField(r, c).setText("");
            }
        }
    }


    public void checkBlock(int row, int col)
    {
        if (!inBounds(row,col))
        {
            return;
        }

        CustomJTextField field = getField(row, col);
        String input = field.getText().toUpperCase();
        String key = Character.toString(getGrid().charAt(row, col));
        if (input.equals(key.toUpperCase())) // if user input matches
                                             // answer key turn text
                                             // green else red
        {
            field.setForeground(Color.GREEN);
        }
        else
        {
            field.setForeground(Color.RED);
        }

        // if (input.length() < 1) // if empty change back to black (might not
        // need)
        // {
        // field.setForeground(Color.BLACK);
        // }
    }

    public void clearBlock(int row, int col)
    {
        if (!inBounds(row,col))
        {
            return;
        }

        CustomJTextField field = getField(row, col);
        field.setText("");
    }

    public boolean inBounds(int row, int col)
    {
        return (row < getRow() && row >= 0) || (col < getCol() && col >= 0);
    }

    /**
     * change later.
     */
    public void checkGrid()
    {
        for (int r = 0; r < getRow(); r++)
        {
            for (int c = 0; c < getCol(); c++)
            {
                checkBlock(r, c);
            }
        }
    }


    public int getRow()
    {
        return grid.getRow();
    }


    public int getCol()
    {
        return grid.getCol();
    }

    // public void loadConnectors()
    // {
    // for (Word word : record)
    // {
    // LinkedList<JTextField> temp = new LinkedList<JTextField>();
    // if (word.getDirection().equals("Across"))
    // {
    // awords.add(temp);
    // for (int c = word.getXpos(); c < word.getXpos()
    // + word.length(); c++)
    // {
    // temp.add((JTextField)j[word.getYpos()][c].getComponent(0));
    // }
    // }
    // else
    // {
    // dwords.add(temp);
    // for (int r = word.getYpos(); r < word.getYpos()
    // + word.length(); r++)
    // {
    // temp.add((JTextField)j[r][word.getXpos()].getComponent(0));
    // }
    // }

    // }
    // }


    public void nextFocus()
    {
        int currCol = currentCol();
        int currRow = currentRow();
        if (isAcross() && currCol + 1 < getCol()
            && labelAt(currRow, currCol + 1).isVisible())
        {
            getField(currRow, currCol + 1).grabFocus();
            updateCurrent(currRow, currCol + 1);
            highlight(new Color(0, 0, 255, 40));
            getField(currRow, currCol + 1)
                .setBackground(new Color(0, 0, 255, 80));
        }
        else if (!isAcross() && currRow + 1 < getRow()
            && labelAt(currRow + 1, currCol).isVisible())
        {
            getField(currRow + 1, currCol).grabFocus();
            updateCurrent(currRow + 1, currCol);
            highlight(new Color(0, 0, 255, 40));
            getField(currRow + 1, currCol)
                .setBackground(new Color(0, 0, 255, 80));
        }
    }


    public void prevFocus()
    {
        int currCol = currentCol();
        int currRow = currentRow();
        if (isAcross() && currCol - 1 >= 0
            && labelAt(currRow, currCol - 1).isVisible())
        {
            getField(currRow, currCol - 1).grabFocus();
            updateCurrent(currRow, currCol - 1);
            highlight(new Color(0, 0, 255, 40));
            getField(currRow, currCol - 1)
                .setBackground(new Color(0, 0, 255, 80));
        }
        else if (!isAcross() && currRow - 1 >= 0
            && labelAt(currRow - 1, currCol).isVisible())
        {
            getField(currRow - 1, currCol).grabFocus();
            updateCurrent(currRow - 1, currCol);
            highlight(new Color(0, 0, 255, 40));
            getField(currRow - 1, currCol)
                .setBackground(new Color(0, 0, 255, 80));
        }
    }


    public void setFocus(CustomJTextField t)
    {
        int newCol = t.getCol();
        int newRow = t.getRow();

        highlight(new Color(0, 0, 0, 0));
        // getField(currRow, currCol).setBackground(new Color(0, 0, 0, 0));
        updateCurrent(newRow, newCol);
        highlight(new Color(0, 0, 255, 40));
        getField(newRow, newCol).setBackground(new Color(0, 0, 255, 80));
    }


    public void highlight(Color color)
    {
        if (isAcross())
        {
            for (int c = currentCol(); c < getCol(); c++)
            {
                CustomJTextField field = getField(currentRow(), c);
                if (labelAt(currentRow(), c).isVisible())
                {
                    field.setBackground(color);
                }
                else
                {
                    break;
                }
            }

            for (int c = currentCol(); c >= 0; c--)
            {
                CustomJTextField field = getField(currentRow(), c);
                if (labelAt(currentRow(), c).isVisible())
                {
                    field.setBackground(color);
                }
                else
                {
                    break;
                }
            }
        }
        else
        {
            for (int r = currentRow(); r < getRow(); r++)
            {
                CustomJTextField field = getField(r, currentCol());
                if (labelAt(r, currentCol()).isVisible())
                {
                    field.setBackground(color);
                }
                else
                {
                    break;
                }
            }

            for (int r = currentRow(); r >= 0; r--)
            {
                CustomJTextField field = getField(r, currentCol());
                if (labelAt(r, currentCol()).isVisible())
                {
                    field.setBackground(color);
                }
                else
                {
                    break;
                }
            }
        }
    }


    public void redirect()
    {
        highlight(new Color(0, 0, 0, 0));
        across = !across;
    }


    public void setLabel(int row, int col, JLabel label)
    {
        if (!inBounds(row,col))
        {
            return;
        }

        j[row][col] = label;
    }


    public JLabel labelAt(int row, int col)
    {
        if (!inBounds(row,col))
        {
            return null;
        }

        return j[row][col];
    }


    public CustomJTextField getField(JLabel j)
    {
        return (CustomJTextField)j.getComponent(0); // don't call if you know j
                                                    // has
        // more than one component
    }


    public CustomJTextField getField(int row, int col)
    {
        if (!inBounds(row,col))
        {
            return null;
        }

        return getField(labelAt(row, col));
    }


    public int currentRow()
    {
        return curr[0];
    }


    public int currentCol()
    {
        return curr[1];
    }


    public void updateCurrent(int row, int col)
    {
        curr[0] = row;
        curr[1] = col;
    }


    public Coordinate getGrid()
    {
        return grid;
    }


    public boolean isAcross()
    {
        return across;
    }
}
