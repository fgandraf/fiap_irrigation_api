package br.com.fiap.irrigationapi.controller;

import br.com.fiap.irrigationapi.modules.areas.AreaController;
import br.com.fiap.irrigationapi.modules.areas.AreaService;
import br.com.fiap.irrigationapi.modules.areas.dtos.CreateArea;
import br.com.fiap.irrigationapi.modules.areas.dtos.OutputArea;
import br.com.fiap.irrigationapi.modules.areas.dtos.UpdateArea;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class AreaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AreaService service;

    @InjectMocks
    private AreaController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @DisplayName("TEST: Area: Create")
    @Test
    void testCreateArea() throws Exception {
        // Arrange
        var createArea = new CreateArea("Área 1", "location1", "100", null);
        var outputArea = new OutputArea(1L, "Área 1", "location1", "100", null);

        when(service.create(any(CreateArea.class))).thenReturn(outputArea);

        // Act & Assert
        mockMvc.perform(post("/api/areas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createArea)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/api/areas/1"))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.description").value("Área 1"))
                .andExpect(jsonPath("$.size").value("100"));
    }

    @DisplayName("TEST: Area: GetById")
    @Test
    void testGetAreaById() throws Exception {
        // Arrange
        var outputArea = new OutputArea(1L, "Área 1", "location1", "100", null);

        when(service.findById(1L)).thenReturn(outputArea);

        // Act & Assert
        mockMvc.perform(get("/api/areas/id/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.description").value("Área 1"))
                .andExpect(jsonPath("$.size").value("100"));
    }


    @DisplayName("TEST: Area : GetAll")
    @Test
    void testGetAllAreas() throws Exception {
        // Arrange
        var outputArea1 = new OutputArea(1L, "Área 1", "location1", "100", null);
        var outputArea2 = new OutputArea(2L, "Área 2", "location2", "200", null);

        var page = new PageImpl<>(List.of(outputArea1, outputArea2), PageRequest.of(0, 10), 2);

        when(service.findAll(any(Pageable.class))).thenReturn(page);

        // Act & Assert
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()) // Resolve Pageable
                .build();

        mockMvc.perform(get("/api/areas/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1L))
                .andExpect(jsonPath("$.content[0].description").value("Área 1"))
                .andExpect(jsonPath("$.content[1].id").value(2L))
                .andExpect(jsonPath("$.content[1].description").value("Área 2"));
    }

    @DisplayName("TEST: Area: Update")
    @Test
    void testUpdateArea() throws Exception {
        // Arrange
        var updateArea = new UpdateArea(1L, "Área Atualizada", "new location", "150", null);
        var outputArea = new OutputArea(1L, "Área Atualizada", "new location", "150", null);

        when(service.update(any(UpdateArea.class))).thenReturn(outputArea);

        // Act & Assert
        mockMvc.perform(put("/api/areas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updateArea)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.description").value("Área Atualizada"))
                .andExpect(jsonPath("$.size").value("150"));
    }

    @DisplayName("TEST: Area: Delete")
    @Test
    void testDeleteAreaById() throws Exception {
        // Arrange
        // O metodo delete não retorna nenhum valor, então não precisamos mockar o retorno

        // Act & Assert
        mockMvc.perform(delete("/api/areas/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}