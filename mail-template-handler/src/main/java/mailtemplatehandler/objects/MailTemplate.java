package mailtemplatehandler.objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MailTemplate {

	@Id
	int id;

	int logicalRef;

	@ManyToOne()
	@JoinColumn(name = "group_id", nullable = false)
	private MailType mailtype;

	String code;

	String value_;

	String description;

	int parentRef;

	int te_wpiid;

	int te_rights;

	int te_wfiid;

	int mail_id;

	public MailTemplate() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLogicalRef() {
		return logicalRef;
	}

	public void setLogicalRef(int logicalRef) {
		this.logicalRef = logicalRef;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue_() {
		return value_;
	}

	public void setValue_(String value_) {
		this.value_ = value_;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParentRef() {
		return parentRef;
	}

	public void setParentRef(int parentRef) {
		this.parentRef = parentRef;
	}

	public int getTe_wpiid() {
		return te_wpiid;
	}

	public void setTe_wpiid(int te_wpiid) {
		this.te_wpiid = te_wpiid;
	}

	public int getTe_rights() {
		return te_rights;
	}

	public void setTe_rights(int te_rights) {
		this.te_rights = te_rights;
	}

	public int getTe_wfiid() {
		return te_wfiid;
	}

	public void setTe_wfiid(int te_wfiid) {
		this.te_wfiid = te_wfiid;
	}

	public MailType getMailtype() {
		return mailtype;
	}

	public void setMailtype(MailType mailtype) {
		this.mailtype = mailtype;
	}

	public int getMail_id() {
		return mail_id;
	}

	public void setMail_id(int mail_id) {
		this.mail_id = mail_id;
	}
}
