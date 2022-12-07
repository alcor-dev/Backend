package com.example.block7crudvalidation.security;

import com.example.block7crudvalidation.person.application.PersonServiceImpl;
import com.example.block7crudvalidation.person.domain.Person;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class SecurityController {

    @Autowired
    PersonServiceImpl personService;

    @PostMapping("security/login")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        Person person = personService.readPersonByUsername(username);
        System.out.println("El nombre del usuario es: " + username + "\nLa clave del usuario es: " + password);

        if (person == null) {
            System.out.println("Persona no encontrada");
        }

        //If both parameters are equal, then we can proceed to the next phase
        if(username.contains(person.getUsername()) && password.contains(person.getPassword())) {
            //If the admin parameter is true (due to being a boolean we can shorten it a bit) we assign it an ADMIN role
            if (person.getAdmin()) {
                System.out.println("El usuario " + person.getUsername() + " es ADMIN");
                return getJwtToken(username, "ADMIN");
            //If that's not the case we assume that the user should be a normal one
            } else {
                System.out.println("El usuario " + person.getUsername() + " es USER");
                return getJwtToken(username, "USER");
            }
        //And if nothing works, then we launch a generic string to not give any hint about what part is giving us an error
        } else {
            return "No coincide usuario/password";
        }


    }

    private String getJwtToken(String username, String role) {
        String secretKey = "mySecretKeyThatMightNotBeSoSecretSoLetsFillTheKeyWithUselessInfo2684789654";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
        String token = Jwts.builder().setId("BosonitJWT").setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
        return "Bearer " + token;
    }
}

