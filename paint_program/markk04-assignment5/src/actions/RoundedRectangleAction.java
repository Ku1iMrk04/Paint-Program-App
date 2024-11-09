/**
 * TCSS 305 assignment 5
 */
package actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.PaintTool;
import model.RoundedRectangleTool;
import view.DrawingPanel;

/**
 * RoundRectangle Action that implements the action of the RoundRectangle tool.
 * 
 * @author Mark Kulibaba
 * @version 1.0
 */
public class RoundedRectangleAction extends AbstractAction {
    /**
     * generated serial version.
     */
    private static final long serialVersionUID = 6820445574035841220L;
    /**
     * icon for the rectangle.
     */
    private static final ImageIcon ROUNDRECTICON = 
            new ImageIcon("./files/roundrectangle_bw.gif");
    /**
     * the drawing panel for the action of drawing.
     */
    private final DrawingPanel myDrawingPanel;
    /**
     * the rectangle tool. 
     */
    private final PaintTool myRoundRectangleTool;
    
    /**
     * Constructor to initialize the panel and the current tool selection key.
     * 
     * @param theDrawingPanel
     */
    public RoundedRectangleAction(final DrawingPanel theDrawingPanel) {
        
        super("RoundRectangle", ROUNDRECTICON);
        myDrawingPanel = theDrawingPanel;
        myRoundRectangleTool = new RoundedRectangleTool();
        
        
    }
    

    @Override
    public void actionPerformed(final ActionEvent theE) {
        
        putValue(Action.SELECTED_KEY, false);
        
        myDrawingPanel.setCurrentTool(myRoundRectangleTool);
        
        putValue(Action.SELECTED_KEY, true);
        
    }


}
