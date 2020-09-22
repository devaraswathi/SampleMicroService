package com.kroger.samplemicroservice.samplemicroservice.service.model;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public ResponseObject getResponse(String arg) {
        boolean flag;
        if (arg.equalsIgnoreCase("hello world")){
            flag = true;
        }else{
            flag = false;
        }
        ResponseObject res = new ResponseObject();
        res.setFlag(flag);
        res.setMessage("Response is successfully retrieved");
        return res;
    }
}
