package com.project.my.dao.film;

import com.project.my.dto.FilmDto;

public interface IFilmDao {
	
	//movieIdx�� ��ü ������������
	//��ȭ db�� �ִ��� üũ
	//�����Է� -> ���� ������Ʈ
	//��ȭ db �Է�
	
	public FilmDto selectbyIdx(int movieIdx) throws Exception;
	public FilmDto selectByTitle(String title) throws Exception;
	public void updateGrade(FilmDto film) throws Exception;
	public void insertFilm(FilmDto film) throws Exception;
	
}
