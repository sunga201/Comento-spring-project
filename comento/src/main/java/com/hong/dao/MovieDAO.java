package com.hong.dao;

import java.util.List;
import com.hong.vo.MovieVO;

public interface MovieDAO {
	public List<MovieVO> selectMovie() throws Exception;
}
