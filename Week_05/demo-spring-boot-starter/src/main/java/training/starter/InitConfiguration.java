package training.starter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import training.starter.entity.Klass;
import training.starter.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author ping.zhang
 * @date 2021/2/21 0:53
 */
@Configuration
public class InitConfiguration {

    @Bean("student100")
    public Student getStudent(){
        return Student.builder()
                .id(1)
                .name("小王")
                .beanName("student100")
                .build();
    }

    @Bean()
    public Klass getKlass(@Qualifier("student100") Student student) {
        Klass klass = new Klass();
        List<Student> collect = Stream.of(student, Student.builder()
                .id(2)
                .name("小李")
                .beanName("student101").build()
        ).collect(Collectors.toList());
        klass.setStudents(collect);
        return klass;
    }

}
