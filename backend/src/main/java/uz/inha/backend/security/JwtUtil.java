package uz.inha.backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import uz.inha.backend.entity.User;
import uz.inha.backend.service.UserService;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtUtil {
    private final CustomUserDetailsService customUserDetailsService;

    public Collection<? extends GrantedAuthority> getRoles(String token) {
        String roles = getClaims(token).get("roles", String.class);
        String[] roleArr = roles.split(",");
        return Arrays.stream(roleArr).map(SimpleGrantedAuthority::new).toList();
    }

    public boolean isValid(String token) {
        try {
            Claims claims = getClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String generateToken(String username) {
        UserDetails user = customUserDetailsService.loadUserByUsername(username);
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000)))
                .signWith(genKey())
                .claim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                .compact();
    }

    public String generateRefreshToken(String username) {
        UserDetails user = customUserDetailsService.loadUserByUsername(username);
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .signWith(genKey())
                .claim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(genKey()).build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public SecretKey genKey() {
        byte[] bytes = Decoders.BASE64.decode("WCILX9EyoOCuNtzRFYw5QSm6vFBCtdVq0XAsHZnXnDPbwmxMxCWYFTmf9j1QccVI");
        return Keys.hmacShaKeyFor(bytes);
    }

}
