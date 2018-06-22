package com.gg.art.controller;
/**
 * Created by chenhu on 2018/6/22.
 */

import com.gg.art.bean.ProductionBean;
import com.gg.art.common.ResponseMessage;
import com.gg.art.model.Code;
import com.gg.art.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: chenhu
 * @Date: 2018/6/22 09:42
 * @Description: 字典接口
 */
@Controller
@RequestMapping(value = "/dictionary")
public class DictionnaryController {

    @Autowired
    private CodeService codeService;

    @ResponseBody
    @RequestMapping(value = "/select", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ResponseMessage select(@RequestParam("type") String type){
        ResponseMessage<List> responseMessage = new ResponseMessage();
        List<Code> codes = codeService.queryByType(type);
        responseMessage.setCode("0");
        responseMessage.setDescription("成功");
        responseMessage.setMessageBody(codes);
        return responseMessage;
    }

}
