package com.shenzhen.teamway.iotaccessproxy.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @program: iot-access
 * @description:
 * @author: liuhanru
 * @create: 2019-06-20 14:02
 **/
@Controller
public class IotAccessController {

    @Autowired
    private RestTemplate restTemplate;

    private String urlRest = "http://192.168.0.127:8080/";

    //=================================出入口管理===============================
    //显示各出入口人员进出统计信息的接口
    @PostMapping("/getCountPersonOfChannel")
    @ResponseBody
    public String getCountPersonOfChannel(){
        String countPersonOfChannelInfo = restTemplate.postForObject(urlRest, null, String.class);
        return countPersonOfChannelInfo;
    }

    //显示各出入口车辆进出统计信息
    @PostMapping("/getCountCarOfChannel")
    @ResponseBody
    public String getCountCarOfChannel(){
        String countCarOfChannelInfo = restTemplate.postForObject(urlRest, null, String.class);
        return countCarOfChannelInfo;
    }

    //显示各出入口门闸通道状态
    @PostMapping("/getDoorStatus")
    @ResponseBody
    public String getDoorStatus(){
        String doorStatus = restTemplate.postForObject(urlRest, null, String.class);
        return doorStatus;
    }

    //显示各出入口道闸通道状态
    @PostMapping("/getBarrierStatus")
    @ResponseBody
    public String getBarrierStatus(){
        String barrierStatus = restTemplate.postForObject(urlRest, null, String.class);
        return barrierStatus;
    }

    //控制出入口门闸、道闸，开门、关门、常开、常闭
    @PostMapping("/updateDoorStatus")
    @ResponseBody
    public Integer updateDoorStatus(String deviceType, Integer channelIndex, String deviceStatus){
        JSONObject json = new JSONObject();
        json.put("deviceType", deviceType);
        json.put("channelIndex", channelIndex);
        json.put("deviceStatus", deviceStatus);

        int resultFlag =  restTemplate.postForObject(urlRest, json, Integer.class);
        return resultFlag;
    }

    //显示出入口实时事件
    @PostMapping("/getRealTimeStatus")
    @ResponseBody
    public String getRealTimeStatus(){
        String realTimeStatus = restTemplate.postForObject(urlRest, null, String.class);
        return realTimeStatus;
    }


    //=================================门禁管理===============================

    //显示各房间人员进出统计信息
    @PostMapping("/getCountPersonOfDoor")
    @ResponseBody
    public String getCountPersonOfDoor(){
        String countPersonOfDoor = restTemplate.postForObject(urlRest, null, String.class);
        return countPersonOfDoor;
    }

    //显示重要位置进出统计信息
    @PostMapping("/getImportantDoorInfo")
    @ResponseBody
    public String getImportantDoorInfo(String door, Integer channelIndex){
        JSONObject json =  new JSONObject();
        json.put("door", door);
        json.put("channelIndex", channelIndex);
        String importantDoorInfo = restTemplate.postForObject(urlRest, json, String.class);
        return importantDoorInfo;
    }

   //显示重要位置人员实时统计信息
   @PostMapping("/getPersonInfoOfImportantDoor")
   @ResponseBody
   public String getPersonInfoOfImportantDoor(String door, Integer channelIndex){
       JSONObject json =  new JSONObject();
       json.put("door", door);
       json.put("channelIndex", channelIndex);
       String personInfoOfImportantDoor = restTemplate.postForObject(urlRest, json, String.class);
       return personInfoOfImportantDoor;
   }

   //显示门禁状态
    @PostMapping("/getOneDoorStatus")
    @ResponseBody
    public String getOneDoorStatus(String door, Integer channelIndex){
        JSONObject json =  new JSONObject();
        json.put("door", door);
        json.put("channelIndex", channelIndex);
        String oneDoorStatus = restTemplate.postForObject(urlRest, json, String.class);
        return oneDoorStatus;
    }

    //控制门禁，开门、关门、常开、常闭
    @PostMapping("/updateOneDoorStatus")
    @ResponseBody
    public Integer updateOneDoorStatus(String door, Integer channelIndex, String deviceStatus){

        JSONObject json = new JSONObject();
        json.put("deviceType", door);
        json.put("channelIndex", channelIndex);
        json.put("deviceStatus", deviceStatus);

        int result = restTemplate.postForObject(urlRest, json, Integer.class);
        return  result;
    }

    //能显示门禁事件
    @RequestMapping("/getDoorRealTimeStatus")
    @ResponseBody
    public String getDoorRealTimeStatus(){
        String doorRealTimeStatus = restTemplate.postForObject(urlRest, null, String.class);
        return doorRealTimeStatus;
    }


}