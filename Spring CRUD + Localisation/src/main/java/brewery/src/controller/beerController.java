/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brewery.src.controller;

import brewery.src.model.Beers;
import brewery.src.model.Categories;
import brewery.src.model.Styles;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 *
 * @author Brendan
 */
@Controller
@RequestMapping("/beer")
@SessionAttributes("beer")
public class beerController {

    @Autowired
    beerService service;

    @RequestMapping("")
    public ModelAndView getBeers() {
//        int x = Integer.parseInt("abc");

        return new ModelAndView("/Allbeers", "beerList", service.getAllBeers());
    }

    @RequestMapping(value = "chooseLocale")
    public ModelAndView chooseLocale(@RequestParam("locale") String locale, HttpServletRequest request, HttpServletResponse response) {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString(locale));
        return new ModelAndView("redirect:/beer");
    }


    @RequestMapping("search")
    public ModelAndView SearchBeers(@RequestParam("searchName") String searchName) {
//        if(searchName == null){
//            return new ModelAndView("/Searchbeers");
//        }
        return new ModelAndView("/Searchbeers", "beerList", service.Search(searchName));

    }

    @RequestMapping("updatePrice")
    public ModelAndView UpdatePrice(@Valid @ModelAttribute("beer") Beers beer, BindingResult result) {
        Date date = new Date();
        beer.setLastMod(date);
        System.out.println(result);
        if (result.hasErrors()) {

            return new ModelAndView("/Viewbeer");
        }
        service.Update(beer);
        return new ModelAndView("redirect:/beer");

    }

    @RequestMapping("viewBeer")
    public ModelAndView ViewBeer(@RequestParam("id") int id) {
//        int x = Integer.parseInt("abc");

        Beers beer = service.GetBeerByID(id);
        Categories cat = service.getCatagoryByCatID(beer.getCatId());
        Styles style = service.getStylesByStyleID(beer.getStyleId());
//        return new ModelAndView("/Viewbeer", "beer", service.GetBeerByID(id));

        ModelAndView model = new ModelAndView();
        model.addObject("beer", beer);
        model.addObject("cat", cat);
        model.addObject("style", style);
        model.setViewName("/Viewbeer");
            return model;
    }
}
