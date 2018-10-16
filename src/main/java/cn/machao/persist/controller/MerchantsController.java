package cn.machao.persist.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/merchants")
public class MerchantsController {

    @RequestMapping(value = "/settle", method = RequestMethod.POST)
    public void Settle(@RequestParam("images")MultipartFile[] images, String merchName) {
        System.out.println(images);
        System.out.println(merchName);
    }
}
