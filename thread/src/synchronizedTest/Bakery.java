package synchronizedTest;

import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		BreadMaker maker = new BreadMaker();
		Thread makerThread = new Thread(maker);
		BreadPlate breadPlate = BreadPlate.getInstance();

		String[] btns = { "빵 먹기", "나가기" };
		int choice = 0;

		makerThread.start();

		while (true) {
			choice = JOptionPane.showOptionDialog(null, "", "동석이네 빵집", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, btns, null);
			if (choice == 0) {
				breadPlate.eatBread();
			} else {
				makerThread.interrupt();
				break;
			}
		}
	}
}
