package com.example.domain.serviceImpl;

import com.example.domain.model.City;
import com.example.domain.mapper.CityMapper;
import com.example.domain.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LRJ
 * @since 2021-11-01
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

}
