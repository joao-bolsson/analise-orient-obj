package br.com.animati.hp.forms.swing.util;

import br.com.jvmarques.controller.OptionsController;
import br.com.jvmarques.model.CustomTableModel;
import br.com.jvmarques.view.util.PanelWithTable;
import java.awt.Window;
import java.util.Arrays;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 20.
 */
public class PanelWithTableLiveTest {

    private PanelWithTableLiveTest() {
        // empty
    }

    /**
     * Method to show this panel.
     *
     * @param args Command line arguments (ignore).
     */
    public static void main(final String[] args) {
        CustomTableModel model = new CustomTableModel<String>(new String[]{"Nome", "Opções"}, Arrays.asList("Joao")) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 1;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                if (rowIndex >= 0 && rowIndex < list.size()) {
                    return list.get(rowIndex);
                }
                return null;
            }
        };

        OptionsController<String> controller = new OptionsController<String>() {
            @Override
            public void edit(final Window parent, final String item) {
                // nothing
            }

            @Override
            public void delete(final String item) {
                // nothing
            }

            @Override
            public void add(final Window parent) {
                String string = JOptionPane.showInputDialog(parent, "Item para adicionar: ");
                if (string != null && !string.isEmpty()) {
                    model.add(string);
                }
            }

        };

        PanelWithTable panel = new PanelWithTable(model, 1, controller);
        panel.init();

        JDialog dialog = new JDialog();
        dialog.setTitle("PanelWithTable Live Test");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setVisible(true);
    }

}
