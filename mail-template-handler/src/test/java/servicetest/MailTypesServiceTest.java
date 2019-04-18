package servicetest;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mailtemplatehandler.objects.MailTemplate;
import mailtemplatehandler.objects.MailType;
import mailtemplatehandler.repository.MailTypesRepository;
import mailtemplatehandler.service.MailTypesService;

@RunWith(SpringJUnit4ClassRunner.class)
public class MailTypesServiceTest {

	@Spy
	@InjectMocks
	MailTypesService mailTypesService;

	@Mock
	MailTypesRepository mailTypesRepository;

	@Mock
	MailType mailType;

	private static final int ID = 1;
	private static final int groupID = 1;

	@Test
	public void getAllMailTypesTest() {

		List<MailType> mailTypesList = new ArrayList<MailType>();
		mailTypesList.add(mailType);
		mailTypesList.add(mailType);
		when(mailTypesRepository.findAll()).thenReturn(mailTypesList);
		assertEquals(mailTypesList, mailTypesService.getAllMailTypes());
		verify(mailTypesService).getAllMailTypes();

	}

	@Test
	public void getMailTypeByGroupIdTest() {

		doCallRealMethod().when(mailType).setDescription(anyString());
		doCallRealMethod().when(mailType).getDescription();

		mailType.setDescription("it is a desc");
		when(mailTypesRepository.getMailTypeByGroupId(groupID)).thenReturn(mailType);

		assertEquals(mailType, mailTypesService.getMailTypeByGroupId(groupID));
		assertEquals("it is a desc", mailTypesService.getMailTypeByGroupId(groupID).getDescription());

		verify(mailTypesService, times(2)).getMailTypeByGroupId(groupID);
	}
}
