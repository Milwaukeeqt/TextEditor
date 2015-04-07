import javax.swing.*;
/**
 * Created by Kim Hermansen on 16-03-2015.
 */
public class Status extends JToolBar {

    JLabel status;

    protected Status() {
        status = new JLabel("OK!");
        add(status);
        setFloatable(false);
    }

    public void setStatus(String s) {
        status.setText("Gem");
    }
}
