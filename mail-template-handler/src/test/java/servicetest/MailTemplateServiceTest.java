package servicetest;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mailtemplatehandler.objects.MailTemplate;
import mailtemplatehandler.repository.MailTemplateRepository;
import mailtemplatehandler.service.MailTemplateService;

@RunWith(SpringJUnit4ClassRunner.class)
public class MailTemplateServiceTest {

	@Spy
	@InjectMocks
	MailTemplateService mailTemplateService;

	@Mock
	MailTemplateRepository mailTemplateRepository;

	@Mock
	MailTemplate mailTemplate;

	int ID = 1;
	private static final int groupID = 1;
	private static final int mailID = 1;

	@Test
	public void getAllMailTemplatesTest() {
		List<MailTemplate> mailTemplates = new ArrayList<MailTemplate>();
		mailTemplates.add(mailTemplate);
		when(mailTemplateRepository.findAll()).thenReturn(mailTemplates);
		assertEquals(mailTemplates, mailTemplateService.getAllMailTemplates());

		verify(mailTemplateService).getAllMailTemplates();
	}

	@Test
	public void getMailTemplateByGroupIdTest() {

		List<MailTemplate> mailTemplates = new ArrayList<MailTemplate>();
		mailTemplates.add(mailTemplate);
		doCallRealMethod().when(mailTemplate).setDescription(anyString());
		doCallRealMethod().when(mailTemplate).getDescription();

		mailTemplate.setDescription("it is a desc");
		when(mailTemplateRepository.getMailTemplateByGroupId(groupID)).thenReturn(mailTemplates);

		assertEquals(mailTemplates, mailTemplateService.getMailTemplateByGroupId(groupID));
		assertEquals("it is a desc", mailTemplateService.getMailTemplateByGroupId(groupID).get(0).getDescription());

		verify(mailTemplateService, times(2)).getMailTemplateByGroupId(groupID);

	}

//	@Test
//	public void updateMailTemplateTest() {
//
//		MailTemplate mailTemplate = mock(MailTemplate.class);
//		mailTemplateService.updateMailTemplate(mailTemplate);
//		verify(mailTemplateRepository).save(mailTemplate);
//
//	}

	@Test
	public void getMailTemplate() {
		doCallRealMethod().when(mailTemplate).setDescription(anyString());
		doCallRealMethod().when(mailTemplate).getDescription();

		mailTemplate.setDescription("it is a desc");
		
		//verify(mailTemplateService).getMailTemplate(ID);
		verify(mailTemplate, times(1)).setDescription(anyString());
	}

//	@Test
//	public void getMailTemplateTest() {
//		mailTemplateService.getMailTemplate(ID);
//		verify(mailTemplateRepository).findById(ID);
//	}

	@Test
	public void getMailTemplatesByMailId() {

		List<MailTemplate> mailTemplates = new ArrayList<MailTemplate>();
		mailTemplates.add(mailTemplate);
		doCallRealMethod().when(mailTemplate).setDescription(anyString());
		doCallRealMethod().when(mailTemplate).getDescription();

		mailTemplate.setDescription("description mail id");
		when(mailTemplateRepository.getMailTemplatesByMailId(groupID, mailID)).thenReturn(mailTemplates);

		assertEquals(mailTemplates, mailTemplateService.getMailTemplatesByMailId(groupID, mailID));
		assertEquals("description mail id",
				mailTemplateService.getMailTemplatesByMailId(groupID, mailID).get(0).getDescription());

		verify(mailTemplateService, times(2)).getMailTemplatesByMailId(groupID, mailID);

	}

//	@Test  //4lü
//	public void updateMailTemplatesTest() {
//
//		MailTemplate mailTemplate = mock(MailTemplate.class);
//		mailTemplateService.updateMailTemplate(mailTemplate);
//		verify(mailTemplateRepository).save(mailTemplate);
//
//	}

}
