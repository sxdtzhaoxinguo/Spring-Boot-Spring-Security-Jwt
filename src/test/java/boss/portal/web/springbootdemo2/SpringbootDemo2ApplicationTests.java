package boss.portal.web.springbootdemo2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringbootDemo2ApplicationTests {

	@Test
	public void contextLoads() {
		long refreshPeriodTime = 36000L;  //seconds为单位,10 hours
		System.out.println(refreshPeriodTime >> 1);
	}

}
