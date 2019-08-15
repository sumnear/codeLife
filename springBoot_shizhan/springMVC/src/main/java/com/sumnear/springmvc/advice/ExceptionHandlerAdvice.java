package com.sumnear.springmvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice
{

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request)
    {
        System.out.println("exceptionHandler 进来了");
        ModelAndView modelAndView = new ModelAndView("error");// error页面
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    public void addAttributes(Model model)
    {
        model.addAttribute("msg", "额外信息 sumnear");
    }

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
        System.out.println("initBinder aaa");
		webDataBinder.setDisallowedFields("id");
	}
}
