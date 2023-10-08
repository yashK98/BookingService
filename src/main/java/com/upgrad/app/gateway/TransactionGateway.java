package com.upgrad.app.gateway;

import com.upgrad.app.dto.TransactionDetailsDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TransactionGateway {

    String POST_TRANSACTION_URI = "http://localhost:8083/payment";
    String TRANSACTION_ENDPOINT = "/transaction";

    public Integer postTransaction(TransactionDetailsDTO transactionDetailsDTO){
        WebClient webClient = WebClient.create(POST_TRANSACTION_URI);
        return webClient.post().uri(TRANSACTION_ENDPOINT).bodyValue(transactionDetailsDTO).retrieve().bodyToMono(Integer.class).block();
    }
}
