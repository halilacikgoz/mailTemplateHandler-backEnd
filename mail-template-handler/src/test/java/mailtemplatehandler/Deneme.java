package mailtemplatehandler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mailtemplatehandler.objects.MailTemplate;
import mailtemplatehandler.repository.MailTemplateRepository;
import mailtemplatehandler.service.MailTemplateService;

@RunWith(SpringJUnit4ClassRunner.class)
public class Deneme {

	@Mock
	MailTemplateService mailTemplateService;

	@Mock
	MailTemplateRepository mailTemplateRepository;

	 

	private static final int ID = 1;

	@Test
	public void denemeTest() {
		MailTemplate mailTemplate = mock(MailTemplate.class);
		
		when(mailTemplate.getId()).thenReturn(5);
		System.out.println(mailTemplate.getId());
		//assertEquals(mailTemplate, mailTemplateService.getAllMailTemplates());
	}

}