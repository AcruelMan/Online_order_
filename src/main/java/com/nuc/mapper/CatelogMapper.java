package com.nuc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.nuc.bean.Catelog;

public interface CatelogMapper {
	@Select("select * from catalog")
	List<Catelog> selcetAll();
}
