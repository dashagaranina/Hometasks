package com.sample.service;

import com.sample.generated.MyClass;

import javax.jws.WebService;

@WebService
public interface SampleWebService {
	public MyClass getDataFromWebService();
}
