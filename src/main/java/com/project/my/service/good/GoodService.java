package com.project.my.service.good;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.my.dao.good.GoodDao;
import com.project.my.dto.GoodDto;

@Service
public class GoodService implements IGoodService {
	
	GoodDao goodDao;

	@Override
	public List<String> selectByUserId(String userId) throws Exception {
		
		return goodDao.selectByUserId(userId);
	}

	@Override
	public void registerGood(GoodDto good) throws Exception {
		
		goodDao.insertGood(good);
	}

	@Override
	public void deleteGood(GoodDto good) throws Exception {
		
		goodDao.deleteGood(good);
	}

	@Override
	public GoodDto selectGood(GoodDto good) throws Exception {
		
		return goodDao.selectGood(good);
	}

}
