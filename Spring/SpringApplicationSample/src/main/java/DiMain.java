import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.controller.MemberController;
import di.domain.Good;
import di.persistence.GoodMapper;
import di.persistence.GoodRepository;
import di.persistence.HibernateRepository;
import di.persistence.TransactionRepository;

public class DiMain {

	public static void main(String[] args) {
		try(GenericXmlApplicationContext context = 
			new GenericXmlApplicationContext(
				"applicationContext.xml")) {
			//Controller 가져오기
			/*MemberController controller = 
				context.getBean("memberController", 
					MemberController.class);
			controller.findById("1");*/
			
			/*SqlSessionFactory sqlFactory =
					context.getBean("sqlSessionFactory", SqlSessionFactory.class);
			System.out.println(sqlFactory);
			SqlSession session = sqlFactory.openSession();
			System.out.println(session);*/
			
			/*&GoodRepository repository = context.getBean(GoodRepository.class);
			Good good = Good.builder()
					.code(2)
					.name("우럭")
					.manufacture("만재도")
					.price(25000)
					.build();
			repository.insertGood(good);*/
			
			/*GoodRepository repository = context.getBean(GoodRepository.class);
			List<Good> list = repository.allGood();
			for(Good good: list) {
				System.out.println(good);
			}*/
			
			/*GoodRepository repository = context.getBean(GoodRepository.class);
			Good good = repository.getGood(1); //없는 번호 입력하면 null 출력
			System.out.println(good);*/
			
			/*GoodMapper repository = context.getBean(GoodMapper.class);
			List<Good> goods = repository.allGood(); //없는 번호 입력하면 null 출력
			System.out.println(goods);*/
			
			/*TransactionRepository repository = context.getBean(TransactionRepository.class);
			repository.insert();*/
			
			
			/*HibernateRepository repository = context.getBean(HibernateRepository.class);
			Good good = Good.builder()
					.code(302)
					.name("감귤")
					.manufacture("제주")
					.price(2500)
					.build();
			repository.insertGood(good);*/
			System.out.println("1:");
			System.out.println("1:"+ context.getBean(SessionFactory.class));
			HibernateRepository repository = context.getBean(HibernateRepository.class);
			
			System.out.println(repository.getGood(1));
			
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}