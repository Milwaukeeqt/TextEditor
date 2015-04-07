import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyledDocument;
import java.io.*;

/**
 * Created by Kim Hermansen on 16-03-2015.
 */
public class FileIO {

    private StyledDocument sDoc;
    private DefaultEditorKit kit;
    private File file;
    private FileNameExtensionFilter filter;

    public FileIO() {
        filter = new FileNameExtensionFilter("Normal text file (*.txt)", "txt");
        kit = new DefaultEditorKit();
    }

    public void newf(Text text, View view) {
        sDoc = (StyledDocument) text.getDocument();
        try {
            if(sDoc.getLength() != 0) {

                String dir;
                if (file == null) {
                    dir = System.getProperty("user.dir");
                } else {
                    dir = file.getAbsolutePath();
                }

                Object[] options = {"Yes", "No", "Cancel"};
                int n = JOptionPane.showOptionDialog(view,
                        "Do you want to save changes to " + dir,
                        view.getTitle(),
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[2]);
                if (n == 0) {
                    if (file.exists()) {
                        save();
                    } else {
                        saveAs(text);
                    }
                    sDoc.remove(0, sDoc.getLength());
                }
                if (n == 1) {
                    sDoc.remove(0, sDoc.getLength());
                }
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public boolean open(Text text) {
        sDoc = (StyledDocument) text.getDocument();
        JFileChooser chooserOpen = new JFileChooser();
        chooserOpen.setFileFilter(filter);

        boolean state = false;
        if (chooserOpen.showOpenDialog(text) == JFileChooser.APPROVE_OPTION) {
            file = chooserOpen.getSelectedFile();
            BufferedInputStream in;
            try {
                in = new BufferedInputStream(new FileInputStream(file));
                kit.read(in, sDoc, sDoc.getStartPosition().getOffset());
                in.close();
                state = true;
            } catch (BadLocationException | IOException e) {
                e.printStackTrace();
            }
        }
        return state;
    }

    public boolean saveAs(Text text) {
        sDoc = (StyledDocument) text.getDocument();
        JFileChooser chooserSaveAs = new JFileChooser();
        chooserSaveAs.setFileFilter(filter);
        chooserSaveAs.setDialogTitle("Save as..");

        boolean state = false;
        if(chooserSaveAs.showSaveDialog(text) == JFileChooser.APPROVE_OPTION)
        {
            file = chooserSaveAs.getSelectedFile();
            BufferedOutputStream out;
            try {
                out = new BufferedOutputStream(new FileOutputStream(file + ".txt"));
                kit.write(out, sDoc, sDoc.getStartPosition().getOffset(), sDoc.getLength());
                out.close();
                state = true;
            } catch (BadLocationException | IOException e) {
                e.printStackTrace();
            }
        }
        return state;
    }

    public void save() {
        BufferedOutputStream out;
        try
        {
            out = new BufferedOutputStream(new FileOutputStream(file));
            kit.write(out, sDoc, sDoc.getStartPosition().getOffset(), sDoc.getLength());
            out.close();
        } catch (BadLocationException | IOException e) {
            e.printStackTrace();
        }
    }
}