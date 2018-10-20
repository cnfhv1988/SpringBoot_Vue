package cn.machao.persist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.machao.persist.mapper")
public class PersistenceIsTheKeyToSuccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistenceIsTheKeyToSuccessApplication.class, args);
	}
}
