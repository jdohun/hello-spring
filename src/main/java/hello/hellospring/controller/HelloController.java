package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // 정적 페이지
    //http://localhost:8080/hello
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    // MVC 방식 -> viewResolver 작동
    //http://localhost:8080/hello-mvc?name=string
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    
    // API 방식
    //http://localhost:8080/hello-string?name=spring
    @GetMapping("hello-string")
    @ResponseBody //html의 body 부분이 아닌 http에서 header와 body 중 body 부분에 값을 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // 소스 원본을 봤을 때 HTML 태그가 존재하지 않음
    }

    // HttpMessageConverter 작동 -> JsonConverter, StringConverter
    // 기본 문자처리 : StringHttpMessageConverter, 기본 객체처리 : MappingJackson2HttpMessageConverter
    //http://localhost:8080/hello-api?name=spring
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // // json 방식
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
