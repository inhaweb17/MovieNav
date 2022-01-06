package com.project.my.util;

import java.util.List;

import com.project.my.dto.FilmDto;

public class filmDB {
	
	CallAPI callapi = new CallAPI();
	List<FilmDto> film = callapi.callFilmByGenre(null);
	
}
