package mb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.PersonCrudApplication;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = PersonCrudApplication.class)
public class PersonCrudApplicationTests {
	
	@Autowired
	private MockMvc mock;
	
	
	
	@Test
	public void addToDataBase() throws Exception{

	}
	
	@Test
	public void homePage() throws Exception {
			mock.perform(get("/")).
			andExpect(view().name("home"));
	}
	
//	@Test
//	public void delete() throws Exception {
//		mock.perform(post("/")
//				.requestAttr("id", "1")).andExpect(view().name("home"));
//		
//	}
	
	

}
