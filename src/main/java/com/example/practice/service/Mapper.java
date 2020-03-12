package com.example.practice.service;

import java.util.List;

import com.example.practice.vo.Sample;

public interface Mapper {
    public List<Sample> getSamples() throws Exception;
}