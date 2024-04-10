package com.example.sort_architectures.distributed.microservices.crossbelt.services;

import com.example.sort_architectures.distributed.microservices.crossbelt.dto.SortStatusDto;
import com.example.sort_architectures.distributed.microservices.crossbelt.exceptions.BeltServiceException;
import com.example.sort_architectures.distributed.microservices.crossbelt.exceptions.ItemsSortingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

@Service
public class DefaultBeltService implements BeltService {

    private static final String BELT_START_ISSUE_MESSAGE = "Couldn't start the belt";
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Value("${belt-service-url}")
    private String beltServiceUrl;

    @Override
    public String startSorter() throws IOException, InterruptedException, BeltServiceException {
        final var result = HttpClient.newHttpClient()
                .send(HttpRequest.newBuilder(URI.create(beltServiceUrl + "/start-server"))
                        .GET()
                        .build(), BodyHandlers.ofString());
        if (result.statusCode() == HttpStatus.OK.value()) {
            return objectMapper.readValue(result.body(), SortStatusDto.class).status().toString();
        } else {
            throw new BeltServiceException(BELT_START_ISSUE_MESSAGE);
        }
    }

    @Override
    public String stopSorter() throws IOException, InterruptedException, BeltServiceException {
        final var result = HttpClient.newHttpClient()
                .send(HttpRequest.newBuilder(URI.create(beltServiceUrl + "/stop-sorter"))
                        .GET()
                        .build(), BodyHandlers.ofString());
        if (result.statusCode() == HttpStatus.OK.value()) {
            return objectMapper.readValue(result.body(), SortStatusDto.class).status().toString();
        } else {
            throw new BeltServiceException(BELT_START_ISSUE_MESSAGE);
        }
    }

    @Override
    public String sortItems() throws ItemsSortingException, IOException, InterruptedException {
        final var result = HttpClient.newHttpClient()
                .send(HttpRequest.newBuilder(URI.create(beltServiceUrl + "/stop-sorter"))
                        .POST(BodyPublishers.noBody())
                        .build(), BodyHandlers.ofString());
        if (result.statusCode() == HttpStatus.OK.value()) {
            return result.body();
        } else {
            throw new ItemsSortingException(BELT_START_ISSUE_MESSAGE);
        }
    }
}
