package vn.totoro.framework.config.properties;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author linhnguyen
 * @description Druid configuration properties
 * @version 1.0
 */
@Configuration
public class DruidProperties {
    @Value("${spring.datasource.druid.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.druid.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.druid.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.druid.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.maxEvictableIdleTimeMillis}")
    private int maxEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.druid.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.druid.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.druid.testOnReturn}")
    private boolean testOnReturn;

    public DruidDataSource dataSource(DruidDataSource dataSource){
        /* Configure initialization size, minimum, maximum */
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        /*Configure the timeout period for obtaining a connection*/
        dataSource.setMaxWait(maxWait);
        /*How often to configure the detection interval to detect idle connections that need to be closed, in milliseconds*/
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        /*Configure the minimum and maximum survival time of a connection in the pool, in milliseconds*/
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);
        /*The SQL used to check whether the connection is valid is required to be a query statement, often select 'x'. If validationQuery is null, testOnBorrow, testOnReturn, testWhileIdle will not work.*/
        dataSource.setValidationQuery(validationQuery);
        /*The recommended configuration is true, which does not affect performance and guarantees security. Check when applying for a connection. If the idle time is greater than timeBetweenEvictionRunsMillis, execute validationQuery to check whether the connection is valid.*/
        dataSource.setTestWhileIdle(testWhileIdle);
        /*When you apply for a connection, perform a validationQuery to check whether the connection is valid. Doing this configuration will reduce performance.*/
        dataSource.setTestOnBorrow(testOnBorrow);
        /*When the connection is returned, a validationQuery is performed to check whether the connection is valid. Doing this configuration will reduce performance.*/
        dataSource.setTestOnReturn(testOnReturn);

        return dataSource;
    }

}
