package com.project.my.dao.good;

import java.util.List;

import com.project.my.dto.GoodDto;

public interface IGoodDao {
	
	//userId�� ��ȭ��ϰ�������
	//�߰�
	//����
	//�򿩺�üũ
	public List<String> selectByUserId(String userId) throws Exception;
	public void insertGood(GoodDto good) throws Exception;
	public void deleteGood(GoodDto good) throws Exception;
	public GoodDto selectGood(GoodDto good) throws Exception;
	
}
