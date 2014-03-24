import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;


public class JXMainWindow {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public JXMainWindow(JXplorer app) {
		initialize(app);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JXplorer app) {
		JXAdressView adressView = new JXAdressView();
		JXListView fileListView = new JXListView(app.getCurrentFile());
		
		adressView.setData(app);
		fileListView.setData(app);

		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getFrame().getContentPane().add(adressView, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		getFrame().getContentPane().add(splitPane, BorderLayout.CENTER);
		
		fileListView.buildGUI();
		splitPane.setRightComponent(fileListView);
		
		JLabel lblplaceholder = new JLabel("[placeholder]");
		getFrame().getContentPane().add(lblplaceholder, BorderLayout.SOUTH);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
