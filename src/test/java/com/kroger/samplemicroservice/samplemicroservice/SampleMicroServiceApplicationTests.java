package com.kroger.samplemicroservice.samplemicroservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kroger.samplemicroservice.samplemicroservice.service.model.ResponseObject;
import net.minidev.json.parser.JSONParser;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest(classes = SampleMicroServiceApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class SampleMicroServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {

		this.mockMvc = webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void validTrueTest() throws Exception {

		MvcResult mvcResult = mockMvc.perform(get("/demo/hello world")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().is2xxSuccessful())
				.andReturn();

		mvcResult.getResponse().getContentAsString().contains("true");
	}

	@Test
	public void validFalseTest() throws Exception {

		MvcResult mvcResult = mockMvc.perform(get("/demo/hello")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().is2xxSuccessful())
				.andReturn();

		mvcResult.getResponse().getContentAsString().contains("false");
	}
}
