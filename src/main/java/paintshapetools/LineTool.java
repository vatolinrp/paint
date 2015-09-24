//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintshapetools;

import java.awt.Color;
import paintshapetools.DragTool;
import painttools.StrokeStyle;

public class LineTool extends DragTool {
    public LineTool(Color clr, int dim, StrokeStyle style) {
        super(clr, dim);
        this.strokeStyle = style;
    }
}
