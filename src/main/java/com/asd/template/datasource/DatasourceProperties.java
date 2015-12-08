/**
 * 
 */
package com.asd.template.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 
 * @author <a href="mailto:wengyingjian@foxmail.com">翁英健</a>
 * @version 1.1 2015年12月8日
 * @since 1.1
 */
@Component
@ConfigurationProperties("datasource")
@PropertySource("classpath:datasource.properties") // 配置文件为classpath下的datasource.properties
@EnableConfigurationProperties(DatasourceProperties.class) // 自动配置类的属性
public class DatasourceProperties {

    private DB master;// 主
    private DB slave; // 从

    public static class DB {
        private String basePackage;           // mapper文件路径
        private String host;                  // 地址
        private String username;              // 用户名
        private String password;              // 密码
        private String dbname;                // 数据库
        private int    port;                  // 端口

        private int    initialSize;           // 初始化连接数
        private int    maxActive;             // 最大连接数
        private int    minIdle;               // 最小空闲数
        private int    maxIdle;               // 最大空闲数
        private int    maxWait;               // 最大等待时间
        private int    removeAbandonedTimeout;// 超过时间限制，回收没有用(废弃)的连接（默认为 300秒)，

        /**
         * @return the basePackage
         */
        public String getBasePackage() {
            return basePackage;
        }

        /**
         * @param basePackage the basePackage to set
         */
        public void setBasePackage(String basePackage) {
            this.basePackage = basePackage;
        }

        /**
         * @return the host
         */
        public String getHost() {
            return host;
        }

        /**
         * @param host the host to set
         */
        public void setHost(String host) {
            this.host = host;
        }

        /**
         * @return the username
         */
        public String getUsername() {
            return username;
        }

        /**
         * @param username the username to set
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         * @return the password
         */
        public String getPassword() {
            return password;
        }

        /**
         * @param password the password to set
         */
        public void setPassword(String password) {
            this.password = password;
        }

        /**
         * @return the dbname
         */
        public String getDbname() {
            return dbname;
        }

        /**
         * @param dbname the dbname to set
         */
        public void setDbname(String dbname) {
            this.dbname = dbname;
        }

        /**
         * @return the port
         */
        public int getPort() {
            return port;
        }

        /**
         * @param port the port to set
         */
        public void setPort(int port) {
            this.port = port;
        }

        /**
         * @return the initialSize
         */
        public int getInitialSize() {
            return initialSize;
        }

        /**
         * @param initialSize the initialSize to set
         */
        public void setInitialSize(int initialSize) {
            this.initialSize = initialSize;
        }

        /**
         * @return the maxActive
         */
        public int getMaxActive() {
            return maxActive;
        }

        /**
         * @param maxActive the maxActive to set
         */
        public void setMaxActive(int maxActive) {
            this.maxActive = maxActive;
        }

        /**
         * @return the minIdle
         */
        public int getMinIdle() {
            return minIdle;
        }

        /**
         * @param minIdle the minIdle to set
         */
        public void setMinIdle(int minIdle) {
            this.minIdle = minIdle;
        }

        /**
         * @return the maxIdle
         */
        public int getMaxIdle() {
            return maxIdle;
        }

        /**
         * @param maxIdle the maxIdle to set
         */
        public void setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
        }

        /**
         * @return the maxWait
         */
        public int getMaxWait() {
            return maxWait;
        }

        /**
         * @param maxWait the maxWait to set
         */
        public void setMaxWait(int maxWait) {
            this.maxWait = maxWait;
        }

        /**
         * @return the removeAbandonedTimeout
         */
        public int getRemoveAbandonedTimeout() {
            return removeAbandonedTimeout;
        }

        /**
         * @param removeAbandonedTimeout the removeAbandonedTimeout to set
         */
        public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
            this.removeAbandonedTimeout = removeAbandonedTimeout;
        }

    }

    /**
     * @return the master
     */
    public DB getMaster() {
        return master;
    }

    /**
     * @param master the master to set
     */
    public void setMaster(DB master) {
        this.master = master;
    }

    /**
     * @return the slave
     */
    public DB getSlave() {
        return slave;
    }

    /**
     * @param slave the slave to set
     */
    public void setSlave(DB slave) {
        this.slave = slave;
    }

}
