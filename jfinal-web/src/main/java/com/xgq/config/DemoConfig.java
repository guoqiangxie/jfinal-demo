package com.xgq.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.xgq.common.model._MappingKit;
import com.xgq.controller.HelloController;

/**
 * Created by xieguoqiang on 2017/3/15.
 */
public class DemoConfig extends JFinalConfig {

    //该方法用于初始化系统部分全局参数，如设置是否为开发模式、编码格式、视图解析、URL参数分隔符、POST请求参数大小等等。
    @Override
    public void configConstant(Constants constants) {
        PropKit.use("jdbc.properties"); //读取配置文件，项目内不需要指定路径 PropKit.get 直接调用
        constants.setDevMode(true); //开发模式设置，默认false。如果将其设置为开发模式，则在前台每次发送URL请求时都会输入报告
        constants.setEncoding("UTF-8"); //编码格式：默认编码格式为UTF-8
        constants.setViewType(ViewType.JSP); //视图解析：默认视图解析为FreeMaker（其扩展名为ftl，但在JFinal里用html作为FreeMarker视图解析的扩展名），JFinal支持三种视图解析JSP，FREE_MARKER，VELOCITY，也可以扩展解析视图，视图解析用于设置render解析视图的类型，如果设置视图解析为JSP，则对于render的视图里包含freemarker标签则无法解析。
        constants.setUrlParaSeparator("-"); //设置url上传参的参数之间的连接字符，默认-  controllerKey/method/param0-param1
    }

    // 配置路由
    //一个controller只要配置一次，前缀，后缀即方法名，默认走index方法
    // 第三个参数为该Controller的视图存放路径，webapp为/，第三个参数省略时默认与第一个参数值相同
    @Override
    public void configRoute(Routes routes) {
        routes.add("/hello", HelloController.class);
//        routes.add("/hello", HelloController.class, "/index");
//        routes.add("/blog", BlogController.class);
    }

    //配置引擎的一些定义了共享函数的模板文件，比如分页等，如果不是用Template Engine，可以不实现
    @Override
    public void configEngine(Engine engine) {
//        engine.addSharedFunction("/common/pagination.html");
    }

    // 配置 JFinal 的 Plugin，比如redis，数据库等
    @Override
    public void configPlugin(Plugins plugins) {
        // 配置druid数据库连接池插件
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.user"), PropKit.get("jdbc.password"));
        plugins.add(druidPlugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        plugins.add(arp);

        //_MappingKit 将所有的model映射加入
        _MappingKit.mapping(arp);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
