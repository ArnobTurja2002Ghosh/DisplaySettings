import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;
import java.lang.Thread;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/*
 *  The main window of the gui.
 *  Notice that it extends JFrame - so we can add our own components.
 *  Notice that it implements ActionListener - so we can handle user input.
 *  This version also implements MouseListener to show equivalent functionality (compare with the other demo).
 *  @author mhatcher
 */
public class DSWriter extends JFrame implements ActionListener, MouseListener
{
    // written by Arnob
	private JTextField tfFontSize, tfWindowWidth, tfWindowHeight;
	private DSMemory wd;
    private JButton bSubmit1, bSubmit2;

    // written by Mashrur
    JScrollPane fontScroll;
	JButton applyButton;
	//JTextArea textArea;
	private JList<String> fontStyList;
	/*
	 *  constructor method takes as input how many rows and columns of gridsquares to create
	 *  it then creates the panels, their subcomponents and puts them all together in the main frame
	 *  it makes sure that action listeners are added to selectable items
	 *  it makes sure that the gui will be visible
	 */
	public DSWriter(String arg1, DSMemory wd)
	{
        this.wd=wd;
		this.setSize(250,250);
		JPanel jp1=(JPanel) getContentPane().add(new JPanel());

        //written by Arnob
        if(arg1.equals("font size"))
        {
            tfFontSize=new JTextField(Integer.toString(wd.font1.getSize()));
            jp1.add(tfFontSize);
            bSubmit1=new JButton("Submit");
            jp1.add(bSubmit1);
            bSubmit1.addActionListener(this);
        }
        else if(arg1.equals("resolution"))
        {
            tfWindowHeight=new JTextField(6); tfWindowWidth=new JTextField(6);
            jp1.add(new JLabel("Preferred width in pixels:"));
            jp1.add(tfWindowWidth);
            jp1.add(new JLabel("Preferred height in pixels:"));
            jp1.add(tfWindowHeight);
            bSubmit2=new JButton("Submit");
            jp1.add(bSubmit2);
            bSubmit2.addActionListener(this);
        }
        
        // Written by Mashrur
        else if(arg1.equals("font style"))
        {
            String [] fontStyNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		    fontStyList = new JList<>(fontStyNames);

			fontScroll = new JScrollPane(fontStyList);

            jp1.add(fontScroll);
            applyButton = new JButton("Apply Change");

            applyButton.addActionListener(this); // or this
            jp1.add(applyButton);

            fontStyList.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e)
                {
                    if (!e.getValueIsAdjusting())
                    {
                        String pickFont = fontStyList.getSelectedValue();
                        changeFont(pickFont);
                    }
                }
            });
    
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
		Object selected = aevt.getSource();

        //written by Arnob
        if(selected.equals(bSubmit1))
        {
            
                
            try 
            {
                Integer number = Integer.valueOf(tfFontSize.getText());
                if(number<1)
                {
                    tfFontSize.setText("");
                }
                else 
                {
                    wd.font1=new Font(wd.font1.getName(), wd.font1.getStyle(), number);
                    dispose();
                    this.wd.setVisible(true);
                }
            } 
            catch (NumberFormatException e) 
            {
                tfFontSize.setText("");
                System.out.println("Invalid integer input");
            }
                
            
            
        }

        //written by Arnob
        else if(selected.equals(bSubmit2))
        {
            try 
            {
                Integer number1 = Integer.valueOf(tfWindowWidth.getText());
                Integer number2 = Integer.valueOf(tfWindowHeight.getText());
                if(number1<1 || number2<1)
                {
                    tfWindowHeight.setText(""); tfWindowWidth.setText("");
                }
                else
                {
                    this.wd.settingWidth=number1;
                    this.wd.settingHeight=number2;
                    this.wd.setSize(number1, number2);
                    dispose();
                    this.wd.setVisible(true);
                    
                }
            } 
            catch (NumberFormatException e) 
            {
                tfWindowHeight.setText(""); tfWindowWidth.setText("");
                System.out.println("Invalid integer input");
            } 
        }

        //written by Mashrur
        else if (aevt.getSource()== applyButton)
		{	
			String pickFont = fontStyList.getSelectedValue();
			changeFont(pickFont);	
		}
		
	}

    //written by Mashrur
    private void changeFont(String name)
	{
		if(tfFontSize != null)
		{
			tfFontSize.setFont(new Font(name, Font.PLAIN, 16));
		}

		dispose();
		this.wd.setVisible(true);
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