//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintapplication;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import paintapplication.Main;
import painttools.FillerElement;

public class PaintMenuBar extends JMenuBar {
    JMenu file;
    JMenuItem quit;
    JMenuItem newSketch;
    JMenuItem openSketch;
    JMenuItem saveSketch;
    JMenu view;
    JMenu options;
    JMenu help;
    JMenuItem howToPaint;

    PaintMenuBar() {
        PaintMenuBar.ItemHandler itemHandler = new PaintMenuBar.ItemHandler();
        this.file = new JMenu("File");
        this.help = new JMenu("Help");
        this.view = new JMenu("View");
        this.options = new JMenu("Options");
        this.newSketch = new JMenuItem("New Sketch");
        this.openSketch = new JMenuItem("Open Sketch");
        this.saveSketch = new JMenuItem("Save Sketch");
        this.quit = new JMenuItem("Quit");
        this.newSketch.addActionListener(itemHandler);
        this.openSketch.addActionListener(itemHandler);
        this.saveSketch.addActionListener(itemHandler);
        this.quit.addActionListener(itemHandler);
        this.file.add(this.newSketch);
        this.file.add(this.openSketch);
        this.file.add(this.saveSketch);
        this.file.addSeparator();
        this.file.add(this.quit);
        this.howToPaint = new JMenuItem("Help...");
        this.howToPaint.addActionListener(itemHandler);
        this.help.add(this.howToPaint);
        this.add(this.file);
        this.add(this.view);
        this.add(this.options);
        this.add(this.help);
    }

    private class ItemHandler implements ActionListener {
        private ItemHandler() {
        }

        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == PaintMenuBar.this.quit) {
                Main.paint.dispose();
                System.exit(0);
            }

            if(event.getSource() == PaintMenuBar.this.newSketch) {
                Main.paint.drawPanel.elements = new ArrayList();
                Main.paint.drawPanel.elements.add(new FillerElement(Color.white));
            }

            if(event.getSource() == PaintMenuBar.this.saveSketch) {
                Main.paint.saveFile();
            }

            if(event.getSource() == PaintMenuBar.this.openSketch) {
                File fileName = Main.paint.getFileName();
                Main.paint.loadFile(fileName);
                Main.paint.loadElementsFromFile();
                Main.paint.closeFile();
            }

            Main.paint.repaint();
            PaintMenuBar.this.setFocusable(false);
        }
    }
}
