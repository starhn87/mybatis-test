package com.example.practice;

import java.util.List;

import com.example.practice.service.Mapper;
import com.example.practice.vo.Sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class MainController {

    @Autowired
    private Mapper mapper;

    @GetMapping("/main")
    @ResponseBody
    public List<Sample> start() throws Exception {

        List<Sample> samples = mapper.getSamples();

        for (Sample sample : samples) {
            System.out.println("id: " + sample.getId());
            System.out.println("name: " + sample.getName());
            System.out.println();
        }

        return samples;
    }
}