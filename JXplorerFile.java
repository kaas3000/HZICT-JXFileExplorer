import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;

// FIXME de TreeNode interface moet nog worden ge�mplementeerd. samen met caching en lazy loading
public class JXplorerFile {
	private File file;

	/**
	 * 
	 * @param file
	 *            The file
	 */
	public JXplorerFile(File file) {
		this.file = file;
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
		return FileSystemView.getFileSystemView().getSystemDisplayName(file);
	}

	/**
	 * 
	 * @return The path of the current file
	 */
	public String getPath() {
		return file.getPath();
	}

	public Icon getIcon() {
		return FileSystemView.getFileSystemView().getSystemIcon(this.file);
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
}
