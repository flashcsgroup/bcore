package uz.sunet.bcore.pharma.web.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * This is sample controller should be renamed for real controller
 *
 * @author Farruh Tashbulov
 */
@RestController
@RequestMapping(value = "/service/")
public class SampleController {
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Message getGreeting(@PathVariable String name) {
//       return "Hello "+name;//TODO: should be dto here and auto converted to JSON, now it not working
        return new Message(name, "Hello " + name);
    }
    static class Message implements Serializable{
        private String name;
        private String value;

        Message() {
        }

        Message(String name, String value) {
            this.name = name;
            this.value = value;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
}
