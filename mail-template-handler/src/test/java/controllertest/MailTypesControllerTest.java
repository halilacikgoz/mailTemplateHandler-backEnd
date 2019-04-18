package controllertest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import mailtemplatehandler.controller.MailTypesController;
import mailtemplatehandler.objects.MailType;
import mailtemplatehandler.service.MailTypesService;

@RunWith(MockitoJUnitRunner.class)
public class MailTypesControllerTest {

	@Spy
	@InjectMocks
	MailTypesController mailTypesController;

	@Mock
	MailTypesService mailTypesService;

	@Mock
	MailType mailType;

	private static final int groupId = 1;

	@Test
	public void getAllMailTypesTest() {
		List<MailType> mailTypes = new ArrayList<MailType>();
		mailTypes.add(mailType);
		when(mailTypesService.getAllMailTypes()).thenReturn(mailTypes);
		assertEquals(mailTypesController.getAllMailTypes().size(), mailTypes.size());
		verify(mailTypesController, times(1)).getAllMailTypes();
	}

	@Test
	public void getMailTypeByGroupIdTest() {
		mailType.setId(5);
		when(mailTypesService.getMailTypeByGroupId(groupId)).thenReturn(mailType);
		assertEquals(mailTypesController.getMailTypeByGroupId(groupId), mailType);
		assertEquals(mailTypesController.getMailTypeByGroupId(groupId).getId(), mailType.getId());
		verify(mailTypesController, atLeastOnce()).getMailTypeByGroupId(groupId);
	}

}
