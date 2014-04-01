import java.awt.LayoutManager;

import javax.swing.JPanel;

public abstract class JXploreView extends JPanel {
	private static final long serialVersionUID = 1L;

	protected JXplorer data;

	public JXploreView(LayoutManager layout) {
		super(layout);
	}

	/**
	 * 
	 * @return The explorer (as JXplorer object)
	 */
	public JXplorer getData() {
		return this.data;
	}

	/**
	 * Set the explorer and add the view to it's memory
	 * 
	 * @param explorer
	 *            The explorer (as JXplorer object)
	 */
	public void setData(JXplorer explorer) {
		this.data = explorer;
		this.data.addView(this);
	}

	public abstract void buildGUI();

	public abstract void updateView();
}
