package com.example.practice.service;

import java.util.List;

import com.example.practice.vo.Sample;

import org.apache.ibatis.annotations.Param;

public interface Mapper {
    public List<Sample> getSamples(@Param("limit") int limit) throws Exception;
}