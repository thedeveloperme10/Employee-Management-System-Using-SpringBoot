package com.emsmanagementsystem.utils;

import com.emsmanagementsystem.models.Dependent;
import com.emsmanagementsystem.models.Employee;
import com.emsmanagementsystem.models.EntityWrapper;
import com.emsmanagementsystem.models.Insurance;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Locale;

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

    public List<Employee> add(List<Employee> employees) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(employees);
        String url = "http://localhost:8081/ems/entity/addEmployees";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() != 200){
            throw new Exception("Employee creation failed - Please validate the filled in values once!");
        }
        return mapper.readValue(response.body(), new TypeReference<List<Employee>>(){});
    }

    public List<Insurance> addInsurance(List<Insurance> insurances) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(insurances);
        String url = "http://localhost:8081/ems/colcreation/insurance";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() != 200){
            throw new Exception("Employee creation failed - Please validate the filled in values once!");
        }
        return mapper.readValue(response.body(), new TypeReference<List<Insurance>>(){});
    }

    public List<Dependent> addDependent(List<Dependent> dependents) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(dependents);
        String url = "http://localhost:8081/ems/colcreation/dependent";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() != 200){
            throw new Exception("Employee creation failed - Please validate the filled in values once!");
        }
        return mapper.readValue(response.body(), new TypeReference<List<Dependent>>(){});
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

    public Employee updateEmployee(String id, Employee employee) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(employee);
        String url = "http://localhost:8081/ems/entity/updateEmployeeById/" + id;
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

    public Insurance updateInsurance(String id, Insurance insurance) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(insurance);
        String url = "http://localhost:8081/ems/colcreation/updateInsuranceById/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("") || response.statusCode() != 200){
            throw new Exception("Employee info modification failed - Either the record cannot be found or the updated information have some issues!");
        }
        return mapper.readValue(response.body(), Insurance.class);
    }

    public Dependent updateDependent(String id, Dependent dependent) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(dependent);
        String url = "http://localhost:8081/ems/colcreation/updateDependentById/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("") || response.statusCode() != 200){
            throw new Exception("Employee info modification failed - Either the record cannot be found or the updated information have some issues!");
        }
        return mapper.readValue(response.body(), Dependent.class);
    }

    public void delete(String id, String collection) throws Exception {
        String port = collection.equals("employee") ? "http://localhost:8081/ems/entity/delete" : "http://localhost:8081/ems/colcreation/delete";
        String url = port  + collection.substring(0,1).toUpperCase(Locale.ROOT) + collection.substring(1) + "ById/" + id;
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

    public List<Insurance> getInsurancesList() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String url = "http://localhost:8081/ems/colcreation/getAllInsurances";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() != 200){
            throw new Exception("Employee records cannot be found");
        }
        return mapper.readValue(response.body(), new TypeReference<List<Insurance>>(){});
    }

    public List<Dependent> getAllDependentsList() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String url = "http://localhost:8081/ems/colcreation/getAllDependents";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() != 200){
            throw new Exception("Employee records cannot be found");
        }
        return mapper.readValue(response.body(), new TypeReference<List<Dependent>>(){});
    }
}
