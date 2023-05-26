package com.jafa.member.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO {
	private Long mno;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joindate;
}
