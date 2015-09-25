//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package paintshapetools;

import java.awt.Color;

import painttools.StrokeStyleEnum;

public class OvalTool extends DragTool {
    public OvalTool(Color clr) {
        super(clr);
        this.strokeStyle = StrokeStyleEnum.OPEN_OVAL;
    }
}
