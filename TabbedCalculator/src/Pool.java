import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.*;

public class Pool extends Frame {
	private static final long serialVersionUID = -340923934234415355L;
	private JButton Calculate = new JButton("Calculate");
	private JButton Exit = new JButton("Exit");
	private JFormattedTextField VolumeField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField DepthField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField WidthField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField LengthField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JLabel LengthLabel = new JLabel("Enter the Pool's Length (ft): ");
	private JLabel WidthLabel = new JLabel("Enter the Pool's Width (ft): ");
	private JLabel DepthLabel = new JLabel("Enter the Pool's Depth (ft): ");
	private JLabel VolumeLabel = new JLabel("The Pool's Volume (ft^3): ");

	public Pool(){
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
		
		this.tabspanel.add(Length);
		this.tabspanel.add(Width);
		this.tabspanel.add(Depth);
		this.tabspanel.add(Buttons);
		this.tabspanel.add(Volume);
		
		ButtonsHandler bh = new ButtonsHandler();
		Calculate.addActionListener(bh);
		Exit.addActionListener(bh);

	}
	class ButtonsHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == Calculate){
				if (WidthField.getText().equals("") == false && LengthField.getText().equals("") == false && DepthField.getText().equals("") == false){
					LengthField.setBackground(Color.white);
					WidthField.setBackground(Color.white);
					DepthField.setBackground(Color.white);
					double Width = Double.parseDouble(WidthField.getText());
					double Length = Double.parseDouble(LengthField.getText());
					double Depth = Double.parseDouble(DepthField.getText());
					double Volume = Width * Length * Depth;
					VolumeField.setValue(new Double(Volume));
				}
				else{
					if (LengthField.getText().equals("") == true){
						LengthField.setBackground(Color.yellow);
						JOptionPane.showMessageDialog(null, "Please enter a value for Length");
					}
					if (WidthField.getText().equals("") == true){
						WidthField.setBackground(Color.yellow);
						JOptionPane.showMessageDialog(null, "Please enter a value for Width");
					}
					if (DepthField.getText().equals("") == true){
						DepthField.setBackground(Color.yellow);
						JOptionPane.showMessageDialog(null, "Please enter a value for Depth");
					}
				}	
			}
			if (e.getSource() == Exit)
				System.exit(0);
		}
	}
}
