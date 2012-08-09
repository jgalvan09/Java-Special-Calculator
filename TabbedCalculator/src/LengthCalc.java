import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.*;
import javax.swing.*;
import javax.swing.event.*;

public class LengthCalc extends Frame {
	private static final long serialVersionUID = -34092234235415355L;
	private JLabel MilliLabel = new JLabel(" Millimeters");
	private JLabel MetersLabel = new JLabel(" Meters");
	private JLabel YardsLabel = new JLabel(" Yards");
	private JLabel FeetLabel = new JLabel(" Feet");
	private JLabel InchesLabel = new JLabel(" Inches");
	private JFormattedTextField MilliField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField MeterField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField YardsField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField FeetField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField InchesField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JButton Exit = new JButton("Exit");
	private JButton Reset = new JButton("Reset");
	private JButton Calculate = new JButton("Calculate");
	public LengthCalc(){
		MilliField.setColumns(7);
		MeterField.setColumns(5);
		YardsField.setColumns(5);
		FeetField.setColumns(5);
		InchesField.setColumns(7);
		InchesLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		FeetLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		YardsLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		MetersLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		MilliLabel.setBorder(BorderFactory.createLineBorder(Color.gray));

		JPanel Milli = new JPanel(new GridLayout(0,1));
		Milli.add(MilliLabel);
		Milli.add(MilliField);
		JPanel Meters = new JPanel(new GridLayout(0,1));
		Meters.add(MetersLabel);
		Meters.add(MeterField);
		JPanel Yards = new JPanel(new GridLayout(0,1));
		Yards.add(YardsLabel);
		Yards.add(YardsField);
		JPanel Feet = new JPanel(new GridLayout(0,1));
		Feet.add(FeetLabel);
		Feet.add(FeetField);
		JPanel Inches = new JPanel(new GridLayout(0,1));
		Inches.add(InchesLabel);
		Inches.add(InchesField);
		JPanel New = new JPanel();
		New.add(Milli);
		New.add(Meters);
		New.add(Yards);
		New.add(Feet);
		New.add(Inches);
		
		this.tabspanel.add(New);
		this.tabspanel.add(Calculate);
		this.tabspanel.add(Reset);
		this.tabspanel.add(Exit);
		
		ButtonsHandler bh = new ButtonsHandler();
		Reset.addActionListener(bh);
		Exit.addActionListener(bh);
		Calculate.addActionListener(bh);

	}
	
	class ButtonsHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == Reset){
				MilliField.setValue(0);
				MeterField.setValue(0);
				YardsField.setValue(0);
				FeetField.setValue(0);
				InchesField.setValue(0);
			}
			if(e.getSource() == Calculate){
				if(MilliField.getText().equals("") == false || MilliField.getText().equals(0) == false){
					double milli = Double.parseDouble(MilliField.getText());
					double meter = milli/1000;
					MeterField.setValue(meter);
				}
				if(MeterField.getText().equals("") == false || MeterField.getText().equals(0) == false){
					double meter = Double.parseDouble(MeterField.getText());
				}
				if(YardsField.getText().equals("") == false || YardsField.getText().equals(0) == false){
					double yards = Double.parseDouble(YardsField.getText());
				}
				if(FeetField.getText().equals("") == false || FeetField.getText().equals(0) == false){
					double feet = Double.parseDouble(FeetField.getText());
				}
				if(InchesField.getText().equals("") == false || InchesField.getText().equals(0) == false){
					double inches = Double.parseDouble(InchesField.getText());
				}
			}
			if(e.getSource() == Exit){
				System.exit(0);
			}
		}
	}

	public static void main(String[] args){
		addTabs one = new addTabs();
	}

}

