package com.project.my.service.good;

import java.util.List;

import com.project.my.dto.GoodDto;

public interface IGoodService {
	
	//userId로 영화목록가져오기
	//추가
	//삭제
	//찜여부체크
	public List<String> selectByUserId(String userId) throws Exception;
	public void registerGood(GoodDto good) throws Exception;
	public void deleteGood(GoodDto good) throws Exception;
	public GoodDto selectGood(GoodDto good) throws Exception;
}
