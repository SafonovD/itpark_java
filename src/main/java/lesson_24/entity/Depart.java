package lesson_24.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "userCardArrayList")
@Entity
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "depart")
public class Depart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(name = "name")
    private String departName;

    @OneToMany(mappedBy = "depart", fetch = FetchType.EAGER)
    private List<UserCard> userCardArrayList = new ArrayList<>();

}
