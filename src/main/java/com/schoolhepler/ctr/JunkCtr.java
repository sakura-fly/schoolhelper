package com.schoolhepler.ctr;

import com.schoolhepler.model.Junk;
import com.schoolhepler.model.response.ResponseListModel;
import com.schoolhepler.service.impl.JunkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/junk")
public class JunkCtr {

    @Resource
    private JunkService junkService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseListModel<Junk> list() {
        return junkService.list(new Junk());
    }

}
