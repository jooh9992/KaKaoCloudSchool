package di.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TransactionRepository {
	@Autowired
	private SimpleJdbcInsert template;
	
	//중간에 예외가 발생하면 모든 작업이 Rollback
		//대부분의 경우 트랜잭션 적용은 Service 메서드에 합니다.
		@Transactional
		public void insert() {
			template.withTableName("goods");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 101);
			map.put("name", "대게");
			map.put("manufacture", "삼척");
			map.put("price", 120000);
			
			template.execute(map);
			template.execute(map); //기본키 중복으로 예외가 발생
		}
}
