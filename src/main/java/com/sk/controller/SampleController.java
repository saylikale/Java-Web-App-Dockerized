package com.sk.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SampleController {
    @RequestMapping(value = "/getJson", method = RequestMethod.GET)
    @ResponseBody
    String uploadImage(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
            throws JSONException {
System.out.println(":::MEthod calling:::");
        JSONObject js = new JSONObject();
        js.put("Name", "Sayali Kale");
        js.put("Technology", "DevOps  ");

        return js.toString();

    }
}
