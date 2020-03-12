package com.example.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import com.example.practice.service.Mapper;
import com.example.practice.vo.Sample;

import org.mybatis.spring.SqlSessionTemplate;
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

    @Autowired
    private SqlSessionTemplate sqlSession;

    @GetMapping("/main")
    @ResponseBody
    public List<Sample> start() throws Exception {

        // List<Sample> samples = mapper.getSamples(1);

        List<Sample> samples = sqlSession.selectList("com.example.practice.service.Mapper.getSamples", makeParameter());
        
        for (Sample sample : samples) {
            System.out.println("id: " + sample.getId());
            System.out.println("name: " + sample.getName());
            System.out.println();
        }
        
        return samples;
    }
    
    private Map<String, Integer> makeParameter() {
        Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("limit", 2);
        return parameters;
    }

}