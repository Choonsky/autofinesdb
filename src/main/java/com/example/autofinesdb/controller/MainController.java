package com.example.autofinesdb.controller;

import com.example.autofinesdb.model.*;
import com.example.autofinesdb.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.format.DateTimeFormatter;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private FineRepo fineRepo;

    @Autowired
    private TypeRepo typeRepo;

    @RequestMapping("/main")
    public ModelAndView getMain() {

        ModelAndView modelAndView = new ModelAndView("main");

// fetching all fines...
        List<Fine> fines = new ArrayList<>(fineRepo.findAll());
        Collections.sort(fines, Comparator.comparing(Fine::getDate));
        modelAndView.addObject("fines", fines);

// fetching all types...
        List<Type> types = new ArrayList<>(typeRepo.findAll());
        Collections.sort(types, Comparator.comparing(Type::getId));
        modelAndView.addObject("types", types);

// fetching popular types...
        fines.forEach(fine -> {
            fine.getType().setQty(fine.getType().getQty() + 1);
        });
        List<Type> typesPopular = new ArrayList<>(typeRepo.findFirst5OrderByQty());
        modelAndView.addObject("typesPopular", typesPopular);

// fetching all cars...
        List<Car> cars = new ArrayList<>(carRepo.findAll());
        modelAndView.addObject("cars", cars);

// fetching all drivers...
        List<Driver> drivers = new ArrayList<>(driverRepo.findAll());
        modelAndView.addObject("drivers", drivers);

// let's see what we have done...
        return modelAndView;
    }
}