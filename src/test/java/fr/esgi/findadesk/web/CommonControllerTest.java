package fr.esgi.findadesk.web;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import fr.esgi.findadesk.FindADeskApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FindADeskApplication.class)
@WebAppConfiguration
public class CommonControllerTest 
{
	
	
	
	protected MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), 
													MediaType.APPLICATION_JSON.getSubtype(),
													Charset.forName("utf8"));

	
	protected MockMvc mockMvc;
    
    
	protected HttpMessageConverter mappingJackson2HttpMessageConverter;
    
    
    @Autowired
    protected WebApplicationContext wac;
    
    
    protected String json(Object o) throws IOException 
    {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
    
    
    @Autowired
    public void setConverters(HttpMessageConverter<?>[] converters) 
    {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    
	public void setMockMvc(MockMvc mockMvc) 
	{
		this.mockMvc = mockMvc;
	}


	public void setWac(WebApplicationContext wac) 
	{
		this.wac = wac;
	}
	
	
	@Before
    public void setup() throws Exception 
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
	
	
	@Test
    public void avoidNoRunnableMethodsFromMaven() throws Exception
	{
		
	}
}
