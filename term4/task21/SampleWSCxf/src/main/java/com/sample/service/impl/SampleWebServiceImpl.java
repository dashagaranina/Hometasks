package com.sample.service.impl;

import javax.jws.WebService;

import com.sample.generated.MyClass;
import com.sample.service.SampleWebService;

@WebService(endpointInterface = "com.sample.service.SampleWebService")
public class SampleWebServiceImpl implements SampleWebService {
	
	 @Override
	public MyClass getDataFromWebService() {
		MyClass a = new MyClass();
		a.setAge(1);
		a.setDescription("Description from Server!");
		a.setName("Name from Server");
		return a;
	}
}