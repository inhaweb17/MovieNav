package com.project.my.dao.film;

import com.project.my.dto.FilmDto;

public interface IFilmDao {
	
	//movieIdx로 전체 정보가져오기
	//영화 db에 있는지 체크
	//별점입력 -> 평점 업데이트
	//영화 db 입력
	
	public FilmDto selectbyIdx(int movieIdx) throws Exception;
	public FilmDto selectByTitle(String title) throws Exception;
	public void updateGrade(FilmDto film) throws Exception;
	public void insertFilm(FilmDto film) throws Exception;
	
}
