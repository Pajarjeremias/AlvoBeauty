package projekti.demo;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import projekti.demo.web.AlvoBeautyController;
import projekti.demo.web.RESTController;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private RESTController rcontroller;

	@Autowired
	private AlvoBeautyController abcontroller;

	@Test
	public void contextLoadAb()throws Exception {
		assertThat(abcontroller).isNotNull();
	}
	@Test
	public void contextLoadRest()throws Exception {
		assertThat(rcontroller).isNotNull();
	
	}
	

}
