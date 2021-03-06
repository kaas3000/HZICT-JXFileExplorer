import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

public class JXListCellRenderer extends DefaultListCellRenderer {
	private static final long serialVersionUID = 1L;

	public JXListCellRenderer() {
		super();
	}

	/**
	 * Replace the ListCellRenderer with one that shows both text and icons
	 */
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		Component tempComponent = super.getListCellRendererComponent(list,
				value, index, isSelected, cellHasFocus);
		JLabel result = (JLabel) tempComponent;

		if (value instanceof JXplorerFile) {
			JXplorerFile file = (JXplorerFile) value;
			result.setIcon(file.getIcon());
		}

		return result;
	}
}
