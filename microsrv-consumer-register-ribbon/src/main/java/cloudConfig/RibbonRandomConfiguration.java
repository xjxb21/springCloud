package cloudConfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon client configuration
 * 定义当前配置 会覆盖@RibbonClient默认的 RibbonClientConfiguration 的负载平衡规则配置
 */
@Configuration
public class RibbonRandomConfiguration {

    @Bean
    public IRule ribbonRule() {
        RandomRule randomRule = new RandomRule();
        return randomRule;
    }
}
