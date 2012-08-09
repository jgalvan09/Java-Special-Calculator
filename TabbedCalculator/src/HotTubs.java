import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.*;

public class HotTubs extends Frame {
	private static final long serialVersionUID = -34092436347415355L;
	private JButton Calculate = new JButton("Calculate");
	private JButton Exit = new JButton("Exit");
	private JFormattedTextField VolumeField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField DepthField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField WidthField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField LengthField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JLabel LengthLabel = new JLabel("Enter the Tub's Length (ft): ");
	private JLabel WidthLabel = new JLabel("Enter the Tub's Width (ft): ");
	private JLabel DepthLabel = new JLabel("Enter the Tub's Depth (ft): ");
	private JLabel VolumeLabel = new JLabel("The Tub's Volume (ft^3): ");
	private JRadioButton Round = new JRadioButton("Round Tub");
	private JRadioButton Oval = new JRadioButton("Oval Tub");
	
	public HotTubs(){
		LengthField.setColumns(7);
		WidthField.setColumns(7);
		DepthField.setColumns(7);
		VolumeField.setColumns(7);
		VolumeField.setEditable(false);
		
		JPanel Length = new JPanel(new FlowLayout());
		Length.add(LengthLabel);
		Length.add(LengthField);
		JPanel Width = new JPanel(new FlowLayout());
		Width.add(WidthLabel);
		Width.add(WidthField);
		JPanel Depth = new JPanel(new FlowLayout());
		Depth.add(DepthLabel);
		Depth.add(DepthField);
		JPanel Buttons = new JPanel(new FlowLayout());
		Buttons.add(Calculate);
		Buttons.add(Exit);
		JPanel Volume = new JPanel(new FlowLayout());
		Volume.add(VolumeLabel);
		Volume.add(VolumeField);
		JPanel Shape = new JPanel(new FlowLayout());
		Shape.add(Round);
		Shape.add(Oval);
		Oval.setSelected(true);
		
		this.tabspanel.add(Shape);
		this.tabspanel.add(Length);
		this.tabspanel.add(Width);
		this.tabspanel.add(Depth);
		this.tabspanel.add(Buttons);
		this.tabspanel.add(Volume);
		
		ButtonsHandler bh = new ButtonsHandler();
		Calculate.addActionListener(bh);
		Exit.addActionListener(bh);
		Round.addActionListener(bh);
		Oval.addActionListener(bh);

	}
	class ButtonsHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			if (e.getSource() == Calculate){
				if (LengthField.getText().equals("") == false && DepthField.getText().equals("") == false){
					LengthField.setBackground(Color.white);
					DepthField.setBackground(Color.white);
					WidthField.setBackground(Color.white);
					if (WidthField.isEditable() == false)	
						getRoundVolume();
					else{
						if(WidthField.getText().equals("") == false)						
							getOvalVolume();
						else{
							WidthField.setBackground(Color.yellow);
							JOptionPane.showMessageDialog(null, "Please enter a value for Width");
						}
					}
				}
				else{
					if (LengthField.getText().equals("") == true){
						LengthField.setBackground(Color.yellow);
						JOptionPane.showMessageDialog(null, "Please enter a value for Length");
					}
					if (DepthField.getText().equals("") == true){
						DepthField.setBackground(Color.yellow);
						JOptionPane.showMessageDialog(null, "Please enter a value for Depth");
					}
				}	
			}
			
			if (e.getSource() == Exit)
				System.exit(0);
			if (e.getSource() == Round){
				WidthField.setEditable(false);
				Oval.setSelected(false);
			}
			if (e.getSource() == Oval){
				WidthField.setEditable(true);
				Round.setSelected(false);
			}
		}
		public void getRoundVolume(){
			double Length = Double.parseDouble(LengthField.getText());
			double Depth = Double.parseDouble(DepthField.getText());
			double Volume = (Math.PI * Math.pow((Length/2),2) * Depth);
			VolumeField.setValue(new Double(Volume));
		}
		public void getOvalVolume(){
			double Length = Double.parseDouble(LengthField.getText());
			double Width = Double.parseDouble(WidthField.getText());
			double Depth = Double.parseDouble(DepthField.getText());
			double Volume = Math.PI * Math.pow((Length * Width),2) * Depth;
			VolumeField.setValue(new Double(Volume));
		}
	}
}
