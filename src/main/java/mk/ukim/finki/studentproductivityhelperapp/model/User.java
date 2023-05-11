package mk.ukim.finki.studentproductivityhelperapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Data
@Entity
@RequiredArgsConstructor
public class User implements UserDetails {

    private String FirstName;
    private String LastName;
    @Column(unique = true)
    @Id
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

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

//    public User(Long userId, String firstName, String lastName, String username, String email, String password, List<Course> courses, List<Topic> topics, List<Event> events, List<Log> logs, List<Attachment> attachments, List<Note> notes, List<ToDo> toDos, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
//        UserId = userId;
//        FirstName = firstName;
//        LastName = lastName;
//        Username = username;
//        Email = email;
//        Password = password;
//        this.courses = courses;
//        this.topics = topics;
//        this.events = events;
//        this.logs = logs;
//        this.attachments = attachments;
//        this.notes = notes;
//        this.toDos = toDos;
//        this.isAccountNonExpired = isAccountNonExpired;
//        this.isAccountNonLocked = isAccountNonLocked;
//        this.isCredentialsNonExpired = isCredentialsNonExpired;
//        this.isEnabled = isEnabled;
//    }
//
    public User(String firstName, String lastName,
                String username, String email, String password) {

        FirstName = firstName;
        LastName = lastName;
        Username = username;
        Email = email;
        Password = password;
    }


}