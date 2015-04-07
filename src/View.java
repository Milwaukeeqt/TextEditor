import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Kim Hermansen on 16-03-2015.
 */
public class View extends JFrame implements Runnable {

    private static String title = "kmacs";

    private static int Width = 1000;
    private static int Height = 600;

    private Text text;
    private Tools tool;
    private Status status;

    @Override
    public void run() {
        View();
    }

    public void View() {
        InitComponent();
    }

    public void InitComponent() {

        text = new Text();
        Menu menu = new Menu(text, this);
        setJMenuBar(menu);
        tool = new Tools(text);
        status = new Status();
        getContentPane().add(tool,BorderLayout.NORTH);
        getContentPane().add(text,BorderLayout.CENTER);
        getContentPane().add(status,BorderLayout.SOUTH);
        add(new JScrollPane(text));

        setTitle(title);
        setSize(Width, Height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        text.requestFocusInWindow();
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String s) {
        title = title + " - " + s;

        //open file needs work
    }
}
