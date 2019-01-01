package com.CurriculumProject.CurriculumProject;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.restdocs.cli.CliDocumentation;
import org.springframework.restdocs.http.HttpDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import capital.scalable.restdocs.AutoDocumentation;
import capital.scalable.restdocs.jackson.JacksonResultHandlers;
import capital.scalable.restdocs.response.ResponseModifyingPreprocessors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CurriculumProjectApplicationTests {

    @Autowired
    private WebApplicationContext context;
    
    @Autowired
    protected ObjectMapper objectMapper;

    @Rule
    public JUnitRestDocumentation jUnitRestDocumentation = new JUnitRestDocumentation();
    
    private MockMvc mockMvc;


    @Before
    public void setUpList() throws Exception {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                //.addFilters()
                .alwaysDo(JacksonResultHandlers.prepareJackson(objectMapper))
                .alwaysDo(MockMvcRestDocumentation.document("/",
                        Preprocessors.preprocessRequest(),
                        Preprocessors.preprocessResponse(
                                ResponseModifyingPreprocessors.replaceBinaryContent(),
                                ResponseModifyingPreprocessors.limitJsonArrayLength(objectMapper),
                                Preprocessors.prettyPrint())))
                .apply(MockMvcRestDocumentation.documentationConfiguration(jUnitRestDocumentation)
                        .uris()
                        .withScheme("http")
                        .withHost("localhost")
                        .withPort(8080)
                        .and().snippets()
                        .withDefaults(CliDocumentation.curlRequest(),
                                HttpDocumentation.httpRequest(),
                                HttpDocumentation.httpResponse(),
                                AutoDocumentation.requestFields(),
                                AutoDocumentation.responseFields(),
                                AutoDocumentation.pathParameters(),
                                AutoDocumentation.requestParameters(),
                                AutoDocumentation.description(),
                                AutoDocumentation.methodAndPath(),
                                AutoDocumentation.section()))
                .build();
    }


    
    @Test
    public void getPersonalDataList() throws Exception {
        this.mockMvc.perform(
                RestDocumentationRequestBuilders
                .get("/personaldata/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(document("personaldata/list"));
    }
    
	@Test
	public void setPersonalDataCreate() throws Exception {
	    Map<String, String> newTestObj = new HashMap<>();
	    newTestObj.put("name", "name_test");
	    newTestObj.put("email", "test@test.com");
	
	    this.mockMvc.perform(
	    	post("/personaldata/create").contentType(MediaType.APPLICATION_JSON).content(
	        this.objectMapper.writeValueAsString(newTestObj)))
	    	.andExpect(status().isOk())
	        .andDo(document("personaldata/create"));
	}
	

	
	
    @Test
    public void getEducationList() throws Exception {
        this.mockMvc.perform(
                RestDocumentationRequestBuilders
                .get("/education/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(document("education/list"));
    }
	
    
    
    @Test
    public void getProfessionalExperienceList() throws Exception {
        this.mockMvc.perform(
                RestDocumentationRequestBuilders
                .get("/professionalexperience/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(document("professionalexperience/list"));
    }
	
	
    @Test
    public void getLanguageList() throws Exception {
        this.mockMvc.perform(
                RestDocumentationRequestBuilders
                .get("/language/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(document("language/list"));
    }
	
    @Test
    public void getCertificationList() throws Exception {
        this.mockMvc.perform(
                RestDocumentationRequestBuilders
                .get("/certification/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(document("certification/list"));
    }
    
    @Test
    public void getProjectList() throws Exception {
        this.mockMvc.perform(
                RestDocumentationRequestBuilders
                .get("/project/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(document("project/list"));
    }
    
/*	@Test
	public void setProjectCreate() throws Exception {
	    Map<String, String> newTestObj = new HashMap<>();
	    newTestObj.put("name", "name_test");
	    newTestObj.put("email", "test@test.com");
	
	    this.mockMvc.perform(
	    	post("/personaldata/create").contentType(MediaType.APPLICATION_JSON).content(
	        this.objectMapper.writeValueAsString(newTestObj)))
	    	.andExpect(status().isOk())
	        .andDo(document("personaldata/create"));
	}*/
    
    @Test
    public void getSkillList() throws Exception {
        this.mockMvc.perform(
                RestDocumentationRequestBuilders
                .get("/skill/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(document("skill/list"));
    }
    
}