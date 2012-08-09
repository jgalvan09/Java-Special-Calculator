import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class addTabs extends Frame {
	private static final long serialVersionUID = -340234235667415355L;
	public addTabs(){
		JFrame frame = new JFrame("");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Pool tab1 = new Pool();
		HotTubs tab2 = new HotTubs();
		TempCalc tab3 = new TempCalc();
		//LengthCalc tab4 = new LengthCalc();
		JTabbedPane allTabs = new JTabbedPane();
		allTabs.addTab("Pool", tab1.tabspanel);
		allTabs.addTab("Hot Tub", tab2.tabspanel);
		allTabs.addTab("Temp Calc.", tab3.tabspanel);
		//allTabs.addTab("Length Calc.", tab4.tabspanel);
		frame.add(allTabs);
		frame.setVisible(true);
		frame.setSize(new Dimension(400,300));	
		frame.setResizable(false);	
	}
}
