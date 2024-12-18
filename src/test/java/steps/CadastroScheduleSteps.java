package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.json.JSONException;
import org.junit.Assert;
import services.CadastroScheduleService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CadastroScheduleSteps {

    CadastroScheduleService cadastroScheduleService = new CadastroScheduleService();

    @Dado("que eu tenha os seguintes dados da schedule:")
    public void queEuTenhaOsSeguintesDadosDaSchedule(List<Map<String, String>> linhas) {
        for(Map<String, String> coluna : linhas) {
            cadastroScheduleService.setFieldsDelivery(coluna.get("campo"), coluna.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de schedules")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDeSchedules(String endpoint) {
        cadastroScheduleService.createDelivery(endpoint);
    }

    @Então("o status code da resposta do schedule deve ser {int}")
    public void oStatusCodeDaRespostaDoScheduleDeveSer(int arg0) {
        Assert.assertEquals(arg0, cadastroScheduleService.response.getStatusCode());
    }

    @Então("o status code da resposta da schedule deve ser {int}")
    public void oStatusCodeDaRespostaDaScheduleDeveSer(int arg0) {
        Assert.assertEquals(arg0, cadastroScheduleService.response.getStatusCode());
    }

    @Dado("que eu recupere o ID da schedule criada no contexto")
    public void queEuRecupereOIDDaScheduleCriadaNoContexto() {
        cadastroScheduleService.retrieveIdDelivery(true);
    }

    @Quando("eu enviar a requisição com o ID para o endpoint {string} de deleção de schedules")
    public void euEnviarARequisiçãoComOIDParaOEndpointDeDeleçãoDeSchedules(String endpoint) {
        cadastroScheduleService.deleteDelivery(endpoint);
    }

    @Dado("que eu recupere o ID da schedule criada no contexto e some um")
    public void queEuRecupereOIDDaScheduleCriadaNoContextoESomeUm() {
        cadastroScheduleService.retrieveIdDelivery(false);
    }

    @E("que o arquivo de contrato da schedule esperado é o {string}")
    public void queOArquivoDeContratoEsperadoÉO(String contrato) throws IOException, JSONException {
        cadastroScheduleService.setContract(contrato);
    }

    @Então("a resposta da requisição deve estar em conformidade com o contrato selecionado da schedule")
    public void aRespostaDaRequisiçãoDeveEstarEmConformidadeComOContratoSelecionado() throws IOException, JSONException {
        Set<ValidationMessage> validateResponse = cadastroScheduleService.validateResponseAgainstSchema();
        Assert.assertTrue("O contrato está inválido. Erros encontrados: " + validateResponse, validateResponse.isEmpty());
    }



}
