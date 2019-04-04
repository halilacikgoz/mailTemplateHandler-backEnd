package mailtemplatehandler.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import mailtemplatehandler.objects.MailType;

@Repository
public interface MailTypesRepository extends CrudRepository<MailType, Integer> {

	@Query(value = "SELECT * FROM mail_type where group_id = ?1 ", nativeQuery = true)
	MailType getMailTypeByGroupId(Integer groupId);

}
