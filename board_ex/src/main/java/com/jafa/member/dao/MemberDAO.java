package com.jafa.member.dao;

import java.util.List;

import com.jafa.member.domain.MemberVO;

public interface MemberDAO {
	
	//list 회원 목록
	List<MemberVO> memberList();
	
	//C 회원 가입
	void join(MemberVO vo);
	
	//R 회원 상세
	MemberVO detail(Long bno);
	
	//U 회원 정보 수정
	void modify(MemberVO vo);
	
	//D 회원 탈퇴
	void remove(Long bno);
}
