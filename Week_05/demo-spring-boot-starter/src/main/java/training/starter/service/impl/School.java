package training.starter.service.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import training.starter.entity.Klass;
import training.starter.entity.Student;
import training.starter.service.ISchool;

import javax.annotation.Resource;

@Data
public class School implements ISchool {

    // Resource 
    @Autowired(required = true) //primary
            Klass class1;

    @Resource(name = "student100")
    Student student100;

    @Override
    public void ding() {

        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);

    }

}
