package com.xgq.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;
import com.xgq.common.model.User;

/**
 * Created by xieguoqiang on 2017/3/15.
 */
public class HelloController extends Controller {
    public void index() {
        // DemoConfig中添加了映射_MappingKit，即可直接save
        new User().set("name", "James").set("age", 25).save();

        // Db+Record 模式，可以不需要映射  Db直接通过表名操作
        Record user = new Record().set("name", "James1").set("age", 253);
        Db.save("xgq_user", user);

        // use不填参数时，默认使用第一个配置的redis
        Cache redisCache = Redis.use("defaultCache");
        redisCache.set("a-test", "hello");
        String obj = redisCache.get("a-test");

        String obj1 = redisCache.get("video_campain_1828");
        String obj2 = redisCache.get("brand_attach_308");

        System.out.println(obj);
        System.out.println(obj1);
        System.out.println(obj2);

        renderText("hello world!");
    }
}
