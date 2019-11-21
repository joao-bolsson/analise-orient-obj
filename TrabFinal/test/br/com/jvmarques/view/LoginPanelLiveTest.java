package br.com.jvmarques.view;

import java.awt.Dimension;
import javax.swing.JDialog;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 21.
 */
public class LoginPanelLiveTest {

    private LoginPanelLiveTest() {
        // empty
    }

    /**
     * Method to show this panel.
     *
     * @param args Command line arguments (ignore).
     */
    public static void main(final String[] args) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Login Panel Live Test");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);

        dialog.setContentPane(new LoginPanel());

        dialog.setPreferredSize(new Dimension(330, 140));
        dialog.pack();
        dialog.setVisible(true);
    }

}
