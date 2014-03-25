import java.util.ArrayList;

/**
 * @author meli0018
 * 
 * FIXME: Ontbreekt: TreeView en StatusView
 * TODO: Dubbelklikken op een bestand in ListView resulteert in een NullPointerException
 * FIXME: nog geen ontwerpdocument ingeleverd op Moodle
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
	}
	
	/**
	 * 
	 * @param file The file to start with
	 */
	public void setFile(JXplorerFile file) {
		this.file = file;
		updateViews();
	}
	
	/**
	 * 
	 * @param filename The path + filename as string
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
	 * @param view The view to be added
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
