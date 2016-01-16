package sample.dbtwo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Account {
    @Id
    @GeneratedValue
    private Integer id;
}
