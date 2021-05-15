package ntou.cs.java2021.hw4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * MaskHandlerTest:作業提供的測試用類別
 * 用來測試口罩搜尋
 * 00857005 周固廷
 */

public class MaskHandlerTest {
    public static void main(String[] args) {
        try {
            MaskHandler handler = new MaskHandler();
            handler.initialize();
            List<Pharmacy> filteredClinicList = handler.findPharmacies("衛生所", "基隆市中正區");
            System.out.println(filteredClinicList);
            List<Pharmacy> filteredClinicList2 = handler.findPharmacies("百福新豐活力", "基隆市中正區");
            System.out.println(filteredClinicList2);
            List<Pharmacy> filteredClinicList3 = handler.findPharmacies("和平", "基隆市中正區");
            System.out.println(filteredClinicList3);
            List<Pharmacy> filteredClinicList4 = handler.findPharmacies("百福", "基隆");
            System.out.println(filteredClinicList4);
        } catch (IOException | URISyntaxException e) {
            System.err.println(e);
        }
    }
}
