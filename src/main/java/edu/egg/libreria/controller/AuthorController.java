package edu.egg.libreria.controller;

import edu.egg.libreria.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ModelAndView getAuthors(HttpServletRequest request){
        ModelAndView mav =new ModelAndView("/table/author-table");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null){
            mav.addObject("success",inputFlashMap.get("success"));
        }
        mav.addObject("authors",authorService.getAll());
        return mav;
    }


}
