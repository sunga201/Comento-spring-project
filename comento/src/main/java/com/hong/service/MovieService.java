package com.hong.service;

import java.util.List;

import com.hong.vo.MovieVO;

public interface MovieService {
	public List<MovieVO> selectMovie() throws Exception;
}
