import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class GridListener
    implements KeyListener
{
    CrosswordUI ui;

    public GridListener(CrosswordUI UI)
    {
        ui = UI;
    }


    @Override
    public void keyPressed(KeyEvent e)
    {
        CustomJTextField field = (CustomJTextField)e.getSource();
        int row = field.getRow();
        int col = field.getCol();
        if (e.getKeyCode() == KeyEvent.VK_DELETE)
        {
            if (field.getText().length() >= 1)
            {
                field.setText("");
            }
            else
            {
                if (ui.isAcross())
                {
                    ui.clearBlock(row, col-1);
                }
                else
                {
                    ui.clearBlock(row-1, col);
                }
            }
            ui.prevFocus();
        }
        else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if (field.getText().length() >= 1)
            {
                ui.clearBlock(row, col);
            }
            else
            {
                if (ui.isAcross())
                {
                    ui.clearBlock(row, col-1);
                }
                else
                {
                    ui.clearBlock(row-1, col);
                }
            }

            ui.prevFocus();
        }
        e.consume();
    }


    @Override
    public void keyReleased(KeyEvent e)
    {
        // ui.checkGrid();

        e.consume(); // this line exists because keyboards exist. period.

    }


    @Override
    public void keyTyped(KeyEvent e)
    {
        // Example provided by Dr. Bryson Payne to restrict user input length
        CustomJTextField field = (CustomJTextField)e.getSource();
        int row = field.getRow();
        int col = field.getCol();

        if (field.getText().length() >= 1
            && Character.isAlphabetic(e.getKeyChar()))
        {
            e.consume();
            field.setText(Character.toString(e.getKeyChar()));
            ui.nextFocus();
        }
        else if (Character.isAlphabetic(e.getKeyChar()))
        {
            field.setText(Character.toString(e.getKeyChar()));
            ui.nextFocus();
        }
        e.consume();
        ui.checkBlock(row, col);
    }
}
