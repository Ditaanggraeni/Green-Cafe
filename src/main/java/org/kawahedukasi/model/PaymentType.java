package org.kawahedukasi.model;

import org.hibernate.annotations.GenericGenerator;
import org.kawahedukasi.model.base.CreatedBase;

import javax.persistence.*;

@Entity
@Table(name = "payment_type")
public class PaymentType extends CreatedBase {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "code", nullable = false, length = 30)
    private String code;

    public PaymentType() {
        super();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
