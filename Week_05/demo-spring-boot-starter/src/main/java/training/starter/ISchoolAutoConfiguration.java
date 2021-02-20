package training.starter;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import training.starter.service.ISchool;
import training.starter.service.impl.School;

/**
 * TODO
 *
 * @author ping.zhang
 * @date 2021/2/21 0:35
 */
@Configuration
@AutoConfigureAfter(InitConfiguration.class)
public class ISchoolAutoConfiguration {

    @Bean
    public ISchool getISchool(){
        return new School();
    }
}
