import sun.font.AttributeMap;

import javax.management.Attribute;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.CSS;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.Map;

/**
 * Created by Kim Hermansen on 16-03-2015.
 */
public class Tools extends JToolBar {

    private String fonts[] = {"Arial","Serif","Monospaced"};
    private String sizes[] = {"12","14","16","18","20"};

    private JComboBox<String> comboFont;
    private JComboBox<String> comboSize;

    public Tools(Text pane) {

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

        JButton bold = new JButton("B");
        bold.setFont(new Font("Times New Roman",Font.BOLD,13));
        JButton itallic = new JButton("I");
        itallic.setFont(new Font("Times New Roman",Font.ITALIC,13));
        JButton underline = new JButton("U");
        underline.setFont(new Font("Times New Roman",Font.PLAIN,13));

        add(bold);
        add(itallic);
        add(underline);

        bold.addActionListener(e -> {
            if (!pane.getFont().isBold()) {
                if (pane.getFont().isItalic()) {
                    pane.setFont(new Font(comboFont.getSelectedItem().toString(), Font.BOLD | Font.ITALIC, Integer.parseInt(comboSize.getSelectedItem().toString())));
                } else {
                    pane.setFont(new Font(comboFont.getSelectedItem().toString(), Font.BOLD, Integer.parseInt(comboSize.getSelectedItem().toString())));
                }
            } else {
                if (!pane.getFont().isItalic()) {
                    pane.setFont(new Font(comboFont.getSelectedItem().toString(), Font.BOLD, Integer.parseInt(comboSize.getSelectedItem().toString())));
                } else {
                    pane.setFont(new Font(comboFont.getSelectedItem().toString(), Font.PLAIN, Integer.parseInt(comboSize.getSelectedItem().toString())));
                }
            }
        });

        itallic.addActionListener(e -> {
            if(!pane.getFont().isItalic()) {
                if(pane.getFont().isBold()) {
                    pane.setFont(new Font(comboFont.getSelectedItem().toString(), Font.ITALIC | Font.BOLD, Integer.parseInt(comboSize.getSelectedItem().toString())));
                } else {
                    pane.setFont(new Font(comboFont.getSelectedItem().toString(), Font.ITALIC, Integer.parseInt(comboSize.getSelectedItem().toString())));
                }
            } else {
                if(!pane.getFont().isBold()) {
                    pane.setFont(new Font(comboFont.getSelectedItem().toString(), Font.ITALIC, Integer.parseInt(comboSize.getSelectedItem().toString())));
                } else {
                    pane.setFont(new Font(comboFont.getSelectedItem().toString(), Font.PLAIN, Integer.parseInt(comboSize.getSelectedItem().toString())));
                }
            }
        });

        setFloatable(false);

    }
}
