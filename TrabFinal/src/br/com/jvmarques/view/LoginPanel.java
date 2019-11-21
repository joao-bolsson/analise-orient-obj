package br.com.jvmarques.view;

import br.com.jvmarques.controller.UserController;
import br.com.jvmarques.entity.User;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * TODO: fazer disso um editor?
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 21.
 */
public class LoginPanel extends JPanel {

    private final JButton btnSignIn;
    private final JButton btnSignUp;
    private final JPasswordField passTxt;
    private final JTextField userTxt;

    private final UserController userController = new UserController();

    /**
     * Creates new form LoginPanel.
     */
    public LoginPanel() {
        super(new BorderLayout());
        userTxt = new JTextField();
        passTxt = new JPasswordField();
        btnSignIn = new JButton("Entrar");
        btnSignUp = new JButton("Cadastrar");

        init();
    }

    private JPanel buildButtonsPanel() {
        JPanel root = new JPanel(new BorderLayout());
        JPanel btnPanel = new JPanel(new GridBagLayout());

        GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.anchor = GridBagConstraints.NORTHWEST;
        cons.insets = new Insets(5, 5, 5, 5);
        btnPanel.add(btnSignUp, cons);

        cons.gridx++;
        cons.gridy = 0;
        btnPanel.add(btnSignIn, cons);

        root.add(btnPanel, BorderLayout.EAST);

        return root;
    }

    private JPanel buildFieldsPanel() {
        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        fieldsPanel.setBorder(BorderFactory.createEtchedBorder());

        GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.anchor = GridBagConstraints.NORTHWEST;
        cons.insets = new Insets(5, 5, 5, 5);
        fieldsPanel.add(new JLabel("Usuário:"), cons);

        cons.gridx++;
        cons.ipadx = 222;
        fieldsPanel.add(userTxt, cons);

        cons.gridx = 0;
        cons.gridy++;
        cons.ipadx = 0;
        fieldsPanel.add(new JLabel("Senha:"), cons);

        cons.gridx++;
        cons.ipadx = 222;
        fieldsPanel.add(passTxt, cons);

        return fieldsPanel;
    }

    private void addListeners() {
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Container parent = getParent();

                while (!(parent instanceof Window)) {
                    parent = parent.getParent();
                }

                User user = new User(userTxt.getText(), userTxt.getText());

                boolean login = userController.singUp((Window) parent, user);
                System.out.println("cadastrou? " + login);
            }
        });

        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Container parent = getParent();

                while (!(parent instanceof Window)) {
                    parent = parent.getParent();
                }

                User user = new User(userTxt.getText(), userTxt.getText());

                boolean login = userController.login((Window) parent, user);
                System.out.println("logou? " + login);
            }
        });
    }

    private void init() {
        addListeners();

        add(buildFieldsPanel(), BorderLayout.CENTER);
        add(buildButtonsPanel(), BorderLayout.PAGE_END);
    }

}
