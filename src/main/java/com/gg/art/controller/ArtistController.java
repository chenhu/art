package com.gg.art.controller;

import com.gg.art.bean.ArtistQueryParam;
import com.gg.art.common.ResponseMessage;
import com.gg.art.model.Artist;
import com.gg.art.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenhu on 2018/6/9.
 */

@Controller
@RequestMapping(value = "/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.PUT)
    public ResponseMessage addArtist(Artist artist){
        ResponseMessage<Void> responseMessage = new ResponseMessage();
        if(artistService.addArtist(artist)) {
            responseMessage.setCode("0");
            responseMessage.setDescription("成功");
        } else {
            responseMessage.setCode("-1");
            responseMessage.setDescription("失败");
        }
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/add1", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.PUT)
    public ResponseMessage addArtistSelective(Artist artist){
        ResponseMessage<Void> responseMessage = new ResponseMessage();
        if(artistService.addArtistSelective(artist)) {
            responseMessage.setCode("0");
            responseMessage.setDescription("成功");
        } else {
            responseMessage.setCode("-1");
            responseMessage.setDescription("失败");
        }

        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public ResponseMessage deleteArtist(@RequestParam("id") int id){
        ResponseMessage<Void> responseMessage = new ResponseMessage();
        if(artistService.deleteById(id)) {
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
        ResponseMessage<Artist> responseMessage = new ResponseMessage();
        Artist artist = artistService.selectById(id);
        responseMessage.setCode("0");
        responseMessage.setDescription("成功");
        responseMessage.setMessageBody(artist);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ResponseMessage dropDownList(){
        ResponseMessage<List> responseMessage = new ResponseMessage();
        List<Artist> artists = artistService.selectDropDownList();
        responseMessage.setCode("0");
        responseMessage.setDescription("成功");
        responseMessage.setMessageBody(artists);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/all", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ResponseMessage selectAll(@RequestBody ArtistQueryParam queryParam){
        ResponseMessage<List> responseMessage = new ResponseMessage();
        List<Artist> allArtist = artistService.selectByParam(queryParam);
        responseMessage.setCode("0");
        responseMessage.setDescription("成功");
        responseMessage.setMessageBody(allArtist);
        return responseMessage;
    }


    @ResponseBody
    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ResponseMessage updateArtistSelective(@RequestBody Artist artist){
        ResponseMessage<Void> responseMessage = new ResponseMessage();
        if(artistService.updateByIdSelective(artist)) {
            responseMessage.setCode("0");
            responseMessage.setDescription("成功");
        } else {
            responseMessage.setCode("-1");
            responseMessage.setDescription("失败");
        }
        return responseMessage;
    }

}
