package top.guke.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FamilyTest {
@Resource
    private Family family;
@Test
    void test() {
    System.out.println(family);
}
}