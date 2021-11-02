package com.example.domain.serviceImpl;

import com.example.domain.model.Country;
import com.example.domain.mapper.CountryMapper;
import com.example.domain.service.CountryService;
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
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements CountryService {

}
