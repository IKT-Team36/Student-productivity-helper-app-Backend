package mk.ukim.finki.studentproductivityhelperapp.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;

    @Column(unique = true)
    private String Email;
    private String Password;
    @Enumerated(EnumType.STRING)
    private AppUserRole role;

    private String FirstName;
    private String LastName;

    private Boolean locked;
    private Boolean enabled;

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
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singleton(authority);
    }

    @Override
    public String getUsername() {
        return Email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public User(String email, String password, AppUserRole role, String firstName, String lastName, Boolean locked, Boolean enabled) {
        Email = email;
        Password = password;
        this.role = role;
        FirstName = firstName;
        LastName = lastName;
        this.locked = locked;
        this.enabled = enabled;
    }
}