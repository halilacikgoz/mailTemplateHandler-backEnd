package mailtemplatehandler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mailtemplatehandler.objects.MailTemplate;
import mailtemplatehandler.repository.MailTemplateRepository;

@Service
public class MailTemplateService {

	@Autowired
	MailTemplateRepository mailTemplateRepository;

	public List<MailTemplate> getAllMailTemplates() {

		return (List<MailTemplate>) mailTemplateRepository.findAll();
	}

	public List<MailTemplate> getMailTemplateByGroupId(int groupId) {

		return mailTemplateRepository.getMailTemplateByGroupId(groupId);
	}

	public void updateMailTemplate(MailTemplate mailTemplate) {
		mailTemplateRepository.save(mailTemplate);

	}

	public MailTemplate getMailTemplate(int id) {

		return mailTemplateRepository.findById(id).get();
	}

	public void addMailTemplate(MailTemplate mailTemplate) {
		//System.out.println(mailTemplate.toString());
		mailTemplateRepository.save(mailTemplate);

	}

	public List<MailTemplate> getMailTemplatesByMailId(int groupId, int mailId) {

		return mailTemplateRepository.getMailTemplatesByMailId(groupId, mailId);
	}

	public void updateMailTemplates(List<MailTemplate> mailTemplateComponents) {

		for (MailTemplate mailTemplate : mailTemplateComponents) {
			mailTemplateRepository.save(mailTemplate);

		}

	}
}
