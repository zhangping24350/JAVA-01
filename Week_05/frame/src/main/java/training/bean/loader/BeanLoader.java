package training.bean.loader;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import training.bean.loader.domain.Student;
import training.bean.loader.factory.DefaultStudentFactory;
import training.bean.loader.factory.StudentFactory;

import java.util.Map;
import java.util.ServiceLoader;

/**
 * TODO
 *
 * @author ping.zhang
 * @date 2021/2/20 23:21
 */
@Import(BeanLoader.Config.class)
public class BeanLoader {
    public static void main(String[] args) {
        // 使用xml装配
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("classpath:bean-loader-context.xml");
        // 构造方法
        Student userByConstructor = xmlApplicationContext.getBean("student-by-constructor", Student.class);
        System.out.println(userByConstructor);
        // 使用静态方法装配
        Student userByStaticMethod = xmlApplicationContext.getBean("student-by-static-method", Student.class);
        System.out.println(userByStaticMethod);
        // 使用实例方法装配
        Student userByInstanceMethod = xmlApplicationContext.getBean("student-by-instance-method", Student.class);
        System.out.println(userByInstanceMethod);
        // 自定义factoryBean
        Student userByFactoryBean = xmlApplicationContext.getBean("student-by-factory-bean", Student.class);
        System.out.println(userByFactoryBean);
        // ServiceLoader
        ServiceLoader<?> serviceLoader = xmlApplicationContext.getBean("studentFactoryServiceLoader", ServiceLoader.class);
        for (Object o : serviceLoader) {
            StudentFactory userFactory = (StudentFactory) o;
            System.out.println(userFactory.create());
        }


        //注解方式包括@Compent @Configuration @Bean @Import
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(BeanLoader.class);

        annotationConfigApplicationContext.refresh();

        Map<String, Student> beansOfType = annotationConfigApplicationContext.getBeansOfType(Student.class);
        System.out.println(beansOfType);

        Student bean = annotationConfigApplicationContext.getBean("bean-student", Student.class);
        System.out.println(bean);



        //Java API BeanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Student.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1)
                .addPropertyValue("name", "小王")
                .addPropertyValue("age", 25);

        annotationConfigApplicationContext.registerBeanDefinition("api-student", beanDefinitionBuilder.getBeanDefinition());

        Student bean1 = annotationConfigApplicationContext.getBean("api-student", Student.class);

        System.out.println(bean1);

        annotationConfigApplicationContext.close();
    }


    public class Config{

        @Bean("bean-student")
        public Student createStudent(){
            return Student.create();
        }
    }
}
