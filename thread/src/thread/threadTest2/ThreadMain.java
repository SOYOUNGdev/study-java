package thread.threadTest2;

import java.util.Scanner;

public class ThreadMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arInput = new int[3];
		Thread[] arThread = new Thread[3];
		
		Runnable threadTask = new ThreadTask();
				
		for (int i = 0; i < arThread.length; i++) {
			arThread[i] = new Thread(threadTask);
		} 
		
		System.out.print("입력 >> ");
		for (int i = 0; i < arThread.length; i++) {
			arInput[i] = sc.nextInt();
			arThread[i].setName(String.valueOf(arInput[i]));
		}
		
		for (int i = 0; i < arThread.length; i++) {
			arThread[i].start();
			try {arThread[i].join();} catch (InterruptedException e) {;}
		}
		
//		String input = sc.nextLine();
//
//		String[] temp = input.split(" ");
//
//		for (int i = 0; i < temp.length; i++) {
//			if (Integer.parseInt(temp[i]) == 1) {
////				System.out.println("1");
//				thread1.printFirst(t1);
//			} else if (Integer.parseInt(temp[i]) == 2) {
////				System.out.println("2");
//				thread2.printSecond(t2);
//			} else if (Integer.parseInt(temp[i]) == 3) {
////				System.out.println("3");
//				thread3.printThird(t3);
//			}
//			
//		}
	}
}
