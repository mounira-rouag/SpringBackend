package com.example.Project.Services;

import com.example.Project.Models.PasswordResetToken;
import com.example.Project.Models.User;
import com.example.Project.Repositories.TokenRepository;
import com.example.Project.Repositories.UserInterface;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl {
    private final TokenRepository tokenRepo;
private final UserInterface userRepo;
    public ResetTokenServiceImpl(TokenRepository tokenRepo, UserInterface userRepo) {
        this.tokenRepo = tokenRepo;
        this.userRepo = userRepo;
    }

    public boolean resetPassword(String token, String newPassword) {
        PasswordResetToken passwordResetToken = tokenRepo.findByToken(token);
        if (passwordResetToken == null ) {
            return false; // Token is invalid or expired
        }

        User user = passwordResetToken.getUser();
        user.setPassword(newPassword);

        userRepo.save(user);

        tokenRepo.delete(passwordResetToken);
        return true;
    }
}
