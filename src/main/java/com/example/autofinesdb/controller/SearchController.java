package com.example.autofinesdb.controller;

import com.example.autofinesdb.model.*;
import com.example.autofinesdb.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class SearchController {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private FineRepo fineRepo;

    @Autowired
    private TypeRepo typeRepo;

    @RequestMapping("/byname")
    public ModelAndView searchByName(@RequestParam(value = "searchString") String searchString,
                                HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("results");

// fetching a driver by name
        Driver driver = driverRepo.findOneByFullname(searchString);

// fetching all cars by driver
        List<Car> cars = new ArrayList<>(carRepo.findAllByDriver(driver));

// fetching all fines...
        List<Fine> fines = new ArrayList<>();
        cars.forEach(car -> {
            fines.addAll(fineRepo.findAllByCar(car));
                });
        modelAndView.addObject("finesResult", fines);
        modelAndView.addObject("searchString", searchString);

// let's see what we have done...
        return modelAndView;
    }

    @RequestMapping("/byplate")
    public ModelAndView searchByPlate(@RequestParam(value = "searchString") String searchString,
                                     HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("results");

// fetching a car
        Car car = carRepo.findOneByPlate(searchString);

// fetching all fines...
        List<Fine> fines = fineRepo.findAllByCar(car);
        modelAndView.addObject("finesResult", fines);
        modelAndView.addObject("searchString", searchString);

// let's see what we have done...
        return modelAndView;
    }
}