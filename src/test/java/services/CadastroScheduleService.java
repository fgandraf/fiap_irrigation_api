package services;



import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import io.restassured.http.ContentType;
import model.ScheduleModel;
import org.json.JSONException;
import org.json.JSONObject;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class CadastroScheduleService {

    final ScheduleModel scheduleModel = new ScheduleModel();
    public final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    private String token;
    private String idDelivery;
    public Response response;
    String baseUrl = "http://localhost:8080";

    String schemasPath = "src/test/resources/schemas/";
    JSONObject jsonSchema;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void authenticate() {
        // Obtenha o token de autenticação chamando o endpoint de login
        this.token = given()
                .contentType("application/json")
                .body(""" 
                          {"email": "admin@admin.com", "password": "1234abcd"}
                        """)
                .post(baseUrl + "/api/users/login")
                .then()
                .extract()
                .path("token");
    }

    public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "id" -> scheduleModel.setId(Integer.parseInt(value));
            case "startTime" -> scheduleModel.setStartTime(value);
            case "endTime" -> scheduleModel.setEndTime(value);
            default -> throw new IllegalStateException("Unexpected field" + field);
        }
    }

    public void createDelivery(String endPoint) {
        this.authenticate();
        String url = baseUrl + endPoint;
        //Convertendo o objeto para JSON
        String bodyToSend = gson.toJson(scheduleModel);
        response = given()
                //Especificando corpo da requisição como JSON
                .contentType(ContentType.JSON)
                //Especificando retorno aceito como JSON
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(bodyToSend)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
        System.out.println(response.jsonPath().prettify());
    }

    public void deleteDelivery(String endpoint){
        this.authenticate();
        String url = String.format("%s%s/%s", baseUrl, endpoint, idDelivery);
        response = given()
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }

    public void retrieveIdDelivery(boolean valid){
        if(valid) idDelivery = String.valueOf(gson.fromJson(response.jsonPath().prettify(), ScheduleModel.class).getId());
        else idDelivery = String.valueOf(gson.fromJson(response.jsonPath().prettify(), ScheduleModel.class).getId() + 1);
    }

    private JSONObject loadJsonFromFile(String filePath) throws IOException, JSONException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONTokener tokener = new JSONTokener(content);
        return new JSONObject(tokener);

    }

    public void setContract(String contract) throws IOException, JSONException {
        switch (contract) {
            case "Cadastro Schedule bem-sucedido" -> jsonSchema = loadJsonFromFile(schemasPath + "cadastro-schedule-bem-sucedido.json");
            default -> throw new IllegalStateException("Unexpected contract" + contract);
        }
    }

    public Set<ValidationMessage> validateResponseAgainstSchema() throws IOException, JSONException {
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        JsonSchema schema = schemaFactory.getSchema(jsonSchema.toString());
        JsonNode jsonResponseNode = objectMapper.readTree(jsonResponse.toString());
        Set<ValidationMessage> schemaValidationErrors = schema.validate(jsonResponseNode);
        return schemaValidationErrors;
    }

}
