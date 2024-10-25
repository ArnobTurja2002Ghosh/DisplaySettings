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
public class DSMemory extends JFrame implements ActionListener, MouseListener
{
	JButton bFontSize, bFontStyle, bResolution, bMainMenu;
	
	/*
	 *  constructor method takes as input how many rows and columns of gridsquares to create
	 *  it then creates the panels, their subcomponents and puts them all together in the main frame
	 *  it makes sure that action listeners are added to selectable items
	 *  it makes sure that the gui will be visible
	 */
	public DSMemory()
	{
		this.setSize(500,500);
		JPanel jp1=(JPanel) getContentPane().add(new JPanel());
		bFontSize = (JButton) jp1.add(new JButton("font size")); bFontSize.addActionListener(this);
		bFontStyle = (JButton) jp1.add(new JButton("font style")); bFontStyle.addActionListener(this);
		bResolution =(JButton)jp1.add(new JButton("resolution")); bResolution.addActionListener(this);
		bMainMenu=(JButton)jp1.add(new JButton("exit")); bMainMenu.addActionListener(this);
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
		// get the object that was selected in the gui
		Object selected = aevt.getSource();
				
		// if resetting the squares' colours is requested then do so
		if (selected.equals(bFontSize))
		{
			DSWriter wd1 = new DSWriter("font size");
			setVisible(false);
		}
		else if(selected.equals(bFontStyle))
		{
			DSWriter wd1 = new DSWriter("font style");
			setVisible(false);
		}
		else if(selected.equals(bResolution))
		{
			DSWriter wd1 = new DSWriter("resolution");
			setVisible(false);
		}
		else if(selected.equals(bMainMenu))
		{
			setVisible(false);
		}
		else if(selected.equals(bMainMenu)) 
		{
			System.exit(0);
			

		}
		
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