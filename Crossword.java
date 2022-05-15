import javax.swing.*;
// GONNA KEEP THIS
// RUN THIS FILE TO SEE PROJECT
public class Crossword
{
    public static void main(String[] args)
    {
        CrossWindow window = new CrossWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setBounds(0, 0, 400, 800);
    }
}