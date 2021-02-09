package com.thzhima.springlearning.ioc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.support.MethodReplacer;

public class MatkTV implements MethodReplacer{

	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		
//		System.out.println(obj);
//		System.out.println(method);
//		System.out.println(Arrays.toString(args));
		
		Home3 h = (Home3) obj;
		
		TV tv = new TV((String)args[0]);
		
		h.setTv(tv);

		
		
		return null;
	}

}
