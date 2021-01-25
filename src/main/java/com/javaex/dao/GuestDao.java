package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {

	@Autowired // 자동으로 연결해 달라고
	private SqlSession sqlSession;

	// 전체리스트 가져오기
	public List<GuestVo> getList() {
		
		List<GuestVo> guestlist = sqlSession.selectList("guestbook.selectlist");
		System.out.println("리스트가져옴");
		return guestlist;
	}

	// 방명록 등록
	public int GuestInsert(GuestVo guestVo) {
		int count = sqlSession.insert("guestbook.guestinsert", guestVo);
		return count;
	}
	//방명록 삭제
	 public int guestDelete(GuestVo guestVo) {
		 int count =sqlSession.delete("guestbook.delete", guestVo);
		 return count;
	 
	 }


}
