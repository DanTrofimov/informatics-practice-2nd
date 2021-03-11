package ru.itis.trofimoff.springcontrollers.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

@Controller
@RequestMapping("/tests")
public class DefaultController {

  @RequestMapping("/rest")
  public String restTest(Model model) {
    System.out.println(model);
    return "tests";
  }

  @RequestMapping
  public String index(ModelMap map) {
    map.put("viewVariable", "Index action");
    return "tests";
  }
  
  @RequestMapping("/s")
  public String simple(ModelMap map) {
    map.put("viewVariable", "Just simple action");
    return "tests";
  }
  
  @RequestMapping( { "/s1" , "/s2" } )
  public String simpleMultiple(ModelMap map) {
    map.put("viewVariable", "Just simple action for 2 addresses");
    return "tests";
  }
  
  @RequestMapping("/rb")
  @ResponseBody
  public String responseBody(){
    return "The only text on a page is this text - @ResponseBody annotation.";
  }
  
  @RequestMapping("/writer")
  public void writer(java.io.Writer writer) throws IOException{
    writer.write("This is plain/text done with java.io.Writer");
  }
  
  @RequestMapping("/rs")
  @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
  public String responseStatus(ModelMap map){
    map.put("viewVariable", "What do you want from me? I'm a teapot!");
    return "tests";
  }

  @RequestMapping(
    value = "/rmb",
    method = RequestMethod.GET,
    headers = "!user-agent=Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:36.0) Gecko/20100101 Firefox/36.0",
    params = "secret_param=1"
  )
  public String requestMappingBunch(ModelMap map) {
    map.put("viewVariable", "Page with secret_param for not Mozilla 36 on Linux");
    return "tests";
  }

  @RequestMapping("/rp")
  public String requestParam(@RequestParam String param, ModelMap map) {
    map.put("viewVariable", "Request parameter:<br>" + param );
    return "tests";
  }
  @RequestMapping("/rp/{param}")
  public String requestVar(@PathVariable String param, ModelMap map) {
    map.put("viewVariable", "Request parameter:<br>" + param );
    return "tests";
  }

  @RequestMapping("/rpb")
  public String requestParamBanch(
    @RequestParam(
      value        = "special_name",
      required     = false,
      defaultValue = "Default value"
    ) String param,
    ModelMap map
  ) {
    map.put("viewVariable", "Request parameter:<br>" + param );
    return "tests";
  }
  
  @RequestMapping("/pv/{param}")
  public String pathVariable(@PathVariable String param, ModelMap map){
    map.put("viewVariable", "Path variable:<br>" + param );
    return "tests";
  }
  
  @RequestMapping("/pvb/{param_special_name}/{param2}/path")
  public String pathVariableBunch(
    @PathVariable(
      value = "param_special_name"
    ) String param,
    @PathVariable String param2,
    ModelMap map
  ){
    map.put("viewVariable", "Path variable:<br>" + param );
    return "tests";
  }

  // fixme: hw
  
  @RequestMapping("/rh")
  public String requestHeader(@RequestHeader() Map<String, String> headers, ModelMap map) {

    ArrayList<Header> headersResult = new ArrayList<>();

    headers.forEach((key, value) -> {
      headersResult.add(new Header(key, value));
    });

    map.put("allHeaders", headersResult);

    return "tests";
  }

  @RequestMapping(
          value = "/request-param",
          method = RequestMethod.GET,
          headers = "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36"
  )
  public String requestMappingBunchWithParam(@RequestParam(
          value        = "special_param",
          required     = true
  ) String param, ModelMap map) {
    map.put("viewVariable", "Page with secret_param for Chrome 88 on Windows, special param: " + param);
    return "tests";
  }
}

/*
  TODO: 1) RequestParam для определенного браузера
        2) Вывести все заголовки используя request header
 */

/*
  TODO:
    1) статическая форма
    2) валидация в котроллере, берет из запроса параметры
    3) запись в БД или куда-то еще
    -- 3 бина, validator, dao, repo --
 */