package top.guke.springboot.configure.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.guke.springboot.configure.entity.Mail;
import top.guke.springboot.configure.service.EmailService;

@RestController
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/mail")
    public void sendEmail(@RequestBody Mail mail) {
        emailService.sendSimpleMail(mail.getTo() , mail.getSubject(), mail.getBody());

    }
}
