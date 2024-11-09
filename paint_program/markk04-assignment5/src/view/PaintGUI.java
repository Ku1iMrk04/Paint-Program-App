/**
 * TCSS 305 assignment 5
 */
package view;

import actions.EllipseAction;
import actions.LineAction;
import actions.PencilAction;
import actions.RectangleAction;
import actions.RoundedRectangleAction;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

/**
 * The Main Graphical User Interface for the Paint program,
 * it displays and adds the menu and tool bar to the frame as well as
 * the drawing panel.
 * 
 * @author Mark Kulibaba
 * @version 2.1
 */
public class PaintGUI implements PropertyChangeListener {
    /**
     * the constant for the size of the frame.
     */
    private static final int FRAMESIZE = 3;
    /**
     * the custom icon of the gui.
     */
    private final ImageIcon myIcon;
    /**
     * instance of the frame.
     */
    private final JFrame myFrame;
    /**
     * the drawing panel of the program.
     */
    private final DrawingPanel myDrawingPanel;
    /**
     * the clear button and it's state of change.
     */
    private final JMenuItem myClearButton;
    /**
     * Create the grid check box.
     */
    private final JCheckBox myGridCheckBox;
   
    
  
    /**
     * Construct the GUI.
     */
    public PaintGUI() {
        super();
        // create the frame
        myFrame = new JFrame("TCSS 305 Paint");
        // create the image icon of the frame
        myIcon = new ImageIcon("./files/w_small.png");
        // set the icon image to the frame
        myFrame.setIconImage(myIcon.getImage());
        
        //  initialize the clear button
        myClearButton = new JMenuItem("Clear");
        
        myGridCheckBox = new JCheckBox("Grid");

        // create the drawing panel
        myDrawingPanel = new DrawingPanel();
        
        
        // create the frame
        createFrame();
        // set up the GUI
        setup();
        
        

    }
    
 
    
    
    /**
     * method creates the buttons and finalizes the actions of each button, combines 
     * the code into one frame.
     */
    private void createFrame() {
        
        
        
        // create the menu bar
        final MenuBar menuBar = new MenuBar(myDrawingPanel);
        // create the tool bar
        final ToolBar toolBar = new ToolBar();
        
        // add property change listeners
        myDrawingPanel.addPropertyChangeListener(menuBar);
        
        menuBar.addPropertyChangeListener(this); 
        
        // set the actions and create the grid check box
        createGridCheckBox();
        
       
        
        // create an action list of all action classes
        final Action[] actions = {new LineAction(myDrawingPanel), 
            new RectangleAction(myDrawingPanel), new RoundedRectangleAction(myDrawingPanel), 
            new EllipseAction(myDrawingPanel), new PencilAction(myDrawingPanel)};

        // loop and add each action to the menu and tool bar
        for (final Action action : actions) {
            menuBar.createMenuButton(action);
            toolBar.createToolBarButton(action);
            
            
           
        }
        
        toolBar.add(myGridCheckBox);

        // set the menu bar to the frame
        myFrame.setJMenuBar(menuBar);

        // add the rest of the components to the frame
        myFrame.add(toolBar, BorderLayout.SOUTH);
        myFrame.add(myDrawingPanel, BorderLayout.CENTER);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.pack();
        
        
        
        
        
    }
    
    /**
     * creates the action listener and events for the grid check box in the tool bar.
     */
    private void createGridCheckBox() {
        
     // action listener for the grid check box
        myGridCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theE) {
                // Toggle the visibility of the grid
                myDrawingPanel.toggleGrid(myGridCheckBox.isSelected());
            }
        });
        
    }

    /**
     * Sets up the GUI size and dimension, also sets the location and 
     * visibility.
     */
    private void setup() {
        // set up the panel
        myDrawingPanel.initializePanel();
        
        // initialize the frame's size
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int frameWidth = screenSize.width / FRAMESIZE;
        final int frameHeight = screenSize.height / FRAMESIZE;
        
        // create the frame's size
        myFrame.setSize(frameWidth, frameHeight);
        // center the frame
        myFrame.setLocationRelativeTo(null);
        // make sure the frame is visible
        myFrame.setVisible(true);
        

    }
    
    /**
     * Property change listener method.
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvt) {
        if ("shapeAdded".equals(theEvt.getPropertyName())) {
            myClearButton.setEnabled((boolean) theEvt.getNewValue());
        
        }
    }
    
 
}
