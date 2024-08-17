package com.surekshya.jobApplication.controller;

import com.surekshya.jobApplication.dto.request.AddressRequestDto;
import com.surekshya.jobApplication.dto.request.ApplicationRequestDto;
import com.surekshya.jobApplication.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class WebController {

    private static final Logger log = LogManager.getLogger(WebController.class);
    private final ApplicationService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("jobApplicationForm", new ApplicationRequestDto());

        return "index";
    }

    @PostMapping("/webJobApplications")
    public String submitForm(@ModelAttribute("ApplicationRequestDto") ApplicationRequestDto applicationRequest) {
        log.info("Saving application:{} ",applicationRequest);
        service.saveJobApplicant(applicationRequest);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success(Model model) {
        ApplicationRequestDto applicationRequestDto = new ApplicationRequestDto();
        applicationRequestDto.setAddressRequest(new AddressRequestDto());
        model.addAttribute("tableViewOfApplicant", service.findAllApplicant());

        Map<String, Long> applicantsByStateMap = service.getApplicantsCountByStateMap();
        model.addAttribute("applicantsByStateMap", applicantsByStateMap);

        return "success";
    }


}
