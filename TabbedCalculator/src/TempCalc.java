import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.*;

public class TempCalc extends Frame{
	private static final long serialVersionUID = -340234235667415355L;
	private JLabel tempLabel = new JLabel("Enter Temperature: ");
	private JLabel ResultsLabel = new JLabel("Results: ");
	private JFormattedTextField tempField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField ResultsField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private	String[] types = {"C", "F", "K"};
	private	JComboBox TypeIn = new JComboBox(types);
	private	JComboBox TypeOut = new JComboBox(types);
	private JButton Convert = new JButton("Convert");
	private JButton Exit = new JButton("Exit");
	public TempCalc(){
		tempField.setColumns(15);
		ResultsField.setColumns(20);
		ResultsField.setEditable(false);
		JPanel Temp = new JPanel();
		Temp.add(tempLabel);
		Temp.add(tempField);
		Temp.add(TypeIn);
		JPanel Results = new JPanel();
		Results.add(ResultsLabel);
		Results.add(ResultsField);
		Results.add(TypeOut);
		JPanel Buttons = new JPanel();
		Buttons.add(Convert);
		Buttons.add(Exit);
		
		this.tabspanel.add(Temp);
		this.tabspanel.add(Results);
		this.tabspanel.add(Buttons);
		
		ButtonsHandler bh = new ButtonsHandler();
		Convert.addActionListener(bh);
		Exit.addActionListener(bh);

	}
	class ButtonsHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double to = 0.555555556;
			double from = 1.8;
			if(e.getSource() == Convert){
				if(tempField.getText().equals("") == false){
					tempField.setBackground(Color.white);
					if(TypeIn.getSelectedIndex() == 0){
						if(TypeOut.getSelectedIndex() == 0){
							double tempIn = Double.parseDouble(tempField.getText());
							ResultsField.setValue(new Double(tempIn));
						}
						if(TypeOut.getSelectedIndex() == 1){
							double tempIn = Double.parseDouble(tempField.getText());
							double CtoF = tempIn*from+32;
							ResultsField.setValue(new Double(CtoF));
						}
						if(TypeOut.getSelectedIndex() == 2){
							double tempIn = Double.parseDouble(tempField.getText());
							double CtoK = tempIn + 273.15;
							ResultsField.setValue(new Double(CtoK));
						}
					}
					if(TypeIn.getSelectedIndex() == 1){
						if(TypeOut.getSelectedIndex() == 0){
							double tempIn = Double.parseDouble(tempField.getText());
							double FtoC = (tempIn - 32)*to;
							ResultsField.setValue(new Double(FtoC));
						}
						if(TypeOut.getSelectedIndex() == 1){
							double tempIn = Double.parseDouble(tempField.getText());
							ResultsField.setValue(new Double(tempIn));
						}
						if(TypeOut.getSelectedIndex() == 2){
							double tempIn = Double.parseDouble(tempField.getText());
							double FtoK = (tempIn + 459.67)*to;
							ResultsField.setValue(new Double(FtoK));
						}
					}
					if(TypeIn.getSelectedIndex() == 2){
						if(TypeOut.getSelectedIndex() == 0){
							double tempIn = Double.parseDouble(tempField.getText());
							double KtoC = tempIn-273.15;
							ResultsField.setValue(new Double(KtoC));
						}
						if(TypeOut.getSelectedIndex() == 1){
							double tempIn = Double.parseDouble(tempField.getText());
							double KtoF = tempIn*from-459.67;
							ResultsField.setValue(new Double(KtoF));
						}
						if(TypeOut.getSelectedIndex() == 2){
							double tempIn = Double.parseDouble(tempField.getText());
							ResultsField.setValue(new Double(tempIn));
						}
					}
				}
				else{
					tempField.setBackground(Color.yellow);
					JOptionPane.showMessageDialog(null, "Enter a Temperature!");
				}
			}
			if (e.getSource() == Exit)
				System.exit(0);
		}
	}
}
