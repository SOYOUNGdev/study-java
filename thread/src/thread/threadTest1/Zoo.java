package thread.threadTest1;

public class Zoo {
	public static void main(String[] args) {
		// 배열로 다시 해보기
		String[] sounds = {"어흥", "우끼끼", "야옹"};		
		Animal[] arAnimal = new Animal[sounds.length];
		Thread[] arThread = new Thread[arAnimal.length];

		for (int i = 0; i < arThread.length; i++) {
			arAnimal[i] = new Animal();
			arThread[i] = new Thread(arAnimal[i], sounds[i]);
		}
		
//		join은 이미 start()된 쓰레드를 막을 수 없다.
		for (int i = 0; i < arThread.length; i++) {
			arThread[i].start();
			if(i != 0) {
				try {arThread[i].join();} catch (InterruptedException e) {;}
			}
		}
		System.out.println("main end");
	}
}
