/**
 * TCSS 305 assignment 5
 */
package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The MenuBar for the PaintGUI class and implements all buttons and features
 * in the menu bar.
 * 
 * @author Mark Kulibaba
 * @version 2.2
 */
public final class MenuBar extends JMenuBar implements PropertyChangeListener {
    /**
     * Minimum space for the grid slider.
     */
    private static final int MIN_SPACE = 10;
    /**
     * Maximum space for the grid slider.
     */
    private static final int MAX_SPACE = 50;
    /**
     * the default space of the grid.
     */
    private static final int DEFAULT_SPACE = 30;
    /**
     * major ticking of the thickness slider.
     */
    private static final int MAJOR_TICK = 5;
    /**
     * icon for the about menu item in the help menu.
     */
    private static final ImageIcon MYICON = new ImageIcon("./files/w_small.png");
    /**
     * A generated serialization ID.
     */
    private static final long serialVersionUID = -8420058521162304426L;
    /**
     * constant for the default color.
     */
    private static final int W = 50;
    /**
     * constant for the default color.
     */
    private static final int HUSKY = 0;
    /**
     * constant for the default color.
     */
    private static final int PURPLE = 110;
    /**
     * the default color set to draw on the panel.
     */
    private static Color DEFAULT = new Color(W, HUSKY, PURPLE);

    /** The View menu. */
    private final JMenu myToolsMenu;

    /** A button group for radio buttons. */
    private final ButtonGroup myGroup;
    /**
     *  The thickness button for the thickness slider.
     */
    private final JMenu myThicknessButton;
    /**
     * The grid slider button.
     */
    private JMenu myGridSpacing;
    /**
     * instance of the help menu.
     */
    private final JMenu myHelpMenu;
    /**
     * instance of the color item.
     */
    private final JMenuItem myColorButton;
    /**
     * instance of the clear item.
     */
    private final JMenuItem myClearButton;
    /**
     * instance of the about item.
     */
    private final JMenuItem myAboutButton;
    /**
     * instance of the drawing panel for the DrawingPanel class.
     */
    private DrawingPanel myDrawingPanel;
    /**
     * the color of the shape.
     */
    private Color myColor;
    /**
     * the grid spacing slider.
     */
    private JSlider myGridSpacingSlider;
   
    
    

    /**
     * Construct the menu bar.
     * 
     * @param theFrame the JFrame which will contain this JMenuBar
     */
    public MenuBar(final DrawingPanel theDrawingPanel) {
        super();
        
        
        // create the buttons and menu items
        myToolsMenu = new JMenu("Tools");
        myHelpMenu = new JMenu("Help");
        myGroup = new ButtonGroup();
        myThicknessButton = new JMenu("Thickness");
        
        myColorButton = new JMenuItem("Color...");
        myClearButton = new JMenuItem("Clear");
        myAboutButton = new JMenuItem("About...");
        // create and set the drawing panel
        myDrawingPanel = theDrawingPanel;
        
        
        
        
        
        // call the set up method
        setup(theDrawingPanel);
    }

    /**
     * Sets up the components of the menu.
     * 
     * @param theFrame the JFrame containing this menu.
     */
    private void setup(final DrawingPanel theDrawingPanel) {
        
        // set the drawing panel
        myDrawingPanel = theDrawingPanel;
        // create the options menu
        final JMenu optionsMenu = new JMenu("Options");
        // create the grid spacing slider button
        myGridSpacing = new JMenu("Grid Spacing");
      
        // add the button items to the options menu
        optionsMenu.add(myThicknessButton);
        optionsMenu.add(myGridSpacing);
        optionsMenu.addSeparator();
        optionsMenu.add(myColorButton);
        optionsMenu.addSeparator();
        optionsMenu.add(myClearButton);
        // set the clear button to the default set up
        myClearButton.setEnabled(false);
        
        // create the thickness and grid slider and it's functions
        createThicknessSlider();
        createGridSpacingSlider();
        
        // add the rest of the menu bar features
        myHelpMenu.add(myAboutButton);
        add(optionsMenu);
        add(myToolsMenu);
        add(myHelpMenu);
        
        // add the rest of the actions and buttons
        createColorChooser();
        createClearButton();
        createAboutMessageDialog();
        
 
       
    }       
 
    
    /**
     * Creates a radio button menu item, associates an action with the button,
     * adds the button to a button group, adds the button to the View menu.
     * 
     * @param theAction the Action to associate with the new button being
     *            created
     */
    public void createMenuButton(final Action theAction) {
        // create the radio button
        final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(theAction);

        myGroup.add(createdButton);
        myToolsMenu.add(createdButton);
    }
    
    
    /**
     * Helper method for the thickness slider, creates the thickness slider.
     */
    private void createThicknessSlider() {
     // Thickness Slider for adjusting the thickness
        final JSlider thicknessSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 2);
        thicknessSlider.setMajorTickSpacing(MAJOR_TICK);
        thicknessSlider.setMinorTickSpacing(1);
        thicknessSlider.setPaintTicks(true);
        thicknessSlider.setPaintLabels(true);
        
        thicknessSlider.addChangeListener(new ChangeListener() {
            /**
             * state the change of the thickness of the shape.
             * sets the current and new thickness of the new shape being drawn.
             * 
             * @param theE
             */
            @Override
            public void stateChanged(final ChangeEvent theE) {
                final int thickness = thicknessSlider.getValue();
                myDrawingPanel.setCurrentThickness(thickness);
               
            }
        });
        myThicknessButton.add(thicknessSlider);
    }
    
    /**
     * Helper method for the grid spacing slider, creates the grid slider.
     */
    private void createGridSpacingSlider() {
     // Grid spacing Slider for adjusting the thickness
        myGridSpacingSlider = new JSlider(JSlider.HORIZONTAL, MIN_SPACE, 
                                                              MAX_SPACE, 
                                                              DEFAULT_SPACE);
        myGridSpacingSlider.setMajorTickSpacing(MAJOR_TICK);
        myGridSpacingSlider.setMinorTickSpacing(MAJOR_TICK);
        myGridSpacingSlider.setPaintTicks(true);
        myGridSpacingSlider.setPaintLabels(true);
        
        myGridSpacingSlider.addChangeListener(new ChangeListener() {
       
            /**
             * state the change of the grid space.
             * sets the current and new gird space on the panel, adjust the size.
             * 
             * @param theE
             */
            @Override
                public void stateChanged(final ChangeEvent theE) {
               
                    final int spacing = myGridSpacingSlider.getValue();
                    myDrawingPanel.setGridSpacing(spacing);
                }
            });

        myGridSpacing.add(myGridSpacingSlider);
    }
    
    
    /**
     * Helper method for the color button, creates and adds actions to the color.
     */
    private void createColorChooser() {
        
        // action listener for the color button
        myColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                // create the color chooser, set it choose to the default
                myColor = javax.swing.JColorChooser.showDialog(null, 
                        "Choose a color", DEFAULT, true);
                // check if the color is valid
                if (myColor != null) {
                    // set the color of the selected color
                    myDrawingPanel.setCurrentColor(myColor);
                } 
            }
        });
        
        
    }
    
    
    /**
     * Helper method for the clear button and applies the action listener.
     */
    private void createClearButton() {
        
        // action listener for the clear button
        myClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                    
                    // clear the drawing panel when action performed
                    myClearButton.setEnabled(false);
                    myDrawingPanel.clear();
                    
                    
                }
                
            
        });
    }
    
    
    /**
     * Helper method for the about button, create the about menu message dialog.
     */
    private void createAboutMessageDialog() {
        
     // action listener for the about message dialog
        myAboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theE) {
                // set the dialog to the preferred message
                JOptionPane.showMessageDialog(null,
                        "Mark Kulibaba\n  Winter 2024", "TCSS 305 Paint", 
                        JOptionPane.INFORMATION_MESSAGE, MYICON);
            }
        });

    
    
    }
    
   
    
    
    /**
     * Property change listener method.
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvt) {
  
        if ("shapeAdded".equals(theEvt.getPropertyName())) {
            
            myClearButton.setEnabled(true);
        }

    }

}
