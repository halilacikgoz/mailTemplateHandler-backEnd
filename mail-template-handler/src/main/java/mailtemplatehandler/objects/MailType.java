package mailtemplatehandler.objects;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class MailType {

	@Id
	int id;

	int logicalRef;
	
	int groupId;
	
	String description;

	int parentRef;

	int te_wpiid;

	int te_rights;

	int te_wfiid;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "group_id")
	private Set<MailTemplate> mailTemplates;

	public MailType() {
		
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

}
