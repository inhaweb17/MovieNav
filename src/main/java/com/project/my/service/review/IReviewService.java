package com.project.my.service.review;

import java.util.List;

import com.project.my.dto.ReviewDto;

public interface IReviewService {
	//���� ���
	//���� ���� -> ����, ���� ������Ʈ
	//���ƿ������Ʈ
	//����
	//����󼼰�������
	//��ȭ�� ����Ʈ��������
	//������ ����Ʈ��������
	//��ü ����Ʈ��������
	public void registerReview(ReviewDto review) throws Exception;
	public void modifyReview(ReviewDto review) throws Exception;
	public void modifyCount(ReviewDto review) throws Exception;
	public void deleteReview(int reviewIdx) throws Exception;
	public ReviewDto selectReview(int reviewIdx) throws Exception;
	public List<ReviewDto> selectByFilm(int movieIdx) throws Exception;
	public List<ReviewDto> selectByUserId(String userId) throws Exception;
	public List<ReviewDto> selectAll() throws Exception;
}
