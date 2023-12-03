package com.easyfestival.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class reviewVO 
{
	private int rvNo;
	private String title;
	private String content;
	private String regAt;
	private int readCount;
	private int cmtCount;
	private int userNo;
	private char secret;
}
