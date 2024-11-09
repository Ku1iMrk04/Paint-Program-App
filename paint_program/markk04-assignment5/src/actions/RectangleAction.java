/**
 * TCSS 305 assignment 5
 */
package actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.PaintTool;
import model.RectangleTool;
import view.DrawingPanel;

/**
 * Rectangle Action that implements the action of the Rectangle tool.
 * 
 * @author Mark Kulibaba
 * @version 1.0
 */
public class RectangleAction extends AbstractAction {
    
    /**
     * generated serial version.
     */
    private static final long serialVersionUID = 6820445574035841220L;
    /**
     * icon for the rectangle.
     */
    private static final ImageIcon ROUNDRECTICON = new ImageIcon("./files/rectangle_bw.gif");
    /**
     * the drawing panel for the action of drawing.
     */
    private final DrawingPanel myDrawingPanel;
    /**
     * the rectangle tool. 
     */
    private final PaintTool myRectangleTool;
    
    /**
     * Constructor to initialize the panel and the current tool selection key.
     * 
     * @param theDrawingPanel
     */
    public RectangleAction(final DrawingPanel theDrawingPanel) {
        
        super("Rectangle", ROUNDRECTICON);
        myDrawingPanel = theDrawingPanel;
        myRectangleTool = new RectangleTool();
        
        
    }
    

    @Override
    public void actionPerformed(final ActionEvent theE) {
        
        putValue(Action.SELECTED_KEY, false);
        
        myDrawingPanel.setCurrentTool(myRectangleTool);
        
        putValue(Action.SELECTED_KEY, true);
        
    }

}
