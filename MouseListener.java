import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.MouseInputListener;
import java.util.*;
public class MouseListener implements MouseInputListener{
    private CrosswordUI ui;

    public MouseListener(CrosswordUI UI)
    {
        ui = UI;
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        
    }
    @Override
    public void mouseClicked(MouseEvent e)
    {
        
    }
    @Override
    public void mousePressed(MouseEvent e)
    {
        CustomJTextField field = (CustomJTextField)(e.getSource());

        if (ui.currentCol() == field.getCol() && ui.currentRow() == field.getRow())
        {
            ui.redirect();
        }

        ui.setFocus(field);
    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
    
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        
        System.out.println(6);
    }
}
