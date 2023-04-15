package com.emsmanagementsystem.utils;

import com.emsmanagementsystem.models.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class HttpUtil {
    HttpClient client = HttpClient.newHttpClient();

    public List<Employee> getList() throws Exception {
        String url = "http://localhost:8081/ems/entity/getAllEmployees";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .GET()
                .build();
        HttpResponse<List<Employee>> response = client.send(request, null);
        if(response.statusCode() != 200){
            throw new Exception("Request failed");
        }
        return response.body();
    }

    public Employee add(Employee employee) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(employee);
        String url = "http://localhost:8081/ems/entity/addEmployee";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        if(response.statusCode() != 204){
//            throw new Exception("Request failed");
//        }
        return mapper.readValue(response.body(), Employee.class);
    }
}
