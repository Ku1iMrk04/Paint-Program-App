/**
 * TCSS 305 assignment 5
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import model.LineTool;
import model.PaintShape;
import model.PaintTool;


/**
 * The Drawing Panel class extends JPanel and takes care of all actions in the 
 * drawing panel and what shape is called it will draw. For part A only a line
 * is applied to draw not any other shapes at the moment.
 * 
 * @author Mark Kulibaba
 * @version 4.0
 */

public class DrawingPanel extends JPanel {

    /**
     * generated serial version.
     */
    private static final long serialVersionUID = 8444575580975344636L;
    /**
     * constant for the default color.
     */
    private static final int PURPLE_R = 50;
    /**
     * constant for the default color.
     */
    private static final int PURPLE_G = 0;
    /**
     * constant for the default color.
     */
    private static final int PURPLE_B = 110;
    /**
     * constant for the default color.
     */
    private static final int GOLD_R = 232;
    /**
     * constant for the default color.
     */
    private static final int GOLD_G = 211;
    /**
     * constant for the default color.
     */
    private static final int GOLD_B = 162;
    /**
     * the default color set to draw on the panel.
     */
    private static Color DEFAULT_PURPLE = new Color(PURPLE_R, PURPLE_G, PURPLE_B);
    /**
     * the default color set to draw on the panel.
     */
    private static Color DEFAULT_GOLD = new Color(GOLD_R, GOLD_G, GOLD_B);
    /**
     * the default grid spacing value.
     */
    private static final int GRID_SPACING = 30;
    /**
     * collection of previous shapes.
     */
    private final List<PaintShape> myPrevShape;
    /**
     * the paint tool that is currently used.
     */
    private PaintTool myCurrentTool;
    /**
     * current shape.
     */
    private Shape myCurrentShape;
    /**
     * the current color or default color.
     */
    private Color myCurrentColor;
    /**
     * the current thickness of the shape.
     */
    private int myCurrentThickness;
    /**
     * support of the property change listener.
     */
    private final PropertyChangeSupport myPCS = new PropertyChangeSupport(this);
    /**
     * check to see of the grid is visible.
     */
    private boolean myGridVisible;
    /**
     * the current grid spacing.
     */
    private int myGridSpacing;
    
    
    
    
    
   
    /**
     * Constructor for the DrawingPanel class.
     */
    public DrawingPanel() {
        // Initialize instance variables
        super();
        
        myPrevShape = new ArrayList<>();
        // current line tool
        myCurrentTool = new LineTool(); 
        myCurrentColor = DEFAULT_PURPLE;
        myCurrentThickness = 2;
        myGridVisible = false;
        myGridSpacing = GRID_SPACING;
        
      
        
        
    }
    /**
     * initializes the drawing panel and sets up the mouse listeners to the panel.
     */
   
    public void initializePanel() {
        
        // create background color
        setBackground(Color.WHITE);
        
        
        // create the cursor
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

        // implement the mouse listeners from the inner class
        final MouseInputAdapter mouseHandler = new SetUpMouseListeners();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
        
        
    }
    
    /**
     * paintComponent sets the graphics and actions for the shapes drawn.
     * 
     * @param theG which is the graphics of the panel and shapes created
     */
    @Override
    protected void paintComponent(final Graphics theG) {
        super.paintComponent(theG);
        
        // check to see of the grid is visible with check box
        if (myGridVisible) {
            // Draw the grid here
            drawGrid(theG, myGridSpacing);
        }
        
        final Graphics2D g2d = (Graphics2D) theG;
        
        
        
        // Set rendering hints
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
       
        // Draw previous shapes
        for (final PaintShape shape : myPrevShape) {
            g2d.setColor(shape.getColor());
            g2d.setStroke(shape.getStroke());
            g2d.draw(shape.getShape());
        }
        
        // Draw current shape
        if (myCurrentShape != null) {
            g2d.setColor(myCurrentColor);
            g2d.setStroke(new BasicStroke(myCurrentThickness));
            g2d.draw(myCurrentShape);
        }
    }
    
   
    
    /**
     * Set the current tool for drawing.
     * 
     * @param tool The paint tool to set
     */
    public void setCurrentTool(final PaintTool theCurrentTool) {
        myCurrentTool = theCurrentTool;
    }
    
    /**
     * Set the current color for drawing.
     * 
     * @param color The color to set
     */
    public void setCurrentColor(final Color theCurrentColor) {
        myCurrentColor = theCurrentColor;
    }
    
    /**
     * Set the current thickness for drawing.
     * 
     * @param thickness The thickness to set
     */
    public void setCurrentThickness(final int theCurrentThickness) {
        myCurrentThickness = theCurrentThickness;
    }
    
    public void setGridSpacing(final int theSpacing) {
        myGridSpacing = theSpacing;
        //repaint();
    }
    
    /**
     * Clear all shapes from the panel.
     */
    public void clear() {
        myPrevShape.clear();
        fireShapeChanged();
        repaint();
    }
    
    /**
     * method to check if the panel has any shapes. 
     * 
     * @return the boolean relation of the existing shapes.
     */
    public boolean hasShapes() {
        
        return !myPrevShape.isEmpty();
    }
    
    
    /**
     * Fire property change event when shapes are added or removed.
     */
    public void fireShapeChanged() {
        myPCS.firePropertyChange("shapeChanged", null, hasShapes());
    }
    
    /**
     * add the property change listener.
     */
    public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        myPCS.addPropertyChangeListener(theListener);
    }
    
    /**
     * remove the property change listener.
     */
    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
        myPCS.removePropertyChangeListener(theListener);
    }
    
    /**
     * Modify the method to toggle grid visibility.
     * 
     * @param visible
     */
    public void toggleGrid(final boolean theGridVisible) {
        myGridVisible = theGridVisible;
        // Redraw the panel to reflect the change
        repaint(); 
    }
    
    /**
     * draw the grid of the panel.
     * 
     * @param theG
     */
    private void drawGrid(final Graphics theG, final int theGridSpacing) {
        theG.setColor(DEFAULT_GOLD);
        myGridSpacing = theGridSpacing;
        
        
        // Draw vertical lines
        for (int x = myGridSpacing; x < getWidth(); x += myGridSpacing) {
            theG.drawLine(x, 0, x, getHeight());
            repaint();
        }
        
        // Draw horizontal lines
        for (int y = myGridSpacing; y < getHeight(); y += myGridSpacing) {
            theG.drawLine(0, y, getWidth(), y);
            repaint();
        }
        
    }
    
    
        
    
    /**
     *  Inner class to handle mouse events and to draw the tools that are set.
     */
    private final class SetUpMouseListeners extends MouseInputAdapter {

        
        @Override
        public void mousePressed(final MouseEvent theE) {
            // check of the right tool exists
            if (myCurrentTool != null) {
                // create the start point of the tool and find the shape drawn
                myCurrentTool.setStartPoint(new Point(0, 0));
                myCurrentTool.setStartPoint(theE.getPoint());
                myCurrentShape = myCurrentTool.getShape();
                
            }
        }
        
        
        @Override
        public void mouseDragged(final MouseEvent theE) {
            
            if (myCurrentTool != null) { 

                // follow the shape's change points
                myCurrentTool.setEndPoint(theE.getPoint());
                myCurrentShape = myCurrentTool.getShape();
                
                repaint();
            }
        }
        
        @Override
        public void mouseReleased(final MouseEvent theE) {
            
            if (myCurrentTool != null) { 

                myCurrentTool.setEndPoint(theE.getPoint());
                // create the shape drawn
                final PaintShape a = new PaintShape(myCurrentTool.getShape(), 
                            myCurrentColor, new BasicStroke(myCurrentThickness));
                // current shape is not there anymore
                myCurrentShape = new Rectangle(1, -1);
                // add the shape to the list
                myPrevShape.add(a);
                repaint();
                //Fire the shapeAdded event
                myPCS.firePropertyChange("shapeAdded", 0, myPrevShape.size());
                
            }
        }
        
        
    }
    
}