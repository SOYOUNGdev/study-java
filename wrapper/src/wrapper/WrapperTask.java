package wrapper;

public class WrapperTask {
//	[숙제]
//	1, 3.5, 12.5F, 'A', "ABC", true
//	위 6개의 값을 6칸 배열에 담기, String[]은 사용하지 않는다!
	public static void main(String[] args) {
//		int intNum = 1;
//		double doubleNum = 3.5;
//		float floatNum = 12.5F;
//		char c = 'A';
//		String str = "ABC";
//		boolean chk = true;
//		
//		
//		Object[] arr = new Object[6];
//		arr[0] = intNum;
//		arr[1] = doubleNum;
//		arr[2] = floatNum;
//		arr[3] = c;
//		arr[4] = str;
//		arr[5] = chk;
//		
//		System.out.println("auto boxing 사용, Object클래스로 upcasting");
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + "\t");
//		}
//		System.out.println("\n-------------------------------------------------------");
//		
//		Integer intNumber = intNum;
//		Double doubleNumber = doubleNum;
//		Float floatNumber = floatNum;
//		Character c2 = c;
//		String str2 = str;
//		Boolean chk2 = chk;
//		
//		Object[] arr2 = new Object[6];
//		arr2[0] = intNumber;
//		arr2[1] = doubleNumber;
//		arr2[2] = floatNumber;
//		arr2[3] = c2;
//		arr2[4] = str2;
//		arr2[5] = chk2;
//		
//		System.out.println("wrapper class로 boxing해줌, Object클래스로 upcasting");
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr2[i] + "\t");
//		}
		
		System.out.println("\n-------------------------------------------------------");
		Object[] datas = {1, 3.5, 12.5F, 'A', "ABC", true};
		
		for (int i = 0; i < datas.length; i++) {
			System.out.println(datas[i]);
		}
		
	}
	
}
