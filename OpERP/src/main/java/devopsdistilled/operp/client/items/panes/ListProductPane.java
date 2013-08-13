package devopsdistilled.operp.client.items.panes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.client.items.models.observers.ProductModelObserver;
import devopsdistilled.operp.client.items.panes.details.ProductDetailsPane;
import devopsdistilled.operp.client.items.panes.models.observers.ListProductPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Product;

public class ListProductPane extends SubTaskPane implements
		ListProductPaneModelObserver, ProductModelObserver {

	@Inject
	private ProductDetailsPane productDetailsPane;

	private final JPanel pane;

	private final JTable table;
	BeanTableModel<Product> tableModel;

	public ListProductPane() {
		pane = new JPanel(new MigLayout("fill"));

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)
						&& e.getClickCount() == 2
						&& table.getSelectedRow() != -1) {

					Product product = tableModel.getRow(table.getSelectedRow());

					productDetailsPane.show(product, getPane());
				}
			}
		});

		final JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(scrollPane, "grow");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateProducts(List<Product> products) {
		tableModel = null;
		tableModel = new BeanTableModel<>(Product.class, products);

		for (int i = 0; i < tableModel.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}

		tableModel.setModelEditable(false);
		table.setModel(tableModel);
	}

}
