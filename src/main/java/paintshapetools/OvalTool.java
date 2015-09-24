//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintshapetools;

import java.awt.Color;
import paintshapetools.DragTool;
import painttools.StrokeStyle;

public class OvalTool extends DragTool {
    public OvalTool(Color clr, int dim) {
        super(clr, dim);
        this.strokeStyle = StrokeStyle.OPEN_OVAL;
    }
}
