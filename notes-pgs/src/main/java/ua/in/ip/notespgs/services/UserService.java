package ua.in.ip.notespgs.services;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.in.ip.notespgs.entityes.Role;
import ua.in.ip.notespgs.entityes.User;
import ua.in.ip.notespgs.repositories.UserRepo;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
//@RequiredArgsConstructor
public class UserService implements UserDetailsService {
//    @Autowired
//    UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder(12);;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public boolean createUser (User user){
        String username = user.getUsername();
        if (userRepo.findByUsername(username) != null) return false;
        user.setActive(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email: {}", username);
        userRepo.save(user);
        return true;
    }
    public User findByUsername(String username){
        return userRepo.findByUsername(username);
    }
    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepo.findByUsername(principal.getName());
    }

    public List<User> list(){
        return userRepo.findAll();
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null){
            throw  new UsernameNotFoundException(String.format("User '%x not found", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }
    public void banUser(Long id) {
        User user = userRepo.findById(id).orElse(null);
        if(user != null){
            if (user.isActive()){
                user.setActive(false);
                log.info("Ban user with id = {}, email: {}", user.getId(), user.getEmail());
            }else {
                user.setActive(true);
                log.info("reBan user with id = {}, email: {}", user.getId(), user.getEmail());
            }
            userRepo.save(user);
        }
    }

}
