import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

/**
 * Provides GUI for all six crossword puzzles
 */
public class CrossWindow
    extends JFrame
{
    private static JFrame  thisWindow;

    private Stack<JPanel>  backward    = new Stack<JPanel>();
    private JButton[]      menuButtons = new JButton[10];
    private ButtonListener ears;

    /**
     * Constructs a new Menu window used to access the six crossword puzzles
     */
    public CrossWindow()
    {
        super("Menu");
        thisWindow = this;
        ears = new ButtonListener();
        setLayout(null);

        loadMenu();
    }


    public void loadMenu()
    {
        JButton btn = new JButton("Singleplayer");
        JButton btn1 = new JButton("Multiplayer");
        JPanel thisPanel = new JPanel();
        Container pane = thisWindow.getContentPane();

        thisPanel.setBounds(0,0,400,400);
        thisPanel.setLayout(new BoxLayout(thisPanel,BoxLayout.Y_AXIS));
        thisPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn.addActionListener(ears);
        btn1.addActionListener(ears);

        thisPanel.add(btn);
        thisPanel.add(btn1);
        pane.add(thisPanel);
    }


    public void loadSingle() // Problem: adds to panel with each click. Might break after n tests.
    {
        JPanel thisPanel = new JPanel();
        JButton btn = new JButton("Home");
        Container pane = thisWindow.getContentPane();

        thisPanel.setBounds(0,0,400,400);

        btn.addActionListener(ears);
        loadLevels(thisPanel);
        thisPanel.add(btn);
        pane.add(thisPanel);
        System.out.println("runs");
    }


    public void loadLevels(JPanel thisPanel)
    {
        JButton[] temp = new JButton[5];

        for (int i = 0; i < 5; i++)
        {
            temp[i] = new JButton("Level " + (i+1));
            temp[i].addActionListener(ears);
            thisPanel.add(temp[i]);
        }
    }

    public void loadPuzzle1() throws FileNotFoundException
    {
        CrossWordPuzzle loadTool = new CrossWordPuzzle("puzzle1.txt");
        ArrayList<Word> words = loadTool.getArrayList();
        CrosswordUI ui = new CrosswordUI(11,16);
        Container c = getContentPane();

        
        loadWords(ui,words);
        ui.loadCrossword();
        

        BankUI b = new BankUI(ui.getGrid());
        
        c.add(loadHeader());
        c.add(ui);
        c.add(b);
    }
    
    public void loadPuzzle2() throws FileNotFoundException
    {
        CrossWordPuzzle loadTool = new CrossWordPuzzle("puzzle2.txt");
        ArrayList<Word> words = loadTool.getArrayList();
        CrosswordUI ui = new CrosswordUI(7,7);
        Container c = getContentPane();

        
        loadWords(ui,words);
        ui.loadCrossword();
        

        BankUI b = new BankUI(ui.getGrid());
        
        c.add(loadHeader());
        c.add(ui);
        c.add(b);
    }

    public void loadPuzzle3() throws FileNotFoundException
    {
        CrossWordPuzzle loadTool = new CrossWordPuzzle("puzzle3.txt");
        ArrayList<Word> words = loadTool.getArrayList();
        CrosswordUI ui = new CrosswordUI(13,13);
        Container c = getContentPane();

        
        loadWords(ui,words);
        ui.loadCrossword();
        

        BankUI b = new BankUI(ui.getGrid());
        
        c.add(loadHeader());
        c.add(ui);
        c.add(b);
    }

    public void loadPuzzle4() throws FileNotFoundException
    {
        CrossWordPuzzle loadTool = new CrossWordPuzzle("puzzle4.txt");
        ArrayList<Word> words = loadTool.getArrayList();
        CrosswordUI ui = new CrosswordUI(13,13);
        Container c = getContentPane();

        
        loadWords(ui,words);
        ui.loadCrossword();
        

        BankUI b = new BankUI(ui.getGrid());
        
        c.add(loadHeader());
        c.add(ui);
        c.add(b);
    }

    //TODO
    public void loadPuzzle5() throws FileNotFoundException
    {
        CrossWordPuzzle loadTool = new CrossWordPuzzle("puzzle1.txt");
        ArrayList<Word> words = loadTool.getArrayList();
        CrosswordUI ui = new CrosswordUI(11,16);
        Container c = getContentPane();

        
        loadWords(ui,words);
        ui.loadCrossword();
        

        BankUI b = new BankUI(ui.getGrid());
        
        c.add(loadHeader());
        c.add(ui);
        c.add(b);
    }

    //TODO
    public void loadPuzzle6() throws FileNotFoundException
    {
        CrossWordPuzzle loadTool = new CrossWordPuzzle("puzzle1.txt");
        ArrayList<Word> words = loadTool.getArrayList();
        CrosswordUI ui = new CrosswordUI(11,16);
        Container c = getContentPane();

        
        loadWords(ui,words);
        ui.loadCrossword();
        

        BankUI b = new BankUI(ui.getGrid());
        
        c.add(loadHeader());
        c.add(ui);
        c.add(b);
    }

    public void loadWords(CrosswordUI ui, ArrayList<Word> words)
    {
        for (Word w: words)
        {
            ui.insertWord(w);
        }
    }

    public JPanel loadHeader() // only for puzzles
    {
        JPanel header = new JPanel();
        JButton btn = new JButton("Home");

        header.setLayout(null);
        header.setBounds(0,0,400,20);
        header.setBackground(new Color(255,255,255));
        header.add(btn);

        btn.addActionListener(ears);
        btn.setBounds(5,5,40,10);
        btn.setFont(new Font("Arial",Font.PLAIN,10));

        return header;

    }

    public void back()
    {
        if (!backward.isEmpty())
        {
            JPanel temp = backward.pop();
            temp.setVisible(true);
        }
    }

    private class ButtonListener
        implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton btn = ((JButton)e.getSource());
            if (btn.getText().equals("Singleplayer"))
            {
                thisWindow.getContentPane().removeAll();
                thisWindow.repaint();
                loadSingle();
                getContentPane().revalidate();
            }
            else if (btn.getText().equals("Home"))
            {
                thisWindow.getContentPane().removeAll();
                thisWindow.repaint();
                loadMenu();
                getContentPane().revalidate();
            }
            else if (btn.getText().equals("Level 1"))
            {
                thisWindow.getContentPane().removeAll();
                thisWindow.repaint();
                try
                {
                    loadPuzzle1();
                }
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                getContentPane().revalidate();
            }
            else if (btn.getText().equals("Level 2"))
            {
                thisWindow.getContentPane().removeAll();
                thisWindow.repaint();
                try
                {
                    loadPuzzle2();
                }
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                getContentPane().revalidate();
            }
            else if (btn.getText().equals("Level 3"))
            {
                thisWindow.getContentPane().removeAll();
                thisWindow.repaint();
                try
                {
                    loadPuzzle3();
                }
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                getContentPane().revalidate();
            }
            else if (btn.getText().equals("Level 4"))
            {
                thisWindow.getContentPane().removeAll();
                thisWindow.repaint();
                try
                {
                    loadPuzzle4();
                }
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                getContentPane().revalidate();
            }
            else if (btn.getText().equals("Level 5"))
            {
                thisWindow.getContentPane().removeAll();
                thisWindow.repaint();
                try
                {
                    loadPuzzle5();
                }
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                getContentPane().revalidate();
            }
            else if (btn.getText().equals("Level 6"))
            {
                thisWindow.getContentPane().removeAll();
                thisWindow.repaint();
                try
                {
                    loadPuzzle6();
                }
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                getContentPane().revalidate();
            }
        }
    }
}
