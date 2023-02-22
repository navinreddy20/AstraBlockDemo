package com.telusko.AstraBlockDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    ConnectDatabase db = new ConnectDatabase();

    @RequestMapping("/tokens")
    @ResponseBody
    public List<String> getValue()
    {
        List<String> values = db.getValue();
        return values;
    }

}
