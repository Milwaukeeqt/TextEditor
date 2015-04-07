import javax.swing.*;
import java.awt.*;

/**
 * Created by Kim Hermansen on 16-03-2015.
 */
public class Tools extends JToolBar {

    private String fonts[] = {"Arial","Serif","Monospaced"};
    private String sizes[] = {"12","14","16","18","20"};

    private JComboBox<String> comboFont;
    private JComboBox<String> comboSize;

    public Tools(Text pane) {

        JLabel font = new JLabel("Font");
        add(font);

        addSeparator();

        comboFont = new JComboBox<>(fonts);
        comboFont.setMaximumSize(comboFont.getPreferredSize());
        comboFont.setSelectedIndex(0);
        comboFont.addActionListener( e -> {
            try {
                pane.setFont(new Font(comboFont.getSelectedItem().toString(),Font.PLAIN, Integer.parseInt(comboSize.getSelectedItem().toString())));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        add(comboFont);

        addSeparator();

        JLabel size = new JLabel("Size");
        add(size);
        addSeparator();
        comboSize = new JComboBox<>(sizes);
        comboSize.setMaximumSize(comboSize.getPreferredSize());
        comboSize.setSelectedIndex(2);
        comboSize.addActionListener(e -> {
            try {
                pane.setFont(new Font(comboFont.getSelectedItem().toString(),Font.PLAIN, Integer.parseInt(comboSize.getSelectedItem().toString())));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        add(comboSize);

        addSeparator();

        JButton bold = new JButton("Bold");
        bold.setFont(new Font("bold",Font.BOLD,14));
        JButton itallic = new JButton("Itallic");
        itallic.setFont(new Font("itallic",Font.ITALIC,14));

        add(bold);
        add(itallic);

        bold.addActionListener(e -> {
            if(pane.getFont().isBold()) {
                pane.setFont(new Font(comboFont.getSelectedItem().toString(),Font.PLAIN, Integer.parseInt(comboSize.getSelectedItem().toString())));
            } else {
                pane.setFont(new Font(comboFont.getSelectedItem().toString(), Font.BOLD, Integer.parseInt(comboSize.getSelectedItem().toString())));
            }
        });

        itallic.addActionListener(e -> {
            if(pane.getFont().isItalic()) {
                pane.setFont(new Font(comboFont.getSelectedItem().toString(),Font.PLAIN, Integer.parseInt(comboSize.getSelectedItem().toString())));
            } else {
                pane.setFont(new Font(comboFont.getSelectedItem().toString(), Font.ITALIC, Integer.parseInt(comboSize.getSelectedItem().toString())));
            }
        });

        setFloatable(false);

    }
}
