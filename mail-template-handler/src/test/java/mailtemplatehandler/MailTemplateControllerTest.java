package mailtemplatehandler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mailtemplatehandler.controller.MailTemplateController;
import mailtemplatehandler.objects.MailTemplate;
import mailtemplatehandler.service.MailTemplateService;

@RunWith(SpringJUnit4ClassRunner.class)
public class MailTemplateControllerTest {

	@InjectMocks
	MailTemplateController mailTemplateController;

	@Mock
	MailTemplateService mailTemplateService;

	@MockBean
	MailTemplate mailTemplate;

	private static final int id = 1;
	private static final int groupId = 1;
	private static final int mailId = 1;
	
	@Before
	public void setup() {
		//if we don't call below, we will get NullPointerException
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllMailTemplatesTest() {
		List<MailTemplate> mailTemplates = new ArrayList<MailTemplate>();
		mailTemplates.add(mailTemplate);
		when(mailTemplateService.getAllMailTemplates()).thenReturn(mailTemplates);
		assertEquals(mailTemplateController.getAllMailTemplates().size(), mailTemplates.size());
	}

	@Test
	public void getAllTemplatesByGroupIdTest() {
		List<MailTemplate> mailTemplates = new ArrayList<MailTemplate>();
		mailTemplates.add(mailTemplate);
		mailTemplates.add(mailTemplate);
		when(mailTemplateService.getMailTemplateByGroupId(groupId)).thenReturn(mailTemplates);

		assertNotNull(mailTemplates);

		assertEquals(mailTemplates.size(), mailTemplateController.getAllTemplatesByGroupId(groupId).size());

	}

	@Test
	public void getMailTemplatesByMailIdTest() {
		List<MailTemplate> mailTemplates = new ArrayList<MailTemplate>();
		mailTemplates.add(mailTemplate);
		mailTemplates.add(mailTemplate);
		when(mailTemplateService.getMailTemplatesByMailId(groupId, mailId)).thenReturn(mailTemplates);

		assertNotNull(mailTemplates);
		System.out.println(mailTemplates.size());
		assertEquals(mailTemplates.size(), mailTemplateController.getMailTemplatesByMailId(groupId, mailId).size());
	}

	@Test
	public void getMailTemplateTest() {
		MailTemplate mailTemplate = new MailTemplate();
		mailTemplate.setId(1);
		mailTemplate.setDescription("NewDescription");
		when(mailTemplateService.getMailTemplate(id)).thenReturn(mailTemplate);

		assertNotNull(mailTemplate);

		assertEquals(1, mailTemplateController.getMailTemplate(id).getId());
	}
	
	@Test
	public void updateMailTemplatesTest() {
		//List<MailTemplate> mailTemplateComponents = new ArrayList<MailTemplate>();
		
		//doNothing().when(mailTemplateService).updateMailTemplates(mailTemplateComponents).thenReturn(mailTemplateComponents);
	}

}
