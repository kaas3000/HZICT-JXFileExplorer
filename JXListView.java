import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JXListView extends JXploreView implements MouseListener {
	private static final long serialVersionUID = 1L;
	
	private JXplorerFile file;

	private DefaultListModel<JXplorerFile> listModel;
	private JList<JXplorerFile> fileList;
	
	/**
	 * Create a {@link JXListView} object using the given file 
	 * @param file The file or folder to be displayed
	 */
	public JXListView(JXplorerFile file) {
		super(new BorderLayout());
		
		this.file = file;
		buildGUI();
	}
	
	/**
	 * 
	 * @param file The new file
	 */
	public void setFile(JXplorerFile file) {
		this.file = file;
	}
	
	/**
	 * 
	 * @return A panel to be used in a JFrame
	 */
	public JPanel getViewPanel() {
		return this;
	}
	
	/**
	 * Fill the JList component using a defaultListModel 
	 */
	public void fillList() {
		this.listModel = new DefaultListModel<JXplorerFile>();
		
		// fill the listModel
		// begin with the parent directory
		if (this.file.getParentDir().getName() != null) {
			JXplorerFile tempFile = this.file.getParentDir();
			tempFile.setName("..");
			tempFile.setHiddenIcon(true);
			this.listModel.addElement(tempFile);
		}
		// begin to fill with the actual content
		for (JXplorerFile child : this.file.getChildren()) {
			this.listModel.addElement(child);
		}
		
		if (fileList == null) { // create new list
			this.fileList = new JList<JXplorerFile>(this.listModel);
			this.fileList.addMouseListener(this);
			this.fileList.setCellRenderer(new JXListCellRenderer());
		} else { //update current list
			this.fileList.setModel(this.listModel);
		}
	}
	
	/**
	 * Prepare the object to be used in a JFrame
	 */
	public void buildGUI() {
		this.fillList();
		JScrollPane scrollPane = new JScrollPane(fileList);
		this.add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void updateView() {
		setFile(this.data.getCurrentFile());
		fillList();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getClickCount() == 2) {
			this.data.setFile(this.fileList.getSelectedValue());
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Do nothing
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Do nothing
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// Do nothing
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// Do nothing
		
	}
}
