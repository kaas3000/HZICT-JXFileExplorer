import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.TreeNode;

// FIXME de TreeNode interface moet nog worden ge�mplementeerd. samen met caching en lazy loading
public class JXplorerFile implements TreeNode {
	private File file;
	
	private String name;
	
	private boolean hiddenIcon;

	/**
	 * 
	 * @param file
	 *            The file
	 */
	public JXplorerFile(File file) {
		this.file = file;
		this.name = null;
		this.hiddenIcon = false;
	}

	/**
	 * 
	 * @param filename
	 *            The path to the file
	 */
	public JXplorerFile(String filename) {
		this.file = new File(filename);
	}

	/**
	 * Make root as file
	 */
	public JXplorerFile() {
		this.file = FileSystemView.getFileSystemView().getRoots()[0];
	}

	/**
	 * 
	 * @return The name of the current file
	 */
	public String getName() {
		if (this.name == null) {
			return FileSystemView.getFileSystemView().getSystemDisplayName(file);
		} else {
			return this.name;
		}
	}

	/**
	 * 
	 * @return The path of the current file
	 */
	public String getPath() {
		return file.getPath();
	}

	/**
	 * 
	 * @return The icon if available and hiddenIcon is false
	 */
	public Icon getIcon() {
		if (hiddenIcon) return null;
		
		return FileSystemView.getFileSystemView().getSystemIcon(this.file);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHiddenIcon(boolean hidden) {
		this.hiddenIcon = hidden;
	}

	/**
	 * 
	 * @return The current file
	 */
	public File getFile() {
		return this.file;
	}
	
	/**
	 * 
	 * @return The parent of the file
	 */
	public JXplorerFile getParentDir() {
		return new JXplorerFile(FileSystemView.getFileSystemView().getParentDirectory(this.file));
	}
	
	
	/**
	 * Returns true if current file is a folder
	 */
	public boolean isFolder() {
		return this.file.isDirectory();
	}
	
	/**
	 * 
	 * @return an array with every file (including folders) as JXplorerFile
	 *         within the given directory.
	 * 
	 * @param type
	 *            The type of the files to return valid types: all, files,
	 *            folders
	 */
	private JXplorerFile[] getFolderContent(String type) {
		ArrayList<File> allFiles = new ArrayList<File>(Arrays.asList(file
				.listFiles()));

		ArrayList<JXplorerFile> subFiles = new ArrayList<JXplorerFile>();

		for (File subFile : allFiles) {
			if (type.equals("all")) {
				subFiles.add(new JXplorerFile(subFile));
			} else if (type.equals("files")) {
				if (subFile.isFile()) {
					subFiles.add(new JXplorerFile(subFile));
				}
			} else if (type.equals("folders")) {
				if (subFile.isDirectory()) {
					subFiles.add(new JXplorerFile(subFile));
				}
			}
		}

		return subFiles.toArray(new JXplorerFile[] {});
	}

	/**
	 * 
	 * @return An array with only files within the given directory
	 */
	public JXplorerFile[] getSubFiles() {
		return getFolderContent("files");
	}

	/**
	 * 
	 * @return An array with only folders within the given directory
	 */
	public JXplorerFile[] getSubFolders() {
		return getFolderContent("folders");
	}
	
	/**
	 * 
	 * @return An array with the files and folders within the given directory
	 */
	public JXplorerFile[] getChildren() {
		return getFolderContent("all");
	}
	
	@Override
	public String toString() {
		return this.getName();
	}

	@Override
	public Enumeration<?> children() {
		return new Enumeration<JXplorerFile>() {
			int index = 0;

			@Override
			public boolean hasMoreElements() {
				return index < getSubFolders().length;
			}

			@Override
			public JXplorerFile nextElement() {
				return getSubFolders()[index++];
			}
		};
	}

	@Override
	public boolean getAllowsChildren() {
		return isFolder();
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return getSubFolders()[childIndex];
	}

	@Override
	public int getChildCount() {
		return getSubFolders().length;
	}

	@Override
	public int getIndex(TreeNode node) {
		JXplorerFile[] folders = getSubFolders();
		for (int n=0; n<folders.length; n++) 
			if (folders[n].equals(node))
				return n;
		return -1; // folder not found
	}

	@Override
	public TreeNode getParent() {
		if (file.getParentFile() == null)
			return null;
		return new JXplorerFile(file.getParentFile());
	}

	@Override
	public boolean isLeaf() {
		return false;
	}
}
