package ru.itis.trofimoff.controller;

import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HEAD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import ru.itis.trofimoff.utils.HeaderResolver;
import ru.itis.trofimoff.utils.IpResolver;

@Controller
public class DefaultController {

  @Autowired
  private HeaderResolver headerResolver;

  @Autowired
  private IpResolver ipResolver;
  
  @Autowired
  private LocaleResolver localeResolver;
  
  @Autowired
  private HttpServletRequest request;
  
  @Autowired
  private HttpServletResponse response;
  
  /**
   * MessageSource could be used but MessageSourceAccessor is more convinient.
   */
  private MessageSourceAccessor msa;
  
  @Autowired
  private void setMessageSourceAccessor(MessageSource ms){
    this.msa = new MessageSourceAccessor(ms);
  }
  
  @RequestMapping("/")
  public String index(ModelMap map){
    map.put("message0", this.msa.getMessage("controller.message"));
    map.put("message1", this.msa.getMessage("controller.param.message", new Double[]{9.78}));
    return "index";
  }
  
  @RequestMapping("/change")
  public String change(@RequestParam String locale, @RequestHeader() Map<String, String> headers, HttpServletRequest request){

    // sets lang with using accept-language header
    String[] localeInfo = headerResolver.resolveLocale(headers.get("accept-language"));
    localeResolver.setLocale(request, response, new Locale(localeInfo[0], localeInfo[1]));

    /*
    // sets lang with using ip address
    String[] localeIpInfo = ipResolver.resolveLocale(request.getRemoteAddr());
    localeResolver.setLocale(request, response, new Locale(localeIpInfo[0], localeIpInfo[1]));
     */

    /*
    // sets land by request param
    String[] localeData = locale.split("_");
    localeResolver.setLocale(request, response, new Locale(localeData[0], localeData[1]));
     */

    return "redirect:" + MvcUriComponentsBuilder.fromMappingName("DC#index").build();
  }
}
