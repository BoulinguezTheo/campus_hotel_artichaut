package com.campus.campus_hotel_artichaut_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/test")
//@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class AuthorizationController {




    @GetMapping("/user")
//    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('USER')")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> protectedRoute() {
        return ResponseEntity.ok("Hello, you have access to a protected resource that requires admin role and read authority.");
    }




    @GetMapping("/admin")
//    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> sayHelloWithRoleAdminAndReadAuthority() {
//        return ResponseEntity.ok("Hello, you have access to a protected resource that requires admin role and read authority.");
        return ResponseEntity.ok("Hello, you have access to a protected resource that requires admin.");
    }

    @DeleteMapping("/admin/resource")
    @PreAuthorize("hasAuthority('DELETE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<String> sayHelloWithRoleAdminAndDeleteAuthority() {
        return ResponseEntity.ok("Hello, you have access to a protected resource that requires admin role and delete authority.");
    }
    @PostMapping("/user/resource")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE') and hasAnyRole('ADMIN','USER')")
    public ResponseEntity<String> sayHelloWithRoleUserAndCreateAuthority() {
        return ResponseEntity.ok("Hello, you have access to a protected resource that requires user role and write authority.");
    }
    @PutMapping("/user/resource")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasAnyRole('ADMIN','USER')")
    public ResponseEntity<String> sayHelloWithRoleUserAndUpdateAuthority() {
        return ResponseEntity.ok("Hello, you have access to a protected resource that requires user role and update authority.");
    }

}