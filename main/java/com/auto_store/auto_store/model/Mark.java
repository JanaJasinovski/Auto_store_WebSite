package com.auto_store.auto_store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "mark")
public class Mark extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "signBlob", columnDefinition = "LONGBLOB")
    private byte[] signBlob;

    @OneToMany(mappedBy="mark", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Model> models;
}
