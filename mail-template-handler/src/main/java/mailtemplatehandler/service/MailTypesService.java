package mailtemplatehandler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mailtemplatehandler.objects.MailType;
import mailtemplatehandler.repository.MailTypesRepository;

@Service
public class MailTypesService {

	@Autowired
	MailTypesRepository mailTypesRepository;

	public List<MailType> getAllMailTypes() {

		return (List<MailType>) mailTypesRepository.findAll();

	}

	public MailType getMailType(int groupId) {
		
		return (MailType) mailTypesRepository.getMailTypeByGroupId(groupId);
	}
}
