package com.staticsyntax.dynafletcher.ui.settings;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.items.Items;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

public class SettingsDialog {

    private DynaFletcher script;

    private JDialog mainDialog;
    private SelectionPanel<Items> bowTypeSelectionPanel;
    private SelectionPanel<Items.Category> ammoCategorySelectionPanel;
    private SelectionPanel<Items.AcquisitionMethod> ammoMethodSelectionPanel;
    private SelectionPanel<Items> ammoTypeSelectionPanel;
    private SelectionPanel<Items> shieldTypeSelectionPanel;

    private Items targetItem = Items.REGULAR_SHORTBOW_U;

    public SettingsDialog(DynaFletcher script) {
        this.script = script;

        mainDialog = new JDialog();
        mainDialog.setTitle(script.getName() + " " + script.getVersion());
        mainDialog.setModal(true);
        mainDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        mainDialog.getContentPane().add(mainPanel);

        try {
            JLabel logoLabel = new JLabel(new ImageIcon(new URL("https://i.imgur.com/UW1c4lN.png")));
            logoLabel.setBorder(new EmptyBorder(0, 25, 25, 25));
            mainPanel.add(logoLabel);
            logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
        mainPanel.add(buttonsPanel);

        String[] cardStrings = new String[] {"Bows", "Ammo", "Shields"};
        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new CardLayout());
        cardsPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
        mainPanel.add(cardsPanel);

        URL[] iconURLs = null;
        try {
            iconURLs = new URL[] {
                    new URL("https://i.imgur.com/KFOLCQM.png"),
                    new URL("https://i.imgur.com/nXjOVVb.png"),
                    new URL("https://i.imgur.com/rAj5Q00.png")};
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        JButton[] mainButtons = new JButton[3];
        for(int i = 0; i < 3; i++) {
            mainButtons[i] = new JButton(cardStrings[i], new ImageIcon(iconURLs[i]));
            Dimension dim = new Dimension(150, 75);
            mainButtons[i].setPreferredSize(dim);
            mainButtons[i].setMaximumSize(dim);
            int finalI = i;
            mainButtons[i].addActionListener(e -> {
                CardLayout cl = (CardLayout) cardsPanel.getLayout();
                cl.show(cardsPanel, cardStrings[finalI]);
            });
            buttonsPanel.add(mainButtons[i]);
        }

        mainButtons[0].addActionListener(e -> updateTargetItem((Items) bowTypeSelectionPanel.getComboBox().getSelectedItem()));
        mainButtons[1].addActionListener(e -> updateTargetItem((Items) ammoTypeSelectionPanel.getComboBox().getSelectedItem()));
        mainButtons[2].addActionListener(e -> updateTargetItem((Items) shieldTypeSelectionPanel.getComboBox().getSelectedItem()));

        JPanel bowsCardPanel = new JPanel();
        bowsCardPanel.setLayout(new BoxLayout(bowsCardPanel, BoxLayout.PAGE_AXIS));
        cardsPanel.add(bowsCardPanel, cardStrings[0]);

        SelectionPanel<Items.AcquisitionMethod> bowMethodSelectionPanel = new SelectionPanel<>("Method", Items.AcquisitionMethod.getBowMethods());
        bowMethodSelectionPanel.getComboBox().addActionListener(e -> {
            Items.AcquisitionMethod acquisitionMethod = (Items.AcquisitionMethod) bowMethodSelectionPanel.getComboBox().getSelectedItem();
            DefaultComboBoxModel<Items> cbModel = new DefaultComboBoxModel<>(Items.getAll(Items.Category.BOW, acquisitionMethod));
            bowTypeSelectionPanel.getComboBox().setModel(cbModel);
        });
        bowsCardPanel.add(bowMethodSelectionPanel);

        bowTypeSelectionPanel = new SelectionPanel<>("Type", Items.getAll(Items.Category.BOW, Items.AcquisitionMethod.CUT));
        bowTypeSelectionPanel.getComboBox().addActionListener(e -> updateTargetItem((Items) bowTypeSelectionPanel.getComboBox().getSelectedItem()));
        bowsCardPanel.add(bowTypeSelectionPanel);

        JPanel ammoCardPanel = new JPanel();
        ammoCardPanel.setLayout(new BoxLayout(ammoCardPanel, BoxLayout.PAGE_AXIS));
        cardsPanel.add(ammoCardPanel, cardStrings[1]);

        ammoCategorySelectionPanel = new SelectionPanel<>("Category", Items.Category.getAmmoCategories());
        ammoCategorySelectionPanel.getComboBox().addActionListener(e -> updateAmmoMethods());
        ammoCardPanel.add(ammoCategorySelectionPanel);

        ammoMethodSelectionPanel = new SelectionPanel<>("Method", Items.AcquisitionMethod.getAmmoMethods());
        ammoMethodSelectionPanel.getComboBox().addActionListener(e -> updateAmmoType());
        ammoCardPanel.add(ammoMethodSelectionPanel);

        ammoTypeSelectionPanel = new SelectionPanel<>("Type", Items.getAll(Items.Category.ARROW, Items.AcquisitionMethod.CUT));
        ammoTypeSelectionPanel.getComboBox().addActionListener(e -> updateTargetItem((Items) ammoTypeSelectionPanel.getComboBox().getSelectedItem()));
        ammoCardPanel.add(ammoTypeSelectionPanel);

        JPanel shieldsCardPanel = new JPanel();
        shieldsCardPanel.setLayout(new BoxLayout(shieldsCardPanel, BoxLayout.PAGE_AXIS));
        cardsPanel.add(shieldsCardPanel, cardStrings[2]);

        shieldTypeSelectionPanel = new SelectionPanel<>("Type", Items.getAll(Items.Category.SHIELD));
        shieldTypeSelectionPanel.getComboBox().addActionListener(e -> updateTargetItem((Items) shieldTypeSelectionPanel.getComboBox().getSelectedItem()));
        shieldsCardPanel.add(shieldTypeSelectionPanel);

        JButton startButton = new JButton("Start");
        startButton.setBackground(Color.CYAN);
        startButton.addActionListener(e -> {
            script.start();
            close();
        });
        mainPanel.add(startButton);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainDialog.pack();
        mainDialog.setLocationRelativeTo(null);
    }

    public void invokeAndWait() {
        try {
            SwingUtilities.invokeAndWait(this::open);
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
            script.stop(false);
            return;
        }
        if (!script.isRunning()) {
            script.stop(false);
        }
    }

    public void open() {
        mainDialog.setVisible(true);
    }

    public void close() {
        mainDialog.setVisible(false);
        mainDialog.dispose();
    }

    private void updateAmmoMethods() {
        Items.Category category = (Items.Category) ammoCategorySelectionPanel.getComboBox().getSelectedItem();
        DefaultComboBoxModel<Items.AcquisitionMethod> cbModel = new DefaultComboBoxModel<>(Items.AcquisitionMethod.getMethodsFor(category));
        ammoMethodSelectionPanel.getComboBox().setModel(cbModel);
        updateAmmoType();
    }

    private void updateAmmoType() {
        Items.Category category = (Items.Category) ammoCategorySelectionPanel.getComboBox().getSelectedItem();
        Items.AcquisitionMethod acquisitionMethod = (Items.AcquisitionMethod) ammoMethodSelectionPanel.getComboBox().getSelectedItem();
        ammoTypeSelectionPanel.getComboBox().setModel(new DefaultComboBoxModel<>(Items.getAll(category, acquisitionMethod)));
        updateTargetItem((Items) ammoTypeSelectionPanel.getComboBox().getSelectedItem());
    }

    private void updateTargetItem(Items item) {
        targetItem = item;
    }

    public Items getTargetItem() {
        return targetItem;
    }
}
