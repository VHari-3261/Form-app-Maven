package com.example.forms_app.controller;

import com.example.forms_app.model.userform;
import com.example.forms_app.repository.submissionrepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller 
public class formcontroller 
{
    private final submissionrepository submission;

    public formcontroller(submissionrepository submission)
    {
        this.submission=submission;
    }
    @GetMapping("/")
    public String ShowForm(Model model)
    {
        model.addAttribute("userform",new userform());
        return "form";
    }
    @PostMapping("/submit")
    public String submitform(@ModelAttribute("userform") userform userform,Model model)
    {
        submission.save(userform);
        model.addAttribute("submittedData",userform);
        return "success";
    }
}
