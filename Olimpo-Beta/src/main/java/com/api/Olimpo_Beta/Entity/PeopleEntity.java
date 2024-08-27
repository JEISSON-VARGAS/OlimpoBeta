package com.api.Olimpo_Beta.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "people")
public class PeopleEntity implements Serializable {
    @Id
    @Column(name = "document_number", nullable = false, unique = true, length = 20)
    private Long documentNumber;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 80)
    private String lastname;

    @Column(name = "document_type", nullable = false, length = 20)
    private String documentType;

}
