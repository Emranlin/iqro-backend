package service;

import com.example.iqro.db.dto.request.AuthenticateRequest;
import com.example.iqro.db.dto.request.UserRegisterRequest;
import com.example.iqro.db.dto.response.AuthenticationResponse;


public interface AuthenticationService {
    AuthenticationResponse userRegister(UserRegisterRequest request);

    AuthenticationResponse authenticate(AuthenticateRequest request);


}
