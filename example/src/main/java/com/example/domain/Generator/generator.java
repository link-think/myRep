package com.example.domain.Generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.util.*;

public class generator {

    private static String url = "jdbc:mysql://127.0.0.1:3306/world?serverTimezone=GMT%2B8&characterEncoding=utf-8";
    private static String user = "root";
    private static String password = "1234";
    private static String dirverName = "com.mysql.cj.jdbc.Driver";
    private static String author = "LRJ";
    private static String outputDir = "src\\main\\java";
    private static String controllerDir="controller";
    private static String modelDir="model";
    private static String packageName = "com.example.domain";//生成的东西放在这个包里
    private static String templateXMLPath="/templates/mapper.xml.vm";
    private static String xmlPath="src/main/resources/mappers/";
    private static String serviceImplPackageName="serviceImpl";
    private static String mapperPackageName="mapper";

    public static void main(String[] args) {
        GlobalConfig config = new GlobalConfig();  //全局配置
        String dbUrl = url;
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername(user)
                .setPassword(password)
                .setDriverName(dirverName);
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(false) //全局大写命名 ??
                .setRestControllerStyle(true)
                .setEntityLombokModel(true) //设置为lombok模型
                //.setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel); //表名生成策略，下划线转驼峰

        config.setActiveRecord(false) //是否开启ActiveRecord模式
                .setEnableCache(false) //是否支持缓存
                .setAuthor(author)
                .setOutputDir(outputDir)
                .setFileOverride(true)  //是否覆盖，第二次运行覆盖第一次
                .setServiceName("%sService")//生成的service接口是否首字母为I
                .setEnableCache(false)
                .setBaseColumnList(true)
                .setBaseResultMap(true);
        InjectionConfig injectionConfig = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig(templateXMLPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return xmlPath + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setCfg(injectionConfig)
                .setTemplate(tc)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController(controllerDir)
                                .setEntity(modelDir)
                                .setMapper(mapperPackageName)
                                .setServiceImpl(serviceImplPackageName)
                ).execute();
    }
}
