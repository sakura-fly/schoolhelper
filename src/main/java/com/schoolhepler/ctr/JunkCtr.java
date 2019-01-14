package com.schoolhepler.ctr;

import com.schoolhepler.model.Junk;
import com.schoolhepler.model.response.ResponseListModel;
import com.schoolhepler.model.response.ResponseModel;
import com.schoolhepler.model.response.ResponseOneModel;
import com.schoolhepler.service.impl.JunkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/junk")
public class JunkCtr {

    @Resource
    private JunkService junkService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseListModel<Junk> list(Junk junk) {
        return junkService.list(junk);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseOneModel<Junk> find(Junk junk) {
        return junkService.find(junk);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel add(Junk junk) {
        junk.setTime(new Date());
        return junkService.add(junk);
    }


}
