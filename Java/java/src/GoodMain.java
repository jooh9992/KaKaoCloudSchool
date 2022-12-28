
public class GoodMain {
	public static void main(String[] args) {
		//싱글톤 확인
		GoodDAO dao= GoodDAOImpl.getInstance();
		//전체 데이터 가져오기
		//System.out.println(dao.getAll());
		
		//기본키를 가지고 조회하면 존재하는 경우는 데이터가 리턴하고
		//없는 경우에는 null을 리턴함
		//System.out.println(dao.getGood("1"));
		//System.out.println(dao.getGood("20"));
		
		Good good = new Good();
		good.setCode("11");
		good.setName("과자");
		good.setManufacture("서울");
		good.setPrice(50);
		
		int r = dao.insertGood(good);
		if(r ==1) {
			System.out.println("삽입 성공");
		}else {
			System.out.println("삽입 실패");
		}
		
		System.out.println(dao.likeGood("국"));
		System.out.println(dao.likeGood("단"));
		
	}
}
