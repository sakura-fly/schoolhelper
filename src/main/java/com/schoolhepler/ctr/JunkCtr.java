package com.schoolhepler.ctr;

import com.schoolhepler.model.Junk;
import com.schoolhepler.model.response.ResponseListModel;
import com.schoolhepler.model.response.ResponseModel;
import com.schoolhepler.model.response.ResponseOneModel;
import com.schoolhepler.service.impl.JunkService;
import com.schoolhepler.util.BaseFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/junk")
public class JunkCtr {

    @Resource
    private JunkService junkService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseListModel<Junk> list(Junk junk) {
        return junkService.query(junk);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseOneModel<Junk> find(Junk junk) {
        return junkService.find(junk);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel add(Junk junk, String picfile, HttpSession session) {
        try {
            String path = session.getServletContext().getRealPath("/pic");
            File f = new File(path);
            if (!f.exists()){
                f.mkdirs();
            }
            String fileName = UUID.randomUUID().toString() + ".jpg";
            junk.setPic("/pic/" + fileName);
            BaseFileUtil.base64ToFile(path,picfile,fileName);
        } catch (Exception e) {
            ResponseModel r = new ResponseModel();
            r.setMsg("pic err");
            r.setCode(-3);
            e.printStackTrace();
            return r;
        }
        junk.setTime(new Date());
        return junkService.add(junk);
    }


}
