package com.codegym.controller;

import com.codegym.model.Transfer;
import com.codegym.service.ITransferService;
import com.codegym.service.TransferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/transfer")
public class TransferController {
    private final ITransferService transferService = new TransferService();

    @GetMapping("")
    public ModelAndView transferList() {
        List<Transfer> transferList = transferService.findAll();
        Double totalFeesAmount = transferService.totalFeesAmount();
        ModelAndView modelAndView = new ModelAndView("transfers", "transferList", transferList);
        modelAndView.addObject("totalFeesAmount", totalFeesAmount);
        return modelAndView;
    }
}
