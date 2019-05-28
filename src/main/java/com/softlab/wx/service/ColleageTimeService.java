package com.softlab.wx.service;

import com.softlab.wx.core.model.vo.ColleageContent;

import java.util.HashMap;

/**
 *
 * Created by LiXiwen on 2019/3/25.
 *
 **/
public interface ColleageTimeService {

    //图标
    HashMap<String,String> search();
    //tip
    HashMap<String,String> selectTip();
    //tip/detail
    //内容
    HashMap<String,Object> selectContent(String tu);

    boolean updateColleageContent(ColleageContent colleageContent);
}
