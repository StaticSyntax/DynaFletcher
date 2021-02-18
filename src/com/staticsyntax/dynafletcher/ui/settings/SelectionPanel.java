package com.staticsyntax.dynafletcher.ui.settings;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SelectionPanel<T> extends JPanel {

    private JLabel label;
    private JComboBox comboBox;

    public SelectionPanel(String string, T[] options) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        initLabel(string);
        initComboBox(options);
    }

    private void initLabel(String string) {
        label = new JLabel(string);
        label.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(label);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void initComboBox(T[] options) {
        comboBox = new JComboBox(options);
        comboBox.setBackground(Color.CYAN);
        add(comboBox);

        Dimension dim = new Dimension(350, 25);
        comboBox.setPreferredSize(dim);
        comboBox.setMaximumSize(dim);

        DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
        listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        comboBox.setRenderer(listCellRenderer);
    }

    public JComboBox getComboBox() {
        return comboBox;
    }
}
