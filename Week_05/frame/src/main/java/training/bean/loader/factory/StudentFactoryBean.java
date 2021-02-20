package training.bean.loader.factory;

import org.springframework.beans.factory.FactoryBean;
import training.bean.loader.domain.Student;

public class StudentFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        Student student = new Student();
        student.setId(1);
        student.setName("小王");
        student.setAge(22);
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
