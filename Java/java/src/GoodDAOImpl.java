import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDAOImpl implements GoodDAO {
	//싱글톤을 만들기 위한 코드 - 안중요
	//외부에서 인스턴스 생성을 못하도록 생성자를 private으로 설계
	private GoodDAOImpl() {}
	//참조를 저장할 변수를 static으로 생성
	private static GoodDAO goodDAO;
	//변수가 null이면 생성하고 리턴하고 null이 아니면 바로 리턴
	public static GoodDAO getInstance() {
		if(goodDAO == null) {
			goodDAO = new GoodDAOImpl();

		}
		return goodDAO;
	}
	
	private Connection connection; //데이터베이스 연결
	private PreparedStatement pstmt; //sql 실행
	private ResultSet rs;//select 구문의 결과
	
	//static 초기화 - 클래스가 로드 될 때 1번만 수행
	//static 속성만 사용 가능
	static {
		//사용하고자 하는 데이터베이스 드라이버 로드
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
	//초기화 - 생성자를 호출할 때마다 먼저 호출됨
	//이 영역은 init 이라는 메서드로 생성
	//모든 속성 사용이 가능
	{
		//2.데이터베이스 접속 - java.sql.Connection
		try {
			connection = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3307/adam",
					"root", "0902");
			System.out.println(connection);
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
	@Override
	//goods 테이블의 전체 데이터 가져오기
	public List<Good> getAll() {
		//List는 조회할 데이터가 없더라도 인스턴스를 생성
		//조회할 데이터가 없다는 사실은 size() 가 0 임
		List<Good> list = new ArrayList<Good>();
		
		try {
			//SQL 실행 클래스의 인스턴스를 생성
			pstmt = connection.prepareStatement(
					"select * from goods");
			//SQL 실행
			rs = pstmt.executeQuery();
			
			//데이터를 하나의 행씩 읽어서 DTO 객체로 변환해서 list에 대입
			while(rs.next()) {
				Good good = new Good();
				good.setCode(rs.getString("code"));
				good.setName(rs.getString("name"));
				good.setManufacture(rs.getString("manufacture"));
				good.setPrice(rs.getInt("price"));
				
				list.add(good);
				
			}
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return list;
	}
	//goods 테이블에서 code를 가지고 데이터를 조회하기
	@Override
	public Good getGood(String code) {
		//조회가 안된 경우는 null
		Good good = null;
		try {
			pstmt = connection.prepareStatement(
					"select * from goods where code=?");
			//?에 바인딩
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				good = new Good();
				
				good.setCode(rs.getString("code"));
				good.setName(rs.getString("name"));
				good.setManufacture(rs.getString("manufacture"));
				good.setPrice(rs.getInt("price"));
			}
			
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		
		return good;
	}
	@Override
	public int insertGood(Good good) {
		int result =0;
		//삽입 작업이므로 트랜잭션을 고려
		
		try {
			connection.setAutoCommit(false);
			
			pstmt = connection.prepareStatement(
					"insert into goods values(?,?,?,?)");
			pstmt.setString(1,  good.getCode());
			pstmt.setString(2,  good.getName());
			pstmt.setString(3,  good.getManufacture());
			pstmt.setInt(4,  good.getPrice());
			
			result = pstmt.executeUpdate();
			
			connection.commit();
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return result;
	}
	@Override
	public List<Good> likeGood(String content) {
		List<Good> list = new ArrayList<Good>();
		
		try {
			pstmt = connection.prepareStatement(
					"select * from goods where name like ? or manufacture like ?");
			pstmt.setString(1, "%"+content + "%");
			pstmt.setString(2, "%"+content + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Good good = new Good();
				good.setCode(rs.getString("code"));
				good.setName(rs.getString("name"));
				good.setManufacture(rs.getString("manufacture"));
				good.setPrice(rs.getInt("price"));
				
				list.add(good);
			}
			
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return list;
	};
}
