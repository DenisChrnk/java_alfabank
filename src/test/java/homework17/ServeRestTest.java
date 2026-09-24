package homework17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ServeRestTest {
    private static String bearerToken;
    private static String userId;
    private static String userEmail;
    private static String bodyString;

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        bearerToken = "";
        userId = "";
    }


    @Test
    @Order(1)
    @DisplayName("проверка получения списка пользователей")
    public void shouldGetAllUsers() {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/usuarios")
                .then()
                .extract()
                .response();

        assertThat(response.getStatusCode(), equalTo(200));

        assertThat(response.getHeader("Content-Type"), containsString("application/json"));

        assertThat(response.jsonPath().getInt("quantidade"), notNullValue());

        assertThat(response.jsonPath().getList("usuarios"), notNullValue());
    }

    @Test
    @Order(2)
    @DisplayName("проверка поиска пользователя по емайл")
    public void shouldFindUserByEmail() {

        String emailUsuario;

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/usuarios")
                .then()
                .extract()
                .response();

        emailUsuario = response.jsonPath().getString("usuarios[0].email");

        response = given()
                .contentType(ContentType.JSON)
                .queryParam("email", emailUsuario)
                .when()
                .get("/usuarios")
                .then()
                .extract()
                .response();

        assertThat(response.getStatusCode(), equalTo(200));

        assertThat(response.jsonPath().get("quantidade"), equalTo(1));

        assertThat(response.jsonPath().get("usuarios[0].email").toString(), equalTo(emailUsuario));


    }

    @Test
    @Order(3)
    @DisplayName("проверка возможности создания пользователя")
    public void shouldCreateNewUser() {

        String time = String.valueOf(System.currentTimeMillis());

        userEmail = "spy_НОМЕР" + time + "@qa.com";

        bodyString = "{\n" +
                "  \"nome\": \"Тайный Покупатель\",\n" +
                "  \"email\": \"" + userEmail + "\",\n" +
                "  \"password\": \"secret123\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyString)
                .when()
                .post("/usuarios")
                .then()
                .extract()
                .response();

        assertThat(response.getStatusCode(), equalTo(201));

        assertThat(response.jsonPath().getString("message"), equalTo("Cadastro realizado com sucesso"));

        userId = response.jsonPath().getString("_id");

    }

    @Test()
    @Order(4)
    @DisplayName("проверка обновления данных пользователя")
    public void shouldUpdateUser() {

        String newUserName = "Обновлённый Покупатель";
        String newRoleUser = "false";

        bodyString = "{\n" +
                "  \"nome\": \"" + newUserName + "\",\n" +
                "  \"email\": \"" + userEmail + "\",\n" +
                "  \"password\": \"secret123\",\n" +
                "  \"administrador\": \"" + newRoleUser + "\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyString)
                .when()
                .put("/usuarios/" + userId)
                .then()
                .extract()
                .response();

        assertThat(response.getStatusCode(), equalTo(200));

        assertThat(response.jsonPath().getString("message"), equalTo("Registro alterado com sucesso"));
    }

    @Test
    @Order(5)
    @DisplayName("проверка удаления данных пользователя")
    public void deleteUser() {

        bodyString = "{\n" +
                "  \"email\": \"" + userEmail + "\",\n" +
                "  \"password\": \"secret123\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyString)
                .when()
                .post("/login")
                .then()
                .extract()
                .response();

        bearerToken = response.jsonPath().getString("authorization");

        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", bearerToken)
                .when()
                .delete(" /usuarios/" + userId)
                .then()
                .extract()
                .response();

        assertThat(response.getStatusCode(), equalTo(200));

        assertThat(response.jsonPath().getString("message"), equalTo("Registro excluído com sucesso"));
    }

    @Test
    @Order(6)
    @DisplayName("проверка цен товаров")
    public void shouldGetAllProducts() {

        List<Integer> prises;
        List<String> names;

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/produtos")
                .then()
                .extract()
                .response();

        prises = response.jsonPath().getList("produtos.preco");
        names = response.jsonPath().getList("produtos.nome");

        assertThat(response.getStatusCode(), equalTo(200));

        assertThat(response.jsonPath().get("quantidade"), greaterThan(0));

        assertThat(names, allOf(notNullValue()));

        for (Integer pris : prises) {
            assertThat(pris, greaterThan(0));
        }

        assertThat(names, hasItem("Logitech MX Vertical"));

    }
}