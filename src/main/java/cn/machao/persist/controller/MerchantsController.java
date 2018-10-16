package cn.machao.persist.controller;

import cn.machao.persist.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/merchants")
public class MerchantsController {

    private static final Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    @RequestMapping(value = "/settle", method = RequestMethod.POST)
    public void Settle(@RequestParam("images")MultipartFile[] images, String merchantName) {
        System.out.println(images);
        System.out.println(merchantName);
    }
}
