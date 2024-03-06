package jp.ne.yonem.sandbox.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringJUnitConfig
@TestPropertySource(locations = "classpath:application-test.properties")
class ReadPropertyServiceTest {

    private final ReadPropertyService sut;

    @Autowired
    public ReadPropertyServiceTest(
            ReadPropertyService readPropertyService
    ) {
        this.sut = readPropertyService;
    }

    @Test
    @DisplayName("動作確認 - outSampleProperty")
    void test1() {
        sut.outSampleProperty();
    }
}