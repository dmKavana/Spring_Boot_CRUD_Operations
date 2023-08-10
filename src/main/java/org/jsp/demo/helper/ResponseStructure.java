package org.jsp.demo.helper;


import lombok.Data;

@Data
public class ResponseStructure<T>  
//T means generic type because it might be change
{
	String message;
	int statusCode;
	T data;
}
