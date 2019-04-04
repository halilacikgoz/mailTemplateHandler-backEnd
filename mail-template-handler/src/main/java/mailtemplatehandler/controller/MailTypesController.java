package mailtemplatehandler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mailtemplatehandler.objects.MailType;
import mailtemplatehandler.service.MailTypesService;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MailTypesController {

	@Autowired
	MailTypesService mailTypesService;

	@RequestMapping("/mailtypes")
	public List<MailType> getAllMailTypes() {
		
		
		return mailTypesService.getAllMailTypes();
	}
	
	@RequestMapping(value="mailtypes/{group_id}", method=RequestMethod.GET)
	public MailType requestMethodName(@PathVariable(value = "group_id") int groupId) {
		return mailTypesService.getMailType(groupId);
	}
	
}
