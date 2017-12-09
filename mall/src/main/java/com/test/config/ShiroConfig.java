package com.test.config;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration//相当于创建一个spring配置文件
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean createFilter(DefaultWebSecurityManager sm) {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setSecurityManager(sm);
        filter.setLoginUrl("/index.html");
        filter.setUnauthorizedUrl("/noqx.html");
        Map<String, String> pattern = new HashMap<>();
        pattern.put("/findAllCategory", "authc,perms[类别管理]");
        pattern.put("/**", "anon");
        filter.setFilterChainDefinitionMap(pattern);
        return filter;
    }


    @Bean
    public DefaultWebSecurityManager createSM(JdbcRealm realm) {
        DefaultWebSecurityManager sm = new DefaultWebSecurityManager();
        sm.setRealm(realm);
        sm.setCacheManager(new MemoryConstrainedCacheManager());
        return sm;
    }

    @Bean
    public JdbcRealm createRealm(DruidDataSource ds) {
        JdbcRealm realm = new JdbcRealm();
        //realm.setDataSource();
        realm.setPermissionsLookupEnabled(true);
        //登录验证
        realm.setAuthenticationQuery("selsect pwd from user where account=?");
        //判断角色
        realm.setUserRolesQuery("select r.name from role r left join user_role ur on ur.rid=r.id left join user u on ur.uid = u.id where u.account=?");

        //判断权限
        realm.setPermissionsQuery("select rs.text from ress rs left join role_res rr on rs.id=rr.resid left join role r on rr.rid=r.id where r.name=?");
        return realm;
    }

//调用createDs()方法，并将ds交由spring处理

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource createDS() {
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }

}
