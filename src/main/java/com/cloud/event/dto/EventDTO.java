package com.cloud.event.dto;

import com.cloud.event.util.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idEvent;
    private Integer idUser;
    private String name;
    private String category;
    private String place;
    private String address;
    @JsonFormat(pattern = Constants.PATTERN_DATE)
    private Date initialDate;
    @JsonFormat(pattern = Constants.PATTERN_DATE)
    private Date finalDate;
    @JsonProperty(value="isPresencial")
    private Boolean isPresencial;
    @JsonFormat(pattern = Constants.PATTERN_DATE_TIME_YYYYMMDDHHMMSS)
    private Date registerDate;

    public EventDTO() {}

    public EventDTO(Integer idEvent, Integer idUser, String name, String category, String place, String address, Date initialDate, Date finalDate, Boolean isPresencial, Date registerDate) {
        this.idEvent = idEvent;
        this.idUser = idUser;
        this.name = name;
        this.category = category;
        this.place = place;
        this.address = address;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.isPresencial = isPresencial;
        this.registerDate = registerDate;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getPresencial() {
        return isPresencial;
    }

    public void setPresencial(Boolean presencial) {
        isPresencial = presencial;
    }
}
