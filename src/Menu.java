import javax.swing.*;

/**
 * Created by Kim Hermansen on 16-03-2015.
 */
public class Menu extends JMenuBar {

    public Menu(Text text, View view) {
        JMenu fileMenu = new JMenu("File");
        add(fileMenu);

        JMenuItem newf = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As...");
        JMenuItem exit = new JMenuItem("Exit");

        fileMenu.add(newf);
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(saveAs);
        fileMenu.add(exit);

        save.setEnabled(false);

        FileIO fileIO = new FileIO();

        newf.addActionListener(e -> {
            fileIO.newf(text, view);
        });

        open.addActionListener(e -> {
            boolean state = fileIO.open(text);
            save.setEnabled(state);
        });

        save.addActionListener(e -> {
            fileIO.save();
        });

        saveAs.addActionListener(e -> {
            boolean state = fileIO.saveAs(text);
            save.setEnabled(state);
        });

        exit.addActionListener(e -> {
            System.exit(1);
        });
    }
}
