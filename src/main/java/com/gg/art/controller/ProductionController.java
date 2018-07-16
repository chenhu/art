package com.gg.art.controller;

import com.gg.art.bean.PageBean;
import com.gg.art.bean.ProductionBean;
import com.gg.art.bean.ProductionQueryParm;
import com.gg.art.common.ResponseMessage;
import com.gg.art.model.Production;
import com.gg.art.service.ProductionService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by chenhu on 2018/6/9.
 */

@Controller
@RequestMapping(value = "/production")
@CrossOrigin(origins = "*")
public class ProductionController {

    @Autowired
    private ProductionService ProductionService;

    private static final String UPLOADED_FOLDER = "/static/uploadfiles/";

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ResponseMessage addProduction(Production production, @RequestParam("file") MultipartFile uploadfile ){
        ResponseMessage<Void> responseMessage = new ResponseMessage();

        if(!uploadfile.isEmpty()) {
            try {
                String path = saveUploadedFiles(uploadfile);
                production.setImage(path);
            } catch (IOException e) {
                responseMessage.setCode("-1");
                responseMessage.setDescription(e.getMessage());
                return responseMessage;
            }

        }
        if(ProductionService.addProduction(production)) {
            responseMessage.setCode("0");
            responseMessage.setDescription("成功");
        } else {
            responseMessage.setCode("-1");
            responseMessage.setDescription("失败");
        }
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/add1", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ResponseMessage addProductionSelective(Production production, @RequestParam("file") MultipartFile uploadfile){
        ResponseMessage<Void> responseMessage = new ResponseMessage();

        if(!uploadfile.isEmpty()) {
            try {
                String path = saveUploadedFiles(uploadfile);
                production.setImage(path);
            } catch (IOException e) {
                responseMessage.setCode("-1");
                responseMessage.setDescription(e.getMessage());
                return responseMessage;
            }

        }

        if(ProductionService.addProductionSelective(production)) {
            responseMessage.setCode("0");
            responseMessage.setDescription("成功");
        } else {
            responseMessage.setCode("-1");
            responseMessage.setDescription("失败");
        }

        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ResponseMessage deleteProduction(@RequestParam("id") int id){
        ResponseMessage<Void> responseMessage = new ResponseMessage();
        if(ProductionService.deleteById(id)) {
            responseMessage.setCode("0");
            responseMessage.setDescription("成功");
        } else {
            responseMessage.setCode("-1");
            responseMessage.setDescription("失败");
        }
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/select", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ResponseMessage select(@RequestParam("id") int id){
        ResponseMessage<ProductionBean> responseMessage = new ResponseMessage();
        ProductionBean Production = ProductionService.selectById(id);
        responseMessage.setCode("0");
        responseMessage.setDescription("成功");
        responseMessage.setMessageBody(Production);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/all", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ResponseMessage queryByParam(@RequestBody ProductionQueryParm queryParam){
        ResponseMessage<Page> responseMessage = new ResponseMessage();
        Page<ProductionBean> allProduction = ProductionService.selectByParam(queryParam);
        PageBean pageInfo = new PageBean();
        pageInfo.setPageNum(queryParam.getPageNum());
        pageInfo.setPageSize(queryParam.getPageSize());
        pageInfo.setTotal(allProduction.getTotal());
        responseMessage.setPageInfo(pageInfo);
        responseMessage.setCode("0");
        responseMessage.setDescription("成功");
        responseMessage.setMessageBody(allProduction);
        return responseMessage;
    }


    @ResponseBody
    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ResponseMessage updateProductionSelective(@RequestBody Production production){
        ResponseMessage<Void> responseMessage = new ResponseMessage();
        if(ProductionService.updateByIdSelective(production)) {
            responseMessage.setCode("0");
            responseMessage.setDescription("成功");
        } else {
            responseMessage.setCode("-1");
            responseMessage.setDescription("失败");
        }
        return responseMessage;
    }

    //save file
    private String saveUploadedFiles(MultipartFile file) throws IOException {

        byte[] bytes = file.getBytes();
        String originalFileName = file.getOriginalFilename();
        String extensionName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String rootpath = this.getClass().getResource("/").getPath();
        String filePath = UPLOADED_FOLDER +  UUID.randomUUID().toString().replaceAll("-", "").concat(".").concat(extensionName);
        Path path = Paths.get(rootpath + filePath);
        Files.write(path, bytes);
        return filePath;
    }

}
