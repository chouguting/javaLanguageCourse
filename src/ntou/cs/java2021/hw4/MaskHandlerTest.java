package ntou.cs.java2021.hw4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

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
			List<Pharmacy> filteredClinicList4 = handler.findPharmacies("新豐", "基隆");
			System.out.println(filteredClinicList4);
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}
}
