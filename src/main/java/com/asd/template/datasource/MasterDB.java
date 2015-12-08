/**
 * 
 */
package com.asd.template.datasource;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.asd.template.datasource.util.DBUtil;

/**
 * 
 * @author <a href="mailto:wengyingjian@foxmail.com">翁英健</a>
 * @version 1.1 2015年12月8日
 * @since 1.1
 */
@Component
@Configuration
@EnableTransactionManagement
public class MasterDB implements TransactionManagementConfigurer {

    @Autowired
    private DatasourceProperties datasourceProperties;

    /*
     * (non-Javadoc)
     * @see org.springframework.transaction.annotation.TransactionManagementConfigurer#annotationDrivenTransactionManager()
     */
    @Override
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean
    public DataSource masterDataSource() {
        return new DataSource(DBUtil.buildPoolProperties(datasourceProperties.getMaster()));
    }

    @Bean
    public SqlSessionFactoryBean masterSqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(masterDataSource());
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate masterSqlSessionTemplate() {
        try {
            return new SqlSessionTemplate(masterSqlSessionFactoryBean().getObject());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
