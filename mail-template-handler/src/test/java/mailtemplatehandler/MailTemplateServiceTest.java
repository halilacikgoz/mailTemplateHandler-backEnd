package mailtemplatehandler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mailtemplatehandler.objects.MailTemplate;
import mailtemplatehandler.repository.MailTemplateRepository;
import mailtemplatehandler.service.MailTemplateService;

@RunWith(SpringJUnit4ClassRunner.class)
public class MailTemplateServiceTest {

	@InjectMocks
	MailTemplateService mailTemplateService;

	@Mock
	MailTemplateRepository mailTemplateRepository;

	@MockBean
	MailTemplate mailTemplate;

	private static final int ID = 1;

	@Test
	public void getAllMailTemplatesTest() {
		List<MailTemplate> mailTemplates = new ArrayList<MailTemplate>();
		mailTemplates.add(mailTemplate);
		when(mailTemplateRepository.findAll()).thenReturn(mailTemplates);
		assertEquals(mailTemplates, mailTemplateService.getAllMailTemplates());
	}

	@Test
	public void getMailTemplateByGroupIdTest() {
		mailTemplateService.getMailTemplateByGroupId(ID);
		verify(mailTemplateRepository).getMailTemplateByGroupId(ID);
	}

	@Test
	public void updateMailTemplateTest() {

		MailTemplate mailTemplate = mock(MailTemplate.class);
		mailTemplateService.updateMailTemplate(mailTemplate);
		verify(mailTemplateRepository).save(mailTemplate);

	}

//	@Test
//	public void getMailTemplateTest() {
//		mailTemplateService.getMailTemplate(ID);
//		verify(mailTemplateRepository).findById(ID);
//	}

}
