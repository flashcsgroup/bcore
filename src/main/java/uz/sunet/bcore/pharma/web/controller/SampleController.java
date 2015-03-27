package uz.sunet.bcore.pharma.web.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * This is sample controller should be renamed for real controller
 *
 * @author Farruh Tashbulov
 */
@RestController
@RequestMapping(value = "/service/")
public class SampleController {
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getGreeting(@PathVariable String name) {
        return "Hello "+name;//TODO: should be dto here and auto converted to JSON, now it not working
    }
}
