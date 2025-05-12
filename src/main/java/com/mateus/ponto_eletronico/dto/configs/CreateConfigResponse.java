package com.mateus.ponto_eletronico.dto.configs;

import com.mateus.ponto_eletronico.dto.GenericResponse;

public class CreateConfigResponse extends GenericResponse {
    private final int configId;
    private static final String CREATE_CONFIG_MESSAGE_SUCESS = "Configurações atualizadas com sucesso.";
    private static final String CREATE_CONFIG_MESSAGE_ERROR = "Erro ao atualizar as configurações.";

    public CreateConfigResponse(int configId) {
        super(configId != 0 ? CREATE_CONFIG_MESSAGE_SUCESS : CREATE_CONFIG_MESSAGE_ERROR);
        this.configId = configId;
    }

    public CreateConfigResponse(int configId, String message) {
        super(message);
        this.configId = configId;
    }

    public int getConfigId() {
        return configId;
    }

    @Override
    public String toString() {
        return "CreateConfigResponse{" +
                "configId=" + configId +
                "message=" + this.getMessage() +
                '}';
    }
}
