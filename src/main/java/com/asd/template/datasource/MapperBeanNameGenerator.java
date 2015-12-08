/**
 * 
 */
package com.asd.template.datasource;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * 
 * @author <a href="mailto:wengyingjian@foxmail.com">翁英健</a>
 * @version 1.1 2015年12月8日
 * @since 1.1
 */
public class MapperBeanNameGenerator implements BeanNameGenerator {

    private String prefix;

    /**
     * @param prefix
     */
    public MapperBeanNameGenerator(String prefix) {
        this.prefix = prefix;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.springframework.beans.factory.support.BeanNameGenerator#generateBeanName(org.springframework.beans.factory.config.BeanDefinition,
     *      org.springframework.beans.factory.support.BeanDefinitionRegistry)
     */
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        return prefix + definition.getClass().getSimpleName();
    }

}
