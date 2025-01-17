package ru.dev.bolnik.dz12;

import javax.persistence.*;

@Entity
@Table
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Integer val;

    @Version
    private Long serial;

    public Item() {}

    public Item(int i) {
        this.val = i;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }
}
