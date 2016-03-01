package itstack.demo.common.constants;

/**
 * Created with IntelliJ IDEA.
 * User: lizhi
 * Date: 15-8-26
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */
public class Constants {

    public static final class ResponseCode {
        public static final String SUCCESS = "0000";

        public static final String UNKNOWN_ERROR = "0001";

        public static final String INDEX_DUP = "0002";

        public static final String ID_NUM_DUP = "0003";

        public static final String CODE_ERROR = "0004";

        public static final String USER_NOT_EXIST = "0005";

        public static final String NO_LOGIN = "0006";

        public static final String SEND_CODE_FAILED = "0007";

        public static final String SEND_CODE_OVERFLOW = "0008";

        public static final String ID_MOBILE_DUP = "0009";

        public static final String INVALID_INVITE_CODE = "0010";

        public static final String INVALID_TRADE_TYPE = "0011";

        public static final String ID_ERP_DUP = "0012";

        public static final String INVALID_PROTOCOL_STATUS = "0013";

        public static final String PAY_APPLIED = "0014";

        public static final String ZERO_CASH_APPLY = "0015";

        public static final String INVALID_PARAM = "E0001";

        public static final String INVALID_BUSINESS_TYPE = "E0002";

        public static final String ORDER_NOT_RECORD = "E0003";

        public static final String INVALID_SYS_CODE = "E0004";

        public static final String INVALID_AGENT = "E0005";

        public static final String WITHDRAW_ALL_LIMIT = "E0005";

        public static final String APPLY_PAY_FAILED = "E0006";

        public static final String INVALID_CASH_REQUEST = "E0007";

        public static final String USER_IS_REWARDED = "W0001";

        public static final String USER_NOT_EXISTS = "W0002";

        public static final String ORDER_ALL_REFUNDED = "W0004";

        public static final String REFUND_GT_ORDER = "W0005";

        public static final String REFUND_OF_ZERO = "W0006";

        //领取任务异常信息

        public static final String TASK_OBT_NO = "T0001"; //没有可领取的任务

        public static final String TASK_RECORD_EQU = "T0002";  //个人可领取数量无

        public static final String TASK_REC_NEXT = "T0003";   //同一个任务已经领取一个但为完成不可领取下一个

        public static final String TASK_INDEX_DUP = "T0004"; //任务领取防重字段冲突

        public static final String TASK_SKU_NO = "T0005"; //sku任务不需要主动领取

        public static final String TASK_SUR_NO = "T0006";//剩余奖励数量为0
    }

    public static final class ResponseInfo {
        public static final String SUCCESS = "成功";

        public static final String UNKNOWN_ERROR = "未知错误";

        public static final String INDEX_DUP = "唯一索引冲突";

        public static final String ID_NUM_DUP = "身份证号重复";

        public static final String CODE_ERROR = "验证码错误";

        public static final String USER_NOT_EXIST = "用户不存在";

        public static final String NO_LOGIN = "用户未登录";

        public static final String SEND_CODE_FAILED = "发送验证码失败";

        public static final String SEND_CODE_OVERFLOW = "短信验证码超限";

        public static final String ID_MOBILE_DUP = "手机号重复";

        public static final String INVALID_PROTOCOL_STATUS = "无效的协议状态";

        public static final String ID_ERP_DUP = "ERP重复";

        public static final String INVALID_INVITE_CODE = "无效邀请码";

        public static final String INVALID_TRADE_TYPE = "无效交易类型";

        public static final String INVALID_PARAM = "参数为空";

        public static final String INVALID_BUSINESS_TYPE = "无效的交易类型";

        public static final String ORDER_NOT_RECORD = "订单并未结算";

        public static final String INVALID_SYS_CODE = "无效的系统码";

        public static final String USER_IS_REWARDED = "用户已经有奖励订单";

        public static final String USER_NOT_EXISTS = "用户不存在";

        public static final String ORDER_ALL_REFUNDED = "退款已结清";

        public static final String REFUND_GT_ORDER = "退款金额大于贷款金额";

        public static final String REFUND_OF_ZERO = "0元退款";

        public static final String INVALID_AGENT = "用户未绑定京东pin";

        public static final String WITHDRAW_ALL_LIMIT = "只支持全额提现";

        public static final String INVALID_CASH_REQUEST = "无效的提现流水号";

        public static final String APPLY_PAY_FAILED = "申请代付失败";

        public static final String PAY_APPLIED = "代付申请已经提交";

        public static final String TASK_OBT_NO = "没有可领取的任务";

        public static final String TASK_RECORD_EQU = "个人可领取数量无";

        public static final String TASK_REC_NEXT = "同一个可领取多次的任务已领取任务未完成不可领取下一个任务";

        public static final String TASK_INDEX_DUP = "任务领取防重字段冲突"; //任务领取防重字段冲突

        public static final String TASK_SKU_NO = "SKU任务不需要主动领取"; //sku任务不需要主动领取

        public static final String TASK_SUR_NO = "奖励数量为零";

        public static final String ZERO_CASH_APPLY = "可提现金额小于0";
    }

    public static final class VerifyCodeType {
        public static final String LOGIN = "login";

        public static final String GESTURE_MODIFY = "gesture";
    }

    public static final class NumberFormatterChoice {
        public static final int INTEGERSTYLE = 1;
        public static final int CURRENCYSTYLE = 2;
        public static final int NUMBERSTYLE = 3;
    }

    public static final class SysCode{
        public static final String SCHOOL_PROCESSOR = "1";
        public static final String SCHOOL_WORKER = "2";
        public static final String SCHOOL_FRONT = "3";
        public static final String BT_RPC = "11";
        public static final String[] ARRAY = {SCHOOL_PROCESSOR,SCHOOL_WORKER,SCHOOL_FRONT,BT_RPC};
    }

    public static final class CashedResult{
        public static final int CASHED_SUCCESS = 0;//成功
        public static final int CASHED_FAILED = 1;//失败
        public static final int CASH_ING = 2; //进行中
    }

    public static final class TaskStatus{
        public static final int DEFAULT = 0;//默认，不执行。
        public static final int DOING = 1;//默认，不执行。
    }

    public static final class TaskType{
        public static final int DEFAULT = 1;//
    }

    /**
     * 公告可见范围
     */
    public static final class NoticeRange{
        public static final int ALL = 0;    //所有的
        public static final int ALONE = 1;  //单独的
        public static final int PART = 2;   //部分的

    }

}
