package gr.codelearn.java.path.spring.test.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PEOPLE")
@SequenceGenerator(name = "idGenerator", sequenceName = "PEOPLE_SEQ", initialValue = 1, allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity{
    @NotNull
    @Column(length = 20, nullable = false)
    private String firstname;

    @NotNull
    @Column(length = 20, nullable = false)
    private String lastname;

    @NotNull
    @Column(nullable = false)
    private String dateOfBirth;

    private String dateOfDeath;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(length = 8, nullable = false)
    private PersonRole personRole;

}
