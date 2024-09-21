package com.klef.ep.services;

import javax.ejb.Remote;

import com.klef.ep.models.StudentMapping;

@Remote
public interface CourseMappingService 
{
	public void addmapping(StudentMapping studentMapping);

}
