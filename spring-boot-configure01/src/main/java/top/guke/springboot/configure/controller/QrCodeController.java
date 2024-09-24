package top.guke.springboot.configure.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.guke.springboot.configure.service.QrCodeService;

@RestController
@AllArgsConstructor
public class QrCodeController {
    private final QrCodeService qrCodeService;

    @GetMapping("/qrcode")
    public void qrcode() {
        qrCodeService.generateCode();
    }
}
