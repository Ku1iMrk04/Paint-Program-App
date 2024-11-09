/**
 * TCSS 305 assignment 5
 */
package actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.EllipseTool;
import model.PaintTool;
import view.DrawingPanel;

/**
 * Ellipse action that implements the action of the Ellipse tool.
 * 
 * @author Mark Kulibaba
 * @version 1.0
 */
public class EllipseAction extends AbstractAction {

    /**
     * generated serial version.
     */
    private static final long serialVersionUID = -8921819088604045911L;
    /**
     * the icon for the ellipse tool.
     */
    private static final ImageIcon ELLIPSEICON = new ImageIcon("./files/ellipse_bw.gif");
    /**
     * the drawing panel.
     */
    private final DrawingPanel myDrawingPanel;
    /**
     * the ellipse tool that is being selected.
     */
    private final PaintTool myEllipseTool;
    
    /**
     * the constructor to initialize the drawing panel and the action of the tool.
     * 
     * @param theDrawingPanel
     */
    public EllipseAction(final DrawingPanel theDrawingPanel) {
        
        super("Ellipse", ELLIPSEICON);
        myDrawingPanel = theDrawingPanel;
        myEllipseTool = new EllipseTool();
        
       
    }

    @Override
    public void actionPerformed(final ActionEvent theE) {
        
        putValue(Action.SELECTED_KEY, false);
        
        myDrawingPanel.setCurrentTool(myEllipseTool);
        
        putValue(Action.SELECTED_KEY, true);
        
    }

}
