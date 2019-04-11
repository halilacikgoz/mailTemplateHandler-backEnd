package mailtemplatehandler;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mailtemplatehandler.repository.MailTypesRepository;
import mailtemplatehandler.service.MailTypesService;

@RunWith(SpringJUnit4ClassRunner.class)
public class MailTypesServiceTest {

	@InjectMocks
	MailTypesService mailTypesService;

	@Mock
	MailTypesRepository mailTypesRepository;

	private static final int ID = 1;

	@Test
	public void getAllMailTypesTest() {
		mailTypesService.getAllMailTypes();
		verify(mailTypesRepository).findAll();

	}

	@Test
	public void getMailTypeByGroupIdTest() {

		mailTypesService.getMailTypeByGroupId(ID);
		verify(mailTypesRepository).getMailTypeByGroupId(ID);
	}
}
