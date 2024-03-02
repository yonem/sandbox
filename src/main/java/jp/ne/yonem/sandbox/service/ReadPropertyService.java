package jp.ne.yonem.sandbox.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReadPropertyService {

    @Value("${sample.property}")
    String sampleProperty;

    public void outSampleProperty() {

        /*
        プログラム引数でハイフン2個付きのパラメータキー{--sample.property}で
        起動時に動的な指定が可能
         */
        System.out.println(sampleProperty);
    }
}
