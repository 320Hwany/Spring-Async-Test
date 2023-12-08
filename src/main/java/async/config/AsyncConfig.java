package async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync // 비동기 기능 활성화
@Configuration
public class AsyncConfig {

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10); // 기본 실행 대기 쓰레드 수
        executor.setMaxPoolSize(10); // 동시 동작 최대 쓰레드 수
        executor.setQueueCapacity(500); // 초과 요청시 최대 수용 가능한 큐의 크기
        executor.setThreadNamePrefix("Async Task");
        executor.initialize();

        return executor;
    }
}
