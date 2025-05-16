package com.spring.professional.exam.tutorial.module05.question10.controller;

import com.spring.professional.exam.tutorial.module05.question10.dao.AddressDao;
import com.spring.professional.exam.tutorial.module05.question10.ds.Address;
import com.spring.professional.exam.tutorial.module05.question10.ds.Country;
import com.spring.professional.exam.tutorial.module05.question10.ds.Person;
import com.spring.professional.exam.tutorial.module05.question10.ds.ShortAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes({"person", "shortAddress", "country"})
public class Example11SessionAttributes {

    @Autowired
    private AddressDao addressDao;

    // Visit http://localhost:8080/example11 in your browser
    // John	Doe
    // 455 Larkspur Dr. Apt 23
    // Baviera	CA	92908	United States
    @GetMapping("/example11")
    public String example11(Model model) {
        model.addAttribute("addresses", addressDao.findAll());

        return "addresses-list";
    }

    // This is a first step in multi step address submission
    @GetMapping("/example11/address/step1")
    public String example11Step1(@ModelAttribute("person") Person person) {
        return "address-form-step1";
    }

    // This is a post submission method for first step of multi step address submission
    @PostMapping("/example11/address/step1")
    public String example11Step1(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "address-form-step1";
        else
            return "redirect:/example11/address/step2";
    }

    // This is a second step in multi step address submission
    @GetMapping("/example11/address/step2")
    public String example11Step2(@ModelAttribute("shortAddress") ShortAddress shortAddress) {
        return "address-form-step2";
    }

    // This is a post submission method for second step of multi step address submission
    @PostMapping("/example11/address/step2")
    public String example11Step2(@ModelAttribute("shortAddress") @Valid ShortAddress shortAddress, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "address-form-step2";
        else
            return "redirect:/example11/address/step3";
    }

    // This is a third step in multi step address submission
    @GetMapping("/example11/address/step3")
    public String example11Step3(@ModelAttribute("country") Country country) {
        return "address-form-step3";
    }

    // This is a post submission method for third step of multi step address submission
    @PostMapping("/example11/address/step3")
    public String example11Step3(@ModelAttribute("country") @Valid Country country, BindingResult bindingResult, @ModelAttribute("shortAddress") ShortAddress shortAddress, @ModelAttribute("person") Person person, SessionStatus sessionStatus) {
        if (bindingResult.hasErrors())
            return "address-form-step3";
        else {
            Address address = new Address(person, shortAddress, country);
            addressDao.save(address);
            sessionStatus.setComplete();

            return "redirect:/example11";
        }
    }

    @ModelAttribute("person")
    public Person person() {
        return new Person();
    }

    @ModelAttribute("shortAddress")
    public ShortAddress shortAddress() {
        return new ShortAddress();
    }

    @ModelAttribute("country")
    public Country country() {
        return new Country();
    }
}
