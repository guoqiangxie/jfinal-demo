package com.xgq.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
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

        renderText("hello world!");
    }
}
