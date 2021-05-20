package gr.codelearn.java.path.spring.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.Delegate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "MOVIES")
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIES_SEQ", initialValue = 1, allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseEntity {

    private interface MyDelegate {
        boolean add(Actor actor);

        boolean remove(Actor actor);
    }

    @NotNull
    @Column(length = 50, nullable = false)
    private String name;

    @NotNull
    @Column(length = 20, nullable = false)
    private String genre;

    @NotNull
    private Integer rating;

    private String releaseDate;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Person director;

    @JsonManagedReference("actor")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Delegate(types = MyDelegate.class)
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private final Set<Actor> actor = new HashSet<>();
}
