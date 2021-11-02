package com.example.domain.controller;


import com.example.domain.model.City;
import com.example.domain.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LRJ
 * @since 2021-11-01
 */
@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping("/citylist")
    public List<City> Citylist(){
        List<City> list=cityService.list();
        return list;
    }

}

