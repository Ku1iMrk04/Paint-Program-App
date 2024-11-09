/**
 * TCSS 305 assignment 5
 */
package actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.PaintTool;
import model.PencilTool;
import view.DrawingPanel;

/**
 * Pencil action that implements the action of the Pencil tool.
 * 
 * @author Mark Kulibaba
 * @version 1.0
 */
public class PencilAction extends AbstractAction {

    /**
     * generated serial version.
     */
    private static final long serialVersionUID = -8921819088604045911L;
    /**
     * the icon for the pencil tool.
     */
    private static final ImageIcon PENCILICON = new ImageIcon("./files/pencil_bw.gif");
    /**
     * the drawing panel.
     */
    private final DrawingPanel myDrawingPanel;
    /**
     * the pencil tool that is being selected.
     */
    private final PaintTool myPencilTool;
    
    /**
     * the constructor to initialize the drawing panel and the action of the tool.
     * 
     * @param theDrawingPanel
     */
    public PencilAction(final DrawingPanel theDrawingPanel) {
        
        super("Pencil", PENCILICON);
        myDrawingPanel = theDrawingPanel;
        myPencilTool = new PencilTool();
        
        
    }

    @Override
    public void actionPerformed(final ActionEvent theE) {
        
        putValue(Action.SELECTED_KEY, false);
        
        myDrawingPanel.setCurrentTool(myPencilTool);
        
        putValue(Action.SELECTED_KEY, true);
        
    }

}
