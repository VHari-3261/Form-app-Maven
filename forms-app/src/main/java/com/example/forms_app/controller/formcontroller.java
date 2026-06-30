package com.example.forms_app.controller;

import com.example.forms_app.model.userform;
import com.example.forms_app.repository.submissionrepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String submitform(@Valid @ModelAttribute("userform") userform userform, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        try {
            submission.save(userform);
            model.addAttribute("submittedData",userform);
            return "success";
        } catch (Exception e) {
            model.addAttribute("error", "Error saving form: " + e.getMessage());
            return "form";
        }
    }
}
