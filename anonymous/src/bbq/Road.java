package bbq;

public class Road {
	public static void main(String[] args) {
		BBQ jamsil = new BBQ("잠실점");
		BBQ gangnam = new BBQ("강남점");
		
//		강남점은 무료나눔 행사중이라서 판매방식이 필요없다.
//		본사에서는 무료나눔 지점일 경우 판매방식검사대신 "무료나눔지점"을 출력
		
		gangnam.register(new FormAdapter() {
			
			@Override
			public String[] getMenu() {
				String[] menus = {"후라이드 치킨", "양념 치킨", "황금올리브 치킨"};
				return menus;
			}
			
		});
		
		jamsil.register(new Form() {
			
			@Override
			public void sell(String order) {
				String[] menus = getMenu();
				
				for (int i = 0; i < menus.length; i++) {
					if(menus[i].equals(order)) {
						System.out.println(menus[i] + "주문 성공");
					}
				}
			}
			
			@Override
			public String[] getMenu() {
				String[] menus = {"후라이드 치킨", "양념 치킨", "황금올리브 치킨"};
				return menus;
			}
		});
	}
}
