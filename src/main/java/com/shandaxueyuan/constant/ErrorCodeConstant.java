package com.shandaxueyuan.constant;

/**
 * Created by HouRuidong on 2016/7/22.
 */
public class ErrorCodeConstant {
    public static final int CODE_SUCCESS = 1;
    public static final int ERRORCODE_COMM_UNKOWN = 0;
    public static final String ERRORMSG_COMM_UNKOWN = "系统错误";

    public static final int ERRORCODE_REGIST_INVALIDPARAM = -101;
    public static final int ERRORCODE_REGIST_ACCOUNTNOTFOUND = -102;
    public static final int ERRORCODE_REGIST_CODEERROR = -103;
    public static final int ERRORCODE_REGIST_NOTVALIDATED = -104;
    public static final int ERRORCODE_REGIST_TOKENUPDATEFAILD = -105;
    public static final int ERRORCODE_REGIST_USEREXIST = -106;
    public static final String ERRORMSG_REGIST_INVALIDPARAM = "用户名和密码不能为空！";

    public static final String ERRORMSG_REGIST_USEREXIST = "用户名已存在";


    public static final int ERRORCODE_PRODUCT_MODELEXIST = -201;
    public static final int ERRORCODE_FAMILY_ALREADYADDED = -202;
    public static final int ERRORCODE_FAMILY_REQUESTNOTFOUND = -203;
    public static final int ERRORCODE_FAMILY_USERNOTFOUND = -204;
    public static final int ERRORCODE_FAMILY_CANNOTADDSELF = -205;
    public static final int ERRORCODE_FAMILY_ACCOUNTNOTFOUND = -206;
    public static final int ERRORCODE_FAMILY_TVNOTFOUND = -207;
    public static final int ERRORCODE_FAMILY_USERNOTVALIDATED = -208;
    public static final String ERRORMSG_PRODUCT_MODELEXIST = "产品型号已存在，请重新输入";


    public static final int ERRORCODE_LOGIN_INVALID = -301;
    public static final int ERRORCODE_LOGIN_NOTLOGINED = -302;
    public static final int ERRORCODE_LOGIN_IDCARDNOTFOUND = -303;
    public static final int ERRORCODE_LOGIN_NOAUTH = -304;
    public static final int ERRORCODE_LOGIN_INVALIDPASSWORD = -305;
    public static final String ERRORMSG_LOGIN_NOTLOGINED = "您还未登录，请先登录";
    public static final String ERRORMSG_LOGIN_INVALIDPASSWORD = "您输入的密码不正确，请重新输入！";
    public static final String ERRORMSG_LOGIN_IDCARDNOTFOUND = "您输入的用户名不存在，请重新输入！";
    public static final String ERRORMSG_LOGIN_NOAUTH = "没有权限！";

    public static final String ERRORMSG_PRODUCT_NOROOTIDNODE = "产品或根节点不存在";
    public static final String ERRORMSG_NODENAME_NONODE = "节点不存在或已被删除";
    public static final String ERRORMSG_DELETENODE_NONODE = "要删除的节点不存在";
    public static final String ERRORMSG_GENERATEODBOM_FAILED = "生成运营部bom错误";
    public static final String ERRORMSG_GENERATEODBOM_NOMARK = "该产品尚未生成生产部BOM";
    public static final int ERRORCODE_GENERATEODBOM_FAILED = -309;
    public static final int ERRORCODE_GENERATEODBOM_NOMARK = -310;
    public static final int ERRORCODE_PRODUCT_NOROOTIDNODE = -306;
    public static final int ERRORCODE_NODENAME_NONODE = -307;
    public static final int ERRORCODE_DELETENODE_NONODE = -308;

    public static final int ERRORCODE_REMARKBOM_FAILED = -401;
    public static final String ERRORMSG_REMARKBOM_FAILED = "标记生产部BOM失败";
    public static final int ERRORCODE_UPLOAD_NOFILE = -501;
    public static final String ERRORMSG_UPLOAD_NOFILE = "文件不存在";

    public static final int ERRORCODE_GETDETAIL_FAILED = -502;
    public static final String ERRORMSG_GETDETAIL_FAILED = "读取节点信息失败";

    public static final int ERRORCODE_GETCATEID_FAILED = -601;
    public static final String ERRORMSG_GETCATEID_FAILED = "物料种类错误";

    public static final String ERRORMSG_CATE_NOTEXIST = "部分行物料种类输入错误,请检查";
    public static final int ERRORCODE_CATE_NOTEXIST = -602;

    public static final String ERRORMSG_CHOOSE_NOTHING = "未选中任何行,保存操作失败";
    public static final int ERRORCODE_CHOOSE_NOTHING = -603;

    public static final int ERRORCODE_TOOMANYRESULTS = -604;
    public static final String ERRORMSG_TOOMANYRESULTS = "已存在同名种类";

    public static final int ERRORCODE_NO_CATE_INPUT = -605;
    public static final String ERRORMSG_NO_CATE_INPUT = "请输入物料种类";


}
