/*
 * Copyright (c) 2019.  黄钰朝
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hyc.wechat.controller.listener;

import com.hyc.wechat.controller.Controller;
import com.hyc.wechat.controller.Impl.ControllerImpl;
import com.hyc.wechat.controller.provider.UserProvider;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program wechat
 * @description 负责监听servlet的初始化和销毁事件
 * @date 2019-05-01 08：44
 */

@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //装载Controller容器
        Controller controller = ControllerImpl.getInstance();
        controller.registerProvider("userProvider",new UserProvider());
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("controller",controller);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
