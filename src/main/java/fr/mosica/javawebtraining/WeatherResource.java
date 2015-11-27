/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mosica.javawebtraining;

import fr.mosica.javawebtraining.model.Weather;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 *
 * @author florent
 */
@Path("weather")
@Component
public class WeatherResource {
    
    @GET
    @Consumes("application/json")
    @Produces("application/json")    
    public Weather getWeater(@QueryParam("zip") String zip) {
        // http://api.openweathermap.org/data/2.5/weather?zip=79000,fr&appid=2de143494c0b295cca9337e1e96b00e0
        Client client = ClientBuilder.newClient();
        WebTarget target = client
                .target("http://api.openweathermap.org")
                .path("data/2.5/weather")
                .queryParam("zip", zip+",fr")
                .queryParam("appid", "2de143494c0b295cca9337e1e96b00e0");
        
        return target
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(Weather.class);
    }
}
