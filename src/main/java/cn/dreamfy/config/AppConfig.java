package cn.dreamfy.config;

import cn.dreampie.orm.ActiveRecordPlugin;
import cn.dreampie.orm.provider.druid.DruidDataSourceProvider;
import cn.dreampie.quartz.QuartzPlugin;
import cn.dreampie.route.config.*;
import cn.dreampie.route.handler.cors.CORSHandler;
import cn.dreampie.route.interceptor.security.SecurityInterceptor;
import cn.dreampie.route.interceptor.transaction.TransactionInterceptor;

/**
 * AppConfig
 * Created by FuYung on 2015/8/28.
 */
public class AppConfig extends Config {

    @Override
    public void configConstant(ConstantLoader constantLoader) {
        constantLoader.setDefaultForward("/");
    }

    @Override
    public void configResource(ResourceLoader resourceLoader) {
        resourceLoader.addIncludePackages("cn.dreamfy.resource");
    }

    @Override
    public void configPlugin(PluginLoader pluginLoader) {
        DruidDataSourceProvider provider = new DruidDataSourceProvider("default");
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(provider);
        activeRecordPlugin.addIncludePackages("cn.dreamfy.resource");

        pluginLoader.add(activeRecordPlugin);

        pluginLoader.add(new QuartzPlugin());

    }

    @Override
    public void configInterceptor(InterceptorLoader interceptorLoader) {
        interceptorLoader.add(new SecurityInterceptor(2, new MyAuthenticateService()));
        //事务的拦截器 @Transaction
        interceptorLoader.add(new TransactionInterceptor());
    }

    @Override
    public void configHandler(HandlerLoader handlerLoader) {
        handlerLoader.add(new CORSHandler());
    }
}
