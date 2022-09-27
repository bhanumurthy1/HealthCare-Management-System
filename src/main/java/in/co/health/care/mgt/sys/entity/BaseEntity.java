package in.co.health.care.mgt.sys.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	protected long id;

	@Column(name = "CREATED_BY")
	protected String createdBy;

	@Column(name = "MODIFIED_BY")
	protected String modifiedBy;

	@Column(name = "CREATED_DATETIME")
	protected Timestamp createdDatetime;

	@Column(name = "MODIFIED_DATETIME")
	protected Timestamp modifiedDatetime;

}
