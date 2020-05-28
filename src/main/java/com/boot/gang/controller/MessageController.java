package com.boot.gang.controller;

import com.boot.gang.activemqTool.ReceiveTool;
import com.boot.gang.entity.Message;
import com.boot.gang.entity.User;
import com.boot.gang.service.Impl.CommonService;
import com.boot.gang.service.TokenService;
import com.boot.gang.util.AjaxResult;
import com.boot.gang.util.ResultCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: lingang
 * @description:
 * @author: dongxiangwei
 * @create: 2020-01-14 22:35
 **/

@RestController
@RequestMapping("/ajax")
@Api(tags = {"消息接口"})
public class MessageController {

    private static Logger logger = LogManager.getLogger(MessageController.class);
    @Autowired
    private CommonService commonService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ReceiveTool receiveTool;


    /**
     * 发送信息接口
     * @param request  获得请求的信息
     * @param messageContent 消息内容
     * @param recruitInfoId 招聘信息
     * @return 发送情况
     */
    @PostMapping("/sendMessage")
//    @ApiParam("发送消息")
    public AjaxResult sendMessage(HttpServletRequest request,
                                  @ApiParam(value = "消息内容", required = true) @RequestParam("messageContent")String messageContent,
                                  @ApiParam(value = "招聘岗位主键，可为空") @RequestParam(value = "recruitInfoId", required = false) Integer recruitInfoId,
                                  @ApiParam(value = "消息接收者") @RequestParam(value = "adminNo", required = false)String adminNo,
                                  @ApiParam(value = "消息类别") @RequestParam(value = "messageType", required = false)Integer messageType,
                                  @ApiParam(value = "消息接收者名称") @RequestParam(value = "adminName", required = false)String adminName) throws JMSException {
//        logger.info("发送消息");
        String userId = "";
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.success(commonService.sendMessage(messageContent, userId, recruitInfoId, adminNo, adminName, messageType));
    }

    /**
     *
     * @return
     */
    @GetMapping("listMessageOnMemory")
    @ApiParam("获得未读的消息---执行速度快")
    public AjaxResult listMessageOnMemory(HttpServletRequest request) throws JMSException {
//        logger.info("获得历史的消息");
        String userId = "";
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return AjaxResult.success(receiveTool.getMessageOnMemory(userId));
    }


//    /**
//     *  获得session中保存的user信息
//     * @return
//     */
//    @GetMapping("listMessageOnMemory")
//    @ApiOperation("获得未读的消息---执行速度快")
//    public AjaxResult listMessageOnMemory(HttpServletRequest request,
//                                          @ApiParam(value = "招聘岗位主键，可为空") @RequestParam(value = "recruitInfoId", required = false) Integer recruitInfoId) throws JMSException {
//        String userId = "";
//        try {
//            userId = tokenService.getIdByToken(request);
//        } catch (Exception e) {
//            return AjaxResult.failure(ResultCodeEnum.USER_NOT_LOGGED_IN);
//        }
//        if(userId.equals("")) {
//            return AjaxResult.failure(ResultCodeEnum.USER_NOT_LOGGED_IN);
//        }
//        return AjaxResult.success(receiveTool.getMessageOnMemory(userId));
//    }

    /**
     *  获得session中保存的user信息
     * @return
     */
    @GetMapping("listUnReadMessage")
    @ApiOperation("获得未读消息的列表")
    public AjaxResult listUnReadMessage(HttpServletRequest request) throws JMSException {
//        logger.info("得未读消息的列息");
        String userId = "";
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            return AjaxResult.failure(ResultCodeEnum.USER_NOT_LOGGED_IN);
        }
        if(userId.equals("")) {
            return AjaxResult.failure(ResultCodeEnum.USER_NOT_LOGGED_IN);
        }
        return AjaxResult.success(receiveTool.listUnReadMessage(userId));
    }



    @GetMapping("listMessageOnDataBase")
    @ApiOperation("获得所有的消息---执行速度慢")
    public AjaxResult listMessageOnDataBase(HttpServletRequest request,
                                            @ApiParam(value = "招聘岗位主键，可为空") @RequestParam(value = "recruitInfoId", required = false) Integer recruitInfoId,
                                            @ApiParam(value = "页码，默认为1") @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                            @ApiParam(value = "每页条数，默认为10") @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        String userId = "";
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            return AjaxResult.failure(ResultCodeEnum.USER_NOT_LOGGED_IN);
        }
        if(userId.equals("")) {
            return AjaxResult.failure(ResultCodeEnum.USER_NOT_LOGGED_IN);
        }
        if(pageNo == 0) {
            List<Message> messages = commonService.listMessageOnDataBaseToday(userId, recruitInfoId);
            return AjaxResult.success(messages);
        } else {
            Map<String, Object> map= commonService.listMessageOnDataBase(pageNo, pageSize, userId, recruitInfoId);
            return AjaxResult.success(map);
        }
    }

}
