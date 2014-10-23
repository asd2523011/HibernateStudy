package Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_core_hh")
public class HibernetBean {
	@Id
	@GenericGenerator(name="sssssss",strategy="assigned")
	@GeneratedValue(generator="sssssss")
	public String id;
	

}
