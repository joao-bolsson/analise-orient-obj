package br.com.jvmarques.view.util;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 20.
 */
public class ButtonsPanel extends JPanel {

    private final List<JButton> buttons;

    /**
     * Creates a panel with given buttons.
     *
     * @param buttons Buttons to add on this panel.
     */
    public ButtonsPanel(final List<JButton> buttons) {
        super();
        this.buttons = buttons;

        init();
    }

    private void init() {
        setOpaque(true);
        for (JButton b : buttons) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            add(b);
        }
    }

}
