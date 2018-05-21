package com.cloud.event.domain;

/*import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
*/
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Users")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    public Users(String email, String password, Date registerDate) {
        this.email = email;
        this.password = password;
        this.registerDate = registerDate;
    }

    public Users(){}

    @Id
    @Column(name = "id_user", nullable = false, unique = true)
    @SequenceGenerator(name="pk_sequence",sequenceName="user_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
    private Integer idUser;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_date")
    private Date registerDate;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
