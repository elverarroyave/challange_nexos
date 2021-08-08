package com.nexos.challenge.challenge.merchandise.io.web.v1;


import com.nexos.challenge.challenge.merchandise.io.web.v1.model.MerchandiseRequest;
import com.nexos.challenge.challenge.merchandise.model.Merchandise;
import com.nexos.challenge.challenge.merchandise.service.marchendise.MerchandiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController
@RequestMapping("api/v1/merchandise")
@Api(tags = "Merchandise", value="Merchandise")
@CrossOrigin(origins = "http://localhost:4200")
public class MerchandiseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MerchandiseService merchandiseService;

    @PostMapping
    @ApiOperation(value = "Create a merchandise")
    public ResponseEntity<Void> create(@RequestBody @Valid MerchandiseRequest merchandiseToCreate){
        Merchandise merchandiseCreated = merchandiseService.save(MerchandiseRequest.toModelCmd(merchandiseToCreate));

        URI location = fromUriString("/api/v1/merchandise").path("/{id}")
                .buildAndExpand(merchandiseCreated.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
