package thi.tai64132083.requestapi.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import thi.tai64132083.requestapi.model.Employee;
import thi.tai64132083.requestapi.model.Knowledge;

public interface ApiService {
    @GET("fact")
    Call<Knowledge> getKnowledgee();
    @GET("values")
    Call<List<Employee>> getEmployee();
}
