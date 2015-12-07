package com.michael.votingsystem.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.michael.votingsystem.model.Dish;
import com.michael.votingsystem.model.Menu;
import com.michael.votingsystem.model.Restaurant;
import com.michael.votingsystem.service.RestaurantService;
import com.michael.votingsystem.service.VotesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
@RunWith(MockitoJUnitRunner.class)
public class RestaurantsControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private RestaurantController unit;

    @Mock
    private RestaurantService restaurantService;

    @Mock
    private VotesService votesService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(unit).apply(springSecurity()).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(unit).build();
    }

    @Test
    public void testCreatingRestaurant() throws Exception {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("restaurant 1");
        Collection<Dish> dishes = new ArrayList<>();
        Dish dish1 = new Dish("Fish", 4.6);
        dishes.add(dish1);
        restaurant1.setLunchMenu(new Menu(dishes));

        String postData = objectMapper.writeValueAsString(restaurant1);

        mockMvc.perform(post("/restaurants").content(postData)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string(""));

        verify(restaurantService).save(restaurant1);
    }

    @Test
    public void testRetrievingRestaurants() throws Exception {

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setId(4L);
        restaurant1.setName("restaurant 1");
        Collection<Dish> dishes1 = new ArrayList<>();
        dishes1.add(new Dish("Fish", 4.6));
        restaurant1.setLunchMenu(new Menu(dishes1));

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setId(6L);
        restaurant2.setName("restaurant 2");
        Collection<Dish> dishes2 = new ArrayList<>();
        dishes2.add(new Dish("Fish", 4.6));
        restaurant1.setLunchMenu(new Menu(dishes2));

        List<Restaurant> restaurants = Arrays.asList(
                restaurant1, restaurant2
        );

        when(restaurantService.getAll()).thenReturn(restaurants);

        String expectedRestaurants = objectMapper.writeValueAsString(restaurants);

        mockMvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedRestaurants));
        verify(restaurantService).getAll();
    }

    @Test
    public void testMenuUpdating() throws Exception {
        Collection<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Fish", 4.6));
        Menu menu = new Menu();
        menu.setDishes(dishes);

        String newMenu = objectMapper.writeValueAsString(menu);
        mockMvc.perform(
                put("/restaurants/5/menu").contentType(MediaType.APPLICATION_JSON)
                        .content(newMenu)).andExpect(status().isOk()).andExpect(content().string(""));
        verify(restaurantService).updateMenu(5L, menu);
    }

    // TODO : configure security for test environment and make this test green
//    @Test
//    @WithMockUser(username = "someuser", roles={"ADMIN"})
//    public void testVote() throws Exception {
//        mockMvc.perform(post("/restaurants/7/vote"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(""));
//
//        verify(votesService).vote("someuser", 7L);
//
//    }
}
