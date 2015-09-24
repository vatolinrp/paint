//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintshapetools;

import java.awt.Color;

import painttools.StrokeStyleEnum;

public class RectangleTool extends DragTool {
    public RectangleTool(Color clr, int dim) {
        super(clr, dim);
        this.strokeStyle = StrokeStyleEnum.OPEN_RECT;
    }
}
