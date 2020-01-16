package com.boot.gang.controller;

import com.boot.gang.activemqTool.ReceiveTool;
import com.boot.gang.entity.Message;
import com.boot.gang.service.Impl.CommonService;
import com.boot.gang.service.TokenService;
import com.boot.gang.util.AjaxResult;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: lingang
 * @description:
 * @author: dongxiangwei
 * @create: 2020-01-14 22:35
 **/

@RestController
@RequestMapping("AMQ")
public class ActiveMQController {

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
    @PostMapping("sendMessage")
//    @ApiParam("发送消息")
    public AjaxResult sendMessage(HttpServletRequest request,
                                  @ApiParam(value = "消息内容", required = true) @RequestParam("messageContent")String messageContent,
                                  @ApiParam(value = "招聘岗位主键，可为空") @RequestParam(value = "recruitInfoId", required = false) Integer recruitInfoId,
                                  @ApiParam(value = "消息接收者") @RequestParam(value = "adminNo", required = false)String adminNo,
                                  @ApiParam(value = "消息接收者名称") @RequestParam(value = "adminName", required = false)String adminName) throws JMSException {

        String userId = "";
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.success(commonService.sendMessage(messageContent, userId, recruitInfoId, adminNo, adminName));
    }

//    @GetMapping("listMessageOnDataBase.html")
//    @ApiParam("获得所有的消息---执行速度慢")
//    public AjaxResult listMessageOnDataBase(HttpServletRequest request,
//                                            @ApiParam(value = "招聘岗位主键，可为空") @RequestParam(value = "recruitInfoId", required = false) Integer recruitInfoId,
//                                            @ApiParam(value = "页码，默认为1") @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
//                                            @ApiParam(value = "每页条数，默认为10") @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
//        String userId = "";
//        try {
//            userId = tokenService.getIdByToken(request);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        List<Message> messages = commonService.listMessageOnDataBaseToday(userId, recruitInfoId);
//        return AjaxResult.success(messages);
////        if(pageNo == 0) {
////        } else {
////            Page<Message> objects = commonService.listMessageOnDataBase(pageNo, pageSize, user.getId(), recruitInfoId);
////            return AjaxResult.success(objects);
////        }
//    }
//
//    // 今天的消息
//    public List<Message> listMessageOnDataBaseToday(HttpServletRequest request) {
//        String userId = "";
//        try {
//            userId = tokenService.getIdByToken(request);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return commonService.findAll();
//    }

    /**
     *
     * @return
     */
    @GetMapping("listMessageOnMemory")
    @ApiParam("获得未读的消息---执行速度快")
    public AjaxResult listMessageOnMemory(HttpServletRequest request) throws JMSException {
        String userId = "";
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return AjaxResult.success(receiveTool.getMessageOnMemory(userId));
    }
}
