package by.itacademy.web.controller;

import by.itacademy.service.dto.ContactsDto;
import by.itacademy.service.dto.UserDto;
import by.itacademy.service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static by.itacademy.web.path.UrlPath.REGISTRATION;

@Controller
@RequestMapping(REGISTRATION)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationController {

    private final UserService userService;

    @GetMapping
    public String getPage() {
        return "/registration";
    }

    @PostMapping
    public String registration(UserDto newUser, ContactsDto contacts) {
        newUser.setContacts(contacts);
        return userService.saveNewUser(newUser)
                .map(user -> "redirect:/login")
                .orElse("redirect:/registration");
    }
}
