package com.benjamin.test;

import com.benjamin.websocket.entity.StringIdentity;
import com.benjamin.websocket.router.WebSocketRouter;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by benjamin on 11/26/14.
 */
@RestController
public class TestController {
  @Resource(name = "webSocketRouter")
  private WebSocketRouter webSocketRouter;
  @RequestMapping("/hello")
  public String sayHelloWorld(){
    return "Hello World+Abcdefg";
  }

  @RequestMapping("/hello1")
  @ResponseBody
  public JSONObject sayHelloWorld1(){
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("hello", "world");
    return jsonObject;
  }

  @RequestMapping("/hello2")
  @ResponseBody
  public List sayHelloWorld2(){
    List list = new ArrayList();
    list.add("hello");
    list.add("world");
    list.add("!");
    return list;
  }

  @RequestMapping("/hello3")
  @ResponseBody
  public Map sayHelloWorld3(){
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "hello");
    map.put("2", "world");
    map.put("3", "!");
    return map;
  }

  @RequestMapping("/send")
  public JSONObject sendMessage(@RequestParam String id, @RequestParam String message){
    TextMessage textMessage = new TextMessage(message);
    StringIdentity identity = new StringIdentity(id);
    return webSocketRouter.dispatcherMessage(identity, textMessage);
  }
}
