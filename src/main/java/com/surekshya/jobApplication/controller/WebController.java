package com.surekshya.jobApplication.controller;

import com.surekshya.jobApplication.dto.request.AddressRequestDto;
import com.surekshya.jobApplication.dto.request.ApplicationRequestDto;
import com.surekshya.jobApplication.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor

public class WebController {

    private final ApplicationService service;
//
//    @GetMapping
//    public String showForm(Model model) {
//        model.addAttribute("test","this is test message from controller");
//        return "people"; // Ensure this matches your HTML template name
//    }

    @GetMapping("/")
    public String index(Model model) {
        ApplicationRequestDto applicationRequestDto = new ApplicationRequestDto();
        applicationRequestDto.setAddressRequest(new AddressRequestDto());
        model.addAttribute("jobApplicationForm", new ApplicationRequestDto());
        model.addAttribute("tableViewOfApplicant", service.getApplicantByState("MN"));
        return "index";
    }


    @PostMapping("/webJobApplications")
    public String submitForm(@ModelAttribute("ApplicationRequestDto") ApplicationRequestDto applicationRequest) {
        System.out.println("Saving application: " + applicationRequest);
        service.saveJobApplicant(applicationRequest);
        return "redirect:/success";
    }

}
