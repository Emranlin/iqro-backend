package com.example.iqro.api;

import com.batoulapps.adhan.*;
import com.batoulapps.adhan.data.DateComponents;
import com.example.iqro.db.dto.request.AuthenticateRequest;
import com.example.iqro.db.dto.request.UserRegisterRequest;
import com.example.iqro.db.dto.response.AuthenticationResponse;
import com.example.iqro.db.dto.response.RegistrationResponse;
import com.example.iqro.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimeZone;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication controller")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Register a new user", description = "This method validates the request and creates a new user.")
    @PostMapping("/sign-up")
    public RegistrationResponse signUpUser(@RequestBody @Valid UserRegisterRequest request) {
        return authenticationService.userRegister(request);
    }

    @Operation(summary = "Authenticate a user", description = "This method validates the request and authenticate a user.")
    @PostMapping("/sign-in")
    public AuthenticationResponse signIn(@RequestBody @Valid AuthenticateRequest request) {
        return authenticationService.authenticate(request);
    }

//    @Operation(summary = "Confirm", description = "This method for confirm code checking method")
//    @PostMapping("/confirm")
//    RegistrationResponse confirmRegistration(String email, int code) {
//        return authenticationService.confirmRegistration(email, code);
//    }

//    @Operation(summary = "Date", description = "This method for confirm code checking method")
//    @PostMapping("/date")
//    Map<String, String> date() {
//        Coordinates coordinates = new Coordinates(42.8746, 74.5698);
//
//        DateComponents date = new DateComponents(2015, 11, 1);
//
//        CalculationParameters params = CalculationMethod.MUSLIM_WORLD_LEAGUE.getParameters();
//        params.madhab = Madhab.HANAFI;
//        params.adjustments.fajr = 2;
//
//        PrayerTimes prayerTimes = new PrayerTimes(coordinates, date, params);
//
//        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
//        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Bishkek"));
//
//        Map<String, String> allDate = new LinkedHashMap<>();
//        allDate.put("Fajr: ", formatter.format(prayerTimes.fajr));
//        allDate.put("Sunrise: ", formatter.format(prayerTimes.sunrise));
//        allDate.put("Dhuhr: ", formatter.format(prayerTimes.dhuhr));
//        allDate.put("Asr: ", formatter.format(prayerTimes.asr));
//        allDate.put("Maghrib: ", formatter.format(prayerTimes.maghrib));
//        allDate.put("Isha: ", formatter.format(prayerTimes.isha));
//
//        return allDate;
//    }

}
