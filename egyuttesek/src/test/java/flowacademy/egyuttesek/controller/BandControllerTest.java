package flowacademy.egyuttesek.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import flowacademy.egyuttesek.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class BandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BandRepository bandRepository;

    private final ObjectMapper mapper = new ObjectMapper();


}