package br.com.jvmarques.view;

import br.com.jvmarques.manager.UserManager;
import br.com.jvmarques.entity.User;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * TODO: documentação.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 21.
 */
public class UserPanel extends JPanel {

    private final User user;

    private final JButton btnLogOut;

    public UserPanel(final User user) {
        super(new BorderLayout());
        this.user = user;

        btnLogOut = new JButton("Sair");

        init();
    }

    private void addListener() {
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                UserManager.getInstance().logout();

                Container container = getParent();
                while (!(container instanceof Window)) {
                    container = container.getParent();
                }

                ((Window) container).dispose(); // closes the window

                // shows the login panel
                JDialog dialog = new JDialog();
                dialog.setTitle("Login Panel");
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setLocationRelativeTo(null);

                dialog.setContentPane(new LoginPanel());

                dialog.setPreferredSize(new Dimension(330, 140));
                dialog.pack();
                dialog.setVisible(true);
            }
        });
    }

    private void init() {
        addListener();
        setBorder(BorderFactory.createEtchedBorder());

        JPanel root = new JPanel(new GridBagLayout());

        GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.fill = GridBagConstraints.BOTH;
        cons.anchor = GridBagConstraints.CENTER;
        cons.insets = new Insets(5, 5, 5, 5);
        root.add(new JLabel("Usuário logado: " + user.getLogin()), cons);

        cons.gridy++;
        root.add(btnLogOut, cons);

        add(root, BorderLayout.CENTER);
    }

}
