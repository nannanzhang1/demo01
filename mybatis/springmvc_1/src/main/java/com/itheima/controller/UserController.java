package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user")//
public class UserController {
    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = "username")
    public String save(){
        System.out.println("Controller save running");
        return"success";
    }

    @RequestMapping(value = " quick2")
    @ResponseBody
    public ModelAndView save2(){
        ModelAndView modelAndView = new ModelAndView();
        /*
        * model 模型数据
        * view 数据名称*/
        modelAndView.addObject("success","itcast");
        modelAndView.setViewName("success");
        System.out.println("8888888888888888");
        return modelAndView;

    }
    //在controller中方法形参上直接声明ModelAndView，无需在方法中自己创建
    //在方法中直接使用该对象设置视图，同样可以条状页面
    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","itheima");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    /*
    * 在controller方法的形参上可以直接使用原生的HttpServletRequest对象
    * 只需声明即可*/
    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","酷丁鱼");
        return "success";
    }
    /*通过SpringMVC框架注入的response对象，使用response.getWriter().print("hello world)
    * 回写数据，此时不需要试图转入，业务方法返回值为void
    * 将需要回写的字符串直接返回，但此时需要通过@ResponseBody注解告知SpringMVC框架，方法返回的字符串不是跳转是直接http响应体中返回*/
    @RequestMapping(value = "/quick7")
    @ResponseBody//告知Spring框架 不进行试图跳转 直接进行数据响应
    public String save7(){
        return "hello itheima";
    }
    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello itcast");
    }
    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8(){
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }
    /*
    * 手动拼接json格式字符串的方式很麻烦，开发中往往要将复杂的java对象转换成json格式的字符串，
    * 我们可以使用web阶段学习过的json转换工具jackson进行转换,通过jackson转换json格式字符串，回写字符串*/
    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(20);
        //使用json的转换工具将对象转换成json格式字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }
    /*
    * 参数：文件项使用MultipartFile对象来表示，并且参数名和文件项的name属性的值是一致的) MultipartFile的API使用：
    * getOriginalFilename() :获取文件的名称
    * transferTo(File file) :将文件存储到指定位置*/
    @RequestMapping("/quickk22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile) throws Exception {
        System.out.println(username);
        String s = uploadFile.getOriginalFilename();
        System.out.println(s);
        uploadFile.transferTo(new File("D:\\bb.txt"));
        System.out.println(uploadFile);
    }





    @RequestMapping("/taget")
    public ModelAndView show(){
        System.out.println("目标资源执行。。。");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","itcast");
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
