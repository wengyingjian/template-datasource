/**
 * 
 */
package com.asd.template.datasource;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.asd.template.util.PropertyUtil;

/**
 * 
 * @author <a href="mailto:wengyingjian@foxmail.com">翁英健</a>
 * @version 1.1 2015年12月8日
 * @since 1.1
 */
@Configuration
@Component
public class AutoMapperScannerConfigurator {

    @Bean
    MapperScannerConfigurer masterMapperScannerConfigurer() throws Exception {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage(PropertyUtil.getProperty("datasource.properties", "datasource.master.basePackage"));
        configurer.setSqlSessionTemplateBeanName("masterSqlSessionTemplate");
        configurer.setNameGenerator(new MapperBeanNameGenerator("master"));
        return configurer;
    }

}
