package mailtemplatehandler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mailtemplatehandler.controller.MailTypesController;
import mailtemplatehandler.objects.MailType;
import mailtemplatehandler.service.MailTypesService;

@RunWith(SpringJUnit4ClassRunner.class)
public class MailTypesControllerTest {

	@InjectMocks
	MailTypesController mailTypesController;

	@Mock
	MailTypesService mailTypesService;

	@MockBean
	MailType mailType;
	
	private static final int groupId = 1;
	
	@Test
	public void getAllMailTypesTest() {
		List<MailType> mailTypes = new ArrayList<MailType>();
		mailTypes.add(mailType);
		when(mailTypesService.getAllMailTypes()).thenReturn(mailTypes);
		assertEquals(mailTypesController.getAllMailTypes().size(), mailTypes.size());
	}
	
	
	@Test
	public void getMailTypeByGroupIdTest() {
		when(mailTypesService.getMailTypeByGroupId(groupId)).thenReturn(mailType);
		assertEquals(mailTypesController.getMailTypeByGroupId(groupId), mailType);
	}
	

}
