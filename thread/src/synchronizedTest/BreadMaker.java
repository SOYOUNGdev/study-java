package synchronizedTest;

public class BreadMaker implements Runnable {
	
	@Override
	public void run() {
		int i = 0;
		for (i = 0; i < 20; i++) {
			BreadPlate.getInstance().makeBread();
			try {Thread.sleep(1000);} catch (InterruptedException e) {break;}
		}
		if(i != 20) {
			System.out.println("안녕히 가세요.");
			return;
		}
		System.out.println("재료 소진 ㅠㅠ");
	}
}
