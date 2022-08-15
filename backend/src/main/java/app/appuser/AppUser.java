package app.appuser;

import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import app.demande.appDemande;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Data


@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {


    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String userName;
    private String password;
    @OneToMany(mappedBy="ClientId", fetch=FetchType.EAGER,targetEntity=appDemande.class,cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    
    private Set<appDemande> appDemandes;
    
    
    /*	spring	security related stuff */
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked = false;
    private Boolean enabled = true;

    public AppUser() {}
    
    public AppUser(String userName,
                   String password,
                   AppUserRole appUserRole) {
        this.userName = userName;


        this.password = password;
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override

    public String getPassword() {
        return password;
    }
    public Long getId()
    {
    	return id;
    }
    public String getRole()
    {
    	return appUserRole.name();
    }

    @Override
    public String getUsername() {
        return userName;
    }
    public void setPassword(String password)
    {
    	this.password = password;
    }
    public void setAppUserRole(AppUserRole appUserRole)
    {
    	this.appUserRole = appUserRole;
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
}
