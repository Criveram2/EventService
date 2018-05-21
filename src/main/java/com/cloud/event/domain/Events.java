package com.cloud.event.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Events")
public class Events implements Serializable {
    private static final long serialVersionUID = 1L;

    public Events() {
    }

    public Events(Integer idEvent, Users user, String name, String category, String place, String address, Date initialDate, Date finalDate, Boolean isPresencial, Date registerDate) {
        this.idEvent = idEvent;
        this.user = user;
        this.name = name;
        this.category = category;
        this.place = place;
        this.address = address;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.isPresencial = isPresencial;
        this.registerDate = registerDate;
    }

    @Id
    @Column(name = "id_event", nullable = false, unique = true)
    @SequenceGenerator(name="pk_sequence",sequenceName="event_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
    private Integer idEvent;
    
    @ManyToOne
    @JoinColumn(name="id_user")
    private Users user;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "place")
    private String place;
    
    @Column(name = "address")
    private String address;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_start")
    private Date initialDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_final")
    private Date finalDate;

    @Column(name = "ispresencial")
    private Boolean isPresencial;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_register")
    private Date registerDate;

    
    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Boolean getPresencial() {
        return isPresencial;
    }

    public void setPresencial(Boolean presencial) {
        isPresencial = presencial;
    }
}
