package training.bean.loader.domain;

import lombok.*;

/**
 * TODO
 *
 * @author ping.zhang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    public static Student create() {
        return Student.builder().id(1)
                .name("小王")
                .age(22)
                .build();
    }
}
