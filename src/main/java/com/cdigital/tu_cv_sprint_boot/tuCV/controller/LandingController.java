package com.cdigital.tu_cv_sprint_boot.tuCV.controller;

import com.cdigital.tu_cv_sprint_boot.tuCV.model.CvData;
import com.cdigital.tu_cv_sprint_boot.tuCV.service.CvInitializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class LandingController {

    private final CvInitializationService cvInitializationService;

    @GetMapping("/")
    public String redirectToForm(){
        return "redirect:/cv-form";
    }

    @GetMapping("/cv-form")
    public String showFormCV(Model model){
        CvData cvData = cvInitializationService.initialiceCvData();

        //model.addAttribute("firstName",cvData.getPersonalDetails().getFirstName()); // pasa un atributo
        model.addAttribute("cvData",cvData);// pasa un objeto
        return "cv-form";
    }

    @PostMapping("/generate-cv")
    public String generateCv(@ModelAttribute CvData cvData, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("cvData", cvData);
        return "redirect:cv-display";
    }

    @GetMapping("/cv-display")
    public String displayCv(@ModelAttribute("cvData") CvData cvData, Model model){
        if(cvData.getPersonalDetails() == null){
            cvData = cvInitializationService.initialiceCvData();
        }
        model.addAttribute("cvData", cvData);
        return "index";
    }





























}
