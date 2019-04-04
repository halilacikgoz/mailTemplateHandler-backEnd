package mailtemplatehandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mailtemplatehandler.service.MailTypesService;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class RunProjectTests {

	@Autowired
	MailTypesService mailTypesService;

	@Test
	public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
		
		Mockito.when(mailTypesService.getAllMailTypes().get(1).getId()).thenReturn(1);
		int id = mailTypesService.getAllMailTypes().get(1).getId();
		Assert.assertEquals("Mock Product Name", id);
	}

}
