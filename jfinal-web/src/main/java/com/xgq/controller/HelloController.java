package com.xgq.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;

/**
 * Created by xieguoqiang on 2017/3/15.
 */
public class HelloController extends Controller {
    public void index() {
        renderText("hello world!" + PropKit.get("host"));
    }
}
