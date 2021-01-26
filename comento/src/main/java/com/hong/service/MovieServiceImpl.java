package com.hong.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hong.dao.MovieDAO;
import com.hong.vo.MovieVO;

@Service
public class MovieServiceImpl implements MovieService{

	@Inject
	private MovieDAO dao;
	
	@Override
	public List<MovieVO> selectMovie() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectMovie();
	}
	
}
