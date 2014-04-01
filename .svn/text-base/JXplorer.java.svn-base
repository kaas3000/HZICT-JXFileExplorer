import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author meli0018
 * 
 *         FIXME: nog geen ontwerpdocument ingeleverd op Moodle
 */
class JXplorer {

	private JXplorerFile file;

	private ArrayList<JXploreView> JXViews;

	/**
	 * Start with a new file
	 */
	public JXplorer() {
		this.file = new JXplorerFile();
		this.JXViews = new ArrayList<JXploreView>();

		updateViews();
	}

	/**
	 * 
	 * @param file
	 *            The file to start with
	 */
	public void setFile(JXplorerFile file) {
		this.file = file;

		if (this.file.isFolder()) {
			updateViews();
		} else {
			showFileInfoDialog();
		}
	}

	/**
	 * 
	 * @param filename
	 *            The path + filename as string
	 */
	public void setFile(String filename) {
		setFile(new JXplorerFile(filename));
	}

	/**
	 * 
	 * @return file
	 */
	public JXplorerFile getCurrentFile() {
		return this.file;
	}

	/**
	 * 
	 * @param view
	 *            The view to be added
	 */
	public void addView(JXploreView view) {
		this.JXViews.add(view);
	}

	/**
	 * 
	 * @param file
	 */
	public void printName(JXplorerFile file) {
		System.out.println(file.getName());
	}

	/**
	 * 
	 * @param file
	 */
	public void printSubFiles(JXplorerFile file) {
		System.out.println(file.getSubFiles());
	}

	public void printSubFolders(JXplorerFile file) {
		System.out.println(file.getSubFolders());
	}

	public void showFileInfoDialog() {
		JOptionPane.showMessageDialog(null, this.file.getDetails(),
				"File information", JOptionPane.INFORMATION_MESSAGE,
				this.file.getIcon());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("The program is running.");
		JXplorer app = new JXplorer();

		JXMainWindow window = new JXMainWindow(app);
		window.getFrame().setVisible(true);
	}

	/**
	 * Update every view (e.g. when a new adress is entered)
	 */
	private void updateViews() {
		for (JXploreView view : JXViews) {
			view.updateView();
		}
	}
}
