package com.lq.plat.link.utils;

import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.PlatformStatus;
import com.lq.plat.link.exception.NotSupportException;
import com.lq.plat.link.utils.security.Aes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import javax.transaction.NotSupportedException;
import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class ApiUtils {


    private static enum ResultMsg
    {
        CREATED("添加成功!"),  UPDATED("修改成功!"),  DELETED("删除成功!"),  ERROR("系统正忙,请稍候...");

        private final String msg;

        private ResultMsg(String msg)
        {
            this.msg = msg;
        }

        public String getMsg()
        {
            return this.msg;
        }
    }



    public static ResponseEntity<PlatformResult> encryptId(String id)
    {
        try
        {
            return ok(Aes.encrypt(id));
        }
        catch (Exception e)
        {
            throw new NotSupportException();
        }
    }

    public static ResponseEntity<PlatformResult> encryptPluginId(String id)
    {
        try
        {
            return ok(Aes.encrypt(id, "lq@Et&#08$Aes"));
        }
        catch (Exception e)
        {
            throw new NotSupportException();
        }
    }

    public static String decryptId(String id) throws NotSupportedException {
        try
        {
            return Aes.decrypt(id);
        }
        catch (Exception e)
        {
            throw new NotSupportedException();
        }
    }

    public static String decryptPluginId(String id)
    {
        try
        {
            return Aes.decrypt(id, "lq@Et&#08$Aes");
        }
        catch (Exception e)
        {
            throw new NotSupportException();
        }
    }

    public static ResponseEntity<PlatformResult> ok()
    {
        return new ResponseEntity(PlatformResult.custom(), HttpStatus.OK);
    }

    public static ResponseEntity<PlatformResult> ok(Object value)
    {
        if ((value instanceof Boolean))
        {
            boolean flag = ((Boolean)value).booleanValue();
            if (flag) {
                return new ResponseEntity(PlatformResult.custom(), HttpStatus.OK);
            }
            return new ResponseEntity(PlatformResult.custom().setErrCode(-1), HttpStatus.OK);
        }
        return new ResponseEntity(PlatformResult.custom().setData(value), HttpStatus.OK);
    }

    public static ResponseEntity<PlatformResult> ok(Object value, HttpStatus status)
    {
        return new ResponseEntity(PlatformResult.custom().setData(value), status);
    }

    public static ResponseEntity<PlatformResult> ok(Object value, HttpHeaders headers, HttpStatus status)
    {
        return new ResponseEntity(PlatformResult.custom().setData(value), headers, status);
    }

    public static ResponseEntity<PlatformResult> created()
    {
        return ok(ResultMsg.CREATED.getMsg(), HttpStatus.CREATED);
    }

    public static ResponseEntity<PlatformResult> updated()
    {
        return ok(ResultMsg.UPDATED.getMsg());
    }

    public static ResponseEntity<PlatformResult> deleted()
    {
        return ok(ResultMsg.DELETED.getMsg());
    }

    public static ResponseEntity<PlatformResult> error()
    {
        return error(ResultMsg.ERROR.getMsg());
    }

    public static ResponseEntity<PlatformResult> error(String errMsg)
    {
        return new ResponseEntity(PlatformResult.custom().setErrMsg(errMsg).setErrCode(-1), HttpStatus.NOT_ACCEPTABLE);
    }

    public static ResponseEntity<PlatformResult> error(PlatformStatus status)
    {
        return new ResponseEntity(PlatformResult.custom().setErrMsg(status.getErrmsg()).setErrCode(status.getErrcode()), status.getHttpStatus());
    }

    public static ResponseEntity<PlatformResult> validError(BindingResult result)
    {
        return new ResponseEntity(PlatformResult.custom().setErrMsg(WebUtils.getValidErrorMsg(result.getAllErrors())).setErrCode(-1), HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseEntity<PlatformResult> result(Object value, Class<T> target)
    {
        T data = DTOUtils.map(value, target);
        return new ResponseEntity(PlatformResult.custom().setData(data), HttpStatus.OK);
    }

    public static <T, E> ResponseEntity<PlatformResult> result(List<E> values, Class<T> target)
    {
        List<T> data = DTOUtils.map(values, target);
        return new ResponseEntity(PlatformResult.custom().setData(data), HttpStatus.OK);
    }
}
