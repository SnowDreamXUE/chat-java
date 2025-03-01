package com.easychat.entity.config;

import com.easychat.utils.StringTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("appConfig")
public class AppConfig {

    /**
     * webSocket端口
     */
    @Value("${ws.port:}")
    private Integer wsPort;

    /**
     * 文件目录
     */
    @Value("${project.folder:}")
    private String projectFolder;

    @Value("${admin.email:}")
    private String adminEmail;

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getProjectFolder() {
        if(StringTools.isEmpty(projectFolder) && !projectFolder.endsWith("/")){
            projectFolder = projectFolder + "/";
        }
        return projectFolder;
    }

    public Integer getWsPort() {
        return wsPort;
    }
}
