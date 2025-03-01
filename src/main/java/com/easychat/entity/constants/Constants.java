package com.easychat.entity.constants;

import com.easychat.entity.enums.UserContactTypeEnum;

public class Constants {

    /**
     * length
     */
    public static final Integer LENGTH_11 = 11;

    public static final Integer LENGTH_20 = 20;

    /**
     * redis key
     */
    public static final String REDIS_KEY_CHECK_CODE = "easychat:checkcode:";

    public static final String REDIS_KEY_WS_USER_HEART_BEAT = "easychat:ws:user:heartbeat:";

    public static final String REDIS_KEY_WS_TOKEN = "easychat:ws:token:";

    public static final String REDIS_KEY_WS_TOKEN_USERID = "easychat:ws:token:userid:";

    public static final String REDIS_KEY_SYS_SETTING = "easychat:syssetting";

    /**
     * redis time
     */
    public static final Integer REDIS_TIME_1MIN = 60;

    public static final Integer REDIS_KEY_EXPIRE_DAY = REDIS_TIME_1MIN * 60 * 24;

    /**
     * robot
     */
    public static final String ROBOT_UID = UserContactTypeEnum.USER.getPrefix() + "robot";

    /**
     * file
     */
    public static final String FILE_FOLDER_FILE = "/file/";

    public static final String FILE_FOLDER_AVATAR_NAME = "avatar/";

    /**
     * 文件后缀
     */
    public static final String IMAGE_SUFFIX = ".png";

    public static final String COVER_IMAGE_SUFFIX = "_cover.png";

    /**
     * 其他
     */
    //申请信息模板
    public static final String APPLY_INFO_TEMPLATE = "我是%s";
}
