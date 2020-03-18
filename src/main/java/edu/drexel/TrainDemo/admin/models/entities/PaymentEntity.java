package edu.drexel.TrainDemo.admin.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "payment")
public class PaymentEntity {

    @Id
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "name=" + name +
						 '}';
    }
}
