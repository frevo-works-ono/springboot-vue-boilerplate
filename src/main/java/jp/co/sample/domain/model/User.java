package jp.co.sample.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the m_user database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @NotNull
    private String mailaddress;

    @NotNull
    private String password;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @OneToMany(mappedBy = "user")
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<Todo> todos;

    public User(Integer userId) {
        this.userId = userId;
    }
}