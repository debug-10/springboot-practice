package top.guke.springboot.file.utils;

import io.minio.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
@Configuration
public class MinIoTemplate {

    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    private MinioClient client;

    /**
     * 初始化服务器连接
     */
    @PostConstruct
    public void init() {
        client = MinioClient.builder()
                .endpoint(endPoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    /**
     * 判断 bucket 是否存在
     * @param bucketName 存储桶名称
     * @return 是否存在
     * @throws Exception 异常
     */
    public boolean bucketExists(String bucketName) throws Exception {
        return client.bucketExists(BucketExistsArgs.builder()
                .bucket(bucketName)
                .build());
    }

    /**
     * 创建 bucket
     * @param bucketName 存储桶名称
     * @throws Exception 异常
     */
    public void makeBucket(String bucketName) throws Exception {
        boolean flag = bucketExists(bucketName);
        // 存储桶不存在,可以创建
        if (!flag) {
            client.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        }
    }

    /**
     * 上传文件
     * @param bucketName  存储桶名称
     * @param objectName  上传后的文件地址和名称
     * @param inputStream 上传文件的字节输入流
     * @return 上传后的文件访问地址
     * @throws Exception 异常
     */
    public String putObject(String bucketName, String objectName, InputStream inputStream) throws Exception {
        client.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(inputStream, -1, 1048576000) // 设置合理的文件大小
                .build());
        return endPoint + "/" + bucketName + "/" + objectName;
    }

    /**
     * 删除文件
     * @param bucketName bucket名称
     * @param objectName 对象名称
     */
    public void removeObject(String bucketName, String objectName) throws Exception {
        client.removeObject(RemoveObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .build());
    }
}
