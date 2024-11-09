/**
 * TCSS 305 assignment 5
 */
package view;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;


/**
 * The Tool bar for the PaintGUI class, creates the tool bar with tool buttons.
 * 
 * @author Mark Kulibaba
 * @version 2.0
 */
public class ToolBar extends JToolBar {

    /** A generated serialization ID. */
    private static final long serialVersionUID = -6969282661802905468L;

    /** A button group for the mutually exclusive tool bar buttons. */ 
    private final ButtonGroup myGroup;
    

    /**
     * Construct the ToolBar of the GUI.
     */
    public ToolBar() {
        super();
        myGroup = new ButtonGroup();
    }

    /**
     * Create a JToggleButton for the ToolBar.
     * 
     * @param theAction to associate with the created JToggleButton
     */
    public void createToolBarButton(final Action theAction) {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        myGroup.add(toggleButton);
        myGroup.clearSelection();
        add(toggleButton);
    }
    

}
