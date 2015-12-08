/**
 * 
 */
package com.asd.template.datasource.util;

import org.apache.tomcat.jdbc.pool.PoolProperties;

import com.asd.template.datasource.DatasourceProperties;

/**
 * 
 * @author <a href="mailto:wengyingjian@foxmail.com">翁英健</a>
 * @version 1.1 2015年12月8日
 * @since 1.1
 */
public class DBUtil {

    private static String url                = "jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=utf8";
    private static String driver             = "com.mysql.jdbc.Driver";
    public static int     DEFAULT_MAX_IDLE   = 10;
    public static int     DEFAULT_MIN_IDLE   = 2;
    public static int     DEFAULT_MAX_ACTIVE = 20;

    public static PoolProperties buildPoolProperties(DatasourceProperties.DB dbProperties) {
        if (dbProperties == null) {
            return null;
        }
        if (dbProperties.getMaxIdle() <= 0) {
            dbProperties.setMaxIdle(DEFAULT_MAX_IDLE);
        }
        if (dbProperties.getMaxActive() <= 0) {
            dbProperties.setMaxActive(DEFAULT_MAX_ACTIVE);
        }
        if (dbProperties.getMinIdle() <= 0) {
            dbProperties.setMinIdle(DEFAULT_MIN_IDLE);
        }
        if (dbProperties.getInitialSize() <= 0) {
            dbProperties.setInitialSize(dbProperties.getMinIdle());
        }

        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setUrl(String.format(url, dbProperties.getHost(), dbProperties.getPort(), dbProperties.getDbname()));
        poolProperties.setDriverClassName(driver);
        poolProperties.setUsername(dbProperties.getUsername());
        poolProperties.setPassword(dbProperties.getPassword());
        poolProperties.setInitialSize(dbProperties.getInitialSize());
        poolProperties.setMaxActive(dbProperties.getMaxActive());
        poolProperties.setMinIdle(dbProperties.getMinIdle());
        poolProperties.setMaxIdle(dbProperties.getMaxIdle());
        poolProperties.setMaxWait(dbProperties.getMaxWait());
        poolProperties.setRemoveAbandonedTimeout(dbProperties.getRemoveAbandonedTimeout());
        poolProperties.setDefaultAutoCommit(true);
        poolProperties.setValidationQuery("SELECT 1");
        return poolProperties;
    }
}
