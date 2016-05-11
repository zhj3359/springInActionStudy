import org.junit.Test;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.SpittleRepository;
import spittr.web.HomeController;
import spittr.web.SpittleController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jhj on 2016-05-10.
 */
public class ControllerTest {
    @Test
    public void testHome() throws Exception{
        HomeController homeController = new HomeController();
        assertEquals("home", homeController.home());
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
        mockMvc.perform(post("/")).andExpect(view().name("home2"));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for(int i = 0; i<count; i++){
            spittles.add(new Spittle("Spittle" + i ,new Date()));
        }
        return  spittles;
    }

    @Test
    public void testSpittle() throws Exception{
        List<Spittle> expected = createSpittleList(20);
        SpittleRepository spittleRepository = mock(SpittleRepository.class);
        when(spittleRepository.findSpittles(Long.MAX_VALUE,20)).thenReturn(expected);

        SpittleController spittleController = new SpittleController(spittleRepository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expected.toArray())));
    }
}
