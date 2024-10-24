import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;
import java.lang.Thread;
import javax.swing.*;

/*
 *  The main window of the gui.
 *  Notice that it extends JFrame - so we can add our own components.
 *  Notice that it implements ActionListener - so we can handle user input.
 *  This version also implements MouseListener to show equivalent functionality (compare with the other demo).
 *  @author mhatcher
 */
public class WindowDemo1 extends JFrame implements ActionListener, MouseListener
{
	JTextField tfFontSize, tfWindowWidth, tfWindowHeight;
	WindowDemo wd;
	/*
	 *  constructor method takes as input how many rows and columns of gridsquares to create
	 *  it then creates the panels, their subcomponents and puts them all together in the main frame
	 *  it makes sure that action listeners are added to selectable items
	 *  it makes sure that the gui will be visible
	 */
	public WindowDemo1(String arg1)
	{
		this.setSize(190,190);
		JPanel jp1=(JPanel) getContentPane().add(new JPanel());

        if(arg1.equals("font size"))
        {
            tfFontSize=new JTextField(16);
            jp1.add(tfFontSize);
        }
        else if(arg1.equals("resolution"))
        {
            tfWindowHeight=new JTextField(16); tfWindowWidth=new JTextField(16);
            jp1.add(tfWindowWidth);
            jp1.add(tfWindowHeight);
        }

		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	
	/*
	 *  handles actions performed in the gui
	 *  this method must be present to correctly implement the ActionListener interface
	 */
	public void actionPerformed(ActionEvent aevt)
	{
		
		
	}


	// Mouse Listener events
	public void mouseClicked(MouseEvent mevt)
	{
		
		
	}
	// not used but must be present to fulfil MouseListener contract
	public void mouseEntered(MouseEvent arg0){}
	public void mouseExited(MouseEvent arg0){}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}