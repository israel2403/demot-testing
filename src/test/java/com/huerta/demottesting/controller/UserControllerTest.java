package com.huerta.demottesting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.huerta.demottesting.form.UserForm;
import com.huerta.demottesting.service.UserService;
import java.math.BigDecimal;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@ContextConfiguration(classes = { UserController.class, UserService.class })
@WebMvcTest
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void whenPostRequestToUserControllerAndInValidUserForm_thenCorrectResponse()
    throws Exception {
    UserForm userForm = new UserForm(
      "Israel",
      "Huerta",
      BigDecimal.valueOf(45554.24),
      28,
      "isra@gmail.com"
    );
    UserForm userBadForm = new UserForm(
      "",
      "Huerta",
      BigDecimal.valueOf(45554.24),
      28,
      "isra@gmail.com"
    );
    ObjectMapper ow = new ObjectMapper();  
    String json = ow.writeValueAsString(userBadForm);
    mockMvc
      .perform(
        MockMvcRequestBuilders
          .post("/users")
          .content(json)
          .contentType(MediaType.APPLICATION_JSON)
      )
      .andExpect(MockMvcResultMatchers.status().isBadRequest())
      /*.andExpect(
        MockMvcResultMatchers.jsonPath("$.name", Is.is("Name is mandatory"))
      ) 
      .andExpect(
        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
      )*/;
  }
}
