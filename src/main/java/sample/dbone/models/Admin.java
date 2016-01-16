package sample.dbone.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Admin {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public Admin(String name) {
        this.name = name;
    }
}

