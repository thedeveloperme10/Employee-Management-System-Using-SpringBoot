package com.emsmanagementsystem.utils;

import com.emsmanagementsystem.models.Employee;
import com.emsmanagementsystem.models.EntityWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
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
        ObjectMapper mapper = new ObjectMapper();
        String url = "http://localhost:8081/ems/entity/getAllEmployees";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() != 200){
            throw new Exception("Employee records cannot be found");
        }
        return mapper.readValue(response.body(), new TypeReference<List<Employee>>(){});
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
        if(response.statusCode() != 200){
            throw new Exception("Employee creation failed - Please validate the filled in values once!");
        }
        return mapper.readValue(response.body(), Employee.class);
    }

    public Employee get(String id) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String url = "http://localhost:8081/ems/entity/getEmployeeById/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() != 200){
            throw new Exception("Employee's record cannot be found");
        }
        return mapper.readValue(response.body(), Employee.class);
    }

    public EntityWrapper getEntity(String id) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String url = "http://localhost:8081/ems/entity/getEmpWrapperById/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() != 200){
            throw new Exception("Employee's record cannot be found");
        }
        return mapper.readValue(response.body(), EntityWrapper.class);
    }

    public Employee put(String id, Employee employee) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(employee);
        String url = "http://localhost:8081/ems/entity/updateEmployee/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("") || response.statusCode() != 200){
            throw new Exception("Employee info modification failed - Either the record cannot be found or the updated information have some issues!");
        }
        return mapper.readValue(response.body(), Employee.class);
    }

    public void delete(String id) throws Exception {
        String url = "http://localhost:8081/ems/entity/deleteEmployeeById/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .DELETE()
                .build();
        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        if(response.statusCode() != 200) {
            throw new Exception("Employee's record cannot be found");
        }
    }
}
