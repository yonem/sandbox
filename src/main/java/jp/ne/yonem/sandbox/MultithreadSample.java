package jp.ne.yonem.sandbox;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executors;

@Slf4j
public class MultithreadSample {

    public static void main(String[] args) {
        var availableProcessors = Runtime.getRuntime().availableProcessors();

        try (var threadPool = Executors.newFixedThreadPool(availableProcessors)) {

            for (int i = 0; i < 30; i++) {
                int index = i + 1;
                threadPool.execute(() -> process(index));
            }
            threadPool.shutdown();
        }
    }

    private static void process(int index) {
        var random = new Random();
        var minWaitTime = 5000; // 5秒（ミリ秒単位）
        var maxWaitTime = 10000; // 10秒（ミリ秒単位）

        // ランダムな待機時間を生成
        var waitTime = random.nextInt(maxWaitTime - minWaitTime + 1) + minWaitTime;

        try {
            Thread.sleep(waitTime);

            // ゼロ埋め2桁、小数3桁で丸めのフォーマットを使用する
            log.info("処理-%02d：%.3fsec".formatted(index, waitTime / 1000.0));

        } catch (InterruptedException e) {
            log.error("", e);
        }
    }
}
