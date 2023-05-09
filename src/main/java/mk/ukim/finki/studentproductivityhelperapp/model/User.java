package mk.ukim.finki.studentproductivityhelperapp.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Table
@Data
@Entity
public class User implements UserDetails {
    @Id
    private Long UserId;
    private String FirstName;
    private String LastName;
    @Column(unique = true)
    private String Username;
    @Column(unique = true)
    private String Email;
    private String Password;
    @OneToMany
    private List<Course> courses;
    @OneToMany
    private List<Topic> topics;
    @OneToMany
    private List<Event> events;
    @OneToMany
    private List<Log> logs;
    @OneToMany
    private List<Attachment> attachments;
    @OneToMany
    private List<Note> notes;
    @OneToMany
    private List<ToDo> toDos;

    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public User() {

    }

    public User( String firstName, String lastName,
                String username, String email, String password) {

        FirstName = firstName;
        LastName = lastName;
        Username = username;
        Email = email;
        Password = password;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}