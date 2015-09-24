

package paintapplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import paintapplication.ColorPicker;
import paintapplication.DrawPanel;
import paintapplication.Main;
import paintapplication.PaintMenuBar;
import paintcontrols.PaintToolPanel;
import paintcontrols.PencilToolPanel;
import paintdrawtools.PaintElement;
import painttools.Tool;

public class PaintApplication extends JFrame {
    public ObjectOutputStream output;
    public ObjectInputStream input;
    public DrawPanel drawPanel;
    protected PaintMenuBar menuBar;
    protected ColorPicker colorPicker;
    public PaintToolPanel paintTools;

    public PaintApplication() {
        this.setSize(1024, 768);
        this.setLayout(new BorderLayout());
        this.drawPanel = new DrawPanel();
        this.menuBar = new PaintMenuBar();
        this.colorPicker = new ColorPicker();
        this.paintTools = new PaintToolPanel(new PencilToolPanel(Tool.PENCIL, 1));
        this.add(this.menuBar, "North");
        this.add(this.colorPicker, "South");
        this.add(this.paintTools, "West");
        this.add(new JScrollPane(this.drawPanel), "Center");
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.synchronizeStartingColor();
    }

    public void synchronizeStartingColor() {
        this.colorPicker.currentClrPanel.setBackground(Color.black);
        this.colorPicker.color = this.colorPicker.currentClrPanel.getBackground();
        this.drawPanel.tool.setColor(this.colorPicker.currentClrPanel.getBackground());
        this.drawPanel.setBrushColor(this.colorPicker.color);
    }

    public File getFileName() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(0);
        fileChooser.setCurrentDirectory(new File("/Users/stevevitali/Desktop"));
        fileChooser.showOpenDialog(this);
        File fileName = fileChooser.getSelectedFile();
        return fileName;
    }

    public void writeSketchToFile(File fileName) {
        try {
            for(int exception = 0; exception < this.drawPanel.elements.size(); ++exception) {
                PaintElement elem = (PaintElement)this.drawPanel.elements.get(exception);
                this.output.writeObject(elem);
            }

        } catch (IOException var4) {
            System.err.println("Error writing to file.");
        }
    }

    public void loadElementsFromFile() {
        try {
            this.drawPanel.elements.clear();

            while(true) {
                this.drawPanel.elements.add(this.input.readObject());
            }
        } catch (IOException var2) {

        } catch (ClassNotFoundException var3) {
            System.err.println("Unable to create object.");
        }
    }

    public void loadFile(File fileName) {
        try {
            this.input = new ObjectInputStream(new FileInputStream(fileName));
        } catch (IOException var3) {
            System.err.println("Error loading file: " + fileName);
        }
    }

    public void openFile(File fileName) {
        try {
            this.output = new ObjectOutputStream(new FileOutputStream(fileName));
        } catch (IOException var3) {
            System.err.println("Error loading file: " + fileName);
        }
    }

    public void saveFile() {
        try {
            JFileChooser exception = new JFileChooser();
            exception.setFileSelectionMode(0);
            exception.showSaveDialog(Main.paint);
            File file = exception.getSelectedFile();
            file = new File(file + ".spa");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.close();
            this.openFile(file);
            this.writeSketchToFile(file);
            this.closeFile();
        } catch (IOException var4) {
            System.err.println("Error saving to new file.");
        }

    }

    public void closeFile() {
        try {
            if(this.output != null) {
                this.output.close();
            }
        } catch (IOException var2) {
            System.err.println("Error closing file");
            System.exit(1);
        }

    }
}
