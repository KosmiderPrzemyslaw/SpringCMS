package pl.kosmider.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kosmider.POJO.Student;
import pl.kosmider.test.Skill;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/search-result")
    @ResponseBody
    public String performShowForm(HttpServletRequest request) {
        logger.info("searched product: {}", request.getParameter("product"));
        return "searched result in console";
    }

    @GetMapping("/form/email")
    public String formResetShow() {
        return "/email";
    }

    @PostMapping("/form/email")
    @ResponseBody
    public String formResetPerform(@RequestParam String email) {
        logger.info("email: {}", email);
        return "already done";
    }

    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String simple() {
        return "studentForm";
    }

    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    @ResponseBody
    public String processSimple(@RequestParam String firstName,
                                @RequestParam String lastName, Model model) {
        Student student = new Student(firstName, lastName);
        model.addAttribute("student", student);
        return "postStudent";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showStudentAddForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("skills", skills());

        return "studentAdd";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String processForm(@ModelAttribute Student student) {
        logger.info("student {}", student);
        return "student added";
    }

    @ModelAttribute("skills")
    public Collection<Skill> skills() {
        List<Skill> skills = new ArrayList<Skill>();
        skills.add(new Skill(1, "Java"));
        skills.add(new Skill(2, "PHP"));
        skills.add(new Skill(3, "Ruby"));
        return skills;
    }
}
