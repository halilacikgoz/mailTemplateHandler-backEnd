package mailtemplatehandler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import mailtemplatehandler.objects.MailTemplate;

@Repository
public interface MailTemplateRepository extends CrudRepository<MailTemplate, Integer> {

	@Query(value = "SELECT * FROM mail_template where group_id = ?1 ", nativeQuery = true)
	List<MailTemplate> getMailTemplateByGroupId(Integer groupId);
	
	@Query(value = "SELECT * FROM mail_template where group_id = ?1 and mail_id =?2", nativeQuery = true)
	List<MailTemplate> getMailTemplatesByMailId(Integer groupId, Integer mailId);

	
	//	@Query("select u from User u where u.firstname = :#{#customer.firstname}")			
	//	List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);
}
