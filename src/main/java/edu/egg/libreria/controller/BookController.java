package edu.egg.libreria.controller;

import edu.egg.libreria.service.AuthorService;
import edu.egg.libreria.service.BookService;
import edu.egg.libreria.service.PublisherService;
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
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @GetMapping
    public ModelAndView getBooks(HttpServletRequest request){
        ModelAndView mav =new ModelAndView("/table/book-table");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null){
            mav.addObject("success",inputFlashMap.get("success"));
        }
        mav.addObject("books",bookService.getAll());
        return mav;
    }
}
