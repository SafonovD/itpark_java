package lesson_24.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@ToString(exclude = "depart")
@Entity
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usercard")
public class UserCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int cartNumber;
    private String fullName;
    private double restSum;
    private Date startDate;
    private Date stopDate;
    private Date birthDate;
    private String tel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_depart")
    private Depart depart;

}
