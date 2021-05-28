package pl.java.calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.java.calculator.model.CalculatorRequest;
import pl.java.calculator.service.AddOperation;
import pl.java.calculator.service.DivideOperation;
import pl.java.calculator.service.MultiplicationOperation;
import pl.java.calculator.service.SubstractOperation;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest({CalculatorController.class, AddOperation.class, DivideOperation.class, MultiplicationOperation.class, SubstractOperation.class})
@AutoConfigureMockMvc
public class CalculatorControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void shouldReturnAddResult() throws Exception {
        String url = "/calculate";
        mockMvc.perform(MockMvcRequestBuilders
                .post(url)
                .content(asJsonString(new CalculatorRequest(new BigDecimal(3), new BigDecimal(2), "+")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("5"));

    }

    @Test
    public void shouldReturnSubstractResult() throws Exception {
        String url = "/calculate";
        mockMvc.perform(MockMvcRequestBuilders
                .post(url)
                .content(asJsonString(new CalculatorRequest(new BigDecimal(10), new BigDecimal(2), "-")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("8"));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void shouldReturnAllDescriptions() throws Exception {
        String url = "/operations";
        mockMvc.perform(MockMvcRequestBuilders
                .get(url)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description", CoreMatchers.is("Multiply two numbers and return result")));
    }
}
