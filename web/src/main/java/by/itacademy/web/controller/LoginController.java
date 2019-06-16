package by.itacademy.web.controller;

import by.itacademy.service.dto.LoginDto;
import by.itacademy.service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static by.itacademy.web.path.UrlPath.LOGIN;

@Controller
@RequestMapping(LOGIN)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private final UserService userService;

    @GetMapping
    public String getPage() {
        return "login";
    }

    @PostMapping
    public String login(LoginDto loginDto) {
        return userService.getByLoginAndPassword(loginDto)
                .map(user -> "redirect:/catalog")
                .orElse("redirect:/login?error=true");
    }
}
