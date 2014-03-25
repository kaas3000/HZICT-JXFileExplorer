import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JXAdressView extends JXploreView implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JXplorerFile file;
	
	private JLabel adressLabel;
	private JTextField adressTextField;
	private JButton goButton;
	private JLabel iconLabel;
	
	/**
	 * Create the adressView, create all GUI elements, and add them
	 */
	public JXAdressView(JXplorerFile file) {
		super(new BorderLayout(10, 10));
		
		this.file = file;
		
		buildGUI();
	}
	
	public JPanel getViewPanel() {
		return this;
	}
	
	public void setAdressTextField(String adress) {
		this.adressTextField.setText(adress);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.data.setFile(this.adressTextField.getText());
	}

	@Override
	public void buildGUI() {
		this.adressLabel = new JLabel("Location");
		this.adressTextField = new JTextField(20);
		this.goButton = new JButton("go");
		this.goButton.addActionListener(this);
		
		this.adressTextField.setText(this.file.getPath());
		
		this.add(adressLabel, BorderLayout.LINE_START);
		this.add(adressTextField, BorderLayout.CENTER);
		this.add(goButton, BorderLayout.LINE_END);
	}

	@Override
	public void updateView() {
		this.file = this.data.getCurrentFile();
		setAdressTextField(this.file.getPath());
	}
}
