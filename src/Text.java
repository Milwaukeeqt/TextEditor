import javax.swing.*;
import java.awt.*;

/**
 * Created by Kim Hermansen on 16-03-2015.
 */
public class Text extends JTextPane {

    public Text() {
        requestFocusInWindow();

        setFont(new Font("Arial",Font.PLAIN, 16));
    }
}
