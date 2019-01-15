package com.schoolhepler.ctr;

import com.schoolhepler.model.LostThing;
import com.schoolhepler.model.response.ResponseListModel;
import com.schoolhepler.model.response.ResponseModel;
import com.schoolhepler.model.response.ResponseOneModel;
import com.schoolhepler.service.impl.LostThingService;
import com.schoolhepler.service.impl.LostThingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/lostthing")
public class LostThingCtr {
    @Resource
    private LostThingService lostThingService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseListModel<LostThing> list(LostThing lostThing) {
        return lostThingService.query(lostThing);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseOneModel<LostThing> find(LostThing lostThing) {
        return lostThingService.find(lostThing);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel add(LostThing lostThing, MultipartFile picfile, HttpSession session) {
        try {
            String path = session.getServletContext().getRealPath("/pic");
            String fileName = UUID.randomUUID().toString() + picfile.getOriginalFilename().substring(picfile.getOriginalFilename().lastIndexOf("."));
            lostThing.setPic("/pic/" + fileName);
            File f = new File(path, fileName);
            picfile.transferTo(f);
        } catch (Exception e) {
            ResponseModel r = new ResponseModel();
            r.setMsg("pic err");
            r.setCode(-3);
            e.printStackTrace();
            return r;
        }
        lostThing.setTime(new Date());
        return lostThingService.add(lostThing);
    }

}
