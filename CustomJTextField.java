import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class CustomJTextField
    extends JTextField
{
    int row;
    int col;

    public CustomJTextField(int r, int c)
    {
        super();
        row = r;
        col = c;
        setCaretColor(new Color(0, 0, 0, 0));
        setBackground(new Color(0, 0, 0, 0));
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
    }


    public int getRow()
    {
        return row;
    }


    public int getCol()
    {
        return col;
    }
}
