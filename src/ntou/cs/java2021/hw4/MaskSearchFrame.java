package ntou.cs.java2021.hw4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * MaskSearchFrame:讓適用者能搜尋庫存的主畫面
 *
 * @author 00857005周固廷
 */
public class MaskSearchFrame extends JFrame implements ActionListener {

    private final JTextField searchAddress;
    private final JTextField searchName;

    private final JButton searchButton;
    private final JButton refreshButton;
    private final MaskHandler maskHandler;

    private final JPanel infoArea;

    JButton testButton;

    public MaskSearchFrame() {
        maskHandler = new MaskHandler();
        try {
            maskHandler.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        this.setLayout(new BorderLayout());
        JPanel header = new JPanel(new FlowLayout());
        searchAddress = new JTextField("輸入地區(如基隆市)", 15);
        searchName = new JTextField("輸入藥局名稱(如百福)", 20);
        searchButton = new JButton("搜尋藥局");
        refreshButton = new JButton("更新資料");


        testButton = new JButton("Test");
        //header.add(testButton);
        testButton.addActionListener(this);


        searchButton.addActionListener(this);
        refreshButton.addActionListener(this);

        header.add(searchAddress);
        header.add(searchName);
        header.add(searchButton);
        header.add(refreshButton);

        this.add(header, BorderLayout.NORTH);

        infoArea = new JPanel(new GridLayout(2, 2));
        this.add(infoArea, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("口罩追蹤系統");
        this.setSize(1280, 720);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            List<Pharmacy> filteredClinicList = maskHandler.findPharmacies(searchName.getText(), searchAddress.getText());
            if (filteredClinicList.isEmpty() || infoArea.getComponentCount() > 3) {
                JOptionPane.showMessageDialog(this, "無搜尋結果或超過可顯示數量");
                return;
            }
            MaskInfoViewer maskInfoViewer = new MaskInfoViewer();
            maskInfoViewer.setPharmacyInfo(filteredClinicList.get(0).getName(),
                    filteredClinicList.get(0).getAddress(),
                    filteredClinicList.get(0).getNumberOfAdultMasks(),
                    filteredClinicList.get(0).getNumberOfChildrenMasks()
            );
            infoArea.add(maskInfoViewer);
            this.revalidate();
        }
        if (e.getSource() == refreshButton) {
            try {
                maskHandler.initialize();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        }
        if (e.getSource() == testButton) {
            JOptionPane.showMessageDialog(this, maskHandler.getMaskData());
        }
    }
}
