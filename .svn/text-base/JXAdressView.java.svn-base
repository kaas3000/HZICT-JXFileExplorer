import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

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
		super(new BorderLayout());

		this.file = file;

		buildGUI();
	}

	/**
	 * 
	 * @return Itself
	 */
	public JPanel getViewPanel() {
		return this;
	}

	/**
	 * Set the text of the adressbar
	 * 
	 * @param adress
	 *            The new text
	 */
	public void setAdressTextField(String adress) {
		this.adressTextField.setText(adress);
	}

	/**
	 * When clicked on the go button
	 */
	public void actionPerformed(ActionEvent e) {
		this.data.setFile(this.adressTextField.getText());
	}

	/**
	 * Configure all JComponents and add them to the panel
	 */
	@Override
	public void buildGUI() {
		this.adressLabel = new JLabel("Location");
		this.adressTextField = new JTextField(this.file.getPath());
		this.iconLabel = new JLabel(FileSystemView.getFileSystemView()
				.getSystemIcon(this.file.getFile()));
		this.goButton = new JButton("go");
		this.goButton.addActionListener(this);

		this.add(adressLabel, BorderLayout.LINE_START);
		this.add(this.iconLabel, BorderLayout.CENTER);
		this.add(adressTextField, BorderLayout.CENTER);
		this.add(goButton, BorderLayout.LINE_END);
	}

	/**
	 * Refresh all JComponents and set the new file
	 */
	@Override
	public void updateView() {
		this.file = this.data.getCurrentFile();
		this.iconLabel.setIcon(FileSystemView.getFileSystemView()
				.getSystemIcon(this.file.getFile()));
		setAdressTextField(this.file.getPath());
	}
}
