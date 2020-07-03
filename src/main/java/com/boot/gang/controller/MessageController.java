package com.boot.gang.controller;

import com.boot.gang.activemqTool.ReceiveTool;
import com.boot.gang.entity.Admin;
import com.boot.gang.entity.Message;
import com.boot.gang.entity.MessageUserAdmin;
import com.boot.gang.service.Impl.MessageService;
import com.boot.gang.service.TokenService;
import com.boot.gang.util.AjaxResult;
import com.boot.gang.util.ResultCodeEnum;
import com.boot.gang.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    private MessageService messageService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ReceiveTool receiveTool;


    /**
     * 发送信息接口
     * @param request  获得请求的信息
     * @param messageContent 消息内容
     * @param adminPic 接收者头像
     * @return 发送情况
     */
    @PostMapping("/sendMessage")
//    @ApiParam("发送消息")
    public AjaxResult sendMessage(HttpServletRequest request,
                                  @ApiParam(value = "消息内容", required = true) @RequestParam("messageContent")String messageContent,
                                  @ApiParam(value = "接收者头像") @RequestParam(value = "adminPic", required = false) String adminPic,
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
        return AjaxResult.success(messageService.sendMessage(messageContent, userId, adminPic, adminNo, adminName, messageType));
    }

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
        String adminNo = request.getParameter("adminNo");
        return AjaxResult.success(receiveTool.getMessageOnMemory(userId, adminNo));
    }

//    @GetMapping("listUnReadMessage")
//    @ApiOperation("获得未读消息的列表")
//    public AjaxResult listUnReadMessage(HttpServletRequest request) throws JMSException {
////        logger.info("得未读消息的列息");
//        String userId = "";
//        try {
//            userId = tokenService.getIdByToken(request);
//        } catch (Exception e) {
//            return AjaxResult.failure(ResultCodeEnum.USER_NOT_LOGGED_IN);
//        }
//        if(userId.equals("")) {
//            return AjaxResult.failure(ResultCodeEnum.USER_NOT_LOGGED_IN);
//        }
//        String adminNo = request.getParameter("adminNo");
//        return AjaxResult.success(receiveTool.listUnReadMessage(userId, adminNo));
//    }


    @GetMapping("countUnReadMessage")
    @ApiOperation("获取未读的消息的数量")
    public AjaxResult countUnReadMessage(HttpServletRequest request){
        String userId = "";
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            return AjaxResult.failure(ResultCodeEnum.USER_NOT_LOGGED_IN);
        }
        return AjaxResult.success(receiveTool.countMessageNotRead(userId));
    }


    @GetMapping("listMessageOnDataBase")
    @ApiOperation("获得所有的历史消息---执行速度慢")
    public AjaxResult listMessageOnDataBase(HttpServletRequest request,
                                            @ApiParam(value = "客服服务号") @RequestParam(value = "adminNo", required = false) String adminNo,
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
            List<Message> messages = messageService.listMessageOnDataBaseToday(userId, adminNo);
            return AjaxResult.success(messages);
        } else {
            Map<String, Object> map= messageService.listMessageOnDataBase(pageNo, pageSize, userId, adminNo);
            return AjaxResult.success(map);
        }
    }

}
