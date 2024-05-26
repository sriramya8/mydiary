package org.example.mydiarysb.controller;

import jakarta.servlet.http.HttpSession;
import org.example.mydiarysb.entity.Entry;
import org.example.mydiarysb.entity.User;
import org.example.mydiarysb.service.EntryService;
import org.example.mydiarysb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EntryService entryService;
    @Autowired
    private UserService userService;
    @Autowired
    HttpSession session;
    @GetMapping("/")
    public String getLoginPage(){
        return "loginpage";
    }
    @PostMapping("home")
    public String home(@RequestParam("username") String username,@RequestParam("password") String password,Model model){
        User user1=userService.findbyUsername(username);
        if(user1==null){
            model.addAttribute("error","User not found");
            return "loginpage";
        }

        else if(user1.getPassword().equals(password)){
            session.setAttribute("user",user1);
            model.addAttribute("user",user1);
            long id=user1.getId();
            List<Entry> entries= entryService.findByUserid(id);
            if(entries==null || entries.isEmpty()){
                model.addAttribute("noItems","Please start adding your valuable memories");
            }else {
                model.addAttribute("entries", entries);
            }
            return "homepage";
        }
        else{
            model.addAttribute("error","Wrong password");
            return "loginpage";

        }

    }
    @GetMapping("login")
    public String login(){
        return "loginpage";
    }
    @GetMapping("signup")
    public String signup(Model model){
        return "signuppage";
    }
    @PostMapping("saveuser")
    public String saveuser(@ModelAttribute("user") User user,Model model){
        userService.save(user);
        return "loginpage";
    }
    @GetMapping ("entries")
    public String getEntriesPage(){
        return "addentriespage";
    }
    @PostMapping("save")
    public String saveEntry(@ModelAttribute("entry") Entry entry,Model model){
        entryService.save(entry);
        User user=(User)session.getAttribute("user");
        if(user==null){
            return "loginpage";
        }
        List<Entry> entries= entryService.findByUserid(user.getId());
        if(entries==null || entries.isEmpty()){
            model.addAttribute("noItems","Please start adding your valuable memories");
        }else {
            model.addAttribute("entries", entries);
        }
        return "homepage";
    }
    @GetMapping("view")
    public String viewEntry(@RequestParam("id") int id,Model model){

        Entry entry=entryService.find(id);
        model.addAttribute("entry",entry);
        return "viewpage";
    }
    @GetMapping("myhome")
    public String myHome(Model model){

        User user1=(User)session.getAttribute("user");
        if(user1==null){
            return "loginpage";
        }
        long id=user1.getId();
        List<Entry> entries= entryService.findByUserid(id);
        if(entries==null || entries.isEmpty()){
            model.addAttribute("noItems","Please start adding your valuable memories");
        }else {
            model.addAttribute("entries", entries);
        }
        return "homepage";
    }
    @GetMapping("update")
    public String updateEntry(@RequestParam("id") int id,Model model){
        User user= (User)session.getAttribute("user");
        if(user==null){
            return "loginpage";
        }
        Entry entry=entryService.find(id);
        model.addAttribute("entry",entry);
        return "updatepage";
    }
    @PostMapping("saveupdate")
    public String saveUpdate(@ModelAttribute("entry") Entry entry,Model model) {
        entryService.save(entry);
        User user=(User)session.getAttribute("user");
        if(user==null){
            return "loginpage";
        }
        List<Entry> entries= entryService.findByUserid(user.getId());
        if(entries==null || entries.isEmpty()){
            model.addAttribute("noItems","Please start adding your valuable memories");
        }else {
            model.addAttribute("entries", entries);
        }

        return "homepage";

    }
    @GetMapping("delete")
    public String deleteEntry(@RequestParam("id") int id,Model model){

        Entry entry= entryService.find(id);
        entryService.delete(entry);
        User user=(User)session.getAttribute("user");
        if(user==null){
            return "loginpage";
        }
        List<Entry> entries= entryService.findByUserid(user.getId());
        if(entries==null || entries.isEmpty()){
            model.addAttribute("noItems","Please start adding your valuable memories");
        }else {
            model.addAttribute("entries", entries);
        }

        return "homepage";
    }
    @GetMapping("logout")
    public String logout(Model model){
        session.invalidate();
        return "loginpage";
    }

}
