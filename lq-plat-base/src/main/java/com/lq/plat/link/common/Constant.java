package com.lq.plat.link.common;

public class Constant {

  public static final int    PAGE                   = 1;

  public static final int    PAGESIZE               = 10;

  public static final String CUST_SESSION_KEY       = "cust.session.key";

  // 商户
  public static final String FLAG_CUST              = "1";

  // 管理员
  public static final String FLAG_ADMIN             = "0";

  public static final String OK                     = "success";

  public static final String ERROR_NAME_OR_PASS     = "301";

  // message
  public static final String MSG_OK                 = "操作成功";

  public static final String ERROR_MSG_NAME_OR_PASS = "用户名或密码不正确";

  public static final String MSG_TYPE               = "msgType";

  public static final String PLAY_V0                = "0";

  public static final String PLAY_V1                = "1";

  public static final String PLAY_V2                = "2";

  public static final String PLAY_V3                = "3";

  public static final String START                  = "start";

  public static final String GO                     = "go";

  public static final String SAVESUCCESS            = "保存成功";

  public static final String MEMBEREXIST            = "会员已存在";

  public static final String FAILURE                = "保存失败";

  public static final String NODISCOUNTCOUPON       = "没有获得优惠券";

  // public static final String SAVECUSSER = "您的手机成功登记为扫码器";
  public static final String SAVECUSSER             = "/as_scanner.html";

  public static final String CUSSERFULL             = "/scanner_count_full.html";

  public static final String EXITCUSSER             = "/not_as_scanner.html";

  public static final String CUSSERSCANHTML         = "/reward.html";

  public static final String NOPERMISSION           = "当前用户没有权限";

  public static final String INCONVERTIBILITY       = "奖券已经使用，不可兑换";

  public static final String CONVERTIBILITY         = "您已兑奖，请明天继续哦！";

  public static final String CONVERTIBILITYSUC      = "兑换成功";

  public static final String NOPRIZE                = "手慢啦！奖券被大家抢完咯！";

  public static final String CUSSERPASTDUE          = "客服已过期";

  public static final String SIGNINSUC              = "签到成功";

  public static final String HYPOSTHENIA            = "体力不足";

  public static final String EXPIRYSUC              = "兑奖成功";


  public static final String UTF8 = "UTF-8";

  // 返回代码
  public enum MSG {
    A1000("成功"), A1001("商户不存在"), A1002("用户未登记"), A1003("活动不存在"), A1004("此游戏过期"), A1005(
        "一天只能摇3次奖哦，积累好运气，明天再来吧！"), A1006("你的游戏积分不足"), A1007("系统繁忙，请稍后再试"), A1008("你不能参与此游戏"), A1009(
        "兑换成功"), A1010("不能兑换"), A1011("未找到此活动类型"), A1012("操作成功"), A1013("操作失败"), A1014("当前用户没有权限"), A1015(
        "奖券已经使用，不可兑换"), A1016("兑奖成功"), A1017("客服已过期"), A1018("手慢啦！奖券被大家抢完咯！"), A1019(
        "不要太贪心哦，一天一次的兑奖机会，你已使用完毕！"), A1020("没有获得奖券"), A1021("已存在"), A1022("领券码不存在"), A1023(
        "已经兑换过奖券，不能重复兑换"), A1024("用户信息只能由获奖用户提交");
    private final String value;

    private MSG(String value) {

      this.value = value;
    }

    public String getValue() {

      return value;
    }
  };

  // 问题或答案类型
  public enum QUESTION_ANSWER_TYPE {

    QUESTION("提问"), ANSWER("答案");

    private final String value;

    private QUESTION_ANSWER_TYPE(String value) {

      this.value = value;
    }

    public String getValue() {

      return value;
    }
  };
}
