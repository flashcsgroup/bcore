package uz.sunet.bcore.pharma.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is sample controller should be renamed for real controller
 * @author Farruh Tashbulov
 */
@RestController
@RequestMapping("/service/")
public class SampleController {
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getGreeting(@PathVariable String name) {
        return "Hello " + name;
    }
}
