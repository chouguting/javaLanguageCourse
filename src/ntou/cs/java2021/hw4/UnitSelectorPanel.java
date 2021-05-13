package ntou.cs.java2021.hw4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * UnitSelectorPanel一個有三個RadioButton在內的PANEL
 * 可以用來選擇溫度單位
 * 提供取得單位的方法
 *
 * @author 周固廷
 */
public class UnitSelectorPanel extends JPanel implements ItemListener {

    public static final int FAHRENHEIT = 1;
    public static final int CELSIUS = 2;
    public static final int KELVIN = 3;
    public static final int NON_SELECTED = 0;
    private final JRadioButton fahrenheitButton;
    private final JRadioButton celsiusButton;
    private final JRadioButton kelvinButton;
    private final ButtonGroup buttonGroup;
    private int selectedUnit;

    public UnitSelectorPanel() {
        selectedUnit = UnitSelectorPanel.NON_SELECTED;

        fahrenheitButton = new JRadioButton("Fahrenheit");
        celsiusButton = new JRadioButton("Celsius");
        kelvinButton = new JRadioButton("Kelvin");
        buttonGroup = new ButtonGroup();

        buttonGroup.add(fahrenheitButton);
        buttonGroup.add(celsiusButton);
        buttonGroup.add(kelvinButton);

        fahrenheitButton.addItemListener(this);
        celsiusButton.addItemListener(this);
        kelvinButton.addItemListener(this);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(fahrenheitButton);
        this.add(celsiusButton);
        this.add(kelvinButton);
        this.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (fahrenheitButton.isSelected()) {
            selectedUnit = UnitSelectorPanel.FAHRENHEIT;
        }

        if (celsiusButton.isSelected()) {
            selectedUnit = UnitSelectorPanel.CELSIUS;
        }

        if (kelvinButton.isSelected()) {
            selectedUnit = UnitSelectorPanel.KELVIN;
        }
    }

    //從外部可以取得用戶選擇的選項
    public int getSelectedUnit() {
        return selectedUnit;
    }
}
