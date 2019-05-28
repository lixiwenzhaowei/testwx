package com.softlab.wx.web.api;

import com.softlab.wx.common.RestData;
import com.softlab.wx.core.mapper.ColleageTimeMapper;
import com.softlab.wx.core.model.vo.ColleageContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by LiXiwen on 2019/3/28 13:45.
 **/

/**
 * 版本信息
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class VersionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ColleageTimeMapper colleageTimeMapper;
    @Autowired
    public VersionController(ColleageTimeMapper colleageTimeMapper){
        this.colleageTimeMapper=colleageTimeMapper;
    }

    /**
     * 版本控制
     * @return
     */
    @RequestMapping(value = "/version",method = RequestMethod.GET)
    public RestData VersionControll(){
        HashMap<String,String> hashMap=new HashMap<>();
        String version="V1.0.0";
        String data="东北林业大学党委学生工作部官方内测版发布，六大基础功能全部上线。\n";
        hashMap.put("version",version);
        hashMap.put("data",data);
        return new RestData(hashMap);
    }


}
