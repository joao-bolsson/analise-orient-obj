package br.com.jvmarques.view;

import br.com.jvmarques.entity.User;
import java.awt.Dimension;
import javax.swing.JDialog;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 21
 */
public class UserPanelLiveTest {

    private UserPanelLiveTest() {
        // empty
    }

    /**
     * Method to show this panel.
     *
     * @param args Command line arguments (ignore).
     */
    public static void main(final String[] args) {
        JDialog dialog = new JDialog();
        dialog.setTitle("User Panel Live Test");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);

        User user = new User("João", "pass");

        dialog.setContentPane(new UserPanel(user));

        dialog.setPreferredSize(new Dimension(330, 140));
        dialog.pack();
        dialog.setVisible(true);
    }

}
