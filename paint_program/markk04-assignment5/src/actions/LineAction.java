/**
 * TCSS 305 assignment 5
 */
package actions;


import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.LineTool;
import model.PaintTool;
import view.DrawingPanel;

/**
 * Line action that implements the action of the line tool.
 * 
 * @author Mark Kulibaba
 * @version 1.0
 */
public class LineAction extends AbstractAction {
    
    /**
     * image icon for the line tool button.
     */
    public static final ImageIcon LINEICON = new ImageIcon("./files/line_bw.gif");

    /**
     * generated serial version.
     */
    private static final long serialVersionUID = 5462163383218958978L;
    /**
     * the drawing panel as an instance.
     */
    private final DrawingPanel myDrawingPanel;
    /**
     * the line tool interface as an instance.
     */
    private final PaintTool myLineTool;
    
    /**
     * Constructs the action of the line tool.
     */
    public LineAction(final DrawingPanel theDrawingPanel) {
        
        super("Line", LINEICON);
        myDrawingPanel = theDrawingPanel;
        myLineTool = new LineTool();
        
        
    }

    
    @Override
    public void actionPerformed(final ActionEvent theE) {
        
        
        putValue(Action.SELECTED_KEY, true);
       
        myDrawingPanel.setCurrentTool(myLineTool);
        
        
        
       
    }
}