package com.project.my.service.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.my.dao.film.FilmDao;
import com.project.my.dto.FilmDto;

@Service
public class FilmService implements IFilmService {

	@Autowired
	FilmDao filmDao;
	
	@Override
	public FilmDto selectFilm(int movieIdx) throws Exception {
		
		return filmDao.selectbyIdx(movieIdx);
	}

	@Override
	public FilmDto checkFilm(String title) throws Exception {
		
		return filmDao.selectByTitle(title);
	}

	@Override
	public void modifyGrade(FilmDto film) throws Exception {

		filmDao.updateGrade(film);
	}

	@Override
	public void registerFilm(FilmDto film) throws Exception {

		filmDao.insertFilm(film);
	}

}
