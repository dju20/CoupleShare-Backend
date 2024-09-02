package com.example.couplesharebackend.service.user;


import com.example.couplesharebackend.dto.user.register.RegisterDto;
import com.example.couplesharebackend.entity.User;
import com.example.couplesharebackend.enums.user.CoupleStatus;
import com.example.couplesharebackend.enums.user.UserRole;
import com.example.couplesharebackend.repository.UserRepository;
import com.example.couplesharebackend.service.util.CommonUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final CommonUtilService commonUtilService;

    @Override
    public void saveUser(RegisterDto registerDto) {
        validateRegisterDto(registerDto);

        User user = User.builder()
                .username(registerDto.getUsername())
                .password(bCryptPasswordEncoder.encode(registerDto.getPassword()))
                .email(registerDto.getEmail())
                .realName(registerDto.getRealName())
                .sex(registerDto.getSex())
                .role(UserRole.ROLE_USER)
                .coupleStatus(CoupleStatus.SOLO)
                .provider("local")
                .build();

        userRepository.save(user);
    }

    private void validateRegisterDto(RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }
    }

}
