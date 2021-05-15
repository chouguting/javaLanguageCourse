package ntou.cs.java2021.hw4;

import javax.swing.*;
import java.awt.*;

/**
 * MaskInfoViewer 秀出單一診所資訊的Panel
 * 00857005 周固廷
 */
public class MaskInfoViewer extends JPanel {
    private static final int fontSize = 28;
    private static final String space = "    ";

    private final JPanel fieldPanel;
    private final JPanel valuePanel;
    private final JLabel nameLabel;
    private final JLabel addressLabel;
    private final JLabel adultMaskLabel;
    private final JLabel childMaskLabel;
    private final JTextField nameValue;
    private final JTextField addressValue;
    private final JTextField adultMaskNumber;
    private final JTextField childMaskNumber;

    public MaskInfoViewer() {

        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(4, 1, 15, 0));

        valuePanel = new JPanel();
        valuePanel.setLayout(new GridLayout(4, 1, 15, 0));

        nameLabel = new JLabel(space + "藥局名稱" + space);
        nameLabel.setHorizontalAlignment(JTextField.RIGHT);
        fieldPanel.add(nameLabel);

        addressLabel = new JLabel(space + "地址" + space);
        addressLabel.setHorizontalAlignment(JTextField.RIGHT);
        fieldPanel.add(addressLabel);

        adultMaskLabel = new JLabel(space + "成人口罩" + space);
        adultMaskLabel.setHorizontalAlignment(JTextField.RIGHT);
        fieldPanel.add(adultMaskLabel);

        childMaskLabel = new JLabel(space + "兒童口罩" + space);
        childMaskLabel.setHorizontalAlignment(JTextField.RIGHT);
        fieldPanel.add(childMaskLabel);

        nameValue = new JTextField("海大");
        nameValue.setEditable(false);
        nameValue.setHorizontalAlignment(JTextField.CENTER);
        valuePanel.add(nameValue);

        addressValue = new JTextField("基隆市中正區");
        addressValue.setHorizontalAlignment(JTextField.CENTER);
        addressValue.setEditable(false);
        valuePanel.add(addressValue);

        adultMaskNumber = new JTextField("2000");
        adultMaskNumber.setFont(new Font("Calibri", Font.PLAIN, fontSize));
        adultMaskNumber.setForeground(Color.BLUE);
        adultMaskNumber.setHorizontalAlignment(JTextField.CENTER);
        adultMaskNumber.setEditable(false);
        valuePanel.add(adultMaskNumber);

        childMaskNumber = new JTextField("1000");
        childMaskNumber.setFont(new Font("Calibri", Font.PLAIN, fontSize));
        childMaskNumber.setForeground(Color.BLUE);
        childMaskNumber.setHorizontalAlignment(JTextField.CENTER);
        childMaskNumber.setEditable(false);
        valuePanel.add(childMaskNumber);

        setLayout(new BorderLayout());
        add(fieldPanel, BorderLayout.WEST);
        add(valuePanel, BorderLayout.CENTER);

        setBorder(BorderFactory.createLineBorder(Color.gray));
    }

    public void setPharmacyInfo(String name, String address, int adultMaskCount, int childrenMaskCount) {
        nameValue.setText(name);
        addressValue.setText(address);
        adultMaskNumber.setText(Integer.toString(adultMaskCount));
        childMaskNumber.setText(Integer.toString(childrenMaskCount));
    }


}
