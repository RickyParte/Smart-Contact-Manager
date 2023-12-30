package com.contactmanager.controllers;

import com.contactmanager.dao.UserRepository;
import com.contactmanager.entities.User;
import com.contactmanager.utils.Message;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ContactController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/home")
    public String testing(Model model){
        model.addAttribute("title","Hii Ricky");
        return "home";
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/signup")
    public String register(){
        return "signup";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value={"/do-signup","/signup.html"},method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, HttpSession session){
        try {
            if(bindingResult.hasErrors()){
                List<String> errors=convertBindingResultToString(bindingResult);
                model.addAttribute("size",errors.size());
                model.addAttribute("errors",errors);
                model.addAttribute("user",user);
                return "signup";
            }

            user.setEnable(true);
            User saveUser=userRepository.save(user);
            if(saveUser!=null){
                session.setAttribute("message",new Message("Register Successfully!!!", "alert-success"));
                return "signup";
            }

        }catch (Exception e){
            e.printStackTrace();
            session.setAttribute("message",new Message("Something Went Wrong!!!!"+e.getMessage(),"alert-danger"));
            model.addAttribute("user",user);
        }

        return "signup";
    }
    private List<String> convertBindingResultToString(BindingResult bindingResult) {

        List<String> errors=new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.add(fieldError.getDefaultMessage());
        }

        return errors;
    }

}
