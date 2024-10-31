package top.guke.springboot.task.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import top.guke.springboot.task.entity.EmailLog;
import top.guke.springboot.task.mapper.EmailLogMapper;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender mailSender;
    private final EmailLogMapper emailLogMapper;

    public void sendMail(String to, String subject, String content) {

        //1.发邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2319780642@qq.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);

        EmailLog emailLog = new EmailLog();
        emailLog.setRecipient(to);
        emailLog.setSubject(subject);
        emailLog.setContent(content);
        emailLog.setSentAt(LocalDateTime.now());
        emailLogMapper.insert(emailLog);

        log.info("邮件发送至： {}", to);
    }
}