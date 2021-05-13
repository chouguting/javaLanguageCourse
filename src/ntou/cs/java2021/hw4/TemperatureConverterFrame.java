package ntou.cs.java2021.hw4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TemperatureConverterFrame 程式的主畫面
 * 處理各類型的事件
 *
 * @author 周固廷
 */
public class TemperatureConverterFrame extends JFrame implements ActionListener {

    UnitSelectorPanel fromUnitPanel;
    UnitSelectorPanel toUnitPanel;

    JTextField getTemperatureField;
    JPanel getTemperaturePanel;
    JButton getTemperatureButton;

    JTextField resultTemperatureField;

    public TemperatureConverterFrame() {
        fromUnitPanel = new UnitSelectorPanel();
        toUnitPanel = new UnitSelectorPanel();

        getTemperaturePanel = new JPanel();
        getTemperaturePanel.setLayout(new BorderLayout());
        getTemperatureButton = new JButton("Convert");
        getTemperatureField = new JTextField();
        getTemperaturePanel.add(getTemperatureField, BorderLayout.CENTER);
        getTemperaturePanel.add(getTemperatureButton, BorderLayout.EAST);
        getTemperatureButton.addActionListener(this); //用戶按下CONVERT按鈕
        getTemperatureField.addActionListener(this); //用戶按ENTER
        resultTemperatureField = new JTextField();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Temperature Conversion");
        setLayout(new GridLayout(8, 1));
        this.add(new JLabel("Convert from:"));
        this.add(fromUnitPanel);
        this.add(new JLabel("Convert to:"));
        this.add(toUnitPanel);
        this.add(new JLabel("Source Temperature:"));
        this.add(getTemperaturePanel);
        this.add(new JLabel("Source Temperature:"));
        resultTemperatureField.setEditable(false);  //結果畫面不要被修改
        this.add(resultTemperatureField);

        this.setSize(500, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //顯全部轉成攝氏溫度 再決定要轉出什麼
        if (e.getSource() == getTemperatureButton || e.getSource() == getTemperatureField) {
            if (fromUnitPanel.getSelectedUnit() == UnitSelectorPanel.NON_SELECTED) {
                resultTemperatureField.setText("請選擇要轉換的單位!!");
                return;
            }
            if (getTemperatureField.getText().isBlank()) {
                resultTemperatureField.setText("輸入不可為空!!");
                return;
            }
            double temperatureInCelsius = Double.parseDouble(getTemperatureField.getText());
            if (fromUnitPanel.getSelectedUnit() == UnitSelectorPanel.FAHRENHEIT) {
                temperatureInCelsius = (temperatureInCelsius - 32) * (5.0 / 9);
            }
            if (fromUnitPanel.getSelectedUnit() == UnitSelectorPanel.KELVIN) {
                temperatureInCelsius = temperatureInCelsius - 273.15;
            }

            if (toUnitPanel.getSelectedUnit() == UnitSelectorPanel.CELSIUS) {
                resultTemperatureField.setText(String.format("%.2f", temperatureInCelsius));
            } else if (toUnitPanel.getSelectedUnit() == UnitSelectorPanel.FAHRENHEIT) {
                resultTemperatureField.setText(String.format("%.2f", temperatureInCelsius / (5.0 / 9) + 32));
            } else if (toUnitPanel.getSelectedUnit() == UnitSelectorPanel.KELVIN) {
                resultTemperatureField.setText(String.format("%.2f", temperatureInCelsius + 273.15));
            } else {
                resultTemperatureField.setText("請選擇要轉出的單位!!");
            }
        }
    }
}
