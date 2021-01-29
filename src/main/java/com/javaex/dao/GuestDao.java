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

	public List<GuestVo> getList(){
		System.out.println("Dao : getList");
		
		List<GuestVo> guestList = sqlSession.selectList("guestbook.selectList");
		
		System.out.println("Dao : guestList"+guestList);
		
		return guestList;
	}
	
	// 방명록 등록
	public int GuestInsert(GuestVo guestVo) {
		int count = sqlSession.insert("guestbook.guestinsert", guestVo);
		System.out.println("insert");
		return count;
	}
	//방명록 삭제
	 public int guestDelete(GuestVo guestVo) {
		 int count =sqlSession.delete("guestbook.delete", guestVo);
		 return count;
	 
	 }


}
