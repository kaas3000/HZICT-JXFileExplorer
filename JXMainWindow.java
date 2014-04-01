import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.UnsupportedLookAndFeelException;

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
		enableGtkTheme();
		JXAdressView adressView = new JXAdressView(app.getCurrentFile());
		JXStatusView statusView = new JXStatusView(app.getCurrentFile());
		JXListView fileListView = new JXListView(app.getCurrentFile());
		JXTreeView treeView = new JXTreeView(app.getCurrentFile());
		statusView.setData(app);
		fileListView.setData(app);
		treeView.setData(app);

		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		adressView.setData(app);

		getFrame().getContentPane().add(adressView, BorderLayout.NORTH);

		JSplitPane splitPane = new JSplitPane();
		getFrame().getContentPane().add(splitPane, BorderLayout.CENTER);

		splitPane.setRightComponent(fileListView);

		splitPane.setLeftComponent(treeView);

		frame.getContentPane().add(statusView, BorderLayout.SOUTH);
	}

	/**
	 * Check if the GTK theme is installed and enables it
	 */
	public void enableGtkTheme() {
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
				.getInstalledLookAndFeels()) {
			if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(info
					.getClassName())) {
				try {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	/**
	 * 
	 * @return The frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Set the frame
	 * 
	 * @param frame
	 *            The new frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
