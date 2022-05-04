package edu.egg.libreria.controller;

import edu.egg.libreria.entity.Publisher;
import edu.egg.libreria.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping
    public ModelAndView getPublishers(HttpServletRequest request){
        ModelAndView mav =new ModelAndView("/table/publisher-table");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null){
            mav.addObject("success",inputFlashMap.get("success"));
        }
        mav.addObject("publishers",publisherService.getAll());
        return mav;
    }

    @GetMapping("/form")
    public ModelAndView getForm(HttpServletRequest request) {
        ModelAndView mav =new ModelAndView("/form/publisher-form");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) {
            mav.addObject("publisher", inputFlashMap.get("publisher"));
            mav.addObject("exception", inputFlashMap.get("exception"));
        } else {
            mav.addObject("publisher", new Publisher());
        }

        mav.addObject("action", "create");
        return mav;
    }

    @GetMapping("/form/{id}")
    public ModelAndView getForm(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("/form/publisher-form");
        mav.addObject("publisher", publisherService.getById(id));
        mav.addObject("action", "update");
        return mav;
    }

    @PostMapping("/create")
    public RedirectView create(Publisher publisherDto, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/publishers");

        try {
            publisherService.create(publisherDto);
            attributes.addFlashAttribute("success", "The operation has been carried out successfully");
        } catch (IllegalArgumentException e) {
            attributes.addFlashAttribute("publisher", publisherDto);
            attributes.addFlashAttribute("exception", e.getMessage());
            redirect.setUrl("/publishers/form");
        }

        return redirect;
    }

    @PostMapping("/update")
    public RedirectView update(Publisher publisherDto, RedirectAttributes attributes) throws Exception {
        RedirectView redirect = new RedirectView("/publishers");
        publisherService.update(publisherDto);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");
        return redirect;
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable Integer id) {
        RedirectView redirect = new RedirectView("/publishers");
        publisherService.deleteById(id);
        return redirect;
    }
}
