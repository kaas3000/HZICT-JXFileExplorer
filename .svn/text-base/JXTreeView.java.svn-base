import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class JXTreeView extends JXploreView implements TreeSelectionListener {
	private static final long serialVersionUID = 1L;

	private JXplorerFile file;
	private JTree fileTree;
	private JXplorerFile rootNode;

	public JXTreeView(JXplorerFile file) {
		super(new BorderLayout());

		this.file = file;
		this.rootNode = new JXplorerFile();
		buildGUI();
	}

	public JXTreeView() {
		super(new BorderLayout());

		this.rootNode = new JXplorerFile();
		buildGUI();
	}

	/**
	 * 
	 * @return The file used in this component
	 */
	public JXplorerFile getFile() {
		return file;
	}

	/**
	 * 
	 * @param file
	 *            The file to be used in this component
	 */
	public void setFile(JXplorerFile file) {
		this.file = file;
	}

	/**
	 * Prepare the panel to be used in the jframe
	 */
	public void buildGUI() {
		this.fileTree = new JTree(this.rootNode);
		this.fileTree.addTreeSelectionListener(this);

		JScrollPane scrollPane = new JScrollPane(fileTree);

		this.add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * Set this.file to the one from this.data when the user selects a new one
	 */
	public void updateView() {
		setFile(this.data.getCurrentFile());
	}

	/**
	 * Called when the user selects a new file. If the file is different from
	 * the one in this.data, update this.data
	 */
	public void valueChanged(TreeSelectionEvent e) {
		JXplorerFile currentNode = (JXplorerFile) fileTree
				.getLastSelectedPathComponent();

		if (currentNode.equals(data.getCurrentFile()))
			return;

		this.data.setFile(currentNode);
	}
}
