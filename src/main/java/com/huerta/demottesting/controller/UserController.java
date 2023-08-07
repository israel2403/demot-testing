package com.huerta.demottesting.controller;

import com.huerta.demottesting.entity.User;
import com.huerta.demottesting.form.UserForm;
import com.huerta.demottesting.service.UserService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@AllArgsConstructor
@RestController
@RequestMapping(value = "users")
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<User> save(
    @Valid @RequestBody final UserForm userForm
  ) {
    User user = this.userService.save(userForm);
    return ResponseEntity
      .created(
        ServletUriComponentsBuilder
          .fromCurrentRequest()
          .path("/{id}")
          .buildAndExpand(user.getId())
          .toUri()
      )
      .build();
  }
}
