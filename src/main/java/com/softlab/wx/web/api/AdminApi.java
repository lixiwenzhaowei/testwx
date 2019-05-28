package com.softlab.wx.web.api;

import com.softlab.wx.common.RestData;
import com.softlab.wx.common.WxException;
import com.softlab.wx.service.AreaService;
import com.softlab.wx.service.FanKuiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by LiXiwen on 2019/5/27 20:24.
 **/
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class AdminApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AreaService areaService;

    @Autowired
    private FanKuiService fanKuiService;

    @RequestMapping(value = "/selectAllFanKui" , method = RequestMethod.GET)
    public RestData selectAllFanKui(){
        try{
            List<Map<String,Object>> data = fanKuiService.selectAllFanKui();
            return new RestData(data);
        }catch (WxException e){
            return new RestData(1,e.getMessage());
        }
    }


    @RequestMapping(value = "/selectAllArea" , method = RequestMethod.GET)
    public RestData selectAllArea(){
        try{
            List<Map<String,Object>> data = areaService.selectAllArea();
            return new RestData(data);
        }catch (WxException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteArea" , method = RequestMethod.GET)
    public RestData deleteArea(@RequestParam("id") Integer id){
        int a =areaService.deleteAreaById(id);
        if(0 != a){
            return new RestData(0,"success");
        }else{
            return new RestData(1,"error");
        }
    }

    @RequestMapping(value = "/deleteFan" , method = RequestMethod.GET)
    public RestData deleteFan(@RequestParam("id") Integer id){
        int a =fanKuiService.deleteFanKui(id);
        if(0 != a){
            return new RestData(0,"success");
        }else{
            return new RestData(1,"error");
        }
    }

}
