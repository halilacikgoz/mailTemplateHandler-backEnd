package mailtemplatehandler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import mailtemplatehandler.service.MailTemplateService;
import mailtemplatehandler.objects.MailTemplate;

@RestController
public class MailTemplateController {

	@Autowired
	MailTemplateService mailTemplateService;

	@GetMapping("/mailtemplates")
	public List<MailTemplate> getAllMailTemplates() {
		return mailTemplateService.getAllMailTemplates();

	}

	@GetMapping("/mailtypes/{group_id}/mailtemplates")
	public List<MailTemplate> getAllTemplatesByGroupId(@PathVariable(value = "group_id") int groupId) {
		return mailTemplateService.getMailTemplateByGroupId(groupId);

	}
	
	@GetMapping("/mailtypes/{group_id}/mailtemplates/{mail_id}/mailtemplates")
	public List<MailTemplate> getMailTemplatesByMailId(@PathVariable(value = "group_id") int groupId,@PathVariable(value = "mail_id") int mailId) {
		return mailTemplateService.getMailTemplatesByMailId(groupId,mailId);

	}

	@GetMapping(value = "/mailtemplates/{id}")
	public MailTemplate getMailTemplate(@PathVariable(value = "id") int id) {
		return mailTemplateService.getMailTemplate(id);

	}

	@PostMapping(value = "/mailtemplates")
	public void addaddMailTemplate(@RequestBody MailTemplate mailTemplate) {
		mailTemplateService.addMailTemplate(mailTemplate);

	}

	@PutMapping(value = "/mailtemplates/{id}")
	public void updateMailTemplate(@RequestBody MailTemplate mailTemplate) {
		mailTemplateService.updateMailTemplate(mailTemplate);
	}

}
