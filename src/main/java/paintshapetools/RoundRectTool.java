//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintshapetools;

import java.awt.Color;

import painttools.StrokeStyleEnum;

public class RoundRectTool extends RectangleTool {
    public RoundRectTool(Color clr, int dim) {
        super(clr, dim);
        this.strokeStyle = StrokeStyleEnum.OPEN_ROUND_RECT;
    }
}
