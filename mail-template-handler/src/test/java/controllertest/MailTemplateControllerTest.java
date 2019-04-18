package controllertest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import mailtemplatehandler.controller.MailTemplateController;
import mailtemplatehandler.objects.MailTemplate;
import mailtemplatehandler.service.MailTemplateService;
import static org.mockito.ArgumentMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class MailTemplateControllerTest {

	@Spy
	@InjectMocks
	MailTemplateController mailTemplateController;

	@Mock
	MailTemplateService mailTemplateService;

	@Mock
	MailTemplate mailTemplate;

	private static final int id = 1;
	private static final int groupId = 1;
	private static final int mailId = 1;

	@Before
	public void setup() {
		// if we don't call below, we will get NullPointerException
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllMailTemplatesTest() {
		// InOrder order = inOrder(mailTemplateService);
		List<MailTemplate> mailTemplates = new ArrayList<MailTemplate>();

		doCallRealMethod().when(mailTemplate).setDescription(anyString());
		doCallRealMethod().when(mailTemplate).getDescription();

		mailTemplate.setDescription("This is description");
		mailTemplates.add(mailTemplate);

		when(mailTemplateService.getAllMailTemplates()).thenReturn(mailTemplates);

		assertEquals("This is description", mailTemplateController.getAllMailTemplates().get(0).getDescription());
		assertEquals(mailTemplateController.getAllMailTemplates().size(), mailTemplates.size());

		verify(mailTemplate, times(1)).setDescription(anyString());
		verify(mailTemplateService, times(2)).getAllMailTemplates();
	}

	@Test
	public void getAllTemplatesByGroupIdTest() {
		List<MailTemplate> mailTemplates = new ArrayList<MailTemplate>();
		mailTemplates.add(mailTemplate);
		mailTemplates.add(mailTemplate);
		when(mailTemplateService.getMailTemplateByGroupId(groupId)).thenReturn(mailTemplates);

		assertNotNull(mailTemplates);

		assertEquals(mailTemplates.size(), mailTemplateController.getAllTemplatesByGroupId(groupId).size());
		verify(mailTemplateController, times(1)).getAllTemplatesByGroupId(anyInt());

	}

	@Test
	public void getMailTemplatesByMailIdTest() {
		List<MailTemplate> mailTemplates = new ArrayList<MailTemplate>();
		mailTemplates.add(mailTemplate);
		mailTemplates.add(mailTemplate);
		when(mailTemplateService.getMailTemplatesByMailId(groupId, mailId)).thenReturn(mailTemplates);

		assertNotNull(mailTemplates);
		assertEquals(mailTemplates.get(0), mailTemplateController.getMailTemplatesByMailId(groupId, mailId).get(0));

		verify(mailTemplateController, times(1)).getMailTemplatesByMailId(anyInt(), anyInt());
	}

	@Test
	public void getMailTemplateTest() {

		doCallRealMethod().when(mailTemplate).setDescription(anyString());
		doCallRealMethod().when(mailTemplate).getDescription();
		doCallRealMethod().when(mailTemplate).setId(anyInt());
		doCallRealMethod().when(mailTemplate).getId();
		mailTemplate.setId(66);
		mailTemplate.setDescription("This is description");

		when(mailTemplateService.getMailTemplate(id)).thenReturn(mailTemplate);

		assertNotNull(mailTemplate);
		assertEquals("This is description", mailTemplate.getDescription());
		assertEquals(66, mailTemplateController.getMailTemplate(id).getId());

		verify(mailTemplateController, times(1)).getMailTemplate(id);
		verify(mailTemplate, times(1)).setId(anyInt());
	}

	@Test
	public void addMailTemplateTest() {
		doCallRealMethod().when(mailTemplate).setDescription(anyString());
		doCallRealMethod().when(mailTemplate).getDescription();
		// doCallRealMethod().when(mailTemplateService).addMailTemplate(any(MailTemplate.class));
		// doCallRealMethod().when(mailTemplateController).addMailTemplate(any(MailTemplate.class));

		mailTemplate.setDescription("Description for added template");
		assertEquals("Description for added template", mailTemplate.getDescription());

		// verify(mailTemplateController, times(0)).addMailTemplate(mailTemplate);
		// verify(mailTemplateService, times(0)).addMailTemplate(mailTemplate);
		// SEARCH FOR VOID METHOD TEST

	}

	@Test
	public void updateMailTemplateTest() {
		// doCallRealMethod().when(mailTemplate).setDescription(anyString());
		// doCallRealMethod().when(mailTemplate).getDescription();
		// doCallRealMethod().when(mailTemplateController).addMailTemplate(any(MailTemplate.class));

	}
	
	@Test
	public void updateMailTemplatesTest() {
		// doCallRealMethod().when(mailTemplate).setDescription(anyString());
		// doCallRealMethod().when(mailTemplate).getDescription();
		// doCallRealMethod().when(mailTemplateController).addMailTemplate(any(MailTemplate.class));

	}

}
