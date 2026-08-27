package co.uap.proiv.jobs.Controller; // Cambié el paquete a co.uap.proiv.jobs.Controller para que coincida con la estructura de paquetes de tu proyecto
import org.junit.jupiter.api.BeforeAll; // Importa para la anotación @BeforeAll que indica que el método se ejecutará antes de todos los tests
import org.junit.jupiter.api.AfterAll; // Importa para la anotación @AfterAll que indica que el método se ejecutará después de todos los tests
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc; //Importa para la anotación @AutoConfigureMockMvc que permite la configuración automática de MockMvc en pruebas de integración
import org.springframework.boot.test.context.SpringBootTest; //Importa para la anotación @Spring BootTest que indica que se trata de una prueba de integración que carga el contexto completo de Spring Boot
import okhttp3.mockwebserver.MockWebServer; //Importa para la clase MockWebServer que permite simular un servidor web para pruebas de integración
import org.springframework.beans.factory.annotation.Autowired; //Importa para la anotación @Autowired que permite la inyección de dependencias en Spring
import org.springframework.test.web.servlet.MockMvc; //Importa para la clase MockMvc que permite realizar solicitudes HTTP simuladas a los controladores de Spring MVC en pruebas
import java.io.IOException; //Importa para la clase IOException que se utiliza para manejar excepciones de entrada/salida

import java.time.Duration; //Importa para la clase Duration que se utiliza para representar un período de tiempo

import okhttp3.mockwebserver.MockResponse; //Importa para la clase MockResponse que permite simular respuestas HTTP en pruebas de integración


@SpringBootTest
@AutoConfigureMockMvc

public class UserControllerIntegrationTest {

    @Autowired

    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired UserApiRepository;

    static MockWebServer mockWebServer;
 
    @beforeAll //antes de todo se ejecuta un server mock para simular las respuestas de la API externa
    public static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll //Después de los test se cierra el server Mock
    public static void tearDown() throws IOException {
        mockWebServer.close();
    }

    @TestConfiguration 
    static class TestConfig {
        @Bean
        @Primary
        public UserApiRepository userApiRepository(ObjectMapper objectMapper) {
            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();
            String baseUrl = mockWebServer.url("/api/users").toString(); // Se obtiene la URL del MockWebServer
            String apiKey = "free_user_3HYTiqu2JKQ4TfGq884xW5mqfrd"

            return new UserApiRepository(httpClient, objectMapper, baseUrl, apiKey);
        } 
        @Test
        @DisplayName ("Get api/users/{id} User Controller, User service and UserApiRepository")

        void getUserById() {

            String jsonResponse = """
                    {
            
                        "id": 1,
                        "first_name": "John",
                        "last_name": "Doe",
                        "avatar": "https://requres.in/img/faces/2.jpg",
                        "email": "john.doe@example.com"
                    """;
                    mockServer.enqueue(new MockResponse()
                    .setBody(jsonResponse)
                    .setResponseCode(200)
                    .addHeader("Content-Type", "application/json"));

                    mockMvc.perform(get("/api/users/2"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id").value(2))
                    .andExpect(jsonPath("$.first_name").value("John"))
                    .andExpect(jsonPath("$.last_name").value("Doe"))
                    .andExpect(jsonPath("$.avatar").value("https://requres.in/img/faces/2.jpg"));

        }
            RecordedRequest recordedRequest = mockWebServer.takeRequest(); // Se obtiene la solicitud registrada en el MockWebServer
            assertEquals(expected: "aplocation/json". request.getGeader(name: "Accept")); // Se verifica que la cabecera "Accept" de la solicitud sea "application/json"
            assertEquals(expected: "free_user_3HYTiqu2JKQ4TfGq884xW5mqfrd", request.getHeader(name: "X-API-KEY")); // Se verifica que la cabecera "Authorization" de la solicitud sea
        
    }
}
package co.uap.proiv.jobs.Controller; // Cambié el paquete a co.uap.proiv.jobs.Controller para que coincida con la estructura de paquetes de tu proyecto
import org.junit.jupiter.api.BeforeAll; // Importa para la anotación @BeforeAll que indica que el método se ejecutará antes de todos los tests
import org.junit.jupiter.api.AfterAll; // Importa para la anotación @AfterAll que indica que el método se ejecutará después de todos los tests
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc; //Importa para la anotación @AutoConfigureMockMvc que permite la configuración automática de MockMvc en pruebas de integración
import org.springframework.boot.test.context.SpringBootTest; //Importa para la anotación @Spring BootTest que indica que se trata de una prueba de integración que carga el contexto completo de Spring Boot
import okhttp3.mockwebserver.MockWebServer; //Importa para la clase MockWebServer que permite simular un servidor web para pruebas de integración
import org.springframework.beans.factory.annotation.Autowired; //Importa para la anotación @Autowired que permite la inyección de dependencias en Spring
import org.springframework.test.web.servlet.MockMvc; //Importa para la clase MockMvc que permite realizar solicitudes HTTP simuladas a los controladores de Spring MVC en pruebas
import java.io.IOException; //Importa para la clase IOException que se utiliza para manejar excepciones de entrada/salida

import java.time.Duration; //Importa para la clase Duration que se utiliza para representar un período de tiempo

import okhttp3.mockwebserver.MockResponse; //Importa para la clase MockResponse que permite simular respuestas HTTP en pruebas de integración


@SpringBootTest
@AutoConfigureMockMvc

public class UserControllerIntegrationTest {

    @Autowired

    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired UserApiRepository;

    static MockWebServer mockWebServer;
 
    @beforeAll //antes de todo se ejecuta un server mock para simular las respuestas de la API externa
    public static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll //Después de los test se cierra el server Mock
    public static void tearDown() throws IOException {
        mockWebServer.close();
    }

    @TestConfiguration 
    static class TestConfig {
        @Bean
        @Primary
        public UserApiRepository userApiRepository(ObjectMapper objectMapper) {
            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();
            String baseUrl = mockWebServer.url("/api/users").toString(); // Se obtiene la URL del MockWebServer
            String apiKey = "free_user_3HYTiqu2JKQ4TfGq884xW5mqfrd"

            return new UserApiRepository(httpClient, objectMapper, baseUrl, apiKey);
        } 
        @Test
        @DisplayName ("Get api/users/{id} User Controller, User service and UserApiRepository")

        void getUserById() {

            String jsonResponse = """
                    {
            
                        "id": 1,
                        "first_name": "John",
                        "last_name": "Doe",
                        "avatar": "https://requres.in/img/faces/2.jpg",
                        "email": "john.doe@example.com"
                    """;
                    mockServer.enqueue(new MockResponse()
                    .setBody(jsonResponse)
                    .setResponseCode(200)
                    .addHeader("Content-Type", "application/json"));

                    mockMvc.perform(get("/api/users/2"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id").value(2))
                    .andExpect(jsonPath("$.first_name").value("John"))
                    .andExpect(jsonPath("$.last_name").value("Doe"))
                    .andExpect(jsonPath("$.avatar").value("https://requres.in/img/faces/2.jpg"));

        }
            RecordedRequest recordedRequest = mockWebServer.takeRequest(); // Se obtiene la solicitud registrada en el MockWebServer
            assertEquals(expected: "aplocation/json". request.getGeader(name: "Accept")); // Se verifica que la cabecera "Accept" de la solicitud sea "application/json"
            assertEquals(expected: "free_user_3HYTiqu2JKQ4TfGq884xW5mqfrd", request.getHeader(name: "X-API-KEY")); // Se verifica que la cabecera "Authorization" de la solicitud sea
        
    }
}