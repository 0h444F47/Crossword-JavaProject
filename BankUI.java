import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class BankUI extends JPanel
{
    private Coordinate grid;
    private JPanel down;
    private JPanel across;

    public BankUI(Coordinate c)
    {
        super();
        grid = c;
        setBounds(0,400,400,400);
        setLayout(new GridLayout(1,2,0,0));
        down = new JPanel();
        across = new JPanel();
        add(down);
        add(across);
        down.setBounds(0,0,200,400);
        across.setBounds(0,0,200,400);
        loadDown();
        loadAcross();
    }

    public void loadDown()
    {
        down.setLayout(new BoxLayout(down,BoxLayout.Y_AXIS));
        down.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextArea n = new JTextArea("Vertical");
        n.setFont(new Font("Arial",Font.BOLD,14));
        n.setEditable(false);
        n.setLineWrap(true);
        n.setWrapStyleWord(true);
        n.setFocusable(false);
        down.add(n);

        for (Word w: getGrid().getDWords())
        {
            n = new JTextArea(w.getNumber() + " : " + w.getClue());
            n.setEditable(false);
            n.setLineWrap(true);
            n.setWrapStyleWord(true);
            n.setFocusable(false);
            down.add(n);
        }
    }

    public void loadAcross()
    {
        across.setLayout(new BoxLayout(across,BoxLayout.Y_AXIS));
        across.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextArea n = new JTextArea("Horizontal");
        n.setFont(new Font("Arial",Font.BOLD,14));
        n.setEditable(false);
        n.setLineWrap(true);
        n.setWrapStyleWord(true);
        n.setFocusable(false);
        across.add(n);

        for (Word w: getGrid().getAWords())
        {
            n = new JTextArea(w.getNumber() + " : " + w.getClue());
            n.setEditable(false);
            n.setLineWrap(true);
            n.setWrapStyleWord(true);
            n.setFocusable(false);
            across.add(n);
        }
    }

    public Coordinate getGrid()
    {
        return grid;
    }
}
