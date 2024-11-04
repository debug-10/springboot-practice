package top.guke.springboot.filter_interceptor.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.guke.springboot.filter_interceptor.interceptor.ImageUploadInterceptor;


@RestController
@RequestMapping("/api/upload")
public class ImageUploadController {

    private final ImageUploadInterceptor imageUploadInterceptor;

    public ImageUploadController(ImageUploadInterceptor imageUploadInterceptor) {
        this.imageUploadInterceptor = imageUploadInterceptor;
    }

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        try {
            // 直接调用拦截器的逻辑
            boolean result =imageUploadInterceptor.preHandle(request, response, null);
            if (!result) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("文件上传失败");
            }
            return ResponseEntity.ok("文件上传成功");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败: " + e.getMessage());
        }
    }
}