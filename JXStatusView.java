import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JXStatusView extends JXploreView {
	private static final long serialVersionUID = 1L;

	private JLabel numberOfItemsLabel;

	private JXplorerFile file;

	public JXStatusView(JXplorerFile file) {
		super(new FlowLayout(FlowLayout.RIGHT));

		this.file = file;

		buildGUI();
	}

	/**
	 * numberOfItemsLabel is set with information about the current file
	 */
	public void setNumberOfItemsLabel() {
		if (this.file.isFolder()) {
			int numberOfItems = this.file.getChildren().length;
			int numberofSubFolders = file.getSubFolders().length;
			this.numberOfItemsLabel.setText("Number of items/subfolders: "
					+ numberOfItems + "/" + numberofSubFolders);
		}
	}

	/**
	 * Prepare the panel to be used in the jframe
	 */
	@Override
	public void buildGUI() {
		this.numberOfItemsLabel = new JLabel();
		this.numberOfItemsLabel.setHorizontalTextPosition(SwingConstants.RIGHT);

		this.add(numberOfItemsLabel);
		setNumberOfItemsLabel();
	}

	/**
	 * A new file is set: this.file retrieves the new file from data and all
	 * components get refreshed
	 */
	@Override
	public void updateView() {
		this.file = this.data.getCurrentFile();
		setNumberOfItemsLabel();
	}

}
