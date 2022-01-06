package com.project.my.service.film;

import com.project.my.dto.FilmDto;

public interface IFilmService {

	public FilmDto selectFilm(int movieIdx) throws Exception;
	public FilmDto checkFilm(String title) throws Exception;
	public void modifyGrade(FilmDto film) throws Exception;
	public void registerFilm(FilmDto film) throws Exception;
}
