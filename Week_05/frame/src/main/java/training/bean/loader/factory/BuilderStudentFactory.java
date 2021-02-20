package training.bean.loader.factory;

import org.springframework.stereotype.Component;
import training.bean.loader.domain.Student;

/**
 * TODO
 *
 * @author ping.zhang
 * @date 2021/2/20 23:48
 */
@Component
public class BuilderStudentFactory implements StudentFactory {
    @Override
    public Student create() {
        return Student.builder().id(1)
                .name("小王")
                .age(23)
                .build();
    }
}
