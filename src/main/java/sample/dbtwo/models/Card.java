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
@Table(name = "cards")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue
    private Integer id;

    private String number;

    public Card(String number) {
        this.number = number;
    }
}
