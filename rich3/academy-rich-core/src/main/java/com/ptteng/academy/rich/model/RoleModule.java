package com.ptteng.academy.rich.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "role_module")
public class RoleModule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7724869622940502016L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long roleId;
	
  	 
    private  Long moduleId;
	
  
	
		 	
         	 	   @Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "role_id")
	public Long getRoleId() {
		return roleId;
	}
	
	
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
		 	@Column(name = "module_id")
	public Long getModuleId() {
		return moduleId;
	}
	
	
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

